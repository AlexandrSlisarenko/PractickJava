package LearnThread;

public class TimeRunThreadMetod implements Runnable {
    float[] arr;
    Thread t;
    public TimeRunThreadMetod(float [] arr){
        this.arr = arr;
        this.t = new Thread(this,"Поток рассчета");
        t.start();
    }

    @Override
    public void run() {

        try {
            for (int i = 0;i<this.arr.length;i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            //Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
