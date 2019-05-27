package SantoS.RelayRace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	    new MyWindow();
    }
}

class MyWindow extends JFrame{
    MyWindow(){
        setTitle("JavaGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int sizeW = 800;
        int sizeH = 600;
        int locationX = (screenSize.width - sizeW) /2;
        int locationY = (screenSize.height - sizeH) /2;
        setBounds(locationX,locationY,sizeW,sizeH);

        JPanel panalChat = new JPanel();
        JPanel panalButton = new JPanel();
        //цвет фона
        panalChat.setBackground(Color.ORANGE);
        panalButton.setBackground(Color.BLACK);
        //минимальный желательный размер
        panalChat.setPreferredSize(new Dimension(1,40));
        panalButton.setPreferredSize(new Dimension(1,40));
        //компановщики панелей
        panalChat.setLayout(new BorderLayout());
        panalButton.setLayout(new FlowLayout());
        //элементы
        JButton b1 = new JButton("Отправить");
        JTextArea jt = new JTextArea();
        jt.setEditable(false);
        JScrollPane jsp = new JScrollPane(jt);
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(300,28));


        panalChat.add(jsp, BorderLayout.CENTER);
        panalButton.add(jtf);
        panalButton.add(b1);

        add(panalChat,BorderLayout.CENTER);
        add(panalButton,BorderLayout.SOUTH);




        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.append(jtf.getText()+ "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });



        setVisible(true);
    }
}

