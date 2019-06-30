package SantoS.RelayRace.Patterns.Created.Factory;

public class Programm {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpecialty("java");

        developerFactory.createDevelopet().writeCode();
    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty){
        DeveloperFactory developerFactory;
        switch (specialty){
            case "java":
                developerFactory = new JavaDeveloperFactory();
                break;
            case "c++":
                developerFactory = new CppDeveloperFactory();
                break;
            default:
                developerFactory = null;
                throw new RuntimeException(specialty + " is unknown specialty");
        }
        return developerFactory;
    }
}
