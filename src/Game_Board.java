import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.WindowEvent;

/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */
public class Game_Board {

	private int reinforce = 3;//int i = 1, 
	private double [] cor = {0,0,0,0};
        private double [][] troops = new double[2][2];
        private int selected = 0;
	private int [][] cord = new int[1][1];
	Text america, canadia,alaska,greenland,mexico,venezuella,brazil,argentina;
	Text nafrica, safrica, egypt, eafrica, madag, eaustralia, waustralia,nguninea;
	Text sasia, indonesia, india, china, russia, japan, meast,afghan;
	Text ireland, scandanavia, eeurope, weurope, britain, rein, turn;
	Button e1, bGround;

	public void Playgame(double[][]neo){

		// Construct a border pane and four individual pane for scene
		BorderPane pane = new BorderPane();
		Pane paneForBoard = new Pane();
		//initialize the properties for the rest of the texts
		initializeProperties(neo);

		bGround = new Button();
		bGround.setMinSize(995, 47);
		bGround.setLayoutY(7);
		bGround.setStyle("-fx-background-color: #0033CC;");

		Button b1 = new Button("Quit");
		b1.setMinSize(120, 47);
		b1.setLayoutY(7);
		b1.setLayoutX(860);

		Button s1 = new Button("Save");
		s1.setMinSize(120, 47);
		s1.setLayoutY(7);
		s1.setLayoutX(720);//840

		e1 = new Button("End Populate");
		e1.setMinSize(120, 47);
		e1.setLayoutY(7);
		e1.setLayoutX(580);//700
		
                Image image = new Image("WorldMap.jpg");
		ImageView imageView1 = new ImageView(image);
		imageView1.setFitHeight(700);
		imageView1.setFitWidth(1000);

		eventButton(neo);

		paneForBoard.getChildren().addAll(imageView1,bGround, turn,rein, b1,s1,e1, america,canadia,alaska,greenland,mexico,venezuella,brazil,argentina,nafrica,safrica,eafrica,egypt,eaustralia,waustralia,nguninea,sasia,indonesia,india,china,russia,japan,meast,afghan,ireland,scandanavia,eeurope,weurope,britain,madag); 
		pane.setCenter(paneForBoard);

		b1.setOnMouseClicked(e -> {
			System.exit(1);
		});
		s1.setOnMouseClicked(e -> {
			save(neo);    
		});
		e1.setOnMouseClicked(e -> {
			eventButton(neo);
		});

		// Set the stage to display the scene
		Scene scene = new Scene(pane);
		Stage primaryStage = new Stage();
		primaryStage.setTitle("GUI_Widgets");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

		setButtonClick(neo);//set all countries actions

	}//Game_Board

	public void eventButton(double [][] neo){

		if((int)neo[3][7] == 2){       //attack phase

			e1.setText("End Turn");
			updater(neo);
			endTurn(neo);
			neo[3][7] ++;
			String[] col = {"-fx-background-color: #DDE6E8;","-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF00;"};
			String[] col2 = {"Turn: White","Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
			if (neo[3][6] == 3||neo[3][6] ==4){ //yellow
				rein.setFill(Color.BLACK);
				turn.setFill(Color.BLACK);
			}else{
				rein.setFill(Color.WHITE);
				turn.setFill(Color.WHITE);
			}//if 
			bGround.setStyle(col[(int)neo[3][6]]);
			turn.setText(col2[(int)neo[3][6]]);
                        selected = 0;
                }else if((int)neo[3][7] == 3){       //fortification phase
                        reinforce = 3;
			rein.setText("Reinforcements: " + Integer.toString(reinforce));
			updater(neo);
			endTurn(neo);
			e1.setText("Reinforce Phase");
			String[] col = {"-fx-background-color: #DDE6E8;","-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF00;"};
			String[] col2 = {"Turn: White","Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
			if (neo[3][6]++ == neo[3][5]){
				neo[3][6] = 1.0;
			}//if
			if (neo[3][6] == 3||neo[3][6] ==4){ //yellow
				rein.setFill(Color.BLACK);
				turn.setFill(Color.BLACK);
			}else{
				rein.setFill(Color.WHITE);
				turn.setFill(Color.WHITE);
			}//if 
			bGround.setStyle(col[(int)neo[3][6]]);
			turn.setText(col2[(int)neo[3][6]]);

			neo[3][7] = 1;              //reset to reinforcement phase

		}//if
	}//eventButton

	public int troop(double territory){
		int trp = (int)territory;
		return trp;
	}//troop

	public void setButtonClick(double [][] neo){
		america.setOnMouseClicked(e2 -> {
			neo[0][0] = actions(0,0, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});

		canadia.setOnMouseClicked(e2 -> {
			neo[0][1] = actions(0,1, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					canadia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					canadia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		alaska.setOnMouseClicked(e2 -> {
			neo[0][2] = actions(0,2, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					alaska.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					alaska.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		greenland.setOnMouseClicked(e2 -> {
			neo[0][3] = actions(0,3, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					greenland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					greenland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		mexico.setOnMouseClicked(e2 -> {
			neo[0][4] = actions(0,4, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					mexico.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					mexico.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		venezuella.setOnMouseClicked(e2 -> {
			neo[0][5] = actions(0,5, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		brazil.setOnMouseClicked(e2 -> {
			neo[0][6] = actions(0,6, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					brazil.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					brazil.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		argentina.setOnMouseClicked(e2 -> {
			neo[0][7] = actions(0,7, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					argentina.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					argentina.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		nafrica.setOnMouseClicked(e2 -> {
			neo[1][0] = actions(1,0, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		safrica.setOnMouseClicked(e2 -> {
			neo[1][1] = actions(1,1, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					safrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		egypt.setOnMouseClicked(e2 -> {
			neo[1][2] = actions(1,2, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					egypt.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		eafrica.setOnMouseClicked(e2 -> {
			neo[1][3] = actions(1,3, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		madag.setOnMouseClicked(e2 -> {
			neo[1][4] = actions(1,4, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					madag.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					madag.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		eaustralia.setOnMouseClicked(e2 -> {
			neo[1][5] = actions(1,5, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		waustralia.setOnMouseClicked(e2 -> {
			neo[1][6] = actions(1,6, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		nguninea.setOnMouseClicked(e2 -> {
			neo[1][7] = actions(1,7, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		sasia.setOnMouseClicked(e2 -> {
			neo[2][0] = actions(2,0, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					sasia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					sasia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		indonesia.setOnMouseClicked(e2 -> {
			neo[2][1] = actions(2,1, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		india.setOnMouseClicked(e2 -> {
			neo[2][2] = actions(2,2, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					india.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					india.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		china.setOnMouseClicked(e2 -> {
			neo[2][3] = actions(2,3, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					china.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		russia.setOnMouseClicked(e2 -> {
			neo[2][4] = actions(2,4, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					russia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		}); 
		japan.setOnMouseClicked(e2 -> {
			neo[2][5] = actions(2,5, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					japan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					japan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		meast.setOnMouseClicked(e2 -> {
			neo[2][6] = actions(2,6, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					meast.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		afghan.setOnMouseClicked(e2 -> {
			neo[2][7] = actions(2,7, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					afghan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		ireland.setOnMouseClicked(e2 -> {
			neo[3][0] = actions(3,0, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					ireland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					ireland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		scandanavia.setOnMouseClicked(e2 -> {
			neo[3][1] = actions(3,1, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		eeurope.setOnMouseClicked(e2 -> {
			neo[3][2] = actions(3,2, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		weurope.setOnMouseClicked(e2 -> {
			neo[3][3] = actions(3,3, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					weurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
		britain.setOnMouseClicked(e2 -> {
			neo[3][4] = actions(3,4, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
			if((int)neo[3][7] == 2){                                                  //attack phase
				if (e2.getButton() == MouseButton.PRIMARY){  //-------------------------PROBLEM CAN'T DO ALLL COUNTRIES HERE
					britain.setFont(Font.font("Courier", FontWeight.BOLD, 40));
				}else if (e2.getButton() == MouseButton.SECONDARY) {	
					britain.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				}//if        
			}//if
		});
	}//setMouseClick

	public double setTroop(int row, int col, double [][] neo, int newNumber){
		int player = player(neo[row][col]);
		return newNumber + (double)player/10;
	}//setTroop

	public double setPlayer(int row, int col, double [][] neo, int newPlayer){
		int troops = troop(neo[row][col]);
		return (double)troops + (double)newPlayer/10;
	}//setPlayer

	public double actions(int row, int column, double [][] neo, Boolean button){
//-------------------INITIAL DEPLOYMENT--------------------------------------------------------------
		if ((int)neo[3][7] == 0){     
			//initial add troops phase
			if (neo[row][column] == 0){
				neo[row][column] = 1;

				int n = (int)neo[0][0] + (int)neo[0][1] + (int)neo[0][2] + (int)neo[0][3] + (int)neo[0][4] + (int)neo[0][5] + (int)neo[0][6] + (int)neo[0][7]+ (int)neo[1][0] + (int)neo[1][1] + (int)neo[1][2] + (int)neo[1][3] + (int)neo[1][4] + (int)neo[1][5] + (int)neo[1][6] + (int)neo[1][7] + (int)neo[2][0] + (int)neo[2][1] + (int)neo[2][2] + (int)neo[2][3] + (int)neo[2][4] + (int)neo[2][5] + (int)neo[2][6] + (int)neo[2][7] + (int)neo[3][0] + (int)neo[3][1] + (int)neo[3][2] + (int)neo[3][3] + (int)neo[3][4];
				if (n != 29.0) {
					neo[3][7] = 0;

					if (neo[3][6] == neo[3][5]) {// If it's the last player's turn
						neo[3][6] = 1;			//Restart cycle

					}else if ( neo[3][6] == 0){	//If it is player 0
						neo[3][6] = 2;			//To avoid repeating player 1 (blue)

					}else if (neo[3][6] != neo[3][5]) {//Proceed with the next color
						neo[3][6]++;
					}
					//Change the color of the bar
					String[] col = {"-fx-background-color: #DDE6E8;","-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF00;"};
					String[] col2 = {"Turn: White","Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
					turn.setText(col2[(int)neo[3][6]]);
					bGround.setStyle(col[(int)neo[3][6]]);

					if(neo[3][6] == 1){//Paint yellow but keep continuation of cycle
						neo[row][column] = setPlayer(row, column, neo, (int)neo[3][5] );

					}else {//Paint the rest of the numbers
						neo[row][column] = setPlayer(row, column, neo, (int)neo[3][6] - 1);	
					}

					endTurn(neo);
				}else if (n == 29.0){
					neo[3][7] = 1;//only once the last troop has been added
					e1.setText("End Attack");//only once the last troop has been added
				}
			}	

	//------------------------REINFORCEMENT PHASE--------------------------------------------------------------------------
            } else if((int)neo[3][7] == 1){                                                  
                //*****************set this  so that the first turn you have 3 + the number of extra reinforcements from initial phase
                if(neo[3][6] == player(neo[row][column])){
                    neo[row][column] = setTroop(row,column,neo, (troop(neo[row][column])+1));
                    reinforce --;
                    rein.setText("Reinforcements: " + Integer.toString(reinforce));
                    if(reinforce == 0){
                        neo[3][7] ++;
                        reinforce = 3;
                        e1.setText("End Attack");
                    }//if
                }//if
//------------------------ATTACK PHASE---------------------------------------------------------------------------
            } else if((int)neo[3][7] == 2){                                                 
                
                if (button){
                    troops[selected][0] = row;
                    troops[selected][1] = column;
                    selected ++;
                }else{
                    selected --;
                }//if
                if (selected == -1){
                    selected = 0;
                }else if(selected == 2){
                    cor[2] = troop(neo[(int)troops[0][0]][(int)troops[0][1]]);
                    cor[3] = troop(neo[(int)troops[1][0]][(int)troops[1][1]]);
                    Dice_Roll_GUI diceBox = new Dice_Roll_GUI();
                    cor = diceBox.roll(cor);
                                        
                    System.out.println(cor[2] +" " + cor[3] + " :)");
                    //have while loop where it doesnt break out until diceBox sends break
                    //try pause code
                    neo[(int)troops[0][0]][(int)troops[0][1]] = setTroop((int)troops[0][0],(int)troops[0][1], neo, (int)cor[2]);
                    neo[(int)troops[1][0]][(int)troops[1][1]] = setTroop((int)troops[1][0],(int)troops[1][1], neo, (int)cor[3]);
                    System.out.println(cor[2]+ " " + cor[3]);
                    System.out.println(cor[0] + " " + cor[1]);
                    selected = 0;
                    endTurn(neo);
                }//if
                //****************Attack Phase
                //---->add 1 (to selected) when place is clicked
                //---->increase font size of selected spot
                //---->when 2 are selected check if they can attack each other
                //---->call dice program with both troop amounts
                //---->set both location with new troop values
//----------------------------------FORTIFICATION PHASE---------------------------------------------------------------                        
            } else if((int)neo[3][7] == 3){                                                  
                if(player(neo[row][column]) == neo[3][6]){  //if its actually the players spot
                    troops[selected][0] = row;              //save the row
                    troops[selected][1] = column;           //save the column
                    selected ++;                    
                    if (selected == 2 && (troops[0][0] != troops[1][0] || troops[0][1] != troops[1][1])){
                        selected = 0;
                        
                        //create a pop-up to get the # of troops to move
                        Label label1 = new Label("Enter number of troops to move: ");
                        label1.setLayoutY(5);
                        label1.setLayoutX(3);
                        TextField textField = new TextField ();
                        textField.setMaxWidth(50);
                        textField.setLayoutX(230);
                        Button leave = new Button("Move Troops");
                        leave.setMinSize(290, 30);
                        leave.setLayoutY(40);
                        Pane hb = new Pane();
                        hb.getChildren().addAll(label1, textField, leave);
                        Scene scenes = new Scene(hb);
                        Stage primaryStage2 = new Stage();
                        //insert pause until primary stage2 closes
                        leave.setOnMouseClicked(e -> {
                            reinforce = Integer.parseInt(textField.getText());
                            primaryStage2.close();
                        });
                        
                        primaryStage2.setTitle("GUI_Widgets");
                        primaryStage2.setScene(scenes);
                        primaryStage2.setMinHeight(60);
                        primaryStage2.setMinWidth(290);
                        primaryStage2.showAndWait();
                        if ((neo[(int)troops[0][0]][(int)troops[0][1]] -1) > reinforce){
                            neo[(int)troops[1][0]][(int)troops[1][1]] =setTroop((int)troops[1][0], (int)troops[1][1], neo, ((int)neo[(int)troops[1][0]][(int)troops[1][1]] + reinforce));
                            neo[(int)troops[0][0]][(int)troops[0][1]] = setTroop((int)troops[0][0], (int)troops[0][1], neo, ((int)neo[(int)troops[0][0]][(int)troops[0][1]] - reinforce));
                        }//if
                        updater(neo);
                    }else{
                        selected = 1;
                    }//if
                }//if
        
            }//if
 //----------------------------------FORTIFICATION PHASE----------------------------------------------
			
		return neo[row][column];
	}//actions

	public int player(double territory){
		return ((int)(10*territory))%10;
	}//player

	public void updater(double[][]neo){
		america.setText(Integer.toString(troop(neo[0][0])));//america
		canadia.setText(Integer.toString(troop(neo[0][1])));//canadia
		alaska.setText(Integer.toString(troop(neo[0][2])));//alaska
		greenland.setText(Integer.toString(troop(neo[0][3])));//greenland
		mexico.setText(Integer.toString(troop(neo[0][4])));//Mexico

		venezuella.setText(Integer.toString(troop(neo[0][5])));//venezuella
		brazil.setText(Integer.toString(troop(neo[0][6])));//brazil
		argentina.setText(Integer.toString(troop(neo[0][7])));//argentina

		nafrica.setText(Integer.toString(troop(neo[1][0])));//nafrica
		safrica.setText(Integer.toString(troop(neo[1][1])));//safrica
		egypt.setText(Integer.toString(troop(neo[1][2])));//egypt
		eafrica.setText(Integer.toString(troop(neo[1][3])));//eafrica
		madag.setText(Integer.toString(troop(neo[1][4])));//madag

		eaustralia.setText(Integer.toString(troop(neo[1][5])));//eaustralia
		waustralia.setText(Integer.toString(troop(neo[1][6])));//waustralia
		nguninea.setText(Integer.toString(troop(neo[1][7])));//nguninea

		sasia.setText(Integer.toString(troop(neo[2][0])));//sasia
		indonesia.setText(Integer.toString(troop(neo[2][1])));//indonesia
		india.setText(Integer.toString(troop(neo[2][2])));//india
		china.setText(Integer.toString(troop(neo[2][3])));//china
		russia.setText(Integer.toString(troop(neo[2][4])));//russia
		japan.setText(Integer.toString(troop(neo[2][5])));//japan
		meast.setText(Integer.toString(troop(neo[2][6])));//meast
		afghan.setText(Integer.toString(troop(neo[2][7])));//afghan

		ireland.setText(Integer.toString(troop(neo[3][0])));//ireland
		scandanavia.setText(Integer.toString(troop(neo[3][1])));//scandanavia
		eeurope.setText(Integer.toString(troop(neo[3][2])));//eeurope
		weurope.setText(Integer.toString(troop(neo[3][3])));//weurope
		britain.setText(Integer.toString(troop(neo[3][4])));//britain

	}//update

	public void save(double [][]neo){

		java.io.File Riskfile = new java.io.File("gamedata.txt");

		try {
			java.io.PrintWriter output = new java.io.PrintWriter(Riskfile);
			for (int k = 0; k < 4; k++){
				for (int l = 0; l < 8; l++){
					output.print(neo[k][l] + " ");
				}//for
				output.print("\n");
			}//for
			output.close();
			System.exit(1);
		} catch (Exception e2){
			e2.printStackTrace();
		}//catch
	}//save

	public void endTurn(double [][] neo){

		//-------------------Properties----------------------------
		turn.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		turn.setFill(Color.WHITE);
		rein.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		rein.setFill(Color.WHITE);

		Color[] ColorArray = {Color.WHITE, Color.BLUEVIOLET, Color.GREEN, Color.RED, Color.YELLOW};
		america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		america.setFill(ColorArray[player(neo[0][0])]);
		canadia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		canadia.setFill(ColorArray[player(neo[0][1])]);
		alaska.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		alaska.setFill(ColorArray[player(neo[0][2])]);
		greenland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		greenland.setFill(ColorArray[player(neo[0][3])]);
		mexico.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		mexico.setFill(ColorArray[player(neo[0][4])]);
		venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		venezuella.setFill(ColorArray[player(neo[0][5])]);
		brazil.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		brazil.setFill(ColorArray[player(neo[0][6])]);
		argentina.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		argentina.setFill(ColorArray[player(neo[0][7])]);
		nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		nafrica.setFill(ColorArray[player(neo[1][0])]);
		safrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		safrica.setFill(ColorArray[player(neo[1][1])]);
		eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		eafrica.setFill(ColorArray[player(neo[1][3])]);
		egypt.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		egypt.setFill(ColorArray[player(neo[1][2])]);
		madag.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		madag.setFill(ColorArray[player(neo[1][4])]);
		eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		eaustralia.setFill(ColorArray[player(neo[1][5])]);
		waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		waustralia.setFill(ColorArray[player(neo[1][6])]);
		nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		nguninea.setFill(ColorArray[player(neo[1][7])]);
		sasia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		sasia.setFill(ColorArray[player(neo[2][0])]);
		indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		indonesia.setFill(ColorArray[player(neo[2][1])]);
		india.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		india.setFill(ColorArray[player(neo[2][2])]);
		china.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		china.setFill(ColorArray[player(neo[2][3])]);
		russia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		russia.setFill(ColorArray[player(neo[2][4])]);
		japan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		japan.setFill(ColorArray[player(neo[2][5])]);
		meast.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		meast.setFill(ColorArray[player(neo[2][6])]);
		afghan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		afghan.setFill(ColorArray[player(neo[2][7])]);
		ireland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		ireland.setFill(ColorArray[player(neo[3][0])]);
		scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		scandanavia.setFill(ColorArray[player(neo[3][1])]);
		eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		eeurope.setFill(ColorArray[player(neo[3][2])]);
		weurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		weurope.setFill(ColorArray[player(neo[3][3])]);
		britain.setFont(Font.font("Courier", FontWeight.BOLD, 25));
		britain.setFill(ColorArray[player(neo[3][4])]);

	}//endTurn

	public void initializeProperties(double [][] neo){
		//initialize countries
		america = new Text(122,216,"0");//america
		canadia = new Text(134,150,"0");//canadia
		alaska = new Text(60,120,"0");//alaska
		greenland = new Text(330,90,"0");//greenland
		mexico = new Text(110,295,"0");//Mexico

		venezuella = new Text(220,450,"0");//venezuella
		brazil = new Text(245,400,"0");//brazil
		argentina = new Text(185,375,"0");//argentina

		nafrica = new Text(400,295,"0");//nafrica
		safrica = new Text(470,420,"0");//safrica
		egypt = new Text(480,295,"0");//egypt
		eafrica = new Text(536,348,"0");//eafrica
		madag = new Text(545,445,"0");//madag

		eaustralia = new Text(903,558,"0");//eaustralia
		waustralia = new Text(800,470,"0");//waustralia
		nguninea = new Text(833,395,"0");//nguninea

		sasia = new Text(718,314,"0");//sasia
		indonesia = new Text(750,370,"0");//indonesia
		india = new Text(647,278,"0");//india
		china = new Text(700,220,"0");//china
		russia = new Text(640,128,"0");//russia
		japan = new Text(820,233,"0");//japan
		meast = new Text(538,250,"0");//meast
		afghan = new Text(595,200,"0");//afghan

		ireland = new Text(390,108,"0");//ireland
		scandanavia = new Text(447,127,"0");//scandanavia
		eeurope = new Text(480,180,"0");//eeurope
		weurope = new Text(423,180,"0");//weurope
		britain = new Text(370,169,"0");//britain

		turn = new Text(10,39,"Turn: Blue");
		rein = new Text(200,39, "Reinforcements: "+ Integer.toString(reinforce));

		endTurn(neo);

	}//initializeProperties
}//Game_Board				