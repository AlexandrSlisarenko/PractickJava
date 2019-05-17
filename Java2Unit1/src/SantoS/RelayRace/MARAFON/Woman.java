package SantoS.RelayRace.MARAFON;

public class Woman extends Human implements Sportsmen {

    boolean dinner;

    Woman(String name, int height, int weight, String sportTitle, int run, int jump,int swim){
        super.name = name;
        super.height = height;
        super.weight = weight;
        super.sportTitle = sportTitle;
        super.max_jamp = jump;
        super.max_run = run;
        super.max_swim = swim;
        this.dinner = false;
    }

    public void make_dinner(){
        this.dinner = true;
        System.out.println("Обед готов!!!");
    }
    public void dinner_info(){
        if(this.dinner){System.out.println("Обед готов!!!");}else{System.out.println("Обед не готов!");}
    }


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
