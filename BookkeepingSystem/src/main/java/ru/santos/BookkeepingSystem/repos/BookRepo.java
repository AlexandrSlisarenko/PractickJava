package ru.santos.BookkeepingSystem.repos;

import org.springframework.data.repository.CrudRepository;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

}
