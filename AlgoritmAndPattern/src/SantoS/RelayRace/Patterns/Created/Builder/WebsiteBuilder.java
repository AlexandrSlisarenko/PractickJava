package SantoS.RelayRace.Patterns.Created.Builder;

public abstract class WebsiteBuilder {
    public Website website;

    void createWebsite(){
        this.website = new Website();
    }

    Website getWebsite(){
        return this.website;
    }

    abstract void buildWebsiteName();

    abstract void buildCMS();

    abstract void buildPrice();

}
