package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.View_countdto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.View_count;
import Odiljon_Olimovich.service.View_CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewcount")
public class View_CountController {

    @Autowired
    View_CountService viewCountService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> viewCount() {
        List<View_count> view_counts = viewCountService.findAll();
        return new ResponseEntity<>(view_counts, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> viewCount(@PathVariable Integer id) {
        View_count view_count = viewCountService.findById(id);
        return new ResponseEntity<>(view_count, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> addViewCount(@RequestBody View_countdto view_countdto) {
        Result result = viewCountService.save(view_countdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> updateViewCount(@PathVariable Integer id, @RequestBody View_countdto dto) {
        Result result = viewCountService.update(id, dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteViewCount(@PathVariable Integer id) {
        Result result = viewCountService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}