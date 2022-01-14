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


}
