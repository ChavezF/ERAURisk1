/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Application {

	//create buttons needed
	final Button howToBtn = new Button("How to Play");
	final Button playBtn = new Button("Play!");
	final Button quitBtn = new Button("Quit");

	@Override
	public void start(Stage stage) {

		//create a stage
		stage.setTitle("ERAU Risk");
		Scene scene = new Scene(new Group(), 450, 250);

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		howToBtn.setOnAction(e -> showInstructions());
		playBtn.setOnAction(e -> {
			Game_Selection gameSelection = new Game_Selection();
			gameSelection.play();
			stage.close();
		});
		quitBtn.setOnAction(e -> System.exit(0));

		//create vBox that contains buttons
		VBox vBox = new VBox(4);
		vBox.getChildren().addAll(howToBtn, playBtn, quitBtn);

		//create a new GridPane that shall contain vBox
		GridPane grid = new GridPane();

		//add everything to the GridPane
		grid.setVgap(4);
		grid.setHgap(4);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.add(vBox, 0, 0);

		//put it all together
		Group root = (Group)scene.getRoot();
		root.getChildren().addAll(grid);
		stage.setScene(scene);
		stage.show();
	}//end start

	//launch the program
	public static void main(String[] args) {
		launch(args);
	}//end main

	public void playGame(){

	}

	public void showInstructions(){

	}
}