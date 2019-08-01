package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Card.BooksInOrderUser;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.ModelData.User.User;
import ru.santos.BookkeepingSystem.queueManager.Manager;
import ru.santos.BookkeepingSystem.repos.Card.BooksInOrderUserRepo;
import ru.santos.BookkeepingSystem.repos.Card.OrderUserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class CardUserService {
    @Autowired
    private OrderUserRepo orderUserRepo;

    @Autowired
    private BooksInOrderUserRepo booksInOrderUserRepo;

    @Autowired
    private  BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private Manager manager;


    public void addToCard(Book book, User user, int quantity){
        boolean old = true;
        OrderUser orderUserNotPaid;
        List<OrderUser> listOrderUser = orderUserRepo.findByCustomerAndPaid(user.getId(),0);
            if(listOrderUser.size() == 0) {
                orderUserNotPaid = new OrderUser();
                orderUserNotPaid.setUser(user.getId());
                orderUserNotPaid.setPaid(0);
                orderUserNotPaid.setPrice(book.getPrice() * quantity);
                orderUserRepo.save(orderUserNotPaid);
                old = false;
            }
            else orderUserNotPaid = listOrderUser.get(0);

            BooksInOrderUser booksInOrderUserExists = booksInOrderUserRepo.findByOrderUserIdAndBookId(orderUserNotPaid.getId(), book.getId());

            if (booksInOrderUserExists != null) {
                booksInOrderUserExists.setQuantity(booksInOrderUserExists.getQuantity() + quantity);
                booksInOrderUserRepo.save(booksInOrderUserExists);
                orderUserNotPaid.setPrice((book.getPrice() * quantity) + orderUserNotPaid.getPrice());
                orderUserRepo.save(orderUserNotPaid);
            } else {
                booksInOrderUserExists = new BooksInOrderUser();
                booksInOrderUserExists.setQuantity(quantity);
                booksInOrderUserExists.setBook(book.getId());
                booksInOrderUserExists.setOrderUser(orderUserNotPaid.getId());
                booksInOrderUserRepo.save(booksInOrderUserExists);
                if (old) {
                    orderUserNotPaid.setPrice((book.getPrice() * quantity) + orderUserNotPaid.getPrice());
                    orderUserRepo.save(orderUserNotPaid);
                }
            }


    }


    public OrderUserTransport showOrderNotPaidUser(User user){
        OrderUserTransport transport = new OrderUserTransport();
        List<OrderUser> listOrderUser = orderUserRepo.findByCustomerAndPaid(user.getId(),0);
        if(listOrderUser != null && listOrderUser.size() != 0) {
            OrderUser orderUserNotPaid = orderUserRepo.findByCustomerAndPaid(user.getId(), 0).get(0);
            if (orderUserNotPaid != null) {
                transport.setIdOrder(orderUserNotPaid.getId());
                transport.setPriceOrder(orderUserNotPaid.getPrice());
                transport.setNameAndQuantityBook(getTitleAndCountBook(booksInOrderUserRepo.findByOrderUserId(orderUserNotPaid.getId())));
                transport.setBooksOrder(getBooksOrder(booksInOrderUserRepo.findByOrderUserId(orderUserNotPaid.getId())));
                ;
                transport.setBooksIdInOrder(getBookIdInOrder(booksInOrderUserRepo.findByOrderUserId(orderUserNotPaid.getId())));
            }
        }
        return  transport;
    }


    private HashMap<String,String> getTitleAndCountBook(List<BooksInOrderUser> booksInOrderUsers) {
        HashMap<String,String> res = new HashMap<>();
        for (BooksInOrderUser book: booksInOrderUsers) {

            String title = bookService.findBookById(book.getBook()).getTitle();
            res.put(title,book.getQuantity().toString());

        }
        return res;
    }

    private List<String> getBookIdInOrder(List<BooksInOrderUser> booksInOrderUsers){
        List<String> id = new ArrayList<>();
        for (BooksInOrderUser book: booksInOrderUsers) {
            id.add(book.getId().toString());
        }
        return id;
    }

    private List<Book> getBooksOrder(List<BooksInOrderUser> booksInOrderUsers){
       List<Book> books = new ArrayList<>();
        for (BooksInOrderUser book: booksInOrderUsers) {
            books.add(bookService.findBookById(book.getBook()));
        }
        return books;
    }

    public void editCountBookInOrder(BooksInOrderUser bookInOrder, String quantity) {
        int maxFree = maxFreeBooks(bookService.findBookById(bookInOrder.getBook()),userService.getUser(bookInOrder.getOrderUser()));
        if(maxFree > Integer.parseInt(quantity)) {
            Integer priceBook = bookService.findBookById(bookInOrder.getBook()).getPrice();
            Integer oldCountBooks = bookInOrder.getQuantity();
            OrderUser orderUser = orderUserRepo.getOne(bookInOrder.getOrderUser());
            Integer newPrice = orderUser.getPrice() - (priceBook * oldCountBooks);
            orderUser.setPrice(newPrice + (priceBook * Integer.parseInt(quantity)));
            bookInOrder.setQuantity(Integer.parseInt(quantity));
            orderUserRepo.save(orderUser);
            booksInOrderUserRepo.save(bookInOrder);
        }
    }

    public void deletBookOfOrder(BooksInOrderUser bookInOrder) {
        Integer priceBook = bookService.findBookById(bookInOrder.getBook()).getPrice();
        Integer oldCountBooks = bookInOrder.getQuantity();
        OrderUser orderUser = orderUserRepo.getOne(bookInOrder.getOrderUser());
        Integer newPrice = orderUser.getPrice()-(priceBook*oldCountBooks);
        booksInOrderUserRepo.delete(bookInOrder);
        if(newPrice > 0) {
            orderUser.setPrice(newPrice);
            orderUserRepo.save(orderUser);
        }else{
            orderUserRepo.delete(orderUser);
        }
    }

    public void сheckoutOrder(OrderUser order, User user) {
        if(user.getMany() > order.getPrice() && checkCountBook(order.getId())){
            user.setMany(user.getMany() - order.getPrice());
            userService.saveUserInDB(user);
            issuanceOfBooks(order.getId());
            order.setPaid(1);
            orderUserRepo.save(order);
        }
    }

    private boolean checkCountBook(Long orderId){
        List<BooksInOrderUser> listBooks = booksInOrderUserRepo.findByOrderUserId(orderId);
        for (BooksInOrderUser bookOfOrder: listBooks) {
            if(bookOfOrder.getQuantity() > bookService.findBookById(bookOfOrder.getBook()).getCount()){
                return false;
            }

        }
        return true;
    }
    private void issuanceOfBooks(Long orderId){
        List<BooksInOrderUser> listBooks = booksInOrderUserRepo.findByOrderUserId(orderId);
        for (BooksInOrderUser bookOfOrder: listBooks) {
            Book book = bookService.findBookById(bookOfOrder.getBook());
            book.setCount(book.getCount() - bookOfOrder.getQuantity());
            bookService.saveBook(book);
        }

    }

    public List<OrderUserTransport> getHistoryOrders(Long userId){
        List<OrderUserTransport> listOrder = new ArrayList<>();
        List<OrderUser> orderUserPaid = orderUserRepo.findByCustomerAndPaid(userId,1);
        for (int i = 0; i < orderUserPaid.size(); i++) {
            OrderUserTransport transport = new OrderUserTransport();
            transport.setPriceOrder(orderUserPaid.get(i).getPrice());
            transport.setIdOrder(orderUserPaid.get(i).getId());
            List<BooksInOrderUser> listBook = booksInOrderUserRepo.findByOrderUserId(orderUserPaid.get(i).getId());
            transport.setNameAndQuantityBook(getTitleAndCountBook(listBook));
            listOrder.add(transport);
        }
        return  listOrder;
    }

    public boolean testCleanBasket(OrderUser orderUser) {
        List<OrderUser> listOrderUser = orderUserRepo.findByCustomerAndPaid(orderUser.getUser(),0);
        if(listOrderUser.size() != 0)
            return false;
        else{
            orderUser.setPaid(0);
            orderUserRepo.save(orderUser);
            return true;
        }
    }

    private HashMap<String, Integer> compareGenre(List<BooksInOrderUser> listBooksOrder, HashMap<String, Integer> result){
        for (int j = 0; j < listBooksOrder.size(); j++) {
            if(result.containsKey(bookService.findBookById(listBooksOrder.get(j).getBook()).getGenre().getName())){
                result.replace(bookService.findBookById(listBooksOrder.get(j).getBook()).getGenre().getName(),
                        result.get(bookService.findBookById(listBooksOrder.get(j).getBook()).getGenre().getName())+1);
            }
        }
        return result;
    }


    public HashMap<String, Integer> getGenreList(Long id) {
        HashMap<String, Integer> result = bookService.getListGenre();
        List<OrderUser> listOrder = orderUserRepo.findByCustomerAndPaid(id,1);
        for (int i = 0; i < listOrder.size(); i++) {
           result = compareGenre(booksInOrderUserRepo.findByOrderUserId(listOrder.get(i).getId()),result);
        }
        return result;
    }


    public boolean checkForFreeBooks(Book book, User user, int quantity){
        if(quantity < maxFreeBooks(book, user))
           return true;
        else
            return false;
    }

    public int maxFreeBooks(Book book, User user){
        int quantityBookInStore = book.getCount();
        int quantityBookInBasketOtherUser = getQuantityBookInBasketOtherUser(user, book.getId());
        return quantityBookInStore - quantityBookInBasketOtherUser;
    }

    private int getQuantityBookInBasketOtherUser(User user, Integer bookId) {
        int result = 0;
        List<OrderUser> listOrderUser = orderUserRepo.findByPaidAndCustomerNot(0,user.getId());
        for (int i = 0; i < listOrderUser.size(); i++) {
            List<BooksInOrderUser> listBooks = booksInOrderUserRepo.findByOrderUserId(listOrderUser.get(i).getId());
            for (int j = 0; j < listBooks.size(); j++) {
                 if(listBooks.get(i).getBook() == bookId) result += listBooks.get(i).getQuantity();
            }
        }
        return result;
    }

    public void orderToSuppliers(String bookId, String author, String quantity){
        manager.createNewOrder(bookId,author,quantity);
    }

    public boolean testCheckoutFreeBookInStore(OrderUser order){
        List<BooksInOrderUser> listBook = booksInOrderUserRepo.findByOrderUserId(order.getUser());
        for (int i = 0; i < listBook.size(); i++) {
            if(!checkForFreeBooks(bookService.findBookById(listBook.get(i).getBook()),
                    userService.getUser(listBook.get(i).getOrderUser()),
                    listBook.get(i).getQuantity())) return false;
        }
        return true;
    }
}
