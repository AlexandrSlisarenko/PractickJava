package SantoS.RelayRace.Patterns.Created.AbstractFactory.banking;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.Developer;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.Manager;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.ProjectTeamFactory;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Manager getProjectManager() {
        return new BankingManagerProject();
    }

    @Override
    public Tester getManualTester() {
        return new ManualTester();
    }
}
