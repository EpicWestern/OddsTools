/**
 * This class gives a basic GUI to calculate the implied winning percentages and
 * vig of two sides in a game given the American odds for each side.
 */

package oddstools;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class BasicOddsToolGUI {
  
  static JTextField side1 = new JTextField("+120");
  static JTextField side2 = new JTextField("-140");
  static JTextField side1Label = new JTextField("Side 1 ");
  static JTextField side2Label = new JTextField("Side 2 ");
  static JLabel side1Prct = new JLabel("Side1 %: ");
  static JLabel answer1 = new JLabel("");
  static JLabel side2Prct = new JLabel("Side2 %: ");
  static JLabel answer2 = new JLabel("");
  static JLabel vig = new JLabel("Vig : ");
  static JLabel vigAnswer = new JLabel();
  static JLabel errorLabel = new JLabel("");
  static JLabel compLabel = new JLabel("Competitiors");
  static JLabel oddsLabel = new JLabel("Odds");
  static JLabel winPrct = new JLabel("Win%");
  static JLabel betPrct = new JLabel("Bet%");
  static JLabel betPrct1 = new JLabel("");
  static JLabel betPrct2 = new JLabel("");
  
  private static class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      clearEntries();
      calculate();
    }
  }
  
  private static void clearEntries() {
    answer1.setText("");
    answer2.setText("");
    vigAnswer.setText("");
    errorLabel.setText("");
  }
  
  private static void setError(String error) {
    //clearEntries();
    errorLabel.setText(error);
  }
  
  private static void calculate() {
    int side1Odds = 0; 
    int side2Odds = 0;
    try {
      side1Odds = Integer.parseInt(side1.getText());
      side2Odds = Integer.parseInt(side2.getText());
    } catch (Exception e) {
      setError("Illegal Txt");
    }
    try {
        Game game = new Game("Side1", side1Odds,  "Side2", side2Odds);
        answer1.setText(new Double(game.side1Prct()).toString());
        answer2.setText(new Double(game.side2Prct()).toString());
        betPrct1.setText(new Double(LineOdds.betProb(side1Odds)).toString());
        betPrct2.setText(new Double(LineOdds.betProb(side2Odds)).toString());
        
        vigAnswer.setText(new Double(game.vig()).toString());
        
      } catch (Exception e) {
        // TODO Auto-generated catch block
        setError("Illegal Val");
      }
    
  }
  

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    JButton calcButton = new JButton("Calculate");
    ButtonHandler listener = new ButtonHandler();
    calcButton.addActionListener(listener);
    
    JPanel content = new JPanel();
    content.setLayout(new GridLayout(4,4));
    //content.add(displayPanel, BorderLayout.CENTER);
    content.add(compLabel);
    content.add(oddsLabel);
    content.add(winPrct);
    content.add(betPrct);
    
    content.add(side1Label);
    content.add(side1);
    content.add(answer1);
    content.add(betPrct1);
    
    content.add(side2Label);
    content.add(side2);
    content.add(answer2);
    content.add(betPrct2);
      
    content.add(calcButton);
    content.add(errorLabel);
    content.add(vig);
    content.add(vigAnswer);
    
    JFrame window = new JFrame("OddsTest");
    window.setContentPane(content);
    //window.setSize(250,100);
    window.setLocation(100,100);
    window.setVisible(true);
    window.setResizable(false);
    window.pack();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

  }

}
