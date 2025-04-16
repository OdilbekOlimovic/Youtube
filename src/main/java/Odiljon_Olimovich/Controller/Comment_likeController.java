package Odiljon_Olimovich.Controller;

import Odiljon_Olimovich.dto.Comment_likedto;
import Odiljon_Olimovich.model.Comment_like;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.Comment_likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentlike")
public class Comment_likeController {

    @Autowired
    Comment_likeService commentLikeService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> list() {
        List<Comment_like> commentLikes = commentLikeService.findAllByComment();
        return new ResponseEntity<>(commentLikes, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Comment_like commentLike = commentLikeService.findById(id);
        return new ResponseEntity<>(commentLike, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Comment_likedto comment_likedto) {
        Result result = commentLikeService.create(comment_likedto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = commentLikeService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}