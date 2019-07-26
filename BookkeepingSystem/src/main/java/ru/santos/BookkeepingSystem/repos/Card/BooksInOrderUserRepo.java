package ru.santos.BookkeepingSystem.repos.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.BookkeepingSystem.ModelData.Card.BooksInOrderUser;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.Order.Book;

import java.util.List;

public interface BooksInOrderUserRepo extends JpaRepository<BooksInOrderUser,Long> {
    List<BooksInOrderUser> findByOrderUserId(Long order);

    BooksInOrderUser findByOrderUserIdAndBookId(Long order, Integer book);
}
