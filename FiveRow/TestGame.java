
public class TestGame{

  public static void main(String[] args) {
    System.out.println("----------Start Test!------------"+"\n");

    System.out.println("-------Testing constructor-------");
    int[] size = new int[2];
    for(int i = 0; i < 100; i++){
      for(int j = 0; j < 100; j++){
        Game testGame1 = new Game(i,j);
        if((args.length<0)&&(args[0].equals("-v"))){
          System.out.println(args[0]);
          size = testGame1.getSize();
          System.out.println(size[0]);
          System.out.println(size[1]);
        }
      }
    }
    System.out.println("+++++Constructor OK+++++++");

    System.out.println("-----Testing making moves-----");
    Game testGame2 = new Game(10, 10);
    Player player1 = new Player("Lasse");
    Player player2 = new Player("Lina");
    System.out.println("->Players ok");

    testGame2.makeMove(player1, 4, 4);
    System.out.println("->Player1 made a move");
    System.out.println("->Player2 tried to place same move = ");
    System.out.print(testGame2.makeMove(player2, 4, 4));

    System.out.println();
    System.out.println();



    System.out.println("Test done!");
  }
}
