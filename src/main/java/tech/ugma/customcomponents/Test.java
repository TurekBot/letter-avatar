package tech.ugma.customcomponents;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane flowPane = new FlowPane(5, 5);
        for (Character c = 'A'; Character.isLetter(c); c++ ) {
            LetterAvatar letterAvatar = new LetterAvatar(String.valueOf(c));
            letterAvatar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    LetterAvatar la = (LetterAvatar) event.getSource();
                    int intValue = Integer.valueOf(la.getColorNumber());
                    if (intValue < 900) {
                        intValue += 100;
                    } else {
                        intValue = 100;
                    }
                    la.setColorNumber(String.valueOf(intValue));
                }
            });
            flowPane.getChildren().add(letterAvatar);
        }

        primaryStage.setScene(new Scene(flowPane));
        primaryStage.show();
    }
}
