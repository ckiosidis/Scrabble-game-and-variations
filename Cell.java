package scramble;

public class Cell {
    
    private String cellBonus;
    private int multiplier;
    private Letter cellLetter;
    private boolean letterExists;
    private boolean bonusExists;
     
    public Cell(){
       letterExists=false;
       bonusExists=false;
    }
    
    public void setLetter(Letter l){
        cellLetter=l;
        letterExists=true;
    }
    
    public boolean exists(){
        return letterExists;
    }
    
    public Letter getLetter(){
        return cellLetter;
    }
    
    public int getCellTotal(){
        if(cellBonus.equals("l"))
            return cellLetter.getValue()*multiplier;
        return cellLetter.getValue();
    }
    
    public int getMult(){
       // if(cellBonus.equals("w"))
            return multiplier;
       // return 1;
    }
    
    public String getBonusType(){
        return cellBonus;
    }
    
    public void setLetterBonus(int multiplier){
        cellBonus="l";
        this.multiplier=multiplier;
        bonusExists=true;
    }
    public void setWordBonus(int multiplier){
        cellBonus="w";
        this.multiplier=multiplier;
        bonusExists=true;
    }
    
    public boolean bonusExists(){
        return bonusExists;
    }
}
