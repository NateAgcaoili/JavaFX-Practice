import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class ConfirmBoxDemo extends Application {

	Stage window;
	Button button;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Confirm Box Demo");
		
		button = new Button("Click!");
		button.setOnAction(e -> {
			boolean result = ConfirmBox.display("Confirm Box", "Are you sure you want to proceed?");
			System.out.println(result);
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	} 
	
}