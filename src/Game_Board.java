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
		                rein.setFont(Font.font("Courier", FontWeight.BOLD, 25));
				rein.setFill(Color.WHITE);
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
		                
		                Button e1 = new Button("End Turn");
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
					if (e.getButton() == MouseButton.PRIMARY ){
						america.setFont(Font.font("Courier", FontWeight.BOLD, 40));
					}
					else if (e.getButton() == MouseButton.SECONDARY ){	
						america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
					}
				});
		                
		                e1.setOnMouseClicked(e -> {
		                        //blue=0033CC||green=339933||red=E62E00
		                        String[] col = {"-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;","-fx-background-color: #CC00FF;"};
		                        String[] col2 = {"Turn: Blue", "Turn: Green", "Turn: Red", "Turn: Purple"};
		                        bGround.setStyle(col[i]);
		                        turn.setText(col2[i]);
		                        i = i + 1;
		                        if (i == neo[3][5]){
		                            i = 0;
		                        }//if
		                });
		                
		                b1.setOnMouseClicked(e -> {
					System.exit(1);
				});
		                dice.setOnMouseClicked(e -> {
					Dice_Roll_GUI diceBox = new Dice_Roll_GUI();
					cor = diceBox.roll(cor);
				});
		                
		                s1.setOnMouseClicked(e -> {
					//------------------yet to come--------------------------------
				});
		              
				// Set the stage to display the scene
				Scene scene = new Scene(pane);
				Stage primaryStage = new Stage();
				primaryStage.setTitle("GUI_Widgets");
				primaryStage.setScene(scene);
				primaryStage.show();	
			}
        public int troop(double territory){
                int trp = (int)territory;
            return trp;
        }//troop
        
        public void update(double[][]neo){
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
}				