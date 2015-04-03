

/** 
 * Author Bruno Malo Torres Trueba 
 * Project: Risk 
 * Date: March 7, 2015 
 * Class: SE300 
 */ 

import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.layout.GridPane; 
import javafx.stage.Stage; 

public class Winner{ 

	public void display() { 

	final int TWO_COLUMN_SPAN = 2; 

	GridPane root = new GridPane(); 
	root.setVgap(10); 
	root.setPadding(new Insets(10)); 
	root.setAlignment(Pos.CENTER);
	Label winnerMessage = new Label("  Congratulations!\n  You won the game");  

	Button mainMenuButton = new Button ("Main Menu"); 
	Button quitButton = new Button ("Quit"); 

	// Allow the button to be wider overriding preferred width 
	winnerMessage.setPrefWidth(Double.MAX_VALUE); 
	winnerMessage.setFont(Font.font ("Verdana", 20)); 
	winnerMessage.setTextFill(Color.RED); 
	mainMenuButton.setPrefWidth(Double.MAX_VALUE); 
	quitButton.setPrefWidth(Double.MAX_VALUE); 

	// using instance method for directly adding the node 
	root.add(winnerMessage,0,1,TWO_COLUMN_SPAN,1); 
	root.add(mainMenuButton,0,2,TWO_COLUMN_SPAN,1); 
	root.add(quitButton,0,3,TWO_COLUMN_SPAN,1); 

	Stage primarystage = new Stage(); 
	Scene scene = new Scene(root,400,150); 
	primarystage.setScene(scene); 
	primarystage.show(); 
	} 
} 
