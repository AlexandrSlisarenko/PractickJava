package Exception;

public class JobToException {

    private int maxLenz;
    String [][] massData;

    public JobToException(String [][] mas, int maxLenz){
        this.massData = mas;
        this.maxLenz = maxLenz;
    }


    public void summElement() throws MyArraySizeException, MyDataException{
        int result = 0;
        if(this.massData.length > this.maxLenz) throw new MyArraySizeException(this.maxLenz,"Длинна привышает "+this.maxLenz);
        for (int i = 0; i < this.massData.length;i++){
            if(this.massData[i].length > this.maxLenz) throw new MyArraySizeException(this.maxLenz, "Длинна привышает "+this.maxLenz);
            for (int j = 0; j < this.massData.length;j++){
                if(Character.isDigit(this.massData[i][j].charAt(0))){
                    result += Integer.parseInt(this.massData[i][j]);
                }else{
                    throw new MyDataException(i,j,"В ячейке "+i+" "+j+" не целое число!");
                }
            }
        }


        System.out.println("Сумма равна "+result);
    }


}
