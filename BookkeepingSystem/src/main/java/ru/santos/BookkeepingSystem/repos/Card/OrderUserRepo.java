package ru.santos.BookkeepingSystem.repos.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.BookkeepingSystem.ModelData.Card.OrderUser;
import ru.santos.BookkeepingSystem.ModelData.User.User;


public interface OrderUserRepo extends JpaRepository<OrderUser,Long> {

    OrderUser findByCustomerAndPaid(Long user, Integer paid);
}
