package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Video_watcheddto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video_watched;
import Odiljon_Olimovich.service.Video_watchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videowatched")
public class Video_watchedController {

    @Autowired
    Video_watchedService video_watchedService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Video_watched> videoWatcheds = video_watchedService.getVideos();
        return new ResponseEntity<>(videoWatcheds, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Video_watched videoWatched = video_watchedService.getVideoById(id);
        return new ResponseEntity<>(videoWatched, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Video_watcheddto video_watcheddto) {
        Result result = video_watchedService.save(video_watcheddto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Video_watcheddto video_watcheddto) {
        Result result = video_watchedService.update(id, video_watcheddto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = video_watchedService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
