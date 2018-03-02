package tech.ugma.customcomponents;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
/**
 * A Material Design-like Avatar that displays the first letter of a user's name.
 */
public class LetterAvatar extends Label {

    private static final String DEFAULT_STYLE_CLASS = "letter-avatar";

    /**
     * The color number that corresponds with the darkness? of color in google's
     * material design <a href="https://material.io/guidelines/style/color.html#color-color-palette">color swatches</a>
     * <p/>
     * Valid choices include:
     * <ul>
     * <li>50</li>
     * <li>100</li>
     * <li>200</li>
     * <li>300</li>
     * <li>400</li>
     * <li>500</li>
     * <li>600</li>
     * <li>700</li>
     * <li>800</li>
     * <li>900</li>
     * <li>A100</li>
     * <li>A200</li>
     * <li>A400</li>
     * <li>A700</li>
     * </ul>
     * </p>
     * *A100, A200, A400, and A700 are not available for brown, grey and blue-grey.
     */
    private StringProperty colorNumber = new SimpleStringProperty("300");

    private StringProperty hashCodeSource = new SimpleStringProperty("some unique value");

    private StringProperty avatarCharacter = new SimpleStringProperty("A");


    /**
     * The different hues in Google's material design <a href="https://material.io/guidelines/style/color.html#color-color-palette">color palette</a>
     * <p/>
     * These colors are looked up in the colors.css stylesheet.
     * <p/>
     * You can remove brown, grey and blue-grey if you want to use A100, A200, A400, or A700
     */
    private static List<String> hues = new ArrayList<>(Arrays.asList("-red-",
            "-pink-",
            "-purple-",
            "-deep-purple-",
            "-indigo-",
            "-blue-",
            "-light-blue-",
            "-cyan-",
            "-teal-",
            "-green-",
            "-light-green-",
            "-lime-",
            "-yellow-",
            "-amber-",
            "-orange-",
            "-deep-orange-",
            "-brown-",
            "-grey-",
            "-blue-grey-"));


    /**
     * I think SceneBuilder requires that custom components have a no-arg constructor.
     */
    public LetterAvatar() {
        this("A", "some unique value");
    }

    /**
     * If you pass in just a hash code source, we'll automatically use its first letter as the avatar character.
     *
     * @param hashCodeSource a unique string for this avatar; determines the avatar color
     */
    public LetterAvatar(String hashCodeSource) {
        this(hashCodeSource.substring(0, 1), hashCodeSource);
    }

    /**
     * @param avatarCharacter the character to display
     * @param hashCodeSource  a unique string for this avatar; determines the avatar color
     */
    public LetterAvatar(String avatarCharacter, String hashCodeSource) {
        super();
        setHashCodeSource(hashCodeSource);
        setAvatarCharacter(avatarCharacter);

        initialize();

        styleAvatar(getHashCodeSource());
    }

    protected void styleAvatar(String hashCodeSource) {
        String color = calculateColor(hashCodeSource);
        this.setStyle("-avatar-background-color: " + color + colorNumber.get() + ";"); //-avatar-background-color: -deep-orange-400;
    }

    private void initialize() {
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);

        this.getStylesheets().add(getClass().getResource("letter-avatar.css").toExternalForm());
        this.getStylesheets().add(getClass().getResource("colors.css").toExternalForm());

        this.setFont(Font.font(45));

        textProperty().bind(avatarCharacterProperty());

        addListeners();
    }


    private void addListeners() {
        this.hashCodeSourceProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    styleAvatar(getHashCodeSource());
                }
            }
        });

        this.colorNumberProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    styleAvatar(getHashCodeSource());
                }
            }
        });
    }

    public String calculateColor(String hashCodeSource) {
        int index = Math.abs(hashCodeSource.hashCode() % (hues.size() - 1));
        return hues.get(index);
    }

    public String getAvatarCharacter() {
        return avatarCharacter.get();
    }

    public StringProperty avatarCharacterProperty() {
        return avatarCharacter;
    }

    public void setAvatarCharacter(String avatarCharacter) {
        this.avatarCharacter.set(avatarCharacter);
    }

    public String getColorNumber() {
        return colorNumber.get();
    }

    /**
     * The color number that corresponds with the darkness? of color in google's
     * material design <a href="https://material.io/guidelines/style/color.html#color-color-palette">color swatches</a>
     * <p/>
     * Valid choices include:
     * <ul>
     * <li>50</li>
     * <li>100</li>
     * <li>200</li>
     * <li>300</li>
     * <li>400</li>
     * <li>500</li>
     * <li>600</li>
     * <li>700</li>
     * <li>800</li>
     * <li>900</li>
     * <li>A100</li>
     * <li>A200</li>
     * <li>A400</li>
     * <li>A700</li>
     * </ul>
     * </p>
     * *A100, A200, A400, and A700 are not available for brown, grey and blue-grey.
     */
    public StringProperty colorNumberProperty() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber.set(colorNumber);
    }

    /**
     *
     * @return a unique string for this avatar; determines the avatar color
     */
    public String getHashCodeSource() {
        return hashCodeSource.get();
    }

    /**
     *
     * @return a unique string for this avatar; determines the avatar color
     */
    public StringProperty hashCodeSourceProperty() {
        return hashCodeSource;
    }

    /**
     *
     * @param hashCodeSource a unique string for this avatar; determines the avatar color
     */
    public void setHashCodeSource(String hashCodeSource) {
        this.hashCodeSource.set(hashCodeSource);
    }

    /**
     * The different hues in Google's material design <a href="https://material.io/guidelines/style/color.html#color-color-palette">color palette</a>
     * <p/>
     * These colors are looked up in the colors.css stylesheet.
     * <p/>
     * You can remove brown, grey and blue-grey if you want to use A100, A200, A400, or A700
     *
     * @return the list of hues
     */
    public static List<String> getHues() {
        return hues;
    }

    /**
     * The different hues in Google's material design <a href="https://material.io/guidelines/style/color.html#color-color-palette">color palette</a>
     * <p/>
     * These colors are looked up in the colors.css stylesheet.
     * <p/>
     * You can remove brown, grey and blue-grey if you want to use A100, A200, A400, or A700
     */
    public static void setHues(List<String> hues) {
        LetterAvatar.hues = hues;
    }

}
