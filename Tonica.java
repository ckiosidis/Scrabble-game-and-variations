package scramble;

import java.util.Locale;

public class Tonica extends Scrabble{
    
    public Tonica(Locale locale){
       super(15,15,1,locale);
       InitializePlayers();
       setBoardBonus();
       drawHands();
       play();
    }
    
    
    @Override
     public void play(){
       int countpass;
       do{
           countpass=0;
           for(int i=0;i<Players.size();i++)
           {
               
               if(bag.getSize()!=0)
               {
                  int choice;
                  do{
                  System.out.println("choice2");
                  choice=s.nextInt();
                  if(choice==1)
                      countpass++;
                  if (choice==3)
                       Players.get(i).setWord(board);
                  }while(choice<0 || choice>3);
                       
               }
           }
       }while(endGame()&&countpass<3);
       showPoints();
    }
    
    @Override
    public void drawHands(){
        do{
            for(int i=0;i<Players.size();i++)
                Players.get(i).drawLetter(bag);
        }while((bag.getSize()/Players.size())!=0);
    }
    
    
    public boolean endGame(){
        for(Player P:Players){
            if(P.getHandSize()==0)
                return false;
        }
        return true;
    }
}
