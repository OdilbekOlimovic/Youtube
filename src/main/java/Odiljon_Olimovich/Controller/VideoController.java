package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Videodto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Video> videos = videoService.findAll();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Video video = videoService.findById(id);
        return new ResponseEntity<>(video, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Videodto videodto) {
        Result result = videoService.save(videodto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Videodto videodto) {
        Result result = videoService.update(id, videodto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = videoService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
