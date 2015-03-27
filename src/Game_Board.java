import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

/**
 * @author Philip
 * @version 1.0
 * @created 25-Feb-2015 03:23:09 PM
 */
public class Game_Board {
	
	public int i = 1;
	public double [] cor = {0,0};
        Text america, canadia,alaska,greenland,mexico,venezuella,brazil,argentina;
        Text nafrica, safrica, egypt, eafrica, madag, eaustralia, waustralia,nguninea;
        Text sasia, indonesia, india, china, russia, japan, meast,afghan;
        Text ireland, scandanavia, eeurope, weurope, britain;
        
        public void Playgame(double[][]neo){
		
            // Construct a border pane and four individual pane for scene
            BorderPane pane = new BorderPane();
            Pane paneForBoard = new Pane();

            Text turn = new Text(10,39,"Turn: Blue");
            Text rein = new Text(200,39, "Reinforcements: ");

            //-------------------Properties----------------------------
            turn.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            turn.setFill(Color.WHITE);
            rein.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            rein.setFill(Color.WHITE);

            //initialize the properties for the rest of the texts
            initializeProperties();
            //update the troops and numbers for rest of the world
            updater(neo);
            
            Image image = new Image("WorldMap.jpg");

            Button bGround = new Button();
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

            Button e1 = new Button("Attack Phase");
            e1.setMinSize(120, 47);
            e1.setLayoutY(7);
            e1.setLayoutX(580);//700
            //----------------------------------
            Button dice = new Button("Dice");
            dice.setMinSize(120, 47);
            dice.setLayoutY(635);
            dice.setLayoutX(812);//700
            //-----------------------------------
            ImageView imageView1 = new ImageView(image);
            imageView1.setFitHeight(700);
            imageView1.setFitWidth(1000);

            paneForBoard.getChildren().addAll(imageView1,bGround, turn,rein, b1,s1,e1, america,canadia,alaska,greenland,mexico,venezuella,brazil,argentina,nafrica,safrica,eafrica,egypt,eaustralia,waustralia,nguninea,sasia,indonesia,india,china,russia,japan,meast,afghan,ireland,scandanavia,eeurope,weurope,britain,dice,madag);

            // Place all the pane create and place them on the border pane 
            pane.setCenter(paneForBoard);

            america.setOnMouseClicked(e -> {
                //*************************add color 
                //************************add all countriess
                //************************move to phase button so these can have different reactions depending on phase
                                        //****************Reinforcement phase
                                                        //----> call set troop(current + 1)
                                                        //----> decrease troop count
                                                        //---->when 0 move to attack phase
                                        //****************Attack Phase
                                                        //---->add 1 (to selected) when place is clicked
                                                        //---->increase font size of selected spot
                                                        //---->when 2 are selected check if they can attack each other
                                                        //---->call dice program with both locations
                                        //****************Fortification Phase
                                                        //---->add 1 (to selected) when place is clicked
                                                        //---->increase font size of selected spot
                                                        //---->when 2 are selected bring up msgbox saying how many troops
                                                        //---->subtract troops from first(if that many are  available
                                                        //---->add troops to second selected
                if (e.getButton() == MouseButton.PRIMARY ){
                        america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
                }
                else if (e.getButton() == MouseButton.SECONDARY ){	
                        america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
                }
            });

            b1.setOnMouseClicked(e -> {
                    System.exit(1);
            });
            dice.setOnMouseClicked(e -> {
                    Dice_Roll_GUI diceBox = new Dice_Roll_GUI();
                    cor = diceBox.roll(cor);
            });

            s1.setOnMouseClicked(e -> {
                String numPlayers = neo[3][5] + " ";
                String stringi = i + " ";
                String [] [] array = {  
                    {america.getText()+ " ", canadia.getText() + " ", alaska.getText() + " ", greenland.getText() + " ", mexico.getText() + " ", venezuella.getText() + " ", brazil.getText() + " ", argentina.getText() + " "},
                    {nafrica.getText() + " ", safrica.getText() + " ", egypt.getText() + " ", eafrica.getText() + " ", madag.getText() + " ", eaustralia.getText() + " ", waustralia.getText() + " ", nguninea.getText() + " "},
                    {sasia.getText() + " ", indonesia.getText() + " ", india.getText() + " ", china.getText() + " ",russia.getText() + " ", japan.getText() + " ", meast.getText() + " ", afghan.getText() + " "},
                    {ireland.getText() + " ", scandanavia.getText() + " ", eeurope.getText() + " ", weurope.getText() + " ",britain.getText() + " ", numPlayers, stringi, Double.toString(neo[3][7])}};
                java.io.File Riskfile = new java.io.File("gamedata.txt");
                
                try {
                    java.io.PrintWriter output = new java.io.PrintWriter(Riskfile);
                    for (int k = 0; k < 4; k++){
                        output.print(array[k][0]);
                        output.print(array[k][1]);
                        output.print(array[k][2]);
                        output.print(array[k][3]);
                        output.print(array[k][4]);
                        output.print(array[k][5]);
                        output.print(array[k][6]);
                        output.println(array[k][7]);
                    }//for
                    output.close();
                    System.exit(1);
                } catch (Exception e2){
                    e2.printStackTrace();
                }//catch    
            });

            // Set the stage to display the scene
            Scene scene = new Scene(pane);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("GUI_Widgets");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            e1.setOnMouseClicked(e -> {
                if ((int)neo[3][7] == 0){            //reinforcement phase

                    //************************give user 3 troops to spend
                    e1.setText("Fortify!");
                     updater(neo);
                     neo[3][7] ++;

                }else if((int)neo[3][7] == 1.0){       //attack phase

                    //*****************************************let user attack
                    e1.setText("End Turn");
                    updater(neo);
                    neo[3][7] ++;

                }else if((int)neo[3][7] == 2){       //fortification phase

                    //***********************************let user move troops between own territories
                    updater(neo);
                    e1.setText("Attack phase!");

                    //blue=0033CC||green=339933||red=E62E00
                    String[] col = {"-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #FFFF99;"};
                    String[] col2 = {"Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Yellow"};
                    bGround.setStyle(col[i]);
                    turn.setText(col2[i]);
                    i = i + 1;
                    if (i == neo[3][5]){
                        i = 0;
                    }//if
                    neo[3][7] = 0;              //reset to reinforcement phase
            
                }//if    
            });
            //-----------------------------------------------------------------
        }
        public int troop(double territory){
            int trp = (int)territory;
            return trp;
        }//troop
        
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
        
        public void initializeProperties(){
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
            
            ireland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            ireland.setFill(Color.WHITE);
	    scandanavia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    scandanavia.setFill(Color.WHITE);
	    eeurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            eeurope.setFill(Color.WHITE);
	    weurope.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    weurope.setFill(Color.WHITE);
	    britain.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    britain.setFill(Color.WHITE);
	    sasia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    sasia.setFill(Color.WHITE);
            indonesia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            indonesia.setFill(Color.WHITE);
            india.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    india.setFill(Color.WHITE);
            china.setFont(Font.font("Courier", FontWeight.BOLD, 25));
   	    china.setFill(Color.WHITE);
            russia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
 	    russia.setFill(Color.WHITE);
            japan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    japan.setFill(Color.WHITE);
            meast.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    meast.setFill(Color.WHITE);
            afghan.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            afghan.setFill(Color.WHITE);
	    america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    america.setFill(Color.WHITE);
            canadia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    canadia.setFill(Color.WHITE);
            alaska.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    alaska.setFill(Color.WHITE);
            greenland.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    greenland.setFill(Color.WHITE);
            mexico.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    mexico.setFill(Color.WHITE);
            venezuella.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    venezuella.setFill(Color.WHITE);
            brazil.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            brazil.setFill(Color.WHITE);
            argentina.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    argentina.setFill(Color.WHITE);
            nafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    nafrica.setFill(Color.WHITE);
            safrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            safrica.setFill(Color.WHITE);
            eafrica.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            eafrica.setFill(Color.WHITE);
	    egypt.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    egypt.setFill(Color.WHITE);
            madag.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    madag.setFill(Color.WHITE);
	    eaustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    eaustralia.setFill(Color.WHITE);
	    waustralia.setFont(Font.font("Courier", FontWeight.BOLD, 25));
	    waustralia.setFill(Color.WHITE);
            nguninea.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            nguninea.setFill(Color.WHITE);
            
        }//initializeProperties
}				