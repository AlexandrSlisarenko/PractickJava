package SantoS.RelayRace.Patterns.Created.Builder;

public class Website {
    private String name;
    private CMS cms;
    private int price;


    public void setName(String name) {
        this.name = name;
    }

    public void setCms(CMS cms) {
        this.cms = cms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Сайт:" + this.name+"; CMS:"+this.cms+"; Цена:"+this.price;
    }
}
