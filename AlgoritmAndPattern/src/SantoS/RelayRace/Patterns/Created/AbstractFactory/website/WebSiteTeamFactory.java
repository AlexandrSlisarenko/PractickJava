package SantoS.RelayRace.Patterns.Created.AbstractFactory.website;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Developer;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.Manager;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.ProjectTeamFactory;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.Tester;

public class WebSiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Manager getProjectManager() {
        return new WebSiteManager();
    }

    @Override
    public Tester getManualTester() {
        return new ViewTester();
    }
}
