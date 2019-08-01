package ru.santos.BookkeepingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.santos.BookkeepingSystem.queueManager.Manager;

@Service
public class StoreService {
    @Autowired
    private Manager manager;

    public String getTimeDelivery(){
        return manager.getPausa();
    }

    public void setTimeDelivery(String time){
        manager.setPausa(time);
    }


}
