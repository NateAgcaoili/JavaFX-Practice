import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableViewDemo extends Application {

	Stage window;
	TableView<Product> table;
	TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("TableView Demo");
		
		//Name Column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name:");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //use 'name' property of products
		
		//Price Column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price:");
		priceColumn.setMinWidth(200);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //use 'price' property of products
		
		//Quantity Column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity:");
		quantityColumn.setMinWidth(200);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity")); //use 'quantity' property of products
		
		//Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);
		
		//Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		
		//Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");
		
		//Button
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		//Layout
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		Scene scene = new Scene(vBox, 300, 250);
		window.setScene(scene);
		window.show();
	}

	private void addButtonClicked() {
		//Creating new Product
		Product product = new Product();
		//Setting product attribute values
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		//Adding item to table
		table.getItems().add(product);
		//Clearing inputs
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}
	
	private void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		productSelected.forEach(allProducts::remove); //if selected, remove from allProducts
	}

	//Get all of the products
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Bouncy Ball", 2.49, 198));
		products.add(new Product("Toilet", 99.25, 12));
		products.add(new Product("Bed", 363.28, 4));
		products.add(new Product("Keyboard", 259.99, 150));
		return products;
	}
	
	
}