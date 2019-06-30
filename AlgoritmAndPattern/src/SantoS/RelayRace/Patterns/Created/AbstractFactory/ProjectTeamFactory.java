package SantoS.RelayRace.Patterns.Created.AbstractFactory;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Manager getProjectManager();
    Tester getManualTester();
}
