package SantoS.RelayRace.Patterns.Created.AbstractFactory.banking;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void writeCode(){
        System.out.println("Java developer write java code...");
    }
}
