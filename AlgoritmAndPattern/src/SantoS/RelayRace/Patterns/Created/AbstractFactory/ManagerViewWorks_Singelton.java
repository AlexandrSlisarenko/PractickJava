package SantoS.RelayRace.Patterns.Created.AbstractFactory;

public class ManagerViewWorks_Singelton {

    private static ManagerViewWorks_Singelton instans;

    private ManagerViewWorks_Singelton(){}

    public static synchronized ManagerViewWorks_Singelton getInstance(){
        if(instans == null) instans = new ManagerViewWorks_Singelton();
        return instans;
    }

    public void getWork(ProjectTeamFactory team){

        Developer developer = team.getDeveloper();
        Tester tester = team.getManualTester();
        Manager manager = team.getProjectManager();
        System.out.println("Start Work...");
        developer.writeCode();
        tester.testCode();
        manager.managerProject();
        System.out.println("Finish Work...");
    }
}
