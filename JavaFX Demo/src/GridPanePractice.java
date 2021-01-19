import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class GridPanePractice extends Application {

	Stage window;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("GridPane Demo");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10 ,10, 10)); //adds 10px of padding around layouts and window
		grid.setVgap(8); //vertical spacing is 8px
		grid.setHgap(10); //horizontal spacing is 10px
		
		//Name label
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0); //what item you want to add, what column, what row (top left)
		
		//Name input
		TextField nameInput = new TextField("Nate"); //default text is "Nate" (optional)
		GridPane.setConstraints(nameInput, 1, 0); //appears to the right of label
		
		//Password label
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);
		
		//Password input
		TextField passInput = new TextField();
		passInput.setPromptText("password"); //prompt text, different from default
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		
		Scene scene = new Scene(grid, 250, 250);
		window.setScene(scene);
		window.show();
	}
	
	
	
}