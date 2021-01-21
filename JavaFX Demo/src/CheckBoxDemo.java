import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class CheckBoxDemo extends Application {

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
		
		//Checkboxes
		CheckBox box1 = new CheckBox("Bacon"); //bacon is text besides checkbox
		CheckBox box2 = new CheckBox("Tuna");
		box2.setSelected(true); //sets box2 to be checked by default
		
		//Button
		button = new Button("Order Now!");
		button.setOnAction(e -> handleOptions(box1, box2));
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(box1, box2, button);
		
		scene = new Scene(layout, 250, 250);
		window.setScene(scene);
		window.show();
	}

	private void handleOptions(CheckBox box1, CheckBox box2) { //checking what the user checked 
		String message = "User order:\n";
		
		if (box1.isSelected()) {
			message += "Bacon\n";
		}
		
		if (box2.isSelected()) {
			message += "Tuna\n";
		}
		
		System.out.println(message);
	}	
}