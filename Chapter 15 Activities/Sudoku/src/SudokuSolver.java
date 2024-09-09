import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows = new ArrayList<>();
    private ArrayList<Set<Integer>> cols = new ArrayList<>();
    private ArrayList<Set<Integer>> squares = new ArrayList<>();
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        

        // create the list of sets for each row (this.rows)
        Set<Integer> curRow;
        for (int i = 0; i < 9; i++){
            curRow = new HashSet<>();
            for (int j = 0; j < 9; j++){
                curRow.add(this.grid[i][j]);
            }
            this.rows.add(curRow);
        }
            


        // create the list of sets for each col (this.cols)
        Set<Integer> curCol;
        for (int j = 0; j < 9; j++){
            curCol = new HashSet<>();
            for (int i = 0; i < 9; i++){
                curCol.add(this.grid[i][j]);
            }
            this.cols.add(curCol);
        }
        
        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        Set<Integer> curBox;
        for (int y = 0; y < 9; y += 3){
            for (int x = 0; x < 9; x += 3){
                curBox = new HashSet<>();
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++)
                        curBox.add(this.grid[y+i][x+j]);
                }
                this.squares.add(curBox);
            }
        }
        

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<>();
        for (int i = 1; i < 10; i++)
            this.nums.add(i);

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */

        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        possibleNums.removeAll(this.rows.get(nextRow));
        possibleNums.removeAll(this.cols.get(nextCol));
        if (nextRow < 3){
            if (nextCol < 3){
                possibleNums.removeAll(this.squares.get(0));
            }
            else if (nextCol < 6){
                possibleNums.removeAll(this.squares.get(1));
            }
            else {
                possibleNums.removeAll(this.squares.get(2));
            }
        }
        else if (nextRow < 6){
            if (nextCol < 3){
                possibleNums.removeAll(this.squares.get(3));
            }
            else if (nextCol < 6){
                possibleNums.removeAll(this.squares.get(4));
            }
            else {
                possibleNums.removeAll(this.squares.get(5));
            }
        }
        else {
            if (nextCol < 3){
                possibleNums.removeAll(this.squares.get(6));
            }
            else if (nextCol < 6){
                possibleNums.removeAll(this.squares.get(7));
            }
            else {
                possibleNums.removeAll(this.squares.get(8));
            }
        }



        
        
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            this.grid[nextRow][nextCol] = possibleNum;

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                this.grid[nextRow][nextCol] = 0;
                possibleNums.remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "data-structures\\Chapter 15 Activities\\Sudoku\\src\\puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
         
        System.out.println(solver);
        /* */
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } 
        else {
            System.out.println("Unsolveable...");
        }
        /* */
           
    }
}