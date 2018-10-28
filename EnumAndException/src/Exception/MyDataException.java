package Exception;

public class MyDataException extends Exception {
    private int i;
    private int j;

    public MyDataException(int i, int j, String msg){
        super(msg);
        this.i = i;
        this.j = j;
    }


}
