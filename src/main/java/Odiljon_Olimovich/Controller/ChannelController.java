package Odiljon_Olimovich.Controller;


import Odiljon_Olimovich.dto.Channeldto;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channel")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping
    public HttpEntity<?> findAll() {
        List<Channel> channels = channelService.getChannels();
        return new ResponseEntity<>(channels, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<?> findById(@PathVariable Integer uuid) {
        Channel channel = channelService.getChannel(uuid);
        return new ResponseEntity<>(channel, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PostMapping
    public HttpEntity<?> save(@RequestBody Channeldto channeldto) {
        Result result = channelService.addChannel(channeldto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody Channeldto channeldto) {
        Result result = channelService.updateChannel(id, channeldto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Result result = channelService.deleteChannel(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
