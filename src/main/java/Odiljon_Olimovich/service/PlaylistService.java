package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Playlistdto;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Playlist;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.entity.Status;
import Odiljon_Olimovich.repository.ChannelRepo;
import Odiljon_Olimovich.repository.PlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepo playlistRepo;

    @Autowired
    ChannelRepo channelRepo;

    // get all
    public List<Playlist> getPlaylists() {
        return playlistRepo.findAll();
    }

    // get by id
    public Playlist getPlaylistbyid(@PathVariable Integer id) {
        return playlistRepo.findById(id).get();
    }

    // create
    public Result createPlaylist(@RequestBody Playlistdto playlistdto) {
        boolean existsbyid = playlistRepo.existsById(playlistdto.getChannels());
        if (existsbyid) {
            return new Result(false, "Playlist already exists");
        }
        Playlist playlist = new Playlist();
        playlist.setName(playlistdto.getName());
        playlist.setDescription(playlistdto.getDescription());
        playlist.setStatus(Status.ACTIVE);
        playlist.setOrder_num(playlistdto.getOrder_num());

        Optional<Channel> channelOptional = channelRepo.findById(playlistdto.getChannels());
        Channel channel = channelOptional.get();
        playlist.setChannels((List<Channel>) channel);

        playlistRepo.save(playlist);
        return new Result(true, "Playlist created");
    }

    // update
    public Result updatePlaylist(@PathVariable Integer id, @RequestBody Playlistdto playlistdto) {
        boolean existsbyid = playlistRepo.existsById(playlistdto.getChannels());
        if (existsbyid) {
            Playlist playlist = playlistRepo.findById(id).get();
            playlist.setName(playlistdto.getName());
            playlist.setDescription(playlistdto.getDescription());
            playlist.setStatus(Status.ACTIVE);
            playlist.setOrder_num(playlistdto.getOrder_num());

            Optional<Channel> channelOptional = channelRepo.findById(playlistdto.getChannels());
            Channel channel = channelOptional.get();
            playlist.setChannels((List<Channel>) channel);
            playlistRepo.save(playlist);
            return new Result(true, "Playlist updated");
        }
        return new Result(false, "Playlist does not exist");
    }

    // delete
    public Result deletePlaylist(@PathVariable Integer id) {
        playlistRepo.deleteById(id);
        return new Result(true, "Playlist deleted");
    }
}
