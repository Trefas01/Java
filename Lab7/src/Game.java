import java.util.ArrayList;

public class Game {
    int nrpiese;
    int  progr;

    public void setNrpiese(int nrpiese) {
        this.nrpiese = nrpiese;
    }

    public void setProgr(int progr) {
        this.progr = progr;
    }
    void stopJoc()
    {



    }

    void createGame(){
    ArrayList<Token> list = new ArrayList<>();
    for(int i=0;i<=nrpiese;i++)
            list.add(new Token(i));
    Board brd=new Board(list);
    Runnable r1=new Player("Player1",brd,this);
    Runnable r2=new Player("player2",brd,this);
        new Thread(r1).start();
        new Thread(r2).start();

    }
}
