package ru.santos.BookkeepingSystem.queueManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import ru.santos.BookkeepingSystem.XMLParser.Parser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
public class Manager {
    @Autowired
    private Producer producer;
    private String pausa = "360000";
    @Autowired
    private Parser parser;

    @Scheduled(fixedDelay = 1)
    public void standardDelivery(){
        while (true){
            try {
                producer.produce("D:\\Java\\PractickJava\\BookkeepingSystem\\src\\main\\resources\\static\\order.xml");
                Thread.sleep(Long.parseLong(this.pausa));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPausa() {
        return pausa;
    }


    public void setPausa(String pausa) {
        this.pausa = pausa;
    }

    public void createNewOrder(String title, String author, String count){
        try {
            String path = parser.createOrderFinishedBook(title,author,count);
            if(path != "") producer.produce(path);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
