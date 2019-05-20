package Exception;

public class SummException extends Exception {
    private int param;

    SummException(String msg,int p){
        super(msg);
        this.param = p;
    }
}
