package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

class Window {
    private JFrame calc;
    private Calculation object_calc; //объект который считает

    public Window(Calculation c){

        //Создали фрейм калькулятора
        calc = new JFrame("Калькулятор");
        object_calc = c;
        //Действвие на крестик
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Получили понель калькулятора
        Container panel_calc = calc.getContentPane();

        // Создаем панель формы
        JPanel forma = new JPanel();

        //задаем менеджер расположения
        BoxLayout bl = new BoxLayout(forma, BoxLayout.Y_AXIS);
        forma.setLayout(bl);

        //поле ввода
        JTextField field = new JTextField(25);

        //выводить то что вводит пользователь
        JLabel enter = new JLabel("Введите число и нажмите Enter");
        enter.setBounds(0,0,200,50);

        //задаем панель расположения поля
        JPanel pfe = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pfe.add(new JLabel("Арифметический калькулятор пяти действий"));
        pfe.add(field);

        //добвляем понель с полем в панель формы
        forma.add(pfe);

        //Создали поле кнопок действий

        JPanel button_arifmitic_pannel =  new JPanel(new GridLayout(1,0,5,5));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton umn = new JButton("*");
        JButton del = new JButton("/");
        JButton sup = new JButton("sup");

        button_arifmitic_pannel.add(plus);
        button_arifmitic_pannel.add(minus);
        button_arifmitic_pannel.add(umn);
        button_arifmitic_pannel.add(del);
        button_arifmitic_pannel.add(sup);

        //центрируем кнопки
        JPanel ar_butt = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ar_butt.add (button_arifmitic_pannel);

        //добавляем кнопки в форму
        forma.add(ar_butt);

        //результат
        JButton res_button = new JButton("Итого!");

        //создаем панель для вывода хода и результата вычисления
        JPanel butt = new JPanel(new FlowLayout(FlowLayout.CENTER));
        butt.add(res_button);
        JPanel enter_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        enter_panel.add(enter);
        forma.add(enter_panel);
        forma.add(butt);
        forma.setSize(panel_calc.getWidth(), panel_calc.getHeight());
        panel_calc.add(forma);
        //
       //center.add(center_panel);
        //calc.add(panel_calc);
        calc.setSize(400,250);
        calc.setLocation(100,100);
        //calc.pack();
        calc.setVisible(true);


        ///...Слушатели...

        //поле ввода
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "нет") {
                    object_calc.setOper1(field.getText());
                    if(TestData.correctData(field.getText())){
                        enter.setText(field.getText());
                        object_calc.setAr_move("да");
                    }
                    else {
                        JOptionPane.showMessageDialog(forma,
                                "Ошибка ввода!",
                                "ERROR!!!",
                                JOptionPane.ERROR_MESSAGE);
                    }


                }
                else {
                    object_calc.setOper2(field.getText());
                    if(TestData.correctData(field.getText()))enter.setText(enter.getText()+field.getText());
                    else {
                        JOptionPane.showMessageDialog(forma,
                                "Ошибка ввода!",
                                "ERROR!!!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    System.out.println(object_calc.getOper2());

                }

                field.setText("");
            }

        });

        //кнопка плюс
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "да") {
                    object_calc.setAr_move("+");
                    enter.setText(enter.getText() + " + ");
                }
            }
        });

        //кнопка минус
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "да") {
                    object_calc.setAr_move("-");
                    enter.setText(enter.getText() + " - ");
                }
            }
        });

        //кнопка умножения
        umn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "да") {
                    object_calc.setAr_move("*");
                    enter.setText(enter.getText() + " * ");
                }
            }
        });

        //кнопка деления
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "да") {
                    object_calc.setAr_move("/");
                    enter.setText(enter.getText() + " / ");
                }
            }
        });

        //кнопка степень
        sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(object_calc.getAr_move() == "да") {
                    object_calc.setAr_move("степень");
                    enter.setText(enter.getText() + " в степени ");
                }
            }
        });

        //результат
        res_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if(object_calc.getAr_move() != "нет") {
                    enter.setText(enter.getText()+" = "+object_calc.calc_move());
                    object_calc.reset();
                }
            }
        });


    }

}
