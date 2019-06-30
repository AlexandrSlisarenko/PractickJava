package SantoS.RelayRace.Patterns.Created.AbstractFactory.website;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php Developer write php code...");
    }
}
