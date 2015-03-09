

/**
 * @author Andrew
 * @version 1.1
 * @created 08-Mar-2015 010:10:09 PM
 * 
 * Displays the instruction window and hides the main menu
 * Has two buttons: Play and Quit
 * 
 * Testing
 */

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Instructions extends Menu {

	public Instructions(){

	}
	
	public void playGame(){
		//Create the two necessary buttons: Play and Quit
		final Button playBtn = new Button("Play");
		final Button quitBtn = new Button("Quit");
		
		//Create the vBox containing both buttons
		VBox vBox = new VBox(4);
		vBox.getChildren().addAll(playBtn, quitBtn);
		
		//create a new GridPane that shall contain vBox
		GridPane pane = new GridPane();
		
		//add everything to the GridPane
		pane.setVgap(4);
		pane.setHgap(4);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.add(vBox, 0, 0);
		
		//create stage
		Stage stage = new Stage();
		Scene scene = new Scene(pane, 450, 150);
		stage.setScene(scene);
		stage.setTitle("Instructions");
		stage.show();
				
		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		playBtn.setOnAction(e -> {
			Game_Selection gameSelection = new Game_Selection();
			gameSelection.play();
			stage.close();
		});
		quitBtn.setOnAction(e -> System.exit(0));
	}

	public void quit(){

	}

	public void showInstructions(){

	}

}