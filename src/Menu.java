/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */
 //test 

import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu extends Application {

	//hello
	//create buttons needed
	final Button howToBtn = new Button("Instructions");
	final Button playBtn = new Button("Play!");
	final Button quitBtn = new Button("Quit");

	@Override
	public void start(Stage stage) {

		//create vBox that contains buttons
		HBox hBox = new HBox(4);
		hBox.getChildren().addAll(howToBtn, playBtn, quitBtn);

		//create a new GridPane that shall contain vBox
		GridPane grid = new GridPane();
//777
		howToBtn.setTextFill(Color.web("#0076a3"));
		howToBtn.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: GOLD");
		howToBtn.setPrefWidth(350);
		playBtn.setTextFill(Color.web("#0076a3"));
		playBtn.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: GOLD");
		playBtn.setPrefWidth(350);
		quitBtn.setTextFill(Color.web("#0076a3"));
		quitBtn.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: GOLD");
		quitBtn.setPrefWidth(350);
		
		grid.add(howToBtn, 0, 0);
		grid.add(playBtn, 1, 0);
		grid.add(quitBtn, 2, 0);
		GridPane.setHalignment(howToBtn, HPos.LEFT);
		GridPane.setHalignment(playBtn, HPos.CENTER);
		GridPane.setHalignment(quitBtn, HPos.RIGHT);
		//add everything to the GridPane
		grid.setVgap(18);
		grid.setHgap(4);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setAlignment(Pos.BOTTOM_CENTER);
		//grid.add(hBox, 43, 35);

		//create stage and scene
		//put everything together
		Scene scene = new Scene(grid, 550, 356);
		Stage stages = new Stage();
		stages.setTitle("ERAU Risk");
		stages.setScene(scene);
		stages.show();
		stages.setScene(scene);
		
		//***
		//Create background image and characteristics
		BackgroundImage myBI= new BackgroundImage(new Image("RiskMenuImage.jpg",550,356,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		//Set image to the grid
		grid.setBackground(new Background(myBI));
		//***
		
		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		howToBtn.setOnAction(e -> {Instructions instructions = new Instructions();
		instructions.playGame();
		stages.close();
		});

		playBtn.setOnAction(e -> {Game_Selection gameSelection = new Game_Selection();
		gameSelection.play();
		stages.close();
		});
		
		quitBtn.setOnAction(e -> System.exit(0));
	}//end start

	//launch the program
	public static void main(String[] args) {
		launch(args);
	}//end main
}