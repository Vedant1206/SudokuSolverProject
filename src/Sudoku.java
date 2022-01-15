public class Sudoku {
  int[][] board;
  public Sudoku(int[][] temp){
    board = new int[temp.length][temp[0].length];

    for(int i = 0; i<temp.length; i++){
      for(int j = 0; j<temp[i].length; j++){
        board[i][j] = temp[i][j];
      }
    }
  }
  public boolean notInRow(int row, int num){
    for(int i = 0; i<board.length; i++){
      if(board[row][i] == num){
        return true;
      }
    }
    return false;
  }
  public boolean notInCol(int col, int num){
    for(int i = 0; i<board.length; i++){
      if(board[i][col] == num){
        return true;
      }
    }
    return false;
  }
  private boolean notInBox(int row, int col, int num) {
    int squareRoot = (int)Math.sqrt(board.length);
    int newRow = row - row%(squareRoot);
    int newCol = col - col%(squareRoot);

    for (int i = newRow; i<newRow+3; i++) {
      for (int j = newCol; j<newCol+3; j++) {
        if (board[newRow][newCol]==num) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean solve(){
    for (int row=0; row<board.length; row++) {
      for (int col=0; col<board.length; col++) {
        if (board[row][col]==0) {
          for (int num=1; num<= board.length; num++) {
            if (!notInRow(row, num) && !notInCol(col, num) && !notInBox(row, col, num)) {
              board[row][col]=num;
              if (solve()) {
                return true;
              } else {
                board[row][col] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public void print(){
    System.out.println();
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j<board[i].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
