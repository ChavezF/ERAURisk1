

/**
 * @author Andrew
 * @version 1.5
 * @updated 17-Mar-2015
 * 
 * Displays the instruction window and hides the main menu
 * Has a text area controlled via pagination and two buttons: Play and Quit
 */

import java.awt.Menu;

import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.util.Callback;

public class Instructions extends Menu {

	private Pagination pagination;

	//List<String> lines = Files.readAllLines("Instructions.txt", Charset.forName("UTF-8"));
	//String[] textPages = lines.toArray(new String[lines.size()]);

	final String[] textPages = new String[]{
			//First Page
			"Playing: On your turn, try to capture territories by defeating your opponents'"
			+ "armies. But be careful: Winning battles will depend on careful planning, "
			+ "quick decisions and bold moves. You'll have to place your forces wisely, "
			+ "attack at just the right time and fortify your defenses against all enemies. "
			+ "Each of your turns consists of three steps, in this order:\n"
			+ "1. Getting and placing new armies\n"
			+ "2. Attacking, if you choose to, by rolling the dice\n"
			+ "3. Fortifying your position\n",
			//Second Page
			"Continents: At the beginning of your turn you will receive armies for each"
			+ "continent you control. (To  control a continent, you must occupy all its "
			+ "territories at the start of your turn.)",
			//Third Page
			"Attacking: After placing your armies at the beginning of your turn, decide if "
			+ "you wish to attack at this time. The object of an attack is to capture a "
			+ "territory by defeating all the opposing armies already on it. The battle is "
			+ "fought by a roll of the dice. Study the board for a moment. Do you want to "
			+ "attack? If you choose to attack, you must follow these rules:\n"
			+ "1. You may only attack a territory that's adjacent (touching) to one of your "
			+ "own, or connected to it by a dashed line.\n"
			+ "2. You must always have at least two armies in the territory you're attacking "
			+ "from.\n"
			+ "3. You may continue attacking one territory until you have eliminated all armies "
			+ "on it, or you may shift your attack from one territory to another, attacking "
			+ "each as often as you like and attacking as many territories as you like during "
			+ "one turn.",
			//Fourth Page
			"Capturing territories: As soon as you defeat the last opposing army on a  "
			+ "territory, you capture that territory and must occupy it immediately. "
			+ "To do so, move in at least as many armies as the number of dice you rolled in "
			+ "your last battle. Remember: In most cases, moving as many armies as you can to "
			+ "the front is advantageous, because armies left behind can't help "
			+ "you when you are attacking. Also remember you must always leave at least "
			+ "one army behind on the territory you attacked from. During the game, every "
			+ "territory must always be occupied by at least one army.",
			//Fifth Page
			"Fortifying Your Position: No matter what you've done on your turn, you may, "
			+ "if you wish, end your turn by fortifying your position. You are not required "
			+ "to win a battle or even to try an attack to do so. Some players refer to this "
			+ "as the \"free move.\""
	};

	public int itemsPerPage() {
		return 1;
	}

	public VBox createPage(int pageIndex) {        
		VBox box = new VBox(5);
		int page = pageIndex * itemsPerPage();
		for (int i = page; i < page + itemsPerPage(); i++) {
			TextArea text = new TextArea(textPages[i]);
			text.setWrapText(true);
			box.getChildren().add(text);
		}
		return box;
	}

	public Instructions(){

	}

	public void playGame() {

		pagination = new Pagination(5, 0);
		pagination.setStyle("-fx-font: 20 courier;" /*  -fx-font-weight: BOLD;*/ + " -fx-base: #0076a3");
		pagination.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer pageIndex) {
				if (pageIndex >= textPages.length) {
					return null;
				}
				else {
					return createPage(pageIndex);
				}
			}
		});

		//Create the two necessary buttons: Play and Quit
		final Button playBtn = new Button("Play");
		final Button quitBtn = new Button("Quit");

		//Create AnchorPane which contains all elements
		AnchorPane anchor = new AnchorPane();

		//Place Pagination Buttons and it's Text Area in AnchorPane
		AnchorPane.setTopAnchor(pagination, 10.0);
		AnchorPane.setRightAnchor(pagination, 10.0);
		AnchorPane.setBottomAnchor(pagination, 60.0);
		AnchorPane.setLeftAnchor(pagination, 10.0);

		//Place Play Button in AnchorPane
		AnchorPane.setBottomAnchor(playBtn, 23.0);
		AnchorPane.setLeftAnchor(playBtn, 85.0);

		//Place Quit Button in AnchorPane
		AnchorPane.setBottomAnchor(quitBtn, 23.0);
		AnchorPane.setRightAnchor(quitBtn, 85.0);

		//Give good looking characteristics to buttons
		playBtn.setTextFill(Color.GOLD);
		playBtn.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");
		playBtn.setPrefWidth(110);

		quitBtn.setTextFill(Color.GOLD);
		quitBtn.setStyle("-fx-font: 20 courier; -fx-font-weight: BOLD; -fx-base: #0076a3");
		quitBtn.setPrefWidth(110);

		//Add Elements to AnchorPane
		anchor.getChildren().addAll(pagination, playBtn, quitBtn);

		//Create stage
		Stage stage = new Stage();
		Scene scene = new Scene(anchor, 550, 356);
		stage.setScene(scene);
		stage.setTitle("Instructions");
		stage.show();
		stage.setResizable(false);

		//***
		//Create background image and characteristics
		BackgroundImage myBI= new BackgroundImage(new Image("RiskMenuImage.jpg",550,356,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		//Set image to the grid
		anchor.setBackground(new Background(myBI));
		//***

		//use lambda expressions to determine what the buttons do
		//each button shall call its respective method
		playBtn.setOnAction(e -> {
			Game_Selection gameSelection = new Game_Selection();
			gameSelection.play();
			stage.close();
		});
		quitBtn.setOnAction(e -> System.exit(0));
	}
}