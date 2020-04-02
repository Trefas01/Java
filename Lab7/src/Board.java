import java.util.ArrayList;

public class Board {
    ArrayList<Token> tokens;

    public Board(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }


    public ArrayList<Token> getTokens() {
        return tokens;
    }
    public  synchronized int  extrag(int i)
    {

            int a = tokens.get(i).getNumber();
            tokens.remove(i);
            return a;
        }

    }

