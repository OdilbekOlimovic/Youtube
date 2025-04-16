package Odiljon_Olimovich.Controller;

import Odiljon_Olimovich.dto.Playlistdto;
import Odiljon_Olimovich.model.Playlist;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> listPlaylists() {
        List<Playlist> playlists = playlistService.getPlaylists();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getPlaylist(@PathVariable Integer id) {
        Playlist playlist = playlistService.getPlaylistbyid(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> createPlaylist(@RequestBody Playlistdto playlistdto) {
        Result result = playlistService.createPlaylist(playlistdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> updatePlaylist(@PathVariable Integer id, @RequestBody Playlistdto playlistdto) {
        Result result = playlistService.updatePlaylist(id, playlistdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePlaylist(@PathVariable Integer id) {
        Result result = playlistService.deletePlaylist(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
