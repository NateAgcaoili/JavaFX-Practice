import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class ExtractingUserInput extends Application {

	Stage window;
	Scene scene;
	Button button;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Extract and Validate Input Demo");
		
		//Form
		TextField nameInput = new TextField();
		
		button = new Button("Click me");
		button.setOnAction(e -> isInt(nameInput, nameInput.getText())); //extracting info from nameInput
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(nameInput, button);
		
		scene = new Scene(layout, 250, 250);
		window.setScene(scene);
		window.show();
	}
	
	private boolean isInt(TextField input, String message) { //makes sure user inputs an integer
		try {
			int age = Integer.parseInt(input.getText());
			System.out.println("Success, age: " + age);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Error: " + message + " is not an int");
			return false;
		}
	}
	
}