import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */
public class Game_Board {
	
	public void twoPlayergame(){
		//@Override 
		//public void start(Stage primaryStage){

			// Construct a border pane and four individual pane for scene
			BorderPane pane = new BorderPane();
			Pane paneForBoard = new Pane();

			Text text1 = new Text("JavaFX Logo");
			Text text2 = new Text(122,216,"0");
			Button AttackBtn = new Button("Attack");
			AttackBtn.setLayoutX(900);
			AttackBtn.setLayoutY(550);
			text2.setFont(Font.font("Courier", FontWeight.BOLD, 25));
			text2.setFill(Color.WHITE);
			Image image = new Image("WorldMap.jpg");		

			ImageView imageView1 = new ImageView(image);
			imageView1.setFitHeight(600);
			imageView1.setFitWidth(1000);

			paneForBoard.getChildren().addAll(imageView1, text1, text2, AttackBtn);
			
			AttackBtn.setOnAction(e-> {
				Dice_Roll_GUI diceBox = new Dice_Roll_GUI();
				diceBox.roll();
			});

			// Place all the pane create and place them on the border pane 
			pane.setCenter(paneForBoard);

			text1.setOnMouseDragged(e -> {
				text1.setX(e.getX());
				text1.setY(e.getY());
				double xcoord = e.getSceneX();
				double ycoord = e.getSceneY();
				text1.setText(String.format("%.2f, %.2f", xcoord, ycoord));
			});
			//text2.setOnMouseEntered(e->{
			text2.setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.U)
					text2.setFill(Color.BLUE);
			});
		//});
			text2.setOnMouseClicked(e -> {
				if (e.getButton() == MouseButton.PRIMARY ){
					int num = Integer.parseInt(text2.getText());
					int sum = num + e.getClickCount();
					text2.setText(String.format("%d", sum));
				}
				else if (e.getButton() == MouseButton.SECONDARY ){	
					int num = Integer.parseInt(text2.getText());
					int sum = num - e.getClickCount();
					text2.setText(String.format("%d", sum));
				}
			});

			// Set the stage to display the scene
			Scene scene = new Scene(pane);
			Stage primaryStage = new Stage();
			primaryStage.setTitle("GUI_Widgets");
			primaryStage.setScene(scene);
			primaryStage.show();	
		}
			// Launch GUI application
		//	public static void main(String[] args){
			//	Application.launch(args);
		//}	
	//}

	public Game_Board(){

	}

	public void finalize() throws Throwable {

	}

	public void endTurn(){

	}

	public void quit(){

	}

	public void saveGame(){

	}

}