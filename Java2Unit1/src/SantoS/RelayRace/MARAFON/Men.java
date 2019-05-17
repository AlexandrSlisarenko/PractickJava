package SantoS.RelayRace.MARAFON;

public class Men extends Human implements Sportsmen {

    boolean tent;

    Men(String name, int height, int weight, String sportTitle, int run, int jump,int swim){
        super.name = name;
        super.height = height;
        super.weight = weight;
        super.sportTitle = sportTitle;
        super.max_jamp = jump;
        super.max_run = run;
        super.max_swim = swim;
        this.tent = false;
    }

    public void put_up_a_tent(){
        this.tent = true;
        System.out.println("Полатка поставлена");
    }
    public void put_down_a_tent(){
        this.tent = false;
        System.out.println("Полатка убрана");
    }
    public void tent_info(){
        if( this.tent){System.out.println("Полатка стоит");}else{System.out.println("Полатка убрана");}
    }

    public int get_wood(){return 10;}

    @Override
    public void doRun(int dist) {
        if(this.max_run >= dist)
            System.out.println("Спортсмен " + this.name + " пробежал дистанцию " + dist + " метров");
        else {
            System.out.println("Спортсмен " + this.name + " не пробежал дистанцию " + dist + " метров");
            this.onDistans = false;
        }
    }

    @Override
    public void doSwim(int dist) {
        if(this.max_swim >= dist)
            System.out.println("Спортсмен " + this.name + " проплыл дистанцию " + dist + " метров");
        else {
            System.out.println("Спортсмен " + this.name + " не проплыл дистанцию " + dist + " метров");
            this.onDistans = false;
        }
    }

    @Override
    public void doJump(int height) {
        if(this.max_jamp >= height)
            System.out.println("Спортсмен " + this.name + " взял высоту в " + height + " метров");
        else {
            System.out.println("Спортсмен " + this.name + " не взял высоту в " + height + " метров");
            this.onDistans = false;
        }
    }

    @Override
    public void getInfo() {
        System.out.println("Спортсмен " + this.name);
        System.out.println("Звание" + this.sportTitle);
    }
    @Override
    public boolean sportsmenOnDistans() {
        return this.onDistans;
    }
}
