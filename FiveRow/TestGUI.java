import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.*;
import java.util.Random;

public class TestGUI extends Application{
  Text statusinfo;

  int dim_x = 40;
  int dim_y = 40;
  Game game = new Game(dim_x, dim_y);
  String[][] board = game.getBoard();

  @Override
  public void start(Stage vindu) {
    statusinfo = new Text("Velg en rute");
    statusinfo.setFont(new Font(20));
    statusinfo.setX(10);
    statusinfo.setY(410);

    Button[][] brett = new Button[board.length][board[0].length];
    for(int i=0; i<brett.length; i++){
      for(int j=0; j<brett[0].length; j++){
        brett[i][j] = new Button();
        brett[i][j].setPrefSize(20, 20);
        brett[i][j].setMaxSize(20, 20);
        brett[i][j].setMinSize(20, 20);
      }
    }

    GridPane rutenett = new GridPane();
    rutenett.setGridLinesVisible(true);
    for(int i = 0; i < brett.length; i++){
      for(int j = 0; j < brett[0].length; j++){
        rutenett.add(brett[i][j], i, j);
      }
    }
    rutenett.setAlignment(Pos.CENTER);
    rutenett.setLayoutX(10);
    rutenett.setLayoutY(10);


    Pane pane = new Pane();
    pane.setPrefSize((20+(brett.length*20)), (20+(brett[0].length*20)));
    pane.getChildren().add(rutenett);

    Scene scene = new Scene(pane);

    vindu.setTitle("Five in a row! Made by HVBE :)");
    vindu.setScene(scene);
    vindu.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
