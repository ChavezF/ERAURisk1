

/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game_Selection extends Menu {

	public void play() {
		//create buttons needed
		final Button startNewBtn = new Button("Start New Game");
		final Button loadPrevBtn = new Button("Load Previous Game");
		final Button mainMenuBtn = new Button("Main Menu");

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		startNewBtn.setOnAction(e -> startNewGame());
		loadPrevBtn.setOnAction(e -> loadPrevGame());
		mainMenuBtn.setOnAction(e -> returnToMenu());

		//create vBox that contains buttons
		VBox vBox = new VBox(4);
		vBox.getChildren().addAll(startNewBtn, loadPrevBtn, mainMenuBtn);

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
		stage.setTitle("Play");
		stage.show();
	
	}
	public void loadPrevGame(){

	}

	public void returnToMenu(){

	}

	public void startNewGame(){
		Num_Of_Players numPlayers = new Num_Of_Players();
		//numPlayers.className();
	}


}

