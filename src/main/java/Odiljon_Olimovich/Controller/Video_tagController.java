package Odiljon_Olimovich.Controller;

import Odiljon_Olimovich.dto.Video_tagdto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video_tag;
import Odiljon_Olimovich.service.Video_tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videotag")
public class Video_tagController {

    @Autowired
    Video_tagService video_tagService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Video_tag> video_tags = video_tagService.getTags();
        return new ResponseEntity<>(video_tags, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Video_tag videoTag = video_tagService.getvideo_Tag(id);
        return new ResponseEntity<>(videoTag, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Video_tagdto videoTagdto) {
        Result result = video_tagService.createVideo_tag(videoTagdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Video_tagdto videoTagdto) {
        Result result = video_tagService.updateVideo_tag(id, videoTagdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = video_tagService.deleteVideo_tag(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
