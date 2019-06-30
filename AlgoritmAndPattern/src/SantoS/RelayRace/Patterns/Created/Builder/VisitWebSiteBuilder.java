package SantoS.RelayRace.Patterns.Created.Builder;

public class VisitWebSiteBuilder extends WebsiteBuilder {
    @Override
    void buildWebsiteName() {
        website.setName("VisitWebSite");
    }

    @Override
    void buildCMS() {
        website.setCms(CMS.MODX);
    }

    @Override
    void buildPrice() {
        website.setPrice(1000);
    }
}
