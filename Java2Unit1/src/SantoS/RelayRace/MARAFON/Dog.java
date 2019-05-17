package SantoS.RelayRace.MARAFON;

public class Dog extends Animal implements Sportsmen{
    Dog(String name, String breed, int run, int jump,int swim){
        if(name.length() > 5) super.name = name;
        if(breed.length() > 5) super.breed = breed;
        if(run > 0) super.max_run = run;
        if(swim > 0) super.max_swim = swim;
        if(jump > 0) super.max_jamp = jump;
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
        System.out.println("Порода " + this.breed);
    }

    @Override
    public boolean sportsmenOnDistans() {
        return this.onDistans;
    }
}
