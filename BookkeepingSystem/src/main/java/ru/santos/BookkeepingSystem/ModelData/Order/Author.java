package ru.santos.BookkeepingSystem.ModelData.Order;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    //@OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name="book_id")
    //private Set<Long> book_id;

    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    @CollectionTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"))
    private Set<Integer> author_book_id = new HashSet();

    public Author(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getAuthor_book_id() {
        return author_book_id;
    }

    /*public void setAuthor_book_id(Set<Integer> author_book_id) {
        this.author_book_id = author_book_id;
    }*/



}
