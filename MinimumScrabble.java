package scramble;

import java.util.Locale;

public class MinimumScrabble extends Scrabble {
    
    public MinimumScrabble(Locale locale){
        super(15,15,1,locale);
        InitializePlayers();
        setBoardBonus();
        drawHands();
        play();
                
    }
    
    
    
    @Override
    public void showPoints(){
       
        int min=10000;
        int winner=-1;
        for(int i=0;i<=Players.size();i++){
            Players.get(i).getPoints();
            if(Players.get(i).getPoints()<min){
                min=Players.get(i).getPoints();
                winner=i;
            }
        }
        System.out.println("Sygxaritiria teliwsate to paixnidi");
        System.out.println("O xristis "+ Players.get(winner).getName() + " einai o nikitis.");
        
    }
}
