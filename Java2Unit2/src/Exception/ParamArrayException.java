package Exception;

public class ParamArrayException extends Exception {
    private int param;

    public int getParam() {
        return param;
    }

    public ParamArrayException(String msg, int param) {
        super(msg);
        this.param = param;
    }
}


