import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

 
public class CloseApp extends Application {

	Stage window;
	Button button;
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Close Application Demo");
		
		window.setOnCloseRequest(e -> { //CALLED WHEN USER PUSHES X
			e.consume(); //consume close request
			closeProgram();
		});
		
		button = new Button("Close Program");
		button.setOnAction(e -> {
			closeProgram();
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Attention:", "Are you sure you want to close?");
		if (answer == true) {
			window.close();
		}
	}
	
}