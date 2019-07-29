package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.ModelData.User.Liked;
import ru.santos.BookkeepingSystem.repos.LikedRepo;

import java.util.List;

@Service
public class LikedService {

    @Autowired
    private LikedRepo likedRepo;


    public List<Liked> findByUserId(Long id) {
        return likedRepo.findByUserId(id);
    }

    public List<Liked> findByUserIdAndBookId(Long id, Integer bookId) {
        return likedRepo.findByUserIdAndBookId(id, bookId);
    }

    public void saveLike(Liked nLike) {
        likedRepo.save(nLike);
    }

    public void deleteLike(Liked liked) {
        likedRepo.delete(liked);
    }
}
