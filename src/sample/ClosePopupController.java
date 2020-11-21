package sample;

import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;

public class ClosePopupController {

		static Stage window;
		static Scene scene;

		public Button yesButton, noButton;
		public Label confirmMsg;

		static Boolean ans= false;

		@FXML
		void yesClicked()
		{
			ans=true;
			window.close();
		}

		@FXML
		void noClicked()
		{
			ans=false;
			window.close();
		}

		public static Boolean display() {
			window = new Stage();

			//Block events to other windows
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Exit program");
			window.setMinWidth(250);
			window.setMinHeight(100);

			//Display window and wait for it to be closed before returning
			scene = Main.closePopupScene;
			window.setScene(scene);
			window.showAndWait();

			return ans;
		}

}
