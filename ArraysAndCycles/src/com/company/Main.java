package com.company;

import sun.awt.geom.AreaOp;

import java.util.Random;
public class Main {

    public static void main(String[] args) {

        int [] arr = {1,0,0,1,1,0,0,0,1,0,1};
        //replaceZerobyone(arr);
        //arr = new int [8];
        //fillingAnArray(arr);
        //lessThenSixMultiplyByTwo();
        int [] arr1 = {23,5,1,6,0,45,3,2,78};
        //minMax(arr1);

        int [][] arrTwo = new int[5][5];
        unitsDiagonally(arrTwo);
    }

   static void replaceZerobyone(int [] arr){
        int l = arr.length;

        System.out.println("Начальный массива");
        for(int i = 0;i < l;i++){
            System.out.print(arr[i]);
        }
        System.out.println("Результат");
       for(int i = 0;i < l;i++){
           if(arr[i] == 0){arr[i] = 1;}else{arr[i] = 0;}
           System.out.print(arr[i]);
       }

   }

   static void fillingAnArray(int [] arr){
        int i  = 0;
        int j = 0;
        int l = arr.length;
        while (i < l){

            arr[i] = j;
            System.out.println(arr[i]);
            j += 3;
            i++;
        }
   }

   static void lessThenSixMultiplyByTwo(){
        int i = 0;
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        do{

            if(arr[i] < 6) arr[i] *=2;
            System.out.println(arr[i]);
            i++;
        }while(i < arr.length);
   }

   static void minMax(int [] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i <arr.length; i++){
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }
        System.out.println(min);
        System.out.println(max);
   }
   static void unitsDiagonally(int [][] arr){
       Random ran = new Random();
       int i;
       int j;
       for(i = 0; i < arr.length; i++){
            for(j = 0; j < arr[i].length; j++){
                //arr[i][j] = ran.nextInt(10);
                arr[i][j] = 0;
            }
        }
        printArray(arr);
       System.out.println("Результат");
       for (i =0;i < arr.length; i++){
           arr[i][i] = 1;
       }
       j = arr.length-1;
       for (i =0;i < arr.length; i++){
           arr[i][j] = 1;
           j--;
       }
       printArray(arr);
   }
   static void printArray(int [][] arr){
       for(int i = 0; i < arr.length; i++){
           for(int j = 0; j < arr[i].length; j++){
               System.out.print(arr[i][j]+"\t");
           }
           System.out.println();
       }
   }
}
