package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PhoneBook {
    private HashMap<String,Integer> indexTel;
    private HashMap<Integer,String> indexName;
    private ArrayList<ArrayList<String>> numbers;


    public PhoneBook(){
        this.indexName = new HashMap<Integer, String>();
        this.numbers = new ArrayList<ArrayList<String>>();
        this.indexTel = new HashMap<String, Integer>();
    }

    public void addRecord(String name,String [] tel){
        if(this.indexTel.get(name) != null){
            for (int i = 0;i < tel.length;i++){
                this.numbers.get(this.indexTel.get(name)).add(tel[i]);
            }
        }else {
            ArrayList<String> tmpName = new ArrayList<String>();
            for (int i = 0; i < tel.length; i++) {
                tmpName.add(tel[i]);
            }
            this.numbers.add(tmpName);
            int tmpKey = this.numbers.lastIndexOf(tmpName);
            this.indexName.put(tmpKey, name);
            this.indexTel.put(name, tmpKey);
        }
    }

    public void delRecord(String name){
        if (this.indexTel.get(name) != null) {
            int index = this.indexTel.get(name);
            this.numbers.get(index).clear();
            this.indexName.remove(index);
            this.indexTel.remove(name);
        }else
            System.out.println("нет такого(((");
    }

    public void findRecord(String name){
        System.out.println(name+":");
        if (this.indexTel.get(name) != null) {
            int index = this.indexTel.get(name);
            for (int i = 0; i < this.numbers.get(index).size(); i++) {
                System.out.println(this.numbers.get(index).get(i));
            }
        }else
            System.out.println("нет такого(((");
    }

    public void printAllRecords(){

       this.indexName.forEach((k, v) -> {

                System.out.println(v +":");
                int index = this.indexTel.get(v);
                for (int j = 0;j < this.numbers.get(index).size();j++) {
                    System.out.println(this.numbers.get(index).get(j));
                }

    });


    }
}
