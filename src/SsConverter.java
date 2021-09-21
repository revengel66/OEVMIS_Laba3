import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
public class SsConverter {

    public String Alphabet = "0123456789abcdef ";
    int SSout;
    int SSin;
    String x;
    public int ostat = 16;
    public static String answer = "";
    public static int Answ = 0;

    public SsConverter(int SSin, int SSout, String x){
        this.SSout = SSout;
        this.SSin = SSin;
        this.x = x;
    }
    public String pop(String x){
        return x.substring(0,x.length()-1);
    }

    public int ssConverterFuncIn10(String x, int i) { //Конвертировать в 10 сс
        if (x.equals("")) {
            return Answ;
        }
        Answ += Alphabet.indexOf(x.charAt(x.length() - 1)) * Math.pow(SSin, i);
        ssConverterFuncIn10(pop(x), i += 1);
        return Answ;
    }
    public int func(){
        return 5;
    }
    public String ssConverterFuncFrom10(int ostat, int x){ //Конвертировать из 10 сс!!!
        answer += Alphabet.charAt(ostat);
        if (x >= SSout) {
            ssConverterFuncFrom10(ostat = x % SSout, x /= SSout);
        }
        else answer+=Alphabet.charAt(x);
        StringBuilder sb = new StringBuilder(SsConverter.answer);
        String str = "" + sb.reverse();
        return str;
    }

    public void Converter(){
        if(SSout != 10){
            int Answer = ssConverterFuncIn10(x, 0);
            String AnswerStr = ssConverterFuncFrom10(16, Answer);
            System.out.println("" + x + ": " + SSin+ " -> " + SSout + " = " + AnswerStr);
        } else if(SSout == 10){
            int Answer = ssConverterFuncIn10(x, 0);
            System.out.println("" + x + ": " + SSin+ " -> " + SSout + " = " + Answer);
        } else if(SSin == 10){
            String Answer = ssConverterFuncFrom10(16, Answ);
            System.out.println("" + x + ": " + SSin+ " -> " + SSout + " = " + Answer);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Введите исходную систему счисления: ");
        int SSin = sc.nextInt();
        System.out.print("Введите конечную систему счисления: ");
        int SSout = sc.nextInt();
        System.out.print("Введите число для конвертации: ");
        String x = sc.next();

        SsConverter SConv = new SsConverter(SSin, SSout, x);
        SConv.Converter();
    }




}
