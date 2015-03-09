/**
 * Author Bruno Malo Torres Trueba
 * Project: Risk
 * Date: March 7, 2015
 * Class: SE300
  */
 

//Helo world
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Num_Of_Players extends Application {

	public void start(Stage primaryStage) {

		final int TWO_COLUMN_SPAN = 2;

		GridPane root = new GridPane();
		root.setVgap(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		Label labelNumPlayers = new Label("Select Number of Players");	
		Button twoPlayers = new Button ("2 Players");
		Button threePlayers = new Button ("3 Players");
		Button fourPlayers = new Button ("4 Players");
		
		// Allow the button to be wider overriding preferred width
		
		labelNumPlayers.setPrefWidth(Double.MAX_VALUE);
		twoPlayers.setPrefWidth(Double.MAX_VALUE);
		threePlayers.setPrefWidth(Double.MAX_VALUE);
		fourPlayers.setPrefWidth(Double.MAX_VALUE);

		// using instance method for directly adding the node
		root.add(labelNumPlayers,0,1,TWO_COLUMN_SPAN,1);
		root.add(twoPlayers,0,2,TWO_COLUMN_SPAN,1);
		root.add(threePlayers,0,3,TWO_COLUMN_SPAN,1);
		root.add(fourPlayers,0,4,TWO_COLUMN_SPAN,1);

		Scene scene = new Scene(root,250,150);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main1(String[] args) {
		launch(args);
	}
}
