import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
/**
 * @author Fernando
 * @version 1.0
 * @created 25-Feb-2015 1:03:58 PM
 */
public class Dice_Roll_GUI {

	public double [] roll(double [] cor){
		
		// Construct a border pane and four individual pane for scene
		GridPane pane = new GridPane();
		Pane paneforDefenderRB = new VBox();
		Pane paneforAttackerRB = new VBox();
		
		Text text1 = new Text("Defender");
		Text text2 = new Text("Attacker");
		
		//Gather dice images
		Image D1 = new Image("Dice21.jpg");
		Image D2 = new Image("Dice22.jpg");
		Image D3 = new Image("Dice23.jpg");
		Image D4 = new Image("Dice24.jpg");
		Image D5 = new Image("Dice25.jpg");
		Image D6 = new Image("Dice26.jpg"); 	

		Image A1 = new Image("Dice11.jpg");
		Image A2 = new Image("Dice12.jpg");
		Image A3 = new Image("Dice13.jpg");
		Image A4 = new Image("Dice14.jpg");
		Image A5 = new Image("Dice15.jpg");
		Image A6 = new Image("Dice16.jpg");

		//Construct image views to display dice
		ImageView View1 = new ImageView();
		ImageView View2 = new ImageView();
		ImageView View3 = new ImageView();
		ImageView View4 = new ImageView();
		ImageView View5 = new ImageView();
		
		//Input win markers 
		Image Win1 = new Image("winmaker.jpg");	
		ImageView W1 = new ImageView();
		ImageView W2 = new ImageView();
		ImageView W3 = new ImageView();
		ImageView W4 = new ImageView();
		
		W1.setImage(Win1);
		W2.setImage(Win1);
		W3.setImage(Win1);
		W4.setImage(Win1);
		
		//Resize markers
		W1.setFitHeight(25);
		W1.setFitWidth(15);
		W2.setFitHeight(25);
		W2.setFitWidth(15);
		W3.setFitHeight(25);
		W3.setFitWidth(15);
		W4.setFitHeight(25);
		W4.setFitWidth(15);
		
		W1.setVisible(false);
		W2.setVisible(false);
		W3.setVisible(false);
		W4.setVisible(false);

		//Resize dice images
		View1.setFitHeight(45);
		View1.setFitWidth(45);
		View2.setFitHeight(45);
		View2.setFitWidth(45);
		View3.setFitHeight(45);
		View3.setFitWidth(45);
		View4.setFitHeight(45);
		View4.setFitWidth(45);
		View5.setFitHeight(45);
		View5.setFitWidth(45);

		View1.setImage(D6);
		View2.setImage(A6);
		View3.setImage(D6);
		View4.setImage(A6);
		View5.setImage(A6);

		pane.add(text1, 1, 0);
		pane.add(text2, 2, 0);
		
		//Add nodes to scene and set alignment
		GridPane.setHalignment(text2, HPos.RIGHT);
		pane.add(W1, 0, 1);
		GridPane.setValignment(W1, VPos.TOP);
		pane.add(W2, 3, 1);
		GridPane.setValignment(W2, VPos.TOP);
		pane.add(W3, 0, 2);
		GridPane.setValignment(W3, VPos.TOP);
		pane.add(W4, 3, 2);
		GridPane.setValignment(W4, VPos.TOP);
		pane.add(View1, 1, 1);
		pane.add(View2, 2, 1);
		GridPane.setHalignment(View2, HPos.RIGHT);
		pane.add(View3, 1, 2);
		pane.add(View4, 2, 2);
		GridPane.setHalignment(View4, HPos.RIGHT);
		pane.add(View5, 2, 3);
		GridPane.setHalignment(View5, HPos.RIGHT);	

		//Construct buttons
		Button btAttack = new Button("Attack");
		Button btLeave = new Button("Leave");

		pane.add(btAttack, 1, 5);
		pane.add(btLeave, 2, 5);
		GridPane.setHalignment(btLeave, HPos.RIGHT);

		//Construct radio buttons, initialize, and add to scene 
		RadioButton rbDef1 = new RadioButton("Roll 1");
		RadioButton rbDef2 = new RadioButton("Roll 2");
		RadioButton rbAtt1 = new RadioButton("Roll 1");
		RadioButton rbAtt2 = new RadioButton("Roll 2");
		RadioButton rbAtt3 = new RadioButton("Roll 3");

		rbDef2.setSelected(true);
		rbAtt3.setSelected(true);

		paneforDefenderRB.getChildren().addAll(rbDef1, rbDef2);
		paneforAttackerRB.getChildren().addAll(rbAtt1, rbAtt2, rbAtt3);

		pane.add(paneforDefenderRB, 1, 4);
		pane.add(paneforAttackerRB, 2, 4);

		pane.setAlignment(Pos.CENTER);
		pane.setHgap(25);
		pane.setVgap(15);

		//Have the radio buttons toggle between each other
		rbDef1.setOnAction(e -> {
			rbDef2.setSelected(false);	
		});
		rbDef2.setOnAction(e -> {
			rbDef1.setSelected(false);
		});
		rbAtt1.setOnAction(e -> {
			rbAtt2.setSelected(false);
			rbAtt3.setSelected(false);
		});
		rbAtt2.setOnAction(e -> {
			rbAtt1.setSelected(false);
			rbAtt3.setSelected(false);
		});
		rbAtt3.setOnAction(e -> {
			rbAtt1.setSelected(false);
			rbAtt2.setSelected(false);
		});
		// Implement the attack button to initiate the dice roll 
		btAttack.setOnAction(e ->  {
			if (rbDef1.isSelected() == true){
				View3.setVisible(false);
				Die Die1 = new Die();
				int num1 = Die1.roll();
				Die1.setValue(num1);
				switch (num1){
				case 1: View1.setImage(D1);
				break;
				case 2: View1.setImage(D2);
				break;
				case 3: View1.setImage(D3);
				break;
				case 4: View1.setImage(D4);
				break;
				case 5: View1.setImage(D5);
				break;
				default: View1.setImage(D6);
				break;
				}
				if (rbAtt1.isSelected() == true){
					View4.setVisible(false);
					View5.setVisible(false);
					Die Adie1 = new Die();
					int num2 = Adie1.roll();
					Adie1.setValue(num2);
					if (Die1.getValue() >= Adie1.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					switch (num2){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
				}
				else if (rbAtt2.isSelected() == true){
					View4.setVisible(true);
					View5.setVisible(false);
					Die Adie1 = new Die();
					Die Adie2 = new Die();
					int[] results2 = new int[2];
					results2[0] = Adie1.roll();
					results2[1] = Adie2.roll();
					java.util.Arrays.sort(results2);
					Adie2.setValue(results2[0]);
					Adie1.setValue(results2[1]);
					if (Die1.getValue() >= Adie1.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					switch (results2[1]){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
					switch (results2[0]){
					case 1: View4.setImage(A1);
					break;
					case 2: View4.setImage(A2);
					break;
					case 3: View4.setImage(A3);
					break;
					case 4: View4.setImage(A4);
					break;
					case 5: View4.setImage(A5);
					break;
					default: View4.setImage(A6);
					break;
					}
				}
				else{
					View4.setVisible(true);
					View5.setVisible(true);
					Die Adie1 = new Die();
					Die Adie2 = new Die();
					Die Adie3 = new Die();
					int[] results3 = new int[3];
					results3[0] = Adie1.roll();
					results3[1] = Adie2.roll();
					results3[2] = Adie3.roll();
					java.util.Arrays.sort(results3);
					Adie3.setValue(results3[0]);
					Adie2.setValue(results3[1]);
					Adie1.setValue(results3[2]);
					if (Die1.getValue() >= Adie1.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					switch (results3[2]){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
					switch (results3[1]){
					case 1: View4.setImage(A1);
					break;
					case 2: View4.setImage(A2);
					break;
					case 3: View4.setImage(A3);
					break;
					case 4: View4.setImage(A4);
					break;
					case 5: View4.setImage(A5);
					break;
					default: View4.setImage(A6);
					break;
					}
					switch (results3[0]){
					case 1: View5.setImage(A1);
					break;
					case 2: View5.setImage(A2);
					break;
					case 3: View5.setImage(A3);
					break;
					case 4: View5.setImage(A4);
					break;
					case 5: View5.setImage(A5);
					break;
					default: View5.setImage(A6);
					break;
					}
				}
			}
			else{
				View3.setVisible(true);
				Die Die1 = new Die(); 
				Die Die2 = new Die();
				int[] results1 = new int[2];
				results1[0] = Die1.roll();
				results1[1] = Die2.roll();				
				java.util.Arrays.sort(results1);
				Die2.setValue(results1[0]);
				Die1.setValue(results1[1]);
				switch (results1[1]){
				case 1: View1.setImage(D1);
				break;
				case 2: View1.setImage(D2);
				break;
				case 3: View1.setImage(D3);
				break;
				case 4: View1.setImage(D4);
				break;
				case 5: View1.setImage(D5);
				break;
				default: View1.setImage(D6);
				break;
				}
				switch (results1[0]){
				case 1: View3.setImage(D1);
				break;
				case 2: View3.setImage(D2);
				break;
				case 3: View3.setImage(D3);
				break;
				case 4: View3.setImage(D4);
				break;
				case 5: View3.setImage(D5);
				break;
				default: View3.setImage(D6);
				break;
				}
				if (rbAtt1.isSelected() == true){
					View4.setVisible(false);
					View5.setVisible(false);
					Die Adie1 = new Die();
					int num2 = Adie1.roll();
					Adie1.setValue(num2);
					if (Die1.getValue() >= Adie1.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(false);
					}
					switch (num2){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
				}
				else if (rbAtt2.isSelected() == true){
					View4.setVisible(true);
					View5.setVisible(false);
					Die Adie1 = new Die();
					Die Adie2 = new Die();
					int[] results2 = new int[2];
					results2[0] = Adie1.roll();
					results2[1] = Adie2.roll();
					java.util.Arrays.sort(results2);
					Adie2.setValue(results2[0]);
					Adie1.setValue(results2[1]);
					if (Die1.getValue() >= Adie1.getValue() && Die2.getValue() >= Adie2.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(true);
						W4.setVisible(false);
					}
					else if (Die1.getValue() >= Adie1.getValue() && Die2.getValue() < Adie2.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(true);
					}
					else if (Die1.getValue() < Adie1.getValue() && Die2.getValue() >= Adie2.getValue()){
						W1.setVisible(false);
						W2.setVisible(true);
						W3.setVisible(true);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(true);
					}
					switch (results2[1]){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
					switch (results2[0]){
					case 1: View4.setImage(A1);
					break;
					case 2: View4.setImage(A2);
					break;
					case 3: View4.setImage(A3);
					break;
					case 4: View4.setImage(A4);
					break;
					case 5: View4.setImage(A5);
					break;
					default: View4.setImage(A6);
					break;
					}
				}
				else{
					View4.setVisible(true);
					View5.setVisible(true);
					Die Adie1 = new Die();
					Die Adie2 = new Die();
					Die Adie3 = new Die();
					int[] results3 = new int[3];
					results3[0] = Adie1.roll();
					results3[1] = Adie2.roll();
					results3[2] = Adie3.roll();
					java.util.Arrays.sort(results3);
					Adie3.setValue(results3[0]);
					Adie2.setValue(results3[1]);
					Adie1.setValue(results3[2]);
					if (Die1.getValue() >= Adie1.getValue() && Die2.getValue() >= Adie2.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(true);
						W4.setVisible(false);
					}
					else if (Die1.getValue() >= Adie1.getValue() && Die2.getValue() < Adie2.getValue()){
						W1.setVisible(true);
						W2.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(true);
					}
					else if (Die1.getValue() < Adie1.getValue() && Die2.getValue() >= Adie2.getValue()){
						W1.setVisible(false);
						W2.setVisible(true);
						W3.setVisible(true);
						W4.setVisible(false);
					}
					else {
						W2.setVisible(true);
						W1.setVisible(false);
						W3.setVisible(false);
						W4.setVisible(true);
					}
					switch (results3[2]){
					case 1: View2.setImage(A1);
					break;
					case 2: View2.setImage(A2);
					break;
					case 3: View2.setImage(A3);
					break;
					case 4: View2.setImage(A4);
					break;
					case 5: View2.setImage(A5);
					break;
					default: View2.setImage(A6);
					break;
					}
					switch (results3[1]){
					case 1: View4.setImage(A1);
					break;
					case 2: View4.setImage(A2);
					break;
					case 3: View4.setImage(A3);
					break;
					case 4: View4.setImage(A4);
					break;
					case 5: View4.setImage(A5);
					break;
					default: View4.setImage(A6);
					break;
					}
					switch (results3[0]){
					case 1: View5.setImage(A1);
					break;
					case 2: View5.setImage(A2);
					break;
					case 3: View5.setImage(A3);
					break;
					case 4: View5.setImage(A4);
					break;
					case 5: View5.setImage(A5);
					break;
					default: View5.setImage(A6);
					break;
					}
				}
			}	
		});
		
		
		// Set the stage to display the scene
		Scene scene = new Scene(pane, 250, 325);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Roll Dice");
		primaryStage.setScene(scene);
		primaryStage.setX(cor[0]);  //line 350
                primaryStage.setY(cor[1]);
   
		primaryStage.show();
                
                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        cor[0] = primaryStage.getX();
                        cor[1] = primaryStage.getY();
                     }
                });                       
		
		btLeave.setOnAction(e -> primaryStage.close());
                return cor;
                
        
	}
	
	
}