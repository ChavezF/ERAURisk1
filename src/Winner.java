/** 
 * Author Bruno, Fernando
 * Project: Risk 
 * Date: March 7, 2015 
 * Class: SE300 
 */ 

import javafx.scene.paint.Color; 
import javafx.geometry.HPos;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
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
import javafx.stage.Stage; 

public class Winner{ 

	public void display(int s) { 

		//String		winnerPyr = "s";

		GridPane RPane = new GridPane(); 
		RPane.setVgap(10); 
		RPane.setPadding(new Insets(10)); 
		
		RPane.setAlignment(Pos.CENTER);
		Label winnerMessage = new Label("  Congratulations!\nPlayer " +s+" won the game!");  

		Button mainMenuButton = new Button ("Menu"); 
		Button quitButton = new Button ("Quit"); 

		mainMenuButton.setTextFill(Color.web("#0076a3"));
		mainMenuButton.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: GOLD");
		//mainMenuButton.setPrefWidth(750);
		quitButton.setTextFill(Color.web("#0076a3"));
		quitButton.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: GOLD");
		//quitButton.setPrefWidth(750);
		
		
		//Set characteristics to the message and buttons
		//winnerMessage.setPrefWidth(Double.MAX_VALUE); 
		winnerMessage.setStyle("-fx-font: 30 courier; -fx-font-weight: BOLD");
		winnerMessage.setTextFill(Color.GOLD);

		//Make it look nice
		RPane.add(winnerMessage, 0, 1);
		RPane.add(mainMenuButton, 0, 2);
		RPane.add(quitButton, 0, 3);
		
		GridPane.setHalignment(winnerMessage, HPos.CENTER);
		GridPane.setHalignment(mainMenuButton, HPos.CENTER);
		GridPane.setHalignment(quitButton, HPos.CENTER);


		Stage Pstage = new Stage(); 
		Scene scene = new Scene(RPane,600,400); 
		Pstage.setScene(scene); 
		Pstage.show(); 

		BackgroundImage myBI= new BackgroundImage(new Image("RiskCannons.jpg",600,400,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		//Set image to the grid
		RPane.setBackground(new Background(myBI));
		
		mainMenuButton.setOnAction(e -> { 
			Menu menu = new Menu();
			menu.start(Pstage);
			Pstage.close();
		});
		quitButton.setOnAction(e -> System.exit(0));
	} 
} 
