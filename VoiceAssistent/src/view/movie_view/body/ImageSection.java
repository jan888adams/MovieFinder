package view.movie_view.body;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 02.12.2020
 */

public class ImageSection extends GridPane {
    private final Image poster;

    public ImageSection(String url) {
        this.poster = new Image(url);
        setUp();
    }

    private void setUp() {

        this.setPadding(new Insets(10, 50, 50, 0));
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        ImageView img = new ImageView();
        img.setImage(poster);
        this.add(img,0,4);
    }
}
