package app.music.playlist.model;


import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "Song")
@Table(name = "song")
public class Song {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "title", nullable = false)
    private String title;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(
            name = "album_id"
    )
    private Album album;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "song_genres",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    public Song() {
    }

    public Song(String title) {
        this.title = title;
    }

    public Song(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
