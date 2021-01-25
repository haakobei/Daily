public class Game{
  //keep track of all moves, for each Player
  private String[][] gameBoard;
  private Player hasWon = null;


  //Take Size and list of players
  public Game(int x, int y){
    gameBoard = gameBoard[x][y];
  }

  //Check if legal
  //registrer if ok
  public boolean makeMove(Player player, int x, int y){
    if gameBoard[x][y] == null{
      gameBoard[x][y] == player.getName();
      if checkWictory(player.getName()){
        hasWon = player;
      }
      return true;
    }
    else{
      return false;
    }
  }

  public Player victory(){
    return hasWon;
  }

  private boolean checkWictory(String name){
    int counter = 0;
    for(int i=0; i<gameBoard.length; i++) {
      for(int j=0; j<gameBoard[i].length; j++) {
        if (gameBoard[i][j]!=null)&&(gameBoard[i][j]==name){
          counter+=1;
          if (counter==5){return true;}
        }else
      }
    }
  }

}
