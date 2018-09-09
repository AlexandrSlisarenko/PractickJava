package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {1,0,0,1,1,0,0,0,1,0,1};
        //replaceZerobyone(arr);
    }

   static void replaceZerobyone(int [] arr){
        int l = arr.length;

        System.out.println("Начальный массива");
        for(int i = 0;i < l;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Результат");
       for(int i = 0;i < l;i++){
           if(arr[i] == 0){arr[i] = 1;}else{arr[i] = 0;}
           System.out.println(arr[i]);
       }

   }
}
