package Exception;

public class MyArraySizeException extends Exception{
    private int length;

    public MyArraySizeException(int length, String msg){
        super(msg);
        this.length = length;
    }


}
