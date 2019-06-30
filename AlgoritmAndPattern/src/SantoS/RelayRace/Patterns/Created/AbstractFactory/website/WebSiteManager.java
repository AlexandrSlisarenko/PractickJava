package SantoS.RelayRace.Patterns.Created.AbstractFactory.website;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Manager;

public class WebSiteManager implements Manager {
    @Override
    public void managerProject() {
        System.out.println("Manager maneges website...");
    }
}
