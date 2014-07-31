package scrabble;

public class Letter {
    
    private char letter;
    private int value;
    
    public Letter(){}
    public Letter(char letter,int value){
        this.letter=letter;
        this.value=value;
    }
    
    public char getLetter(){
        return letter;
    }
    
    public int getValue(){
        return value;
    }

}
