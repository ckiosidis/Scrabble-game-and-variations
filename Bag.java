package scrabble;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
    
    private ArrayList<Letter> letters = new ArrayList<Letter>();
    Random generator = new Random();
    private int lettersleft;
    private int [] letterQuantity = {9,2,2,4,12,2,3,2,9,1,1,4,2,5,8,2,1,7,4,6,4,2,2,1,3,1};
    private int [] letterValue = {1,3,3,2,1,4,2,4,1,9,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private char [] letter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public Bag(int size){
      for(int i=0;i<letter.length; i++){
         for(int k=0;k<=size-1;k++){
             for(int j=0;j<letterQuantity[i];j++)
                 letters.add(new Letter(letter[i],letterValue[i]));
          }
     }
  }        
    
    public void RefreshLettersize(){
        lettersleft=letters.size();
    }
    
    public int getSize(){
        return letters.size();
    }
    public Letter getLetter(){
        RefreshLettersize();
       if(!letters.isEmpty())
       {
        
        int number = generator.nextInt(lettersleft);
        Letter temp = letters.get(number);
        letters.remove(temp);
        return temp;
       }
       return null;
    }
    
   
    
    public Letter changeLetter(Letter x){
        RefreshLettersize();
        int number = generator.nextInt(lettersleft);
        Letter temp = letters.get(number);
        letters.remove(temp);
        letters.add(x);
        return temp;
        
    }
    
    
}
