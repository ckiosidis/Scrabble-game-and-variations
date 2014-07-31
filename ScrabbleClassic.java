package scramble;

import java.util.Locale;

public class ScrabbleClassic extends Scrabble{
    
    public ScrabbleClassic (Locale locale){
        super(15,15,1,locale);
        InitializePlayers();
        drawHands();
        setBoardBonus();
        play();
    }
 
}
