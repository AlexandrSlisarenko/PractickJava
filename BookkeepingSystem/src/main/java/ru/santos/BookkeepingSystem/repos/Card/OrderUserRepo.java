package ru.santos.BookkeepingSystem.repos.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.User.User;

import java.util.List;


public interface OrderUserRepo extends JpaRepository<OrderUser,Long> {

    List<OrderUser> findByCustomerAndPaid(Long user, Integer paid);

    List<OrderUser> findByPaidAndCustomerNot(Integer i, Long id);
}
