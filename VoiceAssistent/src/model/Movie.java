package model;

import codex.modell.ModelInterface;
import codex.utils.annotations.Settable;


import java.io.Serializable;

/**
 * VoiceAssistent
 *
 * @author Jan Adams
 * @version 01.12.2020
 */

public class Movie implements ModelInterface, Serializable {

    private String title;
    private String director;
    private String plot;
    private String poster;

    public String getTitle() {
        return title;
    }

    @Settable(order = 2)
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    @Settable(order = 1)
    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    @Settable(order = 3)
    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    @Settable(order = 4)
    public void setPoster(String poster) {
        this.poster = poster;
    }
}
