

/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Game_Selection {
	//this is the board that you will use for the whole game
	public double [][] neo = new double[4][8];

	public void play() {

		//create buttons needed
		final Button startNewBtn = new Button("Start New Game");
		final Button loadPrevBtn = new Button("Load Previous Game");
		final Button mainMenuBtn = new Button("Main Menu");

		//create vBox that contains buttons
		HBox hBox = new HBox(2);
		HBox vBox2 = new HBox(1);
		hBox.getChildren().addAll(startNewBtn, loadPrevBtn);
		vBox2.getChildren().addAll(mainMenuBtn);
		//create a new GridPane that shall contain vBox
		GridPane pane = new GridPane();
		
		//add everything to the GridPane
		/*pane.setVgap(8);
		pane.setHgap(4);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.add(hBox, 30, 32);
		pane.add(vBox2, 30, 35);*/


		//create scene
		//put everything together
	Scene scene = new Scene(pane, 600, 400);

		//create stage 
		Stage stage = new Stage();
	stage.setScene(scene);
		stage.setTitle("Play");
		stage.show();

		//***
		pane.add(startNewBtn, 0, 2);
		pane.add(loadPrevBtn, 0, 3);
		pane.add(mainMenuBtn, 0, 4);
		GridPane.setHalignment(startNewBtn, HPos.CENTER);
		GridPane.setHalignment(loadPrevBtn, HPos.CENTER);
		GridPane.setHalignment(mainMenuBtn, HPos.CENTER);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(25);
		pane.setVgap(15);
		
		stage.setScene(scene);
		//Create background image and characteristics
		BackgroundImage myBI= new BackgroundImage(new Image("RiskCannons.jpg",600,400,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		//Set image to the grid
		pane.setBackground(new Background(myBI));
		//***

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		startNewBtn.setOnAction(e -> {
			Num_Of_Players numPlayers = new Num_Of_Players();
			numPlayers.play(neo);
			stage.close();
		});
		//use FileChooser to select and open a previously saved game
		loadPrevBtn.setOnAction(e -> {FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.showOpenDialog(stage);});
		mainMenuBtn.setOnAction(e -> { 
			Menu menu = new Menu();
			menu.start(stage);
			stage.close();
		});
	}
}