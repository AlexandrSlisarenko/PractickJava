package com.company;

import sun.awt.geom.AreaOp;

import java.util.Random;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        int [] arr = {1,0,0,1,1,0,0,0,1,0,1};
        //replaceZerobyone(arr);
        //arr = new int [8];
        //fillingAnArray(arr);
        //lessThenSixMultiplyByTwo();
       // int [] arr1 = {23,5,1,6,0,45,3,2,78};
        //minMax(arr1);

        //int [][] arrTwo = new int[5][5];
        //unitsDiagonally(arrTwo);

        int [] arr1 = {1, 1, 1, 2, 1};
        //System.out.print(checkBalans(arr1));
        printArray1(shiftingAnElement(arr1,8));
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

    static void printArray1(int [] arr){
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[j]+"\t");
        }
    }

    static  boolean checkBalans(int [] arr){

        boolean res = false;
        int sum = 0;
        for(int i = 0;i < arr.length; i++){
            sum += arr[i];
        }
        return (sum % 2 == 0)? true : false;
    }

    static int [] shiftingAnElement(int [] arr, int shift){
        int length = arr.length;
        int new_length = Math.abs(shift) + arr.length;
        arr = Arrays.copyOf(arr, new_length);
        if(shift < 0){
            int j = new_length -1;
            for(int i = length -1;i >= 0; i--){
                arr[j] = arr[i]; arr[i] = 0; j--;
            }
        }else{
            for(int i = length;i < new_length; i++){
                arr[i] = 0;
            }
        }
        return arr;
    }
}
