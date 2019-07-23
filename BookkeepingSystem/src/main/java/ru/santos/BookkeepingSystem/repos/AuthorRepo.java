package ru.santos.BookkeepingSystem.repos;

import org.springframework.data.repository.CrudRepository;
import ru.santos.BookkeepingSystem.ModelData.Order.Author;


public interface AuthorRepo extends CrudRepository<Author, Integer> {

}
