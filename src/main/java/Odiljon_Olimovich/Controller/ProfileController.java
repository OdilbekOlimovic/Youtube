package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Profiledto;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> getProfile() {
        List<Profile> profiles = profileService.findAll();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> getProfileById(@PathVariable Integer id) {
        Profile profile = profileService.findById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> createProfile(@RequestBody Profiledto profiledto) {
        Result result = profileService.save(profiledto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> updateProfile(@PathVariable Integer id, @RequestBody Profiledto profiledto) {
        Result result = profileService.update(profiledto, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProfile(@PathVariable Integer id) {
        Result result = profileService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
