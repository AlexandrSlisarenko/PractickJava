package SantoS.RelayRace.Patterns.Created.AbstractFactory;

import SantoS.RelayRace.Patterns.Created.AbstractFactory.banking.BankingTeamFactory;
import SantoS.RelayRace.Patterns.Created.AbstractFactory.website.WebSiteTeamFactory;


public class WebSiteProject {
    public static void main(String[] args) {
        ManagerViewWorks_Singelton.getInstance().getWork(new BankingTeamFactory());
        ManagerViewWorks_Singelton.getInstance().getWork(new WebSiteTeamFactory());
    }





}
