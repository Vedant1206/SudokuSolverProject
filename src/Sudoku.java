public class Sudoku {

  //Instance variable board where we will store the sudoku
  int[][] board;
  private final int EMPTY = 0;

  //Constructor: We are storing the sudoku in our instance variable
  public Sudoku(int[][] temp){
    board = new int[temp.length][temp[0].length];

    //Deep copying all the elements in the gameBoard variable
    //(We are deep copying because we will show the the Sudoku before and after solving).
    for(int i = 0; i<temp.length; i++){
      for(int j = 0; j<temp[i].length; j++){
        board[i][j] = temp[i][j];
      }
    }
  }

  //We are checking if the number does not exist in the row, if it does, we return true, otherwise false
  public boolean notInRow(int row, int num){
    for(int i = 0; i<board.length; i++){
      if(board[row][i] == num){
        return true;
      }
    }
    return false;
  }

  //We are checking if the number does not exist in the column, if it does, we return true, otherwise false
  public boolean notInCol(int col, int num){
    for(int i = 0; i<board.length; i++){
      if(board[i][col] == num){
        return true;
      }
    }
    return false;
  }

  //We are checking if the number does not exist in the box, if it does, we return true, otherwise false
  private boolean notInBox(int row, int col, int num) {
    //The next three line of codes helps in checking whether or not the number is located in the box or not
    int squareRoot = (int)Math.sqrt(board.length);

    //For example, if we are dealing with a 9x9 Sudoku, the square root will be equal to 3,
    //and if row is 5 and col is 4, new row will be 5 - 5%3, which will be equal to 3.
    //For new column, it will be 4 - 4%3, which is equal to 3. Now the program will check from row 3 and col 3
    // to row 5 and col 5 if the number exist there or not.
    //This is how this method will check whether the number exist in the box or not.
    int newRow = row - row%(squareRoot);
    int newCol = col - col%(squareRoot);
    for (int i = newRow; i<newRow+3; i++) {
      for (int j = newCol; j<newCol+3; j++) {
        if (board[newRow][newCol] == num) {
          return true;
        }
      }
    }
    return false;
  }

  //This method will solve our Sudoku. This method is a recursive method.
  public boolean solve(){

    //The first 2 loops are for using the elements of the array row and column wise.
    for (int row=0; row<board.length; row++) {
      for (int col=0; col<board.length; col++) {
        //So now, we will check if the space(gameBoard[row][col]) is free for adding a number.
        if (board[row][col] == EMPTY) {
          //If the space is free, we will try adding a number between 0 and whatever the length of the Sudoku is.
          //For example, if we are solving a 9x9 Sudoku, the numbers which we will use in that Sudoku, will be between
          //0 and 10(i.e. 1,2,3,4,5,6,7,8,9).
          for (int num=1; num<= board.length; num++) {

            //If it is safe, then we add the number to the Sudoko
            if (!notInRow(row, num) && !notInCol(col, num) && !notInBox(row, col, num)) {
              board[row][col]=num;
              //Now from here the recursion will take place.
              //when we add the number(what we did in the previous step) this recursion helps in getting all the
              // permutations related to the number we stored in the Sudoku.
              if (solve()) {
                return true;  //This return statement will run when the sudoku is solved
              } else {
                //else if the number was not we were looking for, we again make it an empty spot.
                board[row][col] = EMPTY;
              }
            }
          }
          //If the number is not fitting for solving the Sudoku then this returns false and backtracks the number to 0
          // to check for another number.
          return false;
        }
      }
    }
    //Once the entire Sudoku is filled, this returns true and the if statement(if (solve())) returns true.
    return true;
  }

  //This method displays the solved Sudoku
  public void print(int[][] prev){
    // If the solve returns true than 2 Sudokus are printed,
    // the first one will the the question which the user gave and
    // the second one will be the solved version of that
    System.out.println("Unsolved Board");
    for(int i = 0; i<prev.length; i++){
      for(int j = 0; j<prev[i].length; j++){
        System.out.print(prev[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("\nAfter solving");
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j<board[i].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}