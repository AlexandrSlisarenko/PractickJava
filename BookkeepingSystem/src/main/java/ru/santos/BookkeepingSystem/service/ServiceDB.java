package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Author;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.repos.AuthorRepo;
import ru.santos.BookkeepingSystem.repos.BookRepo;


import java.util.ArrayList;

@Service
public class ServiceDB {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    private Book findLastElement(Book bookExample){
        Book result = null;
        Iterable<Book> booksInDB = bookRepo.findAll();
        for(Book bookBD :booksInDB){
            if(bookBD.getTitle().equals(bookExample.getTitle())){
               result =  bookBD;

            }
        }
        if(result == null) throw new RuntimeException("Note Found Book!!!");
        return result;
    }

    private  void saveAuthor(Book book) {
        boolean ok1 = true;
        Author author = new Author();
        Iterable<Author> authorsInDB = authorRepo.findAll();
        if (authorsInDB.iterator().hasNext() == false) {

            author.setName(book.getAuthor());
            author.getAuthor_book_id().add(book.getId());
            authorRepo.save(author);
        }else{
            for (Author authorBD : authorsInDB) {
                if (authorBD.getName().equals(book.getAuthor())) {
                    ok1 = false;
                    break;
                }
            }
            if (ok1) {
                author.setName(book.getAuthor());
                author.getAuthor_book_id().add(book.getId());
                authorRepo.save(author);
            }
        }
    }

    public void addToDB(ArrayList<Book> list){
        Iterable<Book> booksInDB = bookRepo.findAll();

        boolean ok = true;

        for (int i = 0; i < list.size(); i++) {
            for(Book bookBD :booksInDB){
                if(bookBD.getTitle().equals(list.get(i).getTitle())){
                    ok = false;
                    bookBD.setCount(bookBD.getCount()+list.get(i).getCount());
                    if(list.get(i).getPrice() > 0) bookBD.setPrice(list.get(i).getPrice());
                    bookRepo.save(bookBD);
                    saveAuthor(bookBD);
                    break;
                }
            }
            if(ok){
                bookRepo.save(list.get(i));
                saveAuthor(findLastElement(list.get(i)));
            }
            ok = true;
        }
        list.clear();
    }
}
