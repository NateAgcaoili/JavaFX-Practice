import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class ChoiceBoxDemo extends Application {

	Stage window;
	Scene scene;
	Button button;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("CheckBox Demo");
		button = new Button("Click me");
		
		//ChoiceBox
		ChoiceBox<String> choiceBox = new ChoiceBox<>(); //don't want to combine int and string dropdown menus, be consistent
		
		//getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Apples"); //need to get items before making any changes
		choiceBox.getItems().add("Bananas");
		choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs"); //addall allows you to add multiple items at once
		
		choiceBox.setValue("Apples"); //sets default value, must be something already inside list
		
		button.setOnAction(e -> getChoice(choiceBox));
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 250, 250);
		window.setScene(scene);
		window.show();
	}

	private void getChoice(ChoiceBox<String> choiceBox) {
		String food = choiceBox.getValue();
		System.out.println(food);
	}

	
}