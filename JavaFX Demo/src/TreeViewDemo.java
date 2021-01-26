import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;


public class TreeViewDemo extends Application {

	Stage window;
	TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TreeView Demo");
		
		TreeItem<String> root, nate, anthony;
		
		//Root, container for all branches
		root = new TreeItem<>();
		root.setExpanded(true); //tree is expanded by default
		
		//Nate
		nate = makeBranch("Nate", root); //branch name followed by parent node
		makeBranch("Nate's first child", nate);
		makeBranch("Nate's second child", nate);
		makeBranch("Nate's third child", nate);
		
		//Anthony
		anthony = makeBranch("Nate", root); //branch name followed by parent node
		makeBranch("Anthony's first child", anthony);
		makeBranch("Anthony's second child", anthony);
		
		//Create tree
		tree = new TreeView<>(root);
		tree.setShowRoot(false); //root is just container, so you don't need to show it
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if(newValue != null) {
				System.out.println(newValue.getValue());
			}
		});
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	
	public TreeItem<String> makeBranch(String nodeName, TreeItem<String> parent) {
	    TreeItem<String> item = new TreeItem<>(nodeName);
	    item.setExpanded(true);

	    parent.getChildren().add(item);
	    return item;
	}
	

	
}