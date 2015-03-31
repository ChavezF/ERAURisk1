/**
 * Author Bruno Malo Torres Trueba
 * Project: Risk
 * Date: March 7, 2015
 * Class: SE300
 */

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Num_Of_Players {

	public void play(double [][]neo) {

		final int TWO_COLUMN_SPAN = 2;

		GridPane root = new GridPane();
		root.setVgap(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);

		Label labelNumPlayers = new Label("Select Number of Players");	
		Button twoPlayers = new Button ("2");
		Button threePlayers = new Button ("3");
		Button fourPlayers = new Button ("4");

		// Allow the button to be wider overriding preferred width		
		labelNumPlayers.setPrefWidth(450);//Double.MAX_VALUE color:web("#0076a3")
		labelNumPlayers.setTextFill(Color.GOLD);
		labelNumPlayers.setStyle("-fx-font: 30 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");//#b6e7c9;

		twoPlayers.setPrefWidth(200);
		twoPlayers.setTextFill(Color.GOLD);
		twoPlayers.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");

		threePlayers.setPrefWidth(200);
		threePlayers.setTextFill(Color.GOLD);
		threePlayers.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");

		fourPlayers.setPrefWidth(200);
		fourPlayers.setTextFill(Color.GOLD);
		fourPlayers.setStyle("-fx-font: 25 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");

		// using instance method for directly adding the node
		root.add(labelNumPlayers,0,1,TWO_COLUMN_SPAN,1);
		root.add(twoPlayers,0,2,TWO_COLUMN_SPAN,1);
		root.add(threePlayers,0,3,TWO_COLUMN_SPAN,1);
		root.add(fourPlayers,0,4,TWO_COLUMN_SPAN,1);

		GridPane.setValignment(labelNumPlayers, VPos.CENTER);
		GridPane.setHalignment(twoPlayers, HPos.CENTER);
		GridPane.setHalignment(threePlayers, HPos.CENTER);
		GridPane.setHalignment(fourPlayers, HPos.CENTER);
		//Main characteristics of the Gridpane
		root.setAlignment(Pos.CENTER);
		root.setHgap(25);
		root.setVgap(15);


		//***
		//Create background image and characteristics
		BackgroundImage myBI= new BackgroundImage(new Image("RiskCannons.jpg",600,400,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		//Set image to the grid
		root.setBackground(new Background(myBI));
		//***

		Scene scene = new Scene(root,600,400);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		twoPlayers.setOnAction(e -> {
			Game_Board board = new Game_Board();
			neo[3][5] = 2;
			board.Playgame(neo);
			primaryStage.close();
		});

		threePlayers.setOnAction(e -> {
			Game_Board board = new Game_Board();
			neo[3][5] = 3;
			board.Playgame(neo);
			primaryStage.close();	
		});
		fourPlayers.setOnAction(e -> {
			Game_Board board = new Game_Board();
			neo[3][5] = 4;
			board.Playgame(neo);
			primaryStage.close();	
		});
	}
}