package com.company;


public class Person {
    private String fio;
    private String position;
    private String email;
    private String telefon;
    private int salary;
    private int age;

    public Person(String fio, String position, String email, String telefon , int salary, int age ){
        this.fio = fio;
        this.position = position;
        if(TestParamPerson.correctEmail(email)) this.email = email;
        if(TestParamPerson.correctPhone(telefon)) this.telefon = telefon;
        if(TestParamPerson.correctSalary(salary)) this.salary = salary;
        if(TestParamPerson.correctAge(age)) this.age = age;
    }

    public void setFio(String fio){
        this.fio = fio;
    }

    public String getFio(){
        return this.fio;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return this.position;
    }


    public void setEmail(String email){
        if(TestParamPerson.correctEmail(email)) this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setTelefon(String telefon){
        if(TestParamPerson.correctPhone(telefon)) this.telefon = telefon;
    }

    public String getTelefon(){
        return this.telefon;
    }

    public void setSalary(int sel){
        if(TestParamPerson.correctSalary(sel)) this.salary = sel;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setAge(int age){
        if(TestParamPerson.correctAge(age)) this.age = age;
    }

    public int getAge(){
        return this.age;
    }


   public void printPersonInfo(){
        System.out.print("ФИО сотрудника: "+this.fio);
        System.out.println();
       System.out.print("Должность сотрудника: "+this.position);
       System.out.println();
       System.out.print("E-mail сотрудника: "+this.email);
       System.out.println();
       System.out.print("Телефон сотрудника: "+this.telefon);
       System.out.println();
       System.out.print("Зарплата сотрудника: "+this.salary);
       System.out.println();
       System.out.print("Возраст сотрудника: "+this.age);
       System.out.println();
   }

}
