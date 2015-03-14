import javafx.application.Application;
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
	public void twoPlayergame(){
		
				// Construct a border pane and four individual pane for scene
				BorderPane pane = new BorderPane();
				Pane paneForBoard = new Pane();

				Text text1 = new Text("JavaFX Logo");
		                Text turn = new Text(10,39,"Turn: Blue");
		                Text rein = new Text(200,39, "Reinforcements: ");
		                
				Text america = new Text(122,216,"0");//america
		                Text canadia = new Text(134,150,"0");//canadia
		                Text alaska = new Text(60,120,"0");//alaska
		                Text greenland = new Text(330,90,"0");//greenland
		                Text mexico = new Text(110,295,"0");//Mexico
		                
		                Text venezuella = new Text(220,450,"0");//venezuella
		                Text brazil = new Text(245,400,"0");//brazil
		                Text argentina = new Text(185,375,"0");//argentina
		                
		                Text nafrica = new Text(400,295,"0");//nafrica
		                Text safrica = new Text(470,420,"0");//safrica
		                Text egypt = new Text(480,295,"0");//egypt
		                Text eafrica = new Text(536,348,"0");//eafrica
		                
		                Text eaustralia = new Text(903,558,"0");//eaustralia
		                Text waustralia = new Text(800,470,"0");//waustralia
		                Text nguninea = new Text(833,395,"0");//nguninea
		                
		                Text sasia = new Text(718,314,"0");//sasia
		                Text indonesia = new Text(750,370,"0");//indonesia
		                Text india = new Text(647,278,"0");//india
		                Text china = new Text(700,220,"0");//china
		                Text russia = new Text(640,128,"0");//russia
		                Text japan = new Text(820,233,"0");//japan
		                Text meast = new Text(538,250,"0");//meast
		                Text afghan = new Text(595,200,"0");//afghan
		                
		                Text ireland = new Text(390,108,"0");//ireland
		                Text scandanavia = new Text(447,127,"0");//scandanavia
		                Text eeurope = new Text(480,180,"0");//eeurope
		                Text weurope = new Text(423,180,"0");//weurope
		                Text britain = new Text(370,169,"0");//britain
		                
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

				paneForBoard.getChildren().addAll(imageView1,bGround, text1, turn,rein, b1,s1,e1, america,canadia,alaska,greenland,mexico,venezuella,brazil,argentina,nafrica,safrica,eafrica,egypt,eaustralia,waustralia,nguninea,sasia,indonesia,india,china,russia,japan,meast,afghan,ireland,scandanavia,eeurope,weurope,britain,dice);

				// Place all the pane create and place them on the border pane 
				pane.setCenter(paneForBoard);

				text1.setOnMouseDragged(e -> {
					text1.setX(e.getX());
					text1.setY(e.getY());
					double xcoord = e.getSceneX();
					double ycoord = e.getSceneY();
					text1.setText(String.format("%.2f, %.2f", xcoord, ycoord));
				});
				america.setOnMouseClicked(e -> {
					if (e.getButton() == MouseButton.PRIMARY ){
						america.setFont(Font.font("Courier", FontWeight.BOLD, 35));
					}
					else if (e.getButton() == MouseButton.SECONDARY ){	
						america.setFont(Font.font("Courier", FontWeight.BOLD, 25));
					}
				});
		                
		                e1.setOnMouseClicked(e -> {
		                        //blue=0033CC||green=339933||red=E62E00
		                        String[] col = {"-fx-background-color: #0033CC;", "-fx-background-color: #339933;", "-fx-background-color: #E62E00;"};
		                        String[] col2 = {"Turn: Blue", "Turn: Green", "Turn: Red"};
		                        bGround.setStyle(col[i]);
		                        turn.setText(col2[i]);
		                        i = i + 1;
		                        if (i == 3){
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
}				