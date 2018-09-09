package com.company;

import sun.awt.geom.AreaOp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {1,0,0,1,1,0,0,0,1,0,1};
        //replaceZerobyone(arr);
        //arr = new int [8];
        //fillingAnArray(arr);
        //lessThenSixMultiplyByTwo();
        int [] arr1 = {23,5,1,6,0,45,3,2,78};
        minMax(arr1);
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
}
