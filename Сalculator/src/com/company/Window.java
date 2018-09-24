package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

class Window {
    private JFrame calc;
    private Calculation object_calc;

    public Window(Calculation c){

        //Создали фрейм калькулятора
        calc = new JFrame("Калькулятор");
        object_calc = c;
        //Действвие на крестик
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Получили понель калькулятора
        Container panel_calc = calc.getContentPane();
        JLabel res = new JLabel("Введите первый оператор и нажинет Enter");
        // Панель для заголовка
        JPanel north_panel = new JPanel();
        north_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        north_panel.add(new JLabel("Арифметический калькулятор!"));

        //добавили панель в фрейм
        panel_calc.add(north_panel, BorderLayout.NORTH);

        // Добавили кнопку Итого
        JButton res_button = new JButton("Итого!");
        res_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if(object_calc.getAr_move() != "нет") {
                    res.setText("Ваш результат: "+object_calc.calc_move());
                    object_calc.reset();
                }
            }
        });

        panel_calc.add(res_button, BorderLayout.SOUTH);

        //добавили поле ввода

        JPanel center_panel = new JPanel();

        JTextField field = new JTextField(25);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "нет") {
                    object_calc.setOper1(Integer.parseInt(field.getText()));
                    res.setText("Нажмите на кнопку необходимого действие.");
                }
                else {
                    object_calc.setOper2(Integer.parseInt(field.getText()));
                    res.setText("Нажмите клавишу 'Итого!'");
                }
                field.setText("");
            }
        });
        center_panel.add(field);


        //Создали поле кнопок действий
        JPanel button_arifmitic_pannel =  new JPanel(new GridLayout(1,5,5,5));
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object_calc.setAr_move("+");
                res.setText("Введите второй оператор и нажинет Enter");
            }
        });
        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object_calc.setAr_move("-");
                res.setText("Введите второй оператор и нажинет Enter");
            }
        });
        JButton umn = new JButton("*");
        umn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object_calc.setAr_move("*");
                res.setText("Введите второй оператор и нажинет Enter");
            }
        });
        JButton del = new JButton("/");
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object_calc.setAr_move("/");
                res.setText("Введите второй оператор и нажинет Enter");
            }
        });
        JButton sup = new JButton("степень");
        sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                object_calc.setAr_move("степень");
                res.setText("Введите второй оператор и нажинет Enter");
            }
        });
        button_arifmitic_pannel.add(plus);
        button_arifmitic_pannel.add(minus);
        button_arifmitic_pannel.add(umn);
        button_arifmitic_pannel.add(del);
        button_arifmitic_pannel.add(sup);
        center_panel.add(button_arifmitic_pannel);


        //результат

        res.setBounds(10,10,150,20);
        center_panel.add(res);

       //
       //center.add(center_panel);
        panel_calc.add(center_panel,BorderLayout.CENTER);
        //calc.add(panel_calc);
        calc.setSize(350,400);
        calc.setLocation(100,100);
        //calc.pack();
        calc.setVisible(true);
    }



    public JFrame getCalc() {
        return calc;
    }
}
