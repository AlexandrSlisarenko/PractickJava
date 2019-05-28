package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML
    TextArea jta;
    @FXML
    TextField jtf;
    @FXML
    Button jb1;
    @FXML
    ScrollPane jscroll;
    @FXML
    VBox jboxMSG;

    public void sendMSG(ActionEvent actionEvent) {

        TextArea ta = new TextArea();
        ta.appendText(jtf.getText());
        ta.autosize();
        ta.setPrefHeight(50);
        ta.setEditable(false);

        if(((jboxMSG.getChildren().size()+1)%2) == 0){
            ta.getStyleClass().add("tabUser");
            System.out.println(ta.getStyleClass());


        }
        ta.getStyleClass().add("msg");
        jboxMSG.getChildren().add(ta);


    }

}
