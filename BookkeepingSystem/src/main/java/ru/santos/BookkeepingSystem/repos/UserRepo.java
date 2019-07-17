package ru.santos.BookkeepingSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.BookkeepingSystem.ModelData.User.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
