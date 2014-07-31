package scrabble;

import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public class ScrabbleGame {

    public static void main(String[] args) {
        Locale locale;
        Scrabble sc;
        Scanner s = new Scanner(System.in);
        int type;
        do{
        System.out.println("Hi");
        System.out.println("(1) Scrabble");
        System.out.println("(2) Double Scrabble");
        System.out.println("(3) Minimum Scrabble");
        System.out.println("(4) Tonica");
        System.out.println("(5) Super Scrabble");
        System.out.println("(0) Exit");
        type = s.nextInt();
        }while(type<0 || type>5);
        s.nextLine();
        System.out.println("Pick language en/el: ");
        String localeStr=s.nextLine();
        locale= new Locale(localeStr);
        
        if(type==1)
             sc=new ScrabbleClassic(locale);
        else if (type==2)
             sc=new DoubleScrabble(locale);
        else if (type==3)
             sc= new MinimumScrabble(locale);
        else if (type==4)
             sc=new Tonica(locale);
        else if (type==5)
             sc=new SuperScrabble(locale);
        
       
        
    }
}
