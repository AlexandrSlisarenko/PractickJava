package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Controller {


    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button sendButton;

    @FXML
    VBox messageBox;

    ScrollPane scroll = new ScrollPane(messageBox);

    public void sendMessage(ActionEvent actionEvent) {
        if(textField.getText() != " ") {
            TextField msg = new TextField();
            msg.setText(textField.getText() + "\n");
            if (messageBox.getChildren().size() % 2 != 0)
                msg.setAlignment(Pos.BASELINE_RIGHT);
            messageBox.getChildren().add(msg);

            textField.clear();
            textField.requestFocus();
        }
    }
}
