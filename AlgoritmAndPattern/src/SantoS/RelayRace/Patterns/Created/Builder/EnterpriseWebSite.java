package SantoS.RelayRace.Patterns.Created.Builder;

public class EnterpriseWebSite extends WebsiteBuilder {
    @Override
    void buildWebsiteName() {
        website.setName("EnterpriseWebSite");
    }

    @Override
    void buildCMS() {
        website.setCms(CMS.BITRIX);
    }

    @Override
    void buildPrice() {
        website.setPrice(10000000);
    }
}
