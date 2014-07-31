package scramble;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Scrabble {
    
    protected  Bag bag;
    protected Board board;
    protected ArrayList<Player> Players;
    Scanner s;
    Scanner scanner;
    private int x;
    private int y;
    private ResourceBundle bundle;
    private Locale locale;

    public Scrabble(int x,int y,int size,Locale locale)
    {
        board= new Board(x,y);
        bag=new Bag(size);
        this.locale=locale;
        Players=new ArrayList<Player>();
        this.x=x;
        this.y=y;
        bundle = ResourceBundle.getBundle(
            "scramble.Localization", locale);
        s= new Scanner(System.in);
        scanner = new Scanner(System.in, bundle.getString("charset"));
        
    }
    
    public void setBoardBonus(){
        for(int i=1;i<=x;i++){
            for(int j=0;j<=y;j++){
                    if((i==2&& j==2)||(i==3&& j==3)||(i==4&& j==4)||(i==5&& j==5)||(i==2&& j==14)||(i==3&& j==13)||(i==4&& j==12) ||
                       (i==5&& j==11)||(i==11&& j==5)||(i==12&& j==4)||(i==13&& j==3)||(i==14&& j==2)||(i==11&& j==11)||(i==12&& j==12)||
                        (i==13&& j==13)||(i==14&& j==14))
                        board.setBonus(i-1, j-1, "w", 2);
                    if((i==1&& j==1)||(i==1&& j==7)||(i==1&& j==15)||(i==7&& j==1)||(i==7&& j==7)||(i==7&& j==15)||
                            (i==15&& j==1)||(i==15&& j==7)||(i==15&& j==15))
                        board.setBonus(i-1,j-1,"w",3);
                    if((i==1&& j==4)||(i==1&& j==12)||(i==3&& j==7)||(i==3&& j==8)||(i==4&& j==1)||(i==4&& j==7)||(i==4&& j==15)||
                            (i==7&& j==3)||(i==7&& j==7)||(i==7&& j==9)||(i==7&& j==13)||(i==8&& j==4)||(i==8&& j==12)||(i==9&& j==3)||
                            (i==9&& j==7)||(i==9&& j==9)||(i==9&& j==13)||(i==12&& j==1)||(i==12&& j==8)||(i==12&& j==15)||(i==13&& j==7)||
                            (i==13&& j==9)||(i==15&& j==4)||(i==15&& j==12))
                        board.setBonus(i-1,j-1,"l",2);
                    if((i==2&& j==6)||(i==2&& j==10)||(i==6&& j==2)||(i==6&& j==6)||(i==6&& j==8)||(i==6&& j==14)||
                            (i==10&& j==2)||(i==10&& j==6)||(i==10&& j==8)||(i==10&& j==14)||(i==14&& j==6)||(i==14&& j==10))
                        board.setBonus(i-1,j-1,"l",3);
               
            }
        }
    }
    
    public void InitializePlayers(){
     
        int players;
        do{
        System.out.println(bundle.getString("players"));
        players=s.nextInt();
        }while(players<2 || players >4);
        s.nextLine();
        for(int i=0;i<players;i++){
             String playername;
             System.out.println("name "+(i+1));
             playername=s.nextLine();
             Players.add(new Player(playername,i+1,locale));
        }
    }
    
    public void drawHands(){
        for(Player p:Players)
            p.drawHand(bag);
    }
    
    public void play(){
       do{
           board.showBoard();
           for(int i=0;i<Players.size();i++)
           {
               if(bag.getSize()!=0)
               {
                  int choice;
                  do{
                  System.out.println("nextPlayer" + Players.get(i).getName());
                  Players.get(i).showHand();
                  System.out.println("choice");
                  choice=s.nextInt();
                  if(choice==2)
                       Players.get(i).changeLetters(bag);
                  else if (choice==3){
                       int size=Players.get(i).setWord(board);
                       for(int j=0;j<size;j++)
                              Players.get(i).drawLetter(bag);}
                  }while(choice<0 || choice>3);
                  System.out.println("points" +Players.get(i).totalPoints());
                       
               }
           }
       }while(bag.getSize()!=0);
       showPoints();
    }
    
    public void showPoints(){
       
        int max=0;
        int winner=-1;
        for(int i=0;i<=Players.size();i++){
            System.out.println("show"+Players.get(i).getName()+ "has" +  "points"+Players.get(i).getPoints());
            if(Players.get(i).getPoints()>max){
                max=Players.get(i).getPoints();
                winner=i;
            }
        }
        System.out.println("end");
        System.out.println("show"+ Players.get(winner).getName() + "winner");
        
    }
}
