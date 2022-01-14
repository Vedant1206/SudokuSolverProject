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
}
