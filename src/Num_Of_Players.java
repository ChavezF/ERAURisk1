import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */
public class Num_Of_Players extends Game_Board {
	
	public void play() {
		//create buttons needed
		final Button TwoPlayerBtn = new Button("2 Players");
		final Button ThreePlayerBtn = new Button("3 Players");
		final Button FourPlayerBtn = new Button("4 Players");

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		TwoPlayerBtn.setOnAction(e -> {
			
		});
		ThreePlayerBtn.setOnAction(e -> {
			
		});
		FourPlayerBtn.setOnAction(e -> {
			
		});

		//create vBox that contains buttons
		VBox vBox = new VBox(4);
		vBox.getChildren().addAll(TwoPlayerBtn, ThreePlayerBtn, FourPlayerBtn);

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
	public Num_Of_Players(){

	}

	public void finalize() throws Throwable {

	}

	public void TwoPlayerGame(){

	}

	public void ThreePlayerGame(){

	}

	public void FourPlayerGame(){

	}

}