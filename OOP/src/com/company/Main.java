package com.company;

public class Main {

    public static void main(String[] args) {

        //Person pr = new Person("Иванов Константин Михайлович","Бухгалтер", "ivk@mail.ru", "+71234567890",20000, 25);
        //pr.printPersonInfo();

        Person [] company  = new Person[5];
        company[0] = new Person("Иванов Константин Михайлович","Бухгалтер", "ivk@mail.ru", "+71234567890",20000, 25);
        company[1] = new Person("Петров Константин Михайлович","Бухгалтер", "pvk@mail.ru", "+71234567890",30000, 40);
        company[2] = new Person("Иванов Василий Михайлович","Бухгалтер", "ivm@mail.ru", "+71234567890",43000, 42);
        company[3] = new Person("Иванов Александр Михайлович","Бухгалтер", "iak@mail.ru", "+71234567890",24000, 18);
        company[4] = new Person("Сидоров Константин Михайлович","Бухгалтер", "svk@mail.ru", "+71234567890",90000, 50);

        System.out.println("Данные сотрудников страрше 40 лет");
        for(int i =0;i < company.length;i++){
            if(company[i].getAge() >= 40){
                company[i].printPersonInfo();
                System.out.println();
            }

        }

        Cat c = new Cat("Барсик","Желтый","Перс", 200,2);
        Dog dog = new Dog("Шарик","Серый","Дворовый", 500,1, 10);
        c.printDescription();
        dog.printDescription();
        System.out.println(dog.swim(20));
        System.out.println(c.run(100));
        System.out.println(c.jamp(2));



    }
}
