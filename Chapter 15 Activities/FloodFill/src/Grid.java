import java.util.*;
public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> Zwardo = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int cur = 0;
        Zwardo.push(new Pair(row, column));
        Pair currentPair;
        while (Zwardo.size()>0){
            currentPair = Zwardo.pop();
            if (pixels[currentPair.getX()][currentPair.getY()] == 0){
            cur++;
            pixels[currentPair.getX()][currentPair.getY()] = cur;
            if (currentPair.getX()>0)
            Zwardo.push(new Pair(currentPair.getX()-1, currentPair.getY()));
            if (currentPair.getY()<9)
            Zwardo.push(new Pair(currentPair.getX(), currentPair.getY()+1));
            if (currentPair.getX()<9)
            Zwardo.push(new Pair(currentPair.getX()+1, currentPair.getY()));
            if (currentPair.getY()>0)
            Zwardo.push(new Pair(currentPair.getX(), currentPair.getY()-1));
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
