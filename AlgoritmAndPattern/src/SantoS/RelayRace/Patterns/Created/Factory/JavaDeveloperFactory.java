package SantoS.RelayRace.Patterns.Created.Factory;

public class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDevelopet() {
        return new JavaDeveloper();
    }
}
