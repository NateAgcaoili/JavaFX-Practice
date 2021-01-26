import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ComboBoxDemo extends Application {

	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ComboBox Demo");
		button = new Button("Submit");
		
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(
				"Shrek 1",
				"Shrek 2",
				"Shrek 3"
		);
		
		comboBox.setPromptText("What is your favorite movie?");
		
		comboBox.setEditable(true); //allows user to edit and input their own values
		button.setOnAction(e -> printMovie());
		comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue())); //don't need to create listener
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox, button);
		
		scene = new Scene(layout, 250, 250);
		window.setScene(scene);
		window.show();
	}

	private void printMovie() {
		System.out.println(comboBox.getValue());
	}

	

	
}