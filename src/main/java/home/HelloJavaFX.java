package home;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Initializing app...");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting app...");

        // helloWorld(primaryStage);
        // twoColumns(primaryStage);
        // gridLayout(primaryStage);
        // listViewExample(primaryStage);
        // simpleStringProperty();
        // bindings();
        // labelAndTextFieldBinding(primaryStage);
        // coolSlider(primaryStage);
        // simpleButtnListener(primaryStage);
        // keypressedListener(primaryStage);

        Parent root = FXMLLoader.load(getClass().getResource("/view.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show(); // ridicarea cortinei
    }

    private void keypressedListener(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setOnKeyPressed(event -> System.out.println(event.getCode()));

        VBox vBox = new VBox();
        vBox.getChildren().add(textField);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
    }

    private void simpleButtnListener(Stage primaryStage) {
        Button button = new Button("Click me");
        button.setOnAction(event -> System.out.println("Aouch!"));

        VBox vBox = new VBox();
        vBox.getChildren().add(button);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
    }

    private void coolSlider(Stage primaryStage) {
        Slider slider = new Slider();
        VBox vBox = new VBox();
        vBox.spacingProperty().bind(slider.valueProperty());
        vBox.getChildren().add(slider);
        vBox.getChildren().add(new Label("Hello, folks!"));

        Scene scene = new Scene(vBox, 300, 150);
        primaryStage.setScene(scene);
    }

    private void labelAndTextFieldBinding(Stage primaryStage) {
        TextField textField = new TextField();
        Label label = new Label();
        label.textProperty().bindBidirectional(textField.textProperty());

        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        vBox.getChildren().add(textField);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
    }

    private void bindings() {
        SimpleStringProperty property1 = new SimpleStringProperty("xyz");
        SimpleStringProperty property2 = new SimpleStringProperty();
        // property2.bind(property1);
        property2.bindBidirectional(property1);

        property1.setValue("New value for property1");
        System.out.printf("Property1: %s; Property2: %s %n", property1.getValue(), property2.getValue());

        property2.setValue("New value for property2");
        System.out.printf("Property1: %s; Property2: %s %n", property1.getValue(), property2.getValue());
    }

    private void simpleStringProperty() {
        SimpleStringProperty stringProperty = new SimpleStringProperty("xyz");
        System.out.println("Initial value: " + stringProperty.getValue());

        stringProperty.addListener((observable, oldValue, newValue) -> System.out.printf("Old value: %s; New value: %s %n", oldValue, newValue));
        stringProperty.setValue("Some new value");
    }

    private void listViewExample(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().add("Element 1");
        listView.getItems().add("Element 2");
        listView.getItems().add("Element 3");

        Scene scene = new Scene(listView);
        primaryStage.setScene(scene);
    }

    private void gridLayout(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Element 1, 1"), 0, 0);
        gridPane.add(new TextField("Element 1, 2"), 1, 0);
        gridPane.add(new TextField("Element 2, 1"), 0, 1);
        gridPane.add(new Label("Element 2, 2"), 1, 1);

        gridPane.add(new CheckBox("Click me!"), 0, 2);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
    }

    private void twoColumns(Stage primaryStage) {
        VBox column1 = new VBox();
        column1.getChildren().add(new Label("Element 1, 1"));
        column1.getChildren().add(new TextField("Element 1, 2"));
        column1.setSpacing(5);

        VBox column2 = new VBox();
        column2.getChildren().add(new TextField("Element 2, 1"));
        column2.getChildren().add(new Label("Element 2, 2"));
        column2.setSpacing(5);

        HBox root = new HBox();
        root.getChildren().add(column1);
        root.getChildren().add(column2);
        root.setSpacing(10);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    private void helloWorld(Stage primaryStage) {
        VBox vBox = new VBox();
        Label label = new Label("Hello JavaFX!");
        vBox.getChildren().add(label);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping app...");
    }

    public static void main(String[] args) {
        launch();
    }
}
