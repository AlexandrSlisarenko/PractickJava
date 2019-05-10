package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.net.ServerSocket;



public class Controller implements Initializable {


    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button sendButton;

    @FXML
    VBox messageBox;

    ScrollPane scroll = new ScrollPane(messageBox);

    Socket socket;

    DataOutputStream out;
    DataInputStream in;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            socket = new Socket(IP_ADRESS,PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/serverClose")) break;
                            if (str != " ") {
                                TextField msg = new TextField();
                                msg.setText(str + "\n");
                                if (messageBox.getChildren().size() % 2 != 0)
                                    msg.setAlignment(Pos.BASELINE_RIGHT);
                                messageBox.getChildren().add(msg);

                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(ActionEvent actionEvent) {
        if(textField.getText() != " ") {
           try{
               String str = textField.getText();
               System.out.println(str);
               out.writeUTF(str);
               textField.clear();
               textField.requestFocus();
           }catch (IOException e){
               e.printStackTrace();
           }

            /* TextField msg = new TextField();
            msg.setText(textField.getText() + "\n");
            if (messageBox.getChildren().size() % 2 != 0)
                msg.setAlignment(Pos.BASELINE_RIGHT);
            messageBox.getChildren().add(msg);
            */

        }
    }


}
