package LearnThread;

public class TimeRunMetod{
    TimeRunThreadMetod [] masThread;
    float [] mass;
    int count = 1;
    int length = 1;
    float [][] masstmpthread;
    long time1;
    long time2;

    public TimeRunMetod(int countThread,int lengthM){
        if(countThread > 1){this.count = countThread;}
        if(lengthM > 1){this.length = lengthM;}
        this.masstmpthread = new float[this.count][];
        this.masThread = new TimeRunThreadMetod[this.count];
        getMass();
        metod();
    }


    public void getMass(){
        this.mass = new float[this.length];
        for (int i = 0;i<this.length;i++) this.mass[i] = 1;

    }



    public void metod(){
        this.time1 = System.currentTimeMillis();
        int lengthTempMass = this.length / this.count;
        int tmp = 0;
        for (int i =0; i < this.count;i++){
            this.masstmpthread[i] = new float[lengthTempMass];
            System.arraycopy(this.mass, tmp, this.masstmpthread[i],0, lengthTempMass);
            this.masThread[i] = new TimeRunThreadMetod(this.masstmpthread[i]);
        }
        try{
            for (int i =0; i < this.count;i++){

                this.masThread[i].t.join();
            }
        }catch (InterruptedException e){
            System.out.println("Поток прерван");
        }
        tmp = 0;
        for (int i =0; i < this.count;i++,tmp+=lengthTempMass){
            System.arraycopy(this.masstmpthread[i], 0, this.mass,tmp, lengthTempMass);

        }
        this.time2 = System.currentTimeMillis();
        System.out.println(this.time2 - this.time1);
    }




}
