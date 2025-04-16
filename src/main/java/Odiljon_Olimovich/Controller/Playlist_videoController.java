package Odiljon_Olimovich.Controller;

import Odiljon_Olimovich.dto.Playlist_videodto;
import Odiljon_Olimovich.model.Playlist_video;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.Playlist_videoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlistvideo")
public class Playlist_videoController {

    @Autowired
    Playlist_videoService playlist_videoService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> listPlaylistVideo() {
        List<Playlist_video> playlistVideos = playlist_videoService.getAllPlaylistVideos();
        return new ResponseEntity<>(playlistVideos, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getPlaylistVideo(@PathVariable Integer id) {
        Playlist_video playlist_video = playlist_videoService.getPlaylistVideo(id);
        return new ResponseEntity<>(playlist_video, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> createPlaylistVideo(@RequestBody Playlist_videodto playlist_videodto) {
        Result result = playlist_videoService.createPlaylistVideo(playlist_videodto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> updatePlaylistvideo(@PathVariable Integer id, @RequestBody Playlist_videodto playlist_videodto) {
        Result result = playlist_videoService.updatePlaylistVideo(id, playlist_videodto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePlaylistVideo(@PathVariable Integer id) {
        Result result = playlist_videoService.deletePlaylistVideo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
