package Exception;

public class NoSuchDay extends Exception {
    private int param;

    public int getParam() {
        return param;
    }

    public NoSuchDay(String msg, int param) {
        super(msg);
        this.param = param;
    }
}
