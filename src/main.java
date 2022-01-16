import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class main {

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Welcome to Sudoku.\nwhich option would you choose?");
    System.out.println("1)Run a demo\n2)Run your own example using a txt file.\n(type 1 or 2 only) ");
    Scanner scan = new Scanner(System.in);
    int chosen = scan.nextInt();
    if(chosen == 1)
      runDemo();
    else
      putInput();


    System.out.println("End of the code");

  }
  public static void runDemo(){
    int[][] board = {
        {8, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 3, 6, 0, 0, 0, 0, 0},
        {0, 7, 0, 0, 9, 0, 2, 0, 0},
        {0, 5, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 4, 5, 7, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 3, 0},
        {0, 0, 1, 0, 0, 0, 0, 6, 8},
        {0, 0, 8, 5, 0, 0, 0, 1, 0},
        {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };

    Sudoku game = new Sudoku(board);
    game.solve();
    game.print(board);
  }
  public static void putInput() throws FileNotFoundException {
    System.out.println("Enter the file name(eg- filename.txt)");
    Scanner scan = new Scanner(System.in);
    String fileName = scan.next();

    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    String sudoku = "";
    int size = 0;

    while (sc.hasNextLine()) {
      sudoku += sc.nextLine();
      size++;
    }
    sc.close();

    int squareRoot = (int) Math.sqrt(size);

    int[][] board = new int[size][size];

    int index = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int temp = sudoku.charAt(index) - 48;
        if (temp > 0 && temp < size) {
          board[i][j] = temp;
        } else {
          board[i][j] = 0;
        }
        index++;
      }
    }
    //Initialising an object for Sudoku class
    Sudoku game = new Sudoku(board);

    //If the sudoku given by the user is solvable then this if statement runs
    if (game.solve()) {
      game.print(board);
    } else {    //Else the sudoku cannot be solved
      System.out.println("The Sudoku cannot be solved");
    }
  }
}

