package tech.ugma.customcomponents;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        final FlowPane alphabet = new FlowPane(5, 5);

        Button darkenButton = new Button("Darken");
        root.setTop(darkenButton);
        darkenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                for (Node child : alphabet.getChildren()) {
                    if (child instanceof LetterAvatar) {
                        LetterAvatar la = (LetterAvatar) child;
                        int intValue = Integer.valueOf(la.getColorNumber());
                        if (intValue < 900) {
                            intValue += 100;
                        } else {
                            intValue = 100;
                        }
                        la.setColorNumber(String.valueOf(intValue));
                        primaryStage.setTitle(String.valueOf(intValue));
                    }
                }
            }
        });


        /* Show the alphabet. */
        /* Note that the color is not unique to the letter, but to the hash code source, like a name.
        *  This means that Johnny, and John will both be Js, but they'll have entirely different colors.*/
        for (Character c = 'A'; Character.isLetter(c); c++ ) {
            LetterAvatar letterAvatar = new LetterAvatar(String.valueOf(c));
            alphabet.getChildren().add(letterAvatar);
        }

        root.setCenter(alphabet);

        // The argument will determine the background color; this will always be the same color for the same input.
        // This assumes you want the avatar's letter to be the first letter of the user's name.
        LetterAvatar la1 = new LetterAvatar("John Sample");

        // If you want to be explicit about which letter to use, use this constructor.
        LetterAvatar la2 = new LetterAvatar("J", "some unique-to-the-user value");

        root.setBottom(new HBox(la1, la2));



        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
