package TestRassword;

public class TestPassword {
    private int length;
    private String strPass;

    public TestPassword(int length, String strPass) {
        this.length = length;
        this.strPass = strPass;
    }

    public boolean test(){
        if(this.strPass.length() < this.length){
            System.out.println("Пароль слишком маленькой длинны");
            return false;
        }else {
            if(this.strPass.matches("\\d.*[a-zA-Z].*")){
                System.out.println("Пароль корректный");
                return true;
            }else{
                System.out.println("Пароль не соответствует заданным условиям");
                return false;
            }
        }


    }

}
