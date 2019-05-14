package SantoS.RelayRace.Number_of_vowels;
import java.util.regex.*;

public class MyRegEx {

    public String getCountMatchesInFile(String expression, String[] file)
    {
        String result = "";


        for (int i = 0; i < expression.length(); i++) {
            String s = "" + expression.charAt(i);
            Pattern pattern = Pattern.compile("[" + s + "]");
            int tmp=0;
            for (int j = 0; j< file.length; j++) {
                if(file[j] == null)break;
                Matcher matcher = pattern.matcher(file[j]);
                while (matcher.find()) {
                    tmp++;
                }

            }
            result += s+"="+tmp+";  ";
        }
        return result;
    }
}
