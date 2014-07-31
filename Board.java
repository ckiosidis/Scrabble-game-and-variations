package scrabble;

import java.util.ArrayList;

public class Board {
    
    private int type;
    private Cell [][] aBoard;
    private int x;
    private int y;
    
    public Board(int x,int y){
        aBoard = new Cell[x][y];
        for(int i=0;i<aBoard.length;i++){
            for(int j=0;j<aBoard[i].length;j++){
                aBoard[i][j]=new Cell();
            }
        }
            
        this.x=x;
        this.y=y;
    }
    
    public void setBonus(int x,int y,String type,int multiplier){
         if(type.equals("w"))
             aBoard[x][y].setWordBonus(multiplier);
         if(type.equals("l"))
             aBoard[x][y].setLetterBonus(multiplier);
                 
         
    }
    
    public void showBoard(){
        for(int i=0;i<x;i++){
            System.out.println(""); 
            for(int j=0;j<y;j++){
                 if(aBoard[i][j].exists()==false){
                     if(aBoard[i][j].bonusExists()==true){    
                            if(aBoard[i][j].getBonusType().equals("l")){
                                 if(aBoard[i][j].getMult()==2)
                                  System.out.print(" |l| ");
                                 else if(aBoard[i][j].getMult()==3)
                                  System.out.print(" |L| ");
                             }
                            else if(aBoard[i][j].getBonusType().equals("w")){
                                 if(aBoard[i][j].getMult()==2)
                                  System.out.print(" |w| ");
                                 else if(aBoard[i][j].getMult()==3)
                                  System.out.print(" |W| ");
                                 else if(aBoard[i][j].getMult()==4)
                                  System.out.print(" |4| ");
                             }
                      }
                     else
                         System.out.print(" | | ");         
                 }
                 else 
                      System.out.print(" |" +aBoard[i][j].getLetter().getLetter()+ "| ");
                 }
             }
            
        System.out.println("");
    }
    
    
    
    public int setWord(ArrayList<Letter> letters, int x , int y,int direction,int wordSize){
        int j=0;
        int points=0;
        int wordMultiplier=1;
        if(direction==1){
            for(int i=0;i<wordSize;i++){
                   if(aBoard[x][y+i].exists()==false){
                       aBoard[x][y+i].setLetter(letters.get(j));
                       j++;
                   }
                   int letterMult=1;
                   if(aBoard[x][y+i].bonusExists()){
                        if(aBoard[x][y+i].getBonusType().equals("w"))
                             wordMultiplier=wordMultiplier* aBoard[x][y+i].getMult();
                        else
                             letterMult=aBoard[x][y+i].getMult();
                   }
                 points=points+aBoard[x][y+i].getLetter().getValue()* letterMult;
            }
                
        }
        else if(direction==2){
            for(int i=0;i<wordSize;i++){
                if(aBoard[x+i][y].exists()==false){
                    aBoard[x+i][y].setLetter(letters.get(j));
                    j++;
                }
                int letterMult=1;
                   if(aBoard[x+i][y].bonusExists()){
                        if(aBoard[x][y+i].getBonusType().equals("w"))
                             wordMultiplier=wordMultiplier* aBoard[x+i][y].getMult();
                        else
                             letterMult=aBoard[x+i][y].getMult();
                   }
                 points=points+aBoard[x+i][y].getLetter().getValue()* letterMult;
           }
       }
    return points;
        
 }
    
    
    
    // which part of the word already exists on the board
    public ArrayList<Character> alreadyExist(String word,int x, int y,int direction){
        ArrayList<Character> temp = new ArrayList<Character>();
        if(direction==1){
            for(int j=0;j<word.length();j++){
                if(aBoard[x][j+y].exists()==false)
                        temp.add(word.charAt(j));
            }
        }
        else if(direction==2){
            for(int j=0;j<word.length();j++){
                   if(aBoard[j+x][y].exists()==false)
                     temp.add(word.charAt(j));
            }
            }
        return temp;
       }
    
}