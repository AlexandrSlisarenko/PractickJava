package SantoS.RelayRace.Patterns.Created.Builder;

public class WebSiteRuner {

    public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new VisitWebSiteBuilder());
        System.out.println(director.getSite().toString());
    }
}
