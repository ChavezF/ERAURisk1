/** 
 * Author Bruno, Fernando
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

	public void display(double winner) { 

		String		winnerPyr = "s";


		final int TWO_COLUMN_SPAN = 2; 

		GridPane RPane = new GridPane(); 
		RPane.setVgap(10); 
		RPane.setPadding(new Insets(10)); 
		
		RPane.setAlignment(Pos.CENTER);
		Label winnerMessage = new Label("  Congratulations!\n" + winnerPyr + "won the game");  

		Button mainMenuButton = new Button ("Main Menu"); 
		Button quitButton = new Button ("Quit"); 

		//Set characteristics to the message and buttons
		winnerMessage.setPrefWidth(Double.MAX_VALUE); 
		winnerMessage.setFont(Font.font ("Courier", 20)); 
		winnerMessage.setTextFill(Color.RED); 
		mainMenuButton.setPrefWidth(Double.MAX_VALUE); 
		quitButton.setPrefWidth(Double.MAX_VALUE); 

		//Make it look nice
		RPane.add(winnerMessage,0,1,TWO_COLUMN_SPAN,1); 
		RPane.add(mainMenuButton,0,2,TWO_COLUMN_SPAN,1); 
		RPane.add(quitButton,0,3,TWO_COLUMN_SPAN,1); 

		Stage Pstage = new Stage(); 
		Scene scene = new Scene(RPane,550,356); 
		Pstage.setScene(scene); 
		Pstage.show(); 

		mainMenuButton.setOnAction(e -> { 
			Menu menu = new Menu();
			menu.start(Pstage);
			Pstage.close();
		});
		quitButton.setOnAction(e -> System.exit(0));
	} 
} 
