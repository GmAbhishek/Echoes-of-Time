package app.music.playlist.controller;

import app.music.playlist.APIController;
import app.music.playlist.model.Album;
import app.music.playlist.service.AlbumService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/album/")
@CrossOrigin("*")
public class AlbumController implements APIController<Album, UUID> {

    private final AlbumService service;

    public AlbumController(AlbumService service) {
        this.service = service;
    }

    @GetMapping("all")
    @Override
    public List<Album> getAll() {
        return service.all();
    }

    @GetMapping("search/{query}")
    public List<Album> searchAlbums(@PathVariable String query) {
        return service.searchByAlbumOrSinger(query);
    }

    @PostMapping("add")
    @Override
    public String add(@RequestBody Album album) {
        service.addAlbum(album);
        return "Album successfully added!";
    }

    @PutMapping("update/{id}")
    @Override
    public String update(@PathVariable UUID id,
                       @RequestBody Album album) {

        service.updateAlbum(id, album.getTitle(), album.getArtist(), album.getReleaseDate(), album.getUrlCoverPhoto());
        return "Album successfully updated!";
    }

    @PostMapping("delete/{id}")
    @Override
    public String delete(@PathVariable UUID id) {
        service.deleteAlbum(id);
        return "Album successfully deleted!";
    }
}
