import java.util.*;

public class Player implements Runnable {
    String name;
    final Game game;
    final Board board;
    List<Integer> piese=new ArrayList<Integer>();



    public Player(String name, Board board,Game game) {
        this.name = name;
        this.board = board;
        this.game=game;

    }
    int verific()
    {
        int ok=0;
        Collections.sort(piese);
        if(piese.size()>=game.progr)
        {
            int q=piese.get(1)-piese.get(0);
            for(int i=2;i<piese.size();i++)
                if(piese.get(i)-piese.get(i-1)==q)
                    ok++;

        }
        if(ok==game.progr)
        {
           return 1;

        }
        else return 0;

    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (board.tokens.size()>0)
        {
            Random r=new Random();
            int a=r.nextInt(board.tokens.size());
            System.out.println(getName()+" a extras piesa "+board.extrag(a));
            piese.add(a);
            if(verific()==1)
            {
                System.out.println(name+" a castigat");
               board.tokens.clear();

            }


        }









    }
}
