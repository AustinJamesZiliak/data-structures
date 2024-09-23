import java.util.*;

public class Pair {
    private int x, y;

    public Pair(int xNew, int yNew){
        x = xNew;
        y = yNew;
    }

    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
    
    public String toString(){
        return x+", "+y;
    }
}
