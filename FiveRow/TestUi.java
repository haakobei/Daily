import java.util.Scanner;

public class TestUi{

  static Player p1 = new Player("x");
  static Player p2 = new Player("y");

  static Player turn = p1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Game game = new Game(10, 10);

    int abort = 0;
    printGame(game);

    while(game.victory()==null){

      int x = -1;
      int y = -1;
      do{
        //Scann for move
        System.out.println("x =");
        x = sc.nextInt();
        System.out.println("y =");
        y = sc.nextInt();
      }while(game.makeMove(turn, x, y)==false);

      System.out.println(abort);
      printGame(game);
      switchTurn();
    }
    System.out.println(game.victory().getName());
  }



  public static void printGame(Game g){
    String[][] board = g.getBoard();

    for(int i=0; i <board[0].length; i++){
      System.out.println();
      for(int j = 0; j<board.length; j++){
        if(board[j][i]==null){
          System.out.print("-");
        }else{
          System.out.print(board[j][i]);
        }
      }
    }
    System.out.println("\n **** \n");
  }

  public static void switchTurn(){
    if(turn == p1){
      turn = p2;
    }else{
      turn = p1;
    }
  }
}
