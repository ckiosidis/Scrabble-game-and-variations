package scramble;

import java.util.ListResourceBundle;

public class Localization_en extends ListResourceBundle {

    private Object[][] contents = {
        {"charset","Cp1252"},
        {"players", "How many players are going to play the game (2 to 4)?"},
        {"name", "Player's name "},
        {"nextPlayer","Next player: "},
        {"choice", "Action:(1)pass,(2)change letters,(3)set word: "},
        {"choice", "Action:(1)pass,(3)set word: "},
        {"lettersToChange","How many letters do you want to change?"},
        {"letter","Choose letter(number): "},
        {"unexpected","Not valid number of letters"},
        {"validation","Are you sure you want to change the letter  "},
        {"validation2"," ? y/n :"},
        {"word","Type the word you want to set: "},
        {"position","Type (1) for horizontal placement and  (2) for vertical placement: "},
        {"coord","Type coordinations of the first cell , separately: "},
        {"show","Player: "},
        {"has"," has "},
        {"points", " points."},
        {"winner"," is the winner."},
        {"end","Congratulations you finished the game."},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
