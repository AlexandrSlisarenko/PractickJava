package SantoS.RelayRace.Patterns.Created.Builder;

public class Director {

    private  WebsiteBuilder builder;

    public void setBuilder(WebsiteBuilder builder){
        this.builder = builder;
    }

    public Website getSite(){
        builder.createWebsite();
        builder.buildWebsiteName();
        builder.buildCMS();
        builder.buildPrice();

        Website website = builder.getWebsite();
        return website;
    }

}
