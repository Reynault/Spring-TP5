package com.tp.album_manager.model;

import javax.persistence.*;

@Entity
@Table(name = "ALBUM")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String editor;
    private float price;
    private int nbEx;
    private String author;

    public Album( String title, String editor, String author, float price, int nbEx) {
        this.title = title;
        this.editor = editor;
        this.author = author;
        this.price = price;
        this.nbEx = nbEx;
    }

    protected Album() { }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNbEx() {
        return nbEx;
    }

    public void setNbEx(int nbEx) {
        this.nbEx = nbEx;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", editor='" + editor + '\'' +
                ", price=" + price +
                ", nbEx=" + nbEx +
                ", author='" + author + '\'' +
                '}';
    }
}
