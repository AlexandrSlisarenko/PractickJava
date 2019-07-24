package ru.santos.BookkeepingSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.santos.BookkeepingSystem.ModelData.User.Liked;

import java.util.List;

public interface LikedRepo extends JpaRepository<Liked,Long> {
    List<Liked> findByUserId(Long id);

    List<Liked> findByUserIdAndBookId(Long id, Integer bookId);
}
