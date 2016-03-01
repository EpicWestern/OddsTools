package oddstools;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.event.*;
import javafx.geometry.*;

public class BasicOddsToolFX extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setPadding(new Insets(15,15,15,15));
    grid.setHgap(5);
    grid.setVgap(5);
    
    Label sideHeader = new Label("Sides");
    grid.add(sideHeader, 0,0);
    
    Label oddsHeader = new Label("Odds");
    grid.add(oddsHeader, 1, 0);
    
    final TextField side1Name = new TextField("Side1");
    grid.add(side1Name, 0, 1);
    side1Name.setPrefColumnCount(10);
    
    final TextField side2Name = new TextField("Side2");
    grid.add(side2Name, 0, 2);
    side2Name.setPrefColumnCount(10);
    
    final TextField side1Odds = new TextField("+120");
    side1Odds.setPrefColumnCount(6);
    grid.add(side1Odds, 1, 1);
    
    final TextField side2Odds = new TextField("-140");
    side2Odds.setPrefColumnCount(6);
    grid.add(side2Odds, 1, 2);
    
    final Text actiontarget = new Text();
    actiontarget.setFill(Color.FIREBRICK);
    grid.add(actiontarget, 0, 6);
    
    Label resultsHeader = new Label("Implied Win%   ");
    resultsHeader.setAlignment(Pos.CENTER);
    grid.add(resultsHeader, 2, 0);
    
    Label resultsHeader2 = new Label("Implied Bet%");
    resultsHeader.setAlignment(Pos.CENTER);
    grid.add(resultsHeader2, 3, 0);
    
    final Text winPrct1 = new Text();
    winPrct1.setTextAlignment(TextAlignment.CENTER);
    grid.add(winPrct1, 2, 1);
    
    final Text winPrct2 = new Text();
    winPrct2.setTextAlignment(TextAlignment.CENTER);
    grid.add(winPrct2, 2, 2);
    
    final Text betPrct1 = new Text();
    betPrct1.setTextAlignment(TextAlignment.CENTER);
    grid.add(betPrct1, 3,1);
    final Text betPrct2 = new Text();
    betPrct2.setTextAlignment(TextAlignment.CENTER);
    grid.add(betPrct2, 3,2);
    
    final Label vigLabel = new Label("Vigorish:");
    grid.add(vigLabel, 0,4);
    
    final Text vig = new Text();
    grid.add(vig, 1,4);
    
    
    Button btn = new Button("Calculate");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        Integer odds1 = null;
        Integer odds2 = null;
        try {
        odds1 = Integer.parseInt(side1Odds.getText());
        odds2 = Integer.parseInt(side2Odds.getText());
        } catch (NumberFormatException nfe) {
          actiontarget.setText("Invalid Odds");
          return;
        }
        
        try {
          Game game = new Game("Side1", odds1, "Side2", odds2);
          double[] impliedPrcts = OddsUtil.impliedPrcts(game.getSide1Odds(), game.getSide2Odds());
          
          winPrct1.setText(String.format("%.2f", new Double(impliedPrcts[0] * 100)));
          winPrct2.setText(String.format("%.2f", new Double(impliedPrcts[1] * 100 )));
          betPrct1.setText(String.format("%.2f", new Double(OddsUtil.betPrct(odds1)) * 100));
          betPrct2.setText(String.format("%.2f", new Double(OddsUtil.betPrct(odds2)) * 100));
          
          vig.setText(String.format("%.4f", new Double(OddsUtil.vig(game.getSide1Odds(), game.getSide2Odds()))));
          actiontarget.setText("");
          
        } catch (Exception ioe) {
          actiontarget.setText("Illegal Odds");
        }
      }
    });
    
    Button clearBtn = new Button("Clear");
    clearBtn.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
        side1Name.setText("Side1");
        side2Name.setText("Side2");
        side1Odds.setText("");
        side2Odds.setText("");
        winPrct1.setText("");
        winPrct2.setText("");
        betPrct1.setText("");
        betPrct2.setText("");
        actiontarget.setText("");
        vig.setText("");
      }
    });
    
    HBox hbBtn = new HBox(4);
    hbBtn.getChildren().add(btn);
    hbBtn.getChildren().add(clearBtn);
    grid.add(hbBtn, 0, 3, 2, 1);
    
    Scene scene = new Scene(grid);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Basic Odds ToolFX");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}