package Exception;

public class CreatedDate {

    private int s1;
    private int s2;
    private String [][] massData;


    public CreatedDate(int s1, int s2) {
        if(s1 > 0) this.s1 = s1;
        if(s1 > 0) this.s2 = s2;
        this.massData = new String[s1][s2];
        fillMass();
    }

    private void fillMass(){
        int tmp = 0;
        for (int i = 0; i < this.s1;i++){
            for (int j = 0; j < this.s1;j++){
                massData[i][j] = String.valueOf(tmp);
                tmp++;
            }
        }
    }

    public String [][] getMassData(){
        return this.massData;
    }
}
