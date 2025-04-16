package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Subscriptiondto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Subscription;
import Odiljon_Olimovich.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Subscription> subscriptions = subscriptionService.findAll();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer id) {
        Subscription subscription = subscriptionService.findById(id);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Subscriptiondto subscriptiondto) {
        Result result = subscriptionService.create(subscriptiondto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Subscriptiondto subscriptiondto) {
        Result result = subscriptionService.update(id, subscriptiondto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = subscriptionService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
