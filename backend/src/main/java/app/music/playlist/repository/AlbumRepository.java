package app.music.playlist.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import app.music.playlist.model.Album;

public interface AlbumRepository extends JpaRepository<Album, UUID> {

    Optional<Album> findAlbumByTitle(String title);

    @OrderBy("title")
    List<Album> findAlbumsByOrderByTitleAsc();

    List<Album> findAlbumsByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(String query1, String query2);
}
