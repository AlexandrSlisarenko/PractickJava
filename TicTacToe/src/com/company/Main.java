package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {
    /*Объявление */
    private static char [][] mapGame;
    private static int SIZE_MAP;

    private static char CELL_X;
    private static char CELL_O;
    private static char CELL_EMPTY;
    private static int COUNT_CELL_EMPTY;
    private static int x;
    private static int y;
    private static Random rendom_step;
    private static Scanner scannerStepHuman;

    public static void main(String[] args) {
        /*инициализация переменных*/
        SIZE_MAP = 3;
        mapGame = new char[SIZE_MAP][SIZE_MAP];
        CELL_X = 'X';
        CELL_O = 'O';
        CELL_EMPTY = '@';
        COUNT_CELL_EMPTY = SIZE_MAP * SIZE_MAP;
        rendom_step = new Random(SIZE_MAP);
        scannerStepHuman = new Scanner(System.in);


        System.out.println("Hello, my friend!!! Will we play?");
        creatNewGame();
        startGame();
    }

    /*Создание поля игры*/
    private static void creatNewGame(){
        mapGame = new char[SIZE_MAP][SIZE_MAP];
        for(int i = 0; i < SIZE_MAP; i++) {
            for(int j = 0; j < SIZE_MAP; j++) mapGame[i][j] = CELL_EMPTY;
        }
        printMapGame(mapGame);
    }

    /*Вывод поля в актуальном состоянии*/
    private static void printMapGame(char [][] map){
        for(int i = 0; i <= SIZE_MAP; i++) System.out.print(i + " ");

        System.out.println();

        for(int i = 0; i < SIZE_MAP; i++) {
            System.out.print((i+1)+" ");
            for(int j = 0; j < SIZE_MAP; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /*Игра*/
    private static void startGame(){
        do{

            stepHuman();
            COUNT_CELL_EMPTY --;
            printMapGame(mapGame);
            if(is_Victory(CELL_X))break;

        }while(!stopGame());
    }

    /*проверка окончания игры*/
    private static boolean stopGame(){
        boolean result = (COUNT_CELL_EMPTY > 0)? false:true;
        return result;
    }

    /*Шаг человека*/
    private static void stepHuman(){
        boolean ok = true;
        System.out.print("Хода за человеком, прошу ввести координаты.");
        do {
            System.out.println();

            System.out.println("Введите X");
            x = scannerStepHuman.nextInt() -1;
            System.out.println();
            System.out.println("Введите Y");
            y = scannerStepHuman.nextInt()-1;
            ok = (x < 0 || x > SIZE_MAP || y < 0 || y > SIZE_MAP)? true:false;
        }while (ok);

        mapGame[y][x] = CELL_X;

    }

    /*проверка на победу*/
    private static boolean is_Victory(char player){
        int good=1;
        boolean result = false;

        while(y - good > 0) {
            if (mapGame[y - good][x] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            } else break;
        }
        while(y + good < SIZE_MAP) {
            if (mapGame[y + good][x] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        good = 1;
        while(x - good > 0) {
            if (mapGame[y][x - good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        while(x + good < SIZE_MAP) {
            if (mapGame[y][x + good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        good = 1;
        while(x - good > 0 && y - good > 0) {
            if (mapGame[y - good][x - good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        while(x + good < SIZE_MAP && y + good < SIZE_MAP) {
            if (mapGame[y + good][x + good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        good = 1;
        while(x + good < SIZE_MAP && y - good > 0) {
            if (mapGame[y - good][x + good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }
        while(x - good > 0 && y + good < SIZE_MAP) {
            if (mapGame[y + good][x - good] == player) {
                good++;
                if(good == SIZE_MAP) return true;
            }else break;
        }


        return result;
    }

}
