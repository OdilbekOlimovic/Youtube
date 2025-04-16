package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Email_historydto;
import Odiljon_Olimovich.model.Email_History;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.Email_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailhistory")
public class Email_historyController {

    @Autowired
    Email_historyService email_historyService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Email_History> emailHistories = email_historyService.findall();
        return new ResponseEntity<>(emailHistories, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Email_History emailHistory = email_historyService.findById(id);
        return new ResponseEntity<>(emailHistory, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Email_historydto email_historydto) {
        Result result = email_historyService.save(email_historydto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Email_historydto email_historydto) {
        Result result = email_historyService.update(id, email_historydto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = email_historyService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
