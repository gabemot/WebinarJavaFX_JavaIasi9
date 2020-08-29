package home;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    public void clickOnTheButton(MouseEvent mouseEvent) {
        System.out.println("Ai dat click pe buton");
    }

    public void mouseHovering(MouseEvent mouseEvent) {
        System.out.println("Ce cauti deasupra mea?");
    }

    public void mouseBlur(MouseEvent mouseEvent) {
        System.out.println("Drum bun, bine c-ai plecat!");
    }

    public void actiunePeCheckbox(ActionEvent actionEvent) {
        System.out.println("Checbox clicked");
    }
}
