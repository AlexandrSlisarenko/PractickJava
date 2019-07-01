package ru.santos.sweaterlearnboot.repos;

import org.springframework.data.repository.CrudRepository;
import ru.santos.sweaterlearnboot.domain.Message;

import java.util.List;

public interface MessageRepo  extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
