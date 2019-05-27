package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea jta;
    @FXML
    TextField jtf;
    @FXML
    Button jb1;

    public void sendMSG(ActionEvent actionEvent) {

        jta.appendText(jtf.getText() + "\n");
        jtf.setText("");


    }

}
