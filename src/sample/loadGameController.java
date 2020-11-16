package sample;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*; //rem
import javafx.scene.control.*; //rem
import javafx.geometry.*; //rem

public class loadGameController {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Back to home...");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
