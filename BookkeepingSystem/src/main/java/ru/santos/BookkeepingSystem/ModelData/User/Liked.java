package ru.santos.BookkeepingSystem.ModelData.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Liked {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Integer bookId;

    public Liked(){}


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public Integer getBook_id() {
        return bookId;
    }

    public void setBookId(Integer book_id) {
        this.bookId = book_id;
    }
}
