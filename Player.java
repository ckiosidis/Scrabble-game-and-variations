package scramble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public class Player {
  //  private static ScrabbleClassic Scrabble;
    private String name;
    private int totalpoints;
    private int id;
    private ArrayList<Letter> hand;
    private Scanner scanner = new Scanner(System.in);
    private static ResourceBundle bundle;
    private Scanner s;
    
    public Player(String name,int id,Locale locale){
        this.name=name;
        this.id=id;
        hand=new ArrayList<Letter>();
        bundle = ResourceBundle.getBundle(
            "scramble.Localization", locale);
        s = new Scanner(System.in, bundle.getString("charset"));
    }
    
    public int totalPoints(){
        return totalpoints;
    }

    public String getName(){
        return name;
    }
    
    public int getHandSize(){
        return hand.size();
    }
    
    public int getPoints(){
        return totalpoints;
    }
    
    public void drawLetter(Bag bag){
        hand.add(bag.getLetter());
        
    }
    public void drawHand(Bag bag){
        
        for ( int i=0 ; i<6 ; i++)
        { 
            hand.add(bag.getLetter());
        }
    }
    
    
    
    public int setWord(Board board){
    

        System.out.println("word");
        String word = scanner.nextLine();
        ArrayList<Letter> temp = new ArrayList<Letter>();
        System.out.println("position");
        int direction= scanner.nextInt();
        System.out.println("coord");
//        String coord= scanner.nextLine();
        int coordX=scanner.nextInt();
        int coordY=scanner.nextInt(); 
        ArrayList<Character> tempLetters = board.alreadyExist(word, coordX, coordY, direction);
        ArrayList<Letter> lettersRemovedfromHand = new ArrayList<Letter>();
        for(int i=0;i<tempLetters.size();i++){
            for(int j=0;j<hand.size();j++){
                if(tempLetters.get(i)==hand.get(i).getLetter()){
                    lettersRemovedfromHand.add(hand.get(i));
                    hand.remove(i);
                    break;
                }
            }
         }
        totalpoints=totalpoints+ board.setWord(lettersRemovedfromHand, coordX, coordY, direction,word.length());
        return lettersRemovedfromHand.size();            

}
    
    
    public boolean exists(int length,int x,int y){
      return true;  
    }
    
    public void changeLetters(Bag bag){
        int number;
        showHand();
        do{
            System.out.println("lettersToChange");
            number=scanner.nextInt();
            if(number>hand.size()+1 && number<hand.size()+1)
                System.out.println("unexpected");
        }while( number>hand.size() && number<hand.size());
        System.out.println("letter");
        int [] tempInt=new int[number];
        ArrayList<Letter> temp = new ArrayList<Letter>();
        for( int i=0 ; i<number ; )
        {
                showHand();
                int pio=scanner.nextInt();
                System.out.print("validation" + hand.get(pio).getLetter() + "validation2");
                String decision= scanner.next();
                scanner.nextLine();
                if(decision.equals("y"))
                {
                tempInt[i]=pio;
                temp.add(hand.get(pio));
                i++;
                }
                else
                {
                    System.out.println("Pick a different letter");
                }
            
        }
        Arrays.sort(tempInt);
        for(int i=number ; i>0 ; i--)
              hand.remove(hand.get(tempInt[i-1]));
            
        for( int i=0 ; i<number ; i++)
        {
            hand.add(bag.changeLetter(temp.get(i)));
        }
        showHand();
    }
    
    public void showHand(){
        for( int i=0 ; i<hand.size() ; i++)
        {
           System.out.println( i+ " " +hand.get(i).getLetter() );   
        }
  }
}
