/**
 * @author Leydi, Bruno
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */

import java.util.Scanner;

import javafx.geometry.HPos;
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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Game_Selection {
	//this is the board that you will use for the whole game
	public double [][] neo = new double[4][8];

	/**
	 * @author Leydi (Structure), Bruno (Layout) 
	 * Give the options to play a new game or load a previous game; otherwise go to the main menu
	 */
	public void play() {

		//create buttons needed
		final Button startNewBtn = new Button("New Game");
		final Button loadPrevBtn = new Button("Load Game");
		final Button mainMenuBtn = new Button("Main Menu");

		GridPane pane = new GridPane();		

		//Provide good looking layout for buttons
		startNewBtn.setTextFill(Color.GOLD);
		startNewBtn.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");//#b6e7c9;
		startNewBtn.setPrefWidth(200);
		loadPrevBtn.setTextFill(Color.GOLD);
		loadPrevBtn.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");
		loadPrevBtn.setPrefWidth(200);
		mainMenuBtn.setTextFill(Color.GOLD);
		mainMenuBtn.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");
		mainMenuBtn.setPrefWidth(200);

		//add everything to the GridPane
		pane.add(startNewBtn, 0, 2);
		pane.add(loadPrevBtn, 0, 3);
		pane.add(mainMenuBtn, 0, 4);
		GridPane.setHalignment(startNewBtn, HPos.CENTER);
		GridPane.setHalignment(loadPrevBtn, HPos.CENTER);
		GridPane.setHalignment(mainMenuBtn, HPos.CENTER);
		//Main characteristics of the Gridpane
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(25);
		pane.setVgap(15);

		//create scene
		//put everything together
		Scene scene = new Scene(pane, 600, 400);

		//create stage 
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Play");
		stage.show();
		stage.setResizable(false);

		//Create background image and characteristics
		BackgroundImage myBI= new BackgroundImage(new Image("RiskCannons.jpg",600,400,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		//Set image to the grid
		pane.setBackground(new Background(myBI));

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		startNewBtn.setOnAction(e -> {
			Num_Of_Players numPlayers = new Num_Of_Players();
			numPlayers.play(neo);
			stage.close();
		});
		loadPrevBtn.setOnAction(e -> {
			java.io.File file = new java.io.File("gamedata.txt");

			try {
				Scanner input = new Scanner(file);
				while (input.hasNextDouble()){
					for (int i = 0; i<4; i++){
						for (int j=0; j<8; j++){
							neo[i][j]=input.nextDouble();
						}
					}///
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Game_Board board = new Game_Board();
			board.Playgame(neo);
			stage.close();
		});

		mainMenuBtn.setOnAction(e -> { 
			Menu menu = new Menu();
			menu.start(stage);
			stage.close();
		});
	}
}
