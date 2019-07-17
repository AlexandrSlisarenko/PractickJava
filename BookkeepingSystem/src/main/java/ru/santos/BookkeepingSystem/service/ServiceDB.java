package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;
import ru.santos.BookkeepingSystem.repos.BookRepo;


import java.util.ArrayList;

@Service
public class ServiceDB {
    @Autowired
    private BookRepo bookRepo;

    public void addToDB(ArrayList<Book> list){
        Iterable<Book> booksInDB = bookRepo.findAll();
        boolean ok = true;
        for (int i = 0; i < list.size(); i++) {
            for(Book bookBD :booksInDB){
                if(bookBD.getTitle().equals(list.get(i).getTitle())){
                    ok = false;
                    bookBD.setCount(bookBD.getCount()+list.get(i).getCount());
                    bookBD.setPrice(list.get(i).getPrice());
                    bookRepo.save(bookBD);
                    break;
                }
            }
            if(ok){
                bookRepo.save(list.get(i));
            }
        }
        list.clear();
    }
}
