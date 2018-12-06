package Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream outStream = null;
        DataInputStream inStream = null;
        try{
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            outStream = new DataOutputStream(socket.getOutputStream());
            inStream = new DataInputStream(socket.getInputStream());

            while (true){
                String message = inStream.readUTF();
                System.out.println(message);
                if(message.equals("/end")) break;
                outStream.writeUTF(message);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                server.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
