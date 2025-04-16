package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Video_likedto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video_like;
import Odiljon_Olimovich.service.Video_likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videolike")
public class Video_likeController {

    @Autowired
    Video_likeService video_likeService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Video_like> videoLikes = video_likeService.findByVideo_all();
        return new ResponseEntity<>(videoLikes, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Video_like videoLike = video_likeService.findById(id);
        return new ResponseEntity<>(videoLike, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Video_likedto video_likedto) {
        Result result = video_likeService.save(video_likedto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Video_likedto video_likedto) {
        Result result = video_likeService.update(id, video_likedto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = video_likeService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
