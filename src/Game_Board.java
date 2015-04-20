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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * @author Philip, Leydi, Andrew, Bruno, Fernando
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */

public class Game_Board {

    private int reinforce = 3;//int i = 1, 
    private double [] cor = {0,0,0,0,0,0};
    private double [][] troops = new double[2][2];
    private double [][] atkCor = new double[1][2];
    private int selected = 0;
    private int [][] cord = new int[1][1];
    private String attacker;
    private String defender;
    private String[] col = {"-fx-background-color: #DDE6E8;","-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF00;"};
    private String[] col2 = {"Turn: White","Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
    private String[] col3 = {"End Populate", "Reinforce", "End Attack", "End Turn"};      
    private int count1 = 1, count2 = 1, count3 = 1, count4 = 1;
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
        updater(neo);
        bGround = new Button();
        bGround.setMinSize(999, 48);
        bGround.setLayoutY(1);
        bGround.setStyle(col[(int)neo[3][6]]);

        Button b1 = new Button("Quit");
        b1.setMinSize(120, 48);
        b1.setLayoutY(1);
        b1.setLayoutX(860);
        b1.setTextFill(Color.web("#0076a3"));
        b1.setStyle("-fx-font: 15 courier; -fx-font-weight: BOLD; -fx-base: GOLD");

        Button s1 = new Button("Save");
        s1.setMinSize(120, 48);
        s1.setLayoutY(1);
        s1.setLayoutX(720);//840
        s1.setTextFill(Color.web("#0076a3"));
        s1.setStyle("-fx-font: 15 courier; -fx-font-weight: BOLD; -fx-base: GOLD");

        e1 = new Button(col3[(int)neo[3][7]]);
        e1.setMinSize(120, 48);
        e1.setLayoutY(1);
        e1.setLayoutX(580);//700
        e1.setTextFill(Color.web("#0076a3"));
        e1.setStyle("-fx-font: 15 courier; -fx-font-weight: BOLD; -fx-base: GOLD");

        Image image = new Image("WorldMap1.jpg");
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
            e1.setText("Reinforce");
            String[] col = {"-fx-background-color: #DDE6E8;","-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF00;"};
            String[] col2 = {"Turn: White","Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
            if (neo[3][6]++ == neo[3][5]){
                    neo[3][6] = 1.0;
            }//if
            System.out.println(count1 + " " + count2 + " " + count3 + " " + count4);
            System.out.println(neo[3][6]);
            if(neo[3][6] == 1.0 && count1 == 0){
                neo[3][6]++;
            }else if(neo[3][6] == 2.0 && count2 == 0){
                neo[3][6]++;
            }else if(neo[3][6] == 3.0 && count3 == 0){
                neo[3][6]++;
            }else if(neo[3][6] == 4.0 && count4 == 0){
                neo[3][6]++;
            }//if
            if (neo[3][6] == neo[3][5]+1){
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
                    if(selected == 1){  
                        america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        america.setFont(Font.font("Courier", FontWeight.BOLD, 25));        
                    }//if
		});
		canadia.setOnMouseClicked(e2 -> {
                    neo[0][1] = actions(0,1, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        canadia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        canadia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		alaska.setOnMouseClicked(e2 -> {
                    neo[0][2] = actions(0,2, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        alaska.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        alaska.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		greenland.setOnMouseClicked(e2 -> {
                    neo[0][3] = actions(0,3, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        greenland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        greenland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		mexico.setOnMouseClicked(e2 -> {
                    neo[0][4] = actions(0,4, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        mexico.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        mexico.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		venezuella.setOnMouseClicked(e2 -> {
                    neo[0][5] = actions(0,5, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		brazil.setOnMouseClicked(e2 -> {
                    neo[0][6] = actions(0,6, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        brazil.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        brazil.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if        
		});
		argentina.setOnMouseClicked(e2 -> {
                    neo[0][7] = actions(0,7, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        argentina.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        argentina.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		nafrica.setOnMouseClicked(e2 -> {
                    neo[1][0] = actions(1,0, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		safrica.setOnMouseClicked(e2 -> {
                    neo[1][1] = actions(1,1, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		egypt.setOnMouseClicked(e2 -> {
                    neo[1][2] = actions(1,2, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		eafrica.setOnMouseClicked(e2 -> {
                    neo[1][3] = actions(1,3, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		madag.setOnMouseClicked(e2 -> {
			neo[1][4] = actions(1,4, neo, e2.getButton() == MouseButton.PRIMARY);
			updater(neo);
                    if(selected == 1){  
                        madag.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        madag.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		eaustralia.setOnMouseClicked(e2 -> {
                    neo[1][5] = actions(1,5, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		waustralia.setOnMouseClicked(e2 -> {
                    neo[1][6] = actions(1,6, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if        
		});
		nguninea.setOnMouseClicked(e2 -> {
                    neo[1][7] = actions(1,7, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		sasia.setOnMouseClicked(e2 -> {
                    neo[2][0] = actions(2,0, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        sasia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        sasia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		indonesia.setOnMouseClicked(e2 -> {
                    neo[2][1] = actions(2,1, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
		    }else if (selected == 0) {	
                        indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		india.setOnMouseClicked(e2 -> {
                    neo[2][2] = actions(2,2, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        india.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        india.setFont(Font.font("Courier", FontWeight.BOLD, 25));        
                    }//if
		});
		china.setOnMouseClicked(e2 -> {
                    neo[2][3] = actions(2,3, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        china.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		russia.setOnMouseClicked(e2 -> {
                    neo[2][4] = actions(2,4, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
		    }else if (selected == 0) {	
                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		}); 
		japan.setOnMouseClicked(e2 -> {
                    neo[2][5] = actions(2,5, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        japan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
		    }else if (selected == 0) {	
                        japan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		meast.setOnMouseClicked(e2 -> {
                    neo[2][6] = actions(2,6, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
		    }else if (selected == 0) {	
                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		afghan.setOnMouseClicked(e2 -> {
                    neo[2][7] = actions(2,7, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
		    }else if (selected == 0) {	
                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		ireland.setOnMouseClicked(e2 -> {
                    neo[3][0] = actions(3,0, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        ireland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        ireland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		scandanavia.setOnMouseClicked(e2 -> {
                    neo[3][1] = actions(3,1, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		eeurope.setOnMouseClicked(e2 -> {
                    neo[3][2] = actions(3,2, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		weurope.setOnMouseClicked(e2 -> {
                    neo[3][3] = actions(3,3, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                    }//if
		});
		britain.setOnMouseClicked(e2 -> {
                    neo[3][4] = actions(3,4, neo, e2.getButton() == MouseButton.PRIMARY);
                    updater(neo);
                    if(selected == 1){  
                        britain.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                    }else if (selected == 0) {	
                        britain.setFont(Font.font("Courier", FontWeight.BOLD, 25));
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

	public int attack(int row, int column, String attacker, String defender){
		troops[1][0] = row;
		troops[1][1] = column;
		System.out.println(attacker + " -> " + defender);
		return selected = 2;
	}//attack

	/**
	 * @author Bruno
	 * @param row
	 * @param column
	 * @param neo
	 * Give the color to the troops added. Change the color of the top bar. Continue cycle
	 */
	public void addTroops(int row, int column, double [] [] neo) {
		//Cycle structure
		if (neo[3][6] == neo[3][5]) {// If it's the last player's turn
			neo[3][6] = 1;			//Restart cycle

		} else if ( neo[3][6] == 0){	//If it is player 0
			neo[3][6] = 2;			//To avoid repeating player 1 (blue)

		} else if (neo[3][6] != neo[3][5]) {//Proceed with the next color
			neo[3][6]++;
		}//if

		turn.setText(col2[(int)neo[3][6]]);
		bGround.setStyle(col[(int)neo[3][6]]);

		//Paint territory and set characteristics
		if(neo[3][6] == 1){//Paint last player's color but keep continuation of cycle
			neo[row][column] = setPlayer(row, column, neo, (int)neo[3][5] );

		}else {//Paint the rest of the numbers
			neo[row][column] = setPlayer(row, column, neo, (int)neo[3][6] - 1);	
		}//if
	}


	public double actions(int row, int column, double [][] neo, Boolean button){
		//-------------------INITIAL DEPLOYMENT--------------------------------------------------------------
		if ((int)neo[3][7] == 0){     
			//initial add troops phase

			//Check if current player is the owner -> if(neo[3][6] == player(neo[row][column])

			int n = 1 + (int)neo[0][0] + (int)neo[0][1] + (int)neo[0][2] + (int)neo[0][3] + (int)neo[0][4] + (int)neo[0][5] + (int)neo[0][6] + (int)neo[0][7]+ (int)neo[1][0] + (int)neo[1][1] + (int)neo[1][2] + (int)neo[1][3] + (int)neo[1][4] + (int)neo[1][5] + (int)neo[1][6] + (int)neo[1][7] + (int)neo[2][0] + (int)neo[2][1] + (int)neo[2][2] + (int)neo[2][3] + (int)neo[2][4] + (int)neo[2][5] + (int)neo[2][6] + (int)neo[2][7] + (int)neo[3][0] + (int)neo[3][1] + (int)neo[3][2] + (int)neo[3][3] + (int)neo[3][4];
			if (n != 72.0) {
				neo[3][7] = 0;

				//Add the first troop to the territory
				if (neo[row][column] == 0){
					neo[row][column] = 1;

					//Add more troops to the territory
				} else if (neo[row][column] != 0){
					neo[row][column]++;
				}//if

				addTroops(row, column, neo);	
				/*			//Cycle structure
				//Change the color and text of the bar
				//Paint territory and set characteristics	*/
				endTurn(neo);



			}else /*if (n == 72.0)*/ {

				neo[row][column] = setPlayer(row, column, neo, (int)neo[3][6]);	
				endTurn(neo);
				neo[3][7] = 1;//only once the last troop has been added
				e1.setText("End Attack");//only once the last troop has been added
			}//if

			//-------------------------END INITIAL DEPLOYMENT                
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
			//------------------------END REINFORCEMENT PHASE----------------------------------------------------------------------
			//------------------------ATTACK PHASE---------------------------------------------------------------------------
		} else if((int)neo[3][7] == 2){                      
			if (button){

				// Attacker Selected
				if((selected == 0) && (player(neo[row][column]) == neo[3][6])) {
					troops[selected][0] = row;
					troops[selected][1] = column;
					atkCor[0][0] = row;
					atkCor[0][1] = column;
					selected = 1;
				}

				// Defender Selected
				else if ((selected == 1) && (player(neo[row][column]) != neo[3][6])) {

					// Attack From America
					if ((atkCor[0][0] == 0) && (atkCor[0][1] == 0)) {
						if ((row == 0) && (column == 1)) {
                                                        canadia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
							attack(row, column, attacker = "America", defender = "Canada");
						}
						else if ((row == 0) && (column == 4)) {
                                                        mexico.setFont(Font.font("Courier", FontWeight.BOLD, 40));
							attack(row, column, attacker = "America", defender = "Mexico");
						}
						else {
							selected = 0;
						}
					}

					// Attack From Canada
					if ((atkCor[0][0] == 0) && (atkCor[0][1] == 1)) {
						if ((row == 0) && (column == 0)) {
							attack(row, column, attacker = "Canada", defender = "America");
                                                        america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 2)) {
							attack(row, column, attacker = "Canada", defender = "Alaska");
                                                        alaska.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 3)) {
							attack(row, column, attacker = "Canada", defender = "Greenland");
                                                        greenland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Alaska
					if ((atkCor[0][0] == 0.0) && (atkCor[0][1] == 2.0)) {
						if ((row == 0) && (column == 1)) {
							attack(row, column, attacker = "Alaska", defender = "Canada");
                                                        canadia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
						}
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "Alaska", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Greenland
					if ((atkCor[0][0] == 0.0) && (atkCor[0][1] == 3.0)) {
						if ((row == 0) && (column == 1)) {
							attack(row, column, attacker = "Greenland", defender = "Canada");
                                                        canadia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
						}
						else if ((row == 3) && (column == 0)) {
							attack(row, column, attacker = "Greenland", defender = "Iceland");
                                                        ireland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Mexico
					if ((atkCor[0][0] == 0.0) && (atkCor[0][1] == 4.0)) {
						if ((row == 0) && (column == 0)) {
							attack(row, column, attacker = "Mexico", defender = "America");
                                                        america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 5)) {
							attack(row, column, attacker = "Mexico", defender = "Venezuela");
                                                        venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Venezuela
					if ((atkCor[0][0] == 0) && (atkCor[0][1] == 5)) {
						if ((row == 0) && (column == 4)) {
							attack(row, column, attacker = "Venezuela", defender = "Mexico");
                                                        mexico.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 6)) {
							attack(row, column, attacker = "Venezuela", defender = "Brazil");
                                                        brazil.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 7)) {
							attack(row, column, attacker = "Venezuela", defender = "Argentina");
                                                        argentina.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Brazil
					if ((atkCor[0][0] == 0) && (atkCor[0][1] == 6)) {
						if ((row == 0) && (column == 5)) {
							attack(row, column, attacker = "Brazil", defender = "Venezuela");
                                                        venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 7)) {
							attack(row, column, attacker = "Brazil", defender = "Argentina");
                                                        argentina.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 0)) {
							attack(row, column, attacker = "Brazil", defender = "North Africa");
                                                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Argentina
					if ((atkCor[0][0] == 0) && (atkCor[0][1] == 7)) {
						if ((row == 0) && (column == 5)) {
							attack(row, column, attacker = "Argentina", defender = "Venezuela");
                                                        venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 0) && (column == 6)) {
							attack(row, column, attacker = "Argentina", defender = "Brazil");
                                                        brazil.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From North Africa
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 0)) {
						if ((row == 0) && (column == 6)) {
							attack(row, column, attacker = "North Africa", defender = "Brazil");
                                                        brazil.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 1)) {
							attack(row, column, attacker = "North Africa", defender = "South Africa");
                                                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "North Africa", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 3)) {
							attack(row, column, attacker = "North Africa", defender = "West Europe");
                                                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From South Africa
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 1)) {
						if ((row == 1) && (column == 0)) {
							attack(row, column, attacker = "South Africa", defender = "North Africa");
                                                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "South Africa", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 3)) {
							attack(row, column, attacker = "South Africa", defender = "East Africa");
                                                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 4)) {
							attack(row, column, attacker = "South Africa", defender = "Madagascar");
                                                        madag.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Egypt
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 2)) {
						if ((row == 1) && (column == 0)) {
							attack(row, column, attacker = "Egypt", defender = "North Africa");
                                                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 1)) {
							attack(row, column, attacker = "Egypt", defender = "South Africa");
                                                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 3)) {
							attack(row, column, attacker = "Egypt", defender = "East Africa");
                                                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 6)) {
							attack(row, column, attacker = "Egypt", defender = "Middle East");
                                                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 2)) {
							attack(row, column, attacker = "Egypt", defender = "East Europe");
                                                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 3)) {
							attack(row, column, attacker = "Egypt", defender = "West Europe");
                                                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From East Africa
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 3)) {
						if ((row == 1) && (column == 1)) {
							attack(row, column, attacker = "East Africa", defender = "South Africa");
                                                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "East Africa", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 4)) {
							attack(row, column, attacker = "East Africa", defender = "Madagascar");
                                                        madag.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 6)) {
							attack(row, column, attacker = "East Africa", defender = "Middle East");
                                                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Madagascar
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 4)) {
						if ((row == 1) && (column == 1)) {
							attack(row, column, attacker = "Madagascar", defender = "South Africa");
                                                        safrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 3)) {
							attack(row, column, attacker = "Madagascar", defender = "East Africa");
                                                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From East Australia
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 5)) {
						if ((row == 1) && (column == 6)) {
							attack(row, column, attacker = "East Australia", defender = "West Australia");
                                                        waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From West Australia
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 6)) {
						if ((row == 1) && (column == 5)) {
							attack(row, column, attacker = "West Australia", defender = "East Australia");
                                                        eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 7)) {
							attack(row, column, attacker = "West Australia", defender = "New Guninea");
                                                        nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 1)) {
							attack(row, column, attacker = "West Australia", defender = "Indonesia");
                                                        indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From New Guninea
					if ((atkCor[0][0] == 1) && (atkCor[0][1] == 7)) {
						if ((row == 1) && (column == 6)) {
							attack(row, column, attacker = "New Guninea", defender = "West Australia");
                                                        waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 1)) {
							attack(row, column, attacker = "New Guninea", defender = "Indonesia");
                                                        indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From South Asia
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 0)) {
						if ((row == 2) && (column == 1)) {
							attack(row, column, attacker = "South Asia", defender = "Indonesia");
                                                        indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 2)) {
							attack(row, column, attacker = "South Asia", defender = "India");
                                                        india.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 3)) {
							attack(row, column, attacker = "South Asia", defender = "China");
                                                        china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Indonesia
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 1)) {
						if ((row == 1) && (column == 6)) {
							attack(row, column, attacker = "Indonesia", defender = "West Australia");
                                                        waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 7)) {
							attack(row, column, attacker = "Indonesia", defender = "New Guninea");
                                                        nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 0)) {
							attack(row, column, attacker = "Indonesia", defender = "South Asia");
                                                        sasia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From India
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 2)) {
						if ((row == 2) && (column == 0)) {
							attack(row, column, attacker = "India", defender = "South Asia");
                                                        sasia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 3)) {
							attack(row, column, attacker = "India", defender = "China");
                                                        china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 7)) {
							attack(row, column, attacker = "India", defender = "Afghanistan");
                                                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From China
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 3)) {
						if ((row == 2) && (column == 0)) {
							attack(row, column, attacker = "China", defender = "South Asia");
                                                        sasia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 2)) {
							attack(row, column, attacker = "China", defender = "India");
                                                        india.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "China", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 5)) {
							attack(row, column, attacker = "China", defender = "Japan");
                                                        japan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 7)) {
							attack(row, column, attacker = "China", defender = "Afghanistan");
                                                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Russia
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 4)) {
						if ((row == 0) && (column == 2)) {
							attack(row, column, attacker = "Russia", defender = "Alaska");
                                                        alaska.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 3)) {
							attack(row, column, attacker = "Russia", defender = "China");
                                                        china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 5)) {
							attack(row, column, attacker = "Russia", defender = "Japan");
                                                        japan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 6)) {
							attack(row, column, attacker = "Russia", defender = "Middle East");
                                                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 7)) {
							attack(row, column, attacker = "Russia", defender = "Afghanistan");
                                                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 1)) {
							attack(row, column, attacker = "Russia", defender = "Scandanavia");
                                                        scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 2)) {
							attack(row, column, attacker = "Russia", defender = "East Europe");
                                                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Japan
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 5)) {
						if ((row == 2) && (column == 3)) {
							attack(row, column, attacker = "Japan", defender = "China");
                                                        japan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "Japan", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Middle East
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 6)) {
						if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "Middle East", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 3)) {
							attack(row, column, attacker = "Middle East", defender = "East Africa");
                                                        eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "Middle East", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 7)) {
							attack(row, column, attacker = "Middle East", defender = "Afghanistan");
                                                        afghan.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 2)) {
							attack(row, column, attacker = "Middle East", defender = "East Europe");
                                                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Afghanistan
					if ((atkCor[0][0] == 2) && (atkCor[0][1] == 7)) {
						if ((row == 2) && (column == 2)) {
							attack(row, column, attacker = "Afghanistan", defender = "India");
                                                        india.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 3)) {
							attack(row, column, attacker = "Afghanistan", defender = "China");
                                                        china.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "Afghanistan", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 6)) {
							attack(row, column, attacker = "Afghanistan", defender = "Middle East");
                                                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Iceland
					if ((atkCor[0][0] == 3) && (atkCor[0][1] == 0)) {
						if ((row == 0) && (column == 3)) {
							attack(row, column, attacker = "Iceland", defender = "Greenland");
                                                        greenland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 1)) {
							attack(row, column, attacker = "Iceland", defender = "Scandanavia");
                                                        scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 4)) {
							attack(row, column, attacker = "Iceland", defender = "Britain");
                                                        britain.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Scandanavia
					if ((atkCor[0][0] == 3) && (atkCor[0][1] == 1)) {
						if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "Scandanavia", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 0)) {
							attack(row, column, attacker = "Scandanavia", defender = "Iceland");
                                                        ireland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 2)) {
							attack(row, column, attacker = "Scandanavia", defender = "East Europe");
                                                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 3)) {
							attack(row, column, attacker = "Scandanavia", defender = "West Europe");
                                                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From East Europe
					if ((atkCor[0][0] == 3) && (atkCor[0][1] == 2)) {
						if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "East Europe", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 4)) {
							attack(row, column, attacker = "East Europe", defender = "Russia");
                                                        russia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 2) && (column == 6)) {
							attack(row, column, attacker = "East Europe", defender = "Middle East");
                                                        meast.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 1)) {
							attack(row, column, attacker = "East Europe", defender = "Scandanavia");
                                                        scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 3)) {
							attack(row, column, attacker = "East Europe", defender = "West Europe");
                                                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From West Europe
					if ((atkCor[0][0] == 3) && (atkCor[0][1] == 3)) {
						if ((row == 1) && (column == 0)) {
							attack(row, column, attacker = "West Europe", defender = "North Africa");
                                                        nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 1) && (column == 2)) {
							attack(row, column, attacker = "West Europe", defender = "Egypt");
                                                        egypt.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 2)) {
							attack(row, column, attacker = "West Europe", defender = "East Europe");
                                                        eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 4)) {
							attack(row, column, attacker = "West Europe", defender = "Britain");
                                                        britain.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

					// Attack From Britain
					if ((atkCor[0][0] == 3) && (atkCor[0][1] == 4)) {
						if ((row == 3) && (column == 0)) {
                                                    	attack(row, column, attacker = "Britain", defender = "Iceland");
                                                        ireland.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else if ((row == 3) && (column == 3)) {
							attack(row, column, attacker = "Britain", defender = "West Europe");
                                                        weurope.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                                                }
						else {
							selected = 0;
						}
					}

				}//if
			}else{
				selected --;
			}//if
			if (selected == -1) {
				selected = 0;
			}else if(selected == 2){
                                cor[4] = 0;
                                cor[5] = 0;
				cor[2] = troop(neo[(int)troops[0][0]][(int)troops[0][1]]);
				cor[3] = troop(neo[(int)troops[1][0]][(int)troops[1][1]]);
				Dice_Roll_GUI diceBox = new Dice_Roll_GUI();
				cor = diceBox.roll(cor);
				//-------------------------------------------------------------------------------------------------------                    
				//create a pop-up to get the # of troops to move
				Label label1 = new Label("Troops to new colony: ");
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
				primaryStage2.setResizable(false);
                                        
				leave.setOnMouseClicked(e -> {
                                    String get = textField.getText();
                                    char let;
                                    reinforce = 0;
                                    if(!(get.isEmpty())){ 
                                        let = get.charAt(0);
                                        if ((int)let< 58  && (int)let >47){
                                            reinforce = Integer.parseInt(get);
                                        }//if
                                    }//if
                                    
                                    primaryStage2.close();                                    
                                });

				primaryStage2.setTitle("Troop Counter");
				primaryStage2.setScene(scenes);
				primaryStage2.setMinHeight(60);
				primaryStage2.setMinWidth(290);
				primaryStage2.setX(0);
				primaryStage2.setY(450);
				do{
                                    primaryStage2.showAndWait();
                                }while(cor[4] == 0);

				//------------------------------------------------------------------------------------------------------                    
				neo[(int)troops[0][0]][(int)troops[0][1]] = setTroop((int)troops[0][0],(int)troops[0][1], neo, (int)cor[2]);
				neo[(int)troops[1][0]][(int)troops[1][1]] = setTroop((int)troops[1][0],(int)troops[1][1], neo, (int)cor[3]);
				if(cor[5] == 1){
                                    neo[(int)troops[1][0]][(int)troops[1][1]] = setPlayer((int)troops[1][0],(int)troops[1][1], neo, (int)neo[3][6]);
                                    if(reinforce <= troop(neo[(int)troops[1][0]][(int)troops[1][1]]) && reinforce > 0){
                                        int num = troop(neo[(int)troops[1][0]][(int)troops[1][1]]) - reinforce;
                                        neo[(int)troops[0][0]][(int)troops[0][1]] = setTroop((int)troops[0][0],(int)troops[0][1], neo, num+1);
                                        neo[(int)troops[1][0]][(int)troops[1][1]] = setTroop((int)troops[1][0],(int)troops[1][1], neo, reinforce);        
                                    }//if
                                }//if
                		selected = 0;
				endTurn(neo);
                                count1 = 0;
                                count2 = 0;
                                count3 = 0;
                                count4 = 0;
                                for(int i = 0; i < 4; i++){    
                                    for (int j = 0; j < 8; j++){
                                        if (!((i == 3) &&(j ==7 || j == 6 || j ==5))){
                                            if (player(neo[i][j]) == 1){//this line
                                                count1 ++;
                                            }
                                            else if(player(neo[i][j]) == 2){
                                                count2 ++;
                                            }
                                            else if (player(neo[i][j]) == 3){
                                                count3++;
                                            }
                                            else if (player(neo[i][j]) == 4){
                                                count4++;
                                            }//if
                                        }//if
                                    }//for
                                    if (count1 == 29){
                                        Winner winner = new Winner();
                                        winner.display(1);
                                    }
                                    else if (count2 == 29){
                                        Winner winner = new Winner();
                                        winner.display(2);
                                    }
                                    else if (count3 == 29){
                                        Winner winner = new Winner();
                                        winner.display(3);
                                    }
                                    else if (count4 == 29){
                                        Winner winner = new Winner();
                                        winner.display(4);
                                    }//if
                                }//for

                        }//if
                	//----------------------------------END ATTACK PHASE----------------------------------------------------------------                
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
                                            String get = textField.getText();
                                            char let;
                                            reinforce = 0;
                                            if(!(get.isEmpty())){ 
                                                let = get.charAt(0);
                                                if ((int)let< 58  && (int)let >47){
                                                    reinforce = Integer.parseInt(get);
                                                }//if
                                            }//if
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
                                        endTurn(neo);
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

	/**
	 * @author Fernando
	 * @param neo
	 */
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
		mexico = new Text(100,295,"0");//Mexico

		venezuella = new Text(205,475,"0");//venezuella
		brazil = new Text(235,405,"0");//brazil
		argentina = new Text(170,385,"0");//argentina

		nafrica = new Text(400,295,"0");//nafrica
		safrica = new Text(470,420,"0");//safrica
		egypt = new Text(480,295,"0");//egypt
		eafrica = new Text(536,348,"0");//eafrica
		madag = new Text(545,445,"0");//madag

		eaustralia = new Text(907,565,"0");//eaustralia
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

		turn = new Text(10,39,col2[(int)neo[3][6]]);
		rein = new Text(200,39, "Reinforcements: "+ Integer.toString(reinforce));

		endTurn(neo);

	}//initializeProperties
}//Game_Board				
