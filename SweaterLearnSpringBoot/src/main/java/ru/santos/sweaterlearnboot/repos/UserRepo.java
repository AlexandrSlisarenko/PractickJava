package ru.santos.sweaterlearnboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.sweaterlearnboot.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
