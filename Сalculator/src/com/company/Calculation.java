package com.company;

class Calculation {
    private int oper1;
    private int oper2;
    private String ar_move;

    public Calculation(){

        oper1 = 0;
        oper2 = 0;
        ar_move = "нет";
    }
    public void reset(){

        oper1 = 0;
        oper2 = 0;
        ar_move = "нет";
    }


    public int getOper1(){
        return oper1;
    }

    public void setOper1(int op){
        oper1 = op;
    }
    public int getOper2(){
        return oper2;
    }

    public void setOper2(int op){
        oper2 = op;
    }
    public String getAr_move(){
        return ar_move;
    }

    public void setAr_move(String ar){
        ar_move = ar;
    }

     public int  calc_move(){
        int res = 1;
        switch (ar_move){
            case "+":
                res = oper1+oper2;
                break;
            case "-":
                res = oper1-oper2;
                break;
            case "*":
                res = oper1*oper2;
                break;
            case "/":
                if(oper2 != 0) res = oper1/oper2;
                break;
            case "степень":
                for(int i = 0;i<oper2; i++) res *= oper1;
                break;
         }
         return res;
     }


}
