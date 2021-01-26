public class Game{
  //keep track of all moves, for each Player
  private String[][] gameBoard;
  private Player hasWon = null;


  //Take Size and list of players
  public Game(int x, int y){
    if((x<6)||(y<6)){
      gameBoard = new String[6][6];
    }else{
      gameBoard = new String[x][y];
    }
  }

  public String[][] getBoard(){
    return gameBoard;
  }

  //Check if legal
  //registrer if ok
  public boolean makeMove(Player player, int x, int y){
    if ((x<gameBoard.length)&&(y<gameBoard[0].length)&&(gameBoard[x][y] == null)){
      gameBoard[x][y] = player.getName();

      if (checkWictory(player.getName())){
        System.out.println("victory?");
        hasWon=player;
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

    for(int i=0; i<(gameBoard.length-5); i++) {
      System.out.println();
      for(int j=0; j<(gameBoard[i].length-5); j++) {

        //Check i-axis
        int _i = 0;
        while(_i < 5){
          if((gameBoard[i+_i][j] != null)&&(gameBoard[i+_i][j].equals(name))){
            counter += 1;
            if (counter == 5){
              return true;
            }else{
              _i+=1;
            }
          }else{
            _i+=1;
            counter = 0;
          }
        }
        counter = 0;

        //Check j-axis
        int _j = 0;
        while(_j < 5){
          if((gameBoard[i][j+_j] != null)&&(gameBoard[i][j+_j].equals(name))){
            counter += 1;
            if (counter == 5){
              return true;
            }else{
              _j+=1;
            }
          }else{
            _j+=1;
            counter = 0;
          }
        }

        //Check diagonal \
        counter = 0;
        _i = 0;
        _j = 0;
        while(_j < 5){
          if((gameBoard[i+_i][j+_j] != null)&&(gameBoard[i+_i][j+_j].equals(name))){
            counter += 1;
            if (counter == 5){
              return true;
            }else{
              _j+=1;
              _i+=1;
            }
          }else{
            _j+=1;
            _i+=1;
            counter = 0;
          }
        }
      }
    }

    counter = 0;
    for(int i=4; i<(gameBoard.length); i++) {
      System.out.println();
      for(int j=0; j<(gameBoard[i].length-5); j++){
        if(gameBoard[i][j] != null){
        }else{
        }

        //Check diagonal /
        int _i = 0;
        int _j = 0;
        while(_i < 5){
          if((gameBoard[i-_i][j+_j] != null)&&(gameBoard[i-_i][j+_j].equals(name))){
            counter += 1;
            if (counter == 5){
              return true;
            }else{
              _j+=1;
              _i+=1;
            }
          }else{
            _j+=1;
            _i+=1;
            counter = 0;
          }
        }
      }
    }
    return false;
  }

  //Just for Testing
  public int[] getSize(){
    int[] size = new int[2];
    size[0]= gameBoard.length;
    size[1]= gameBoard[0].length;
    return size;
  }
}
