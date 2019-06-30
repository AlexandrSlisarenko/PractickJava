package SantoS.RelayRace.Patterns.Created.Factory;

public class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDevelopet() {
        return new CppDeveloper();
    }
}
