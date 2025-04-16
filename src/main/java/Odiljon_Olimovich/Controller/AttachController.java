package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Attachdto;
import Odiljon_Olimovich.model.Attach;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attach")
public class AttachController {

    @Autowired
    AttachService attachService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> getAttach() {
        List<Attach> attachList = attachService.findAll();
        return new ResponseEntity<>(attachList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getAttachById(@PathVariable UUID id) {
        Attach attach = attachService.findById(id);
        return new ResponseEntity<>(attach, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> createAttach(@RequestBody Attachdto attachdto) {
        Result result = attachService.save(attachdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> updateAttach(@PathVariable UUID id, @RequestBody Attachdto attachdto) {
        Result result = attachService.update(id, attachdto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAttach(@PathVariable UUID id) {
        Result result = attachService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
