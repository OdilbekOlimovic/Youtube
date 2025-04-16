package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Playlist_videodto;
import Odiljon_Olimovich.model.Playlist;
import Odiljon_Olimovich.model.Playlist_video;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.repository.PlaylistRepo;
import Odiljon_Olimovich.repository.Playlist_videoRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Playlist_videoService {

    @Autowired
    Playlist_videoRepo playlist_videoRepo;

    @Autowired
    PlaylistRepo playlistRepo;

    @Autowired
    VideoRepo videoRepo;

    // get all
    public List<Playlist_video> getAllPlaylistVideos() {
        return playlist_videoRepo.findAll();
    }

    // get  by id
    public Playlist_video getPlaylistVideo(Integer id) {
        return playlist_videoRepo.findById(id).get();
    }

    // create
    public Result createPlaylistVideo(Playlist_videodto playlist_videodto) {
        boolean existsbyid = playlist_videoRepo.existsById(playlist_videodto.getPlaylists());
        if (existsbyid) {
            return new Result(false, "Playlist already exists");
        }
        Playlist_video playlist_video = new Playlist_video();
        playlist_video.setCreated_Date(playlist_videodto.getCreated_Date());
        playlist_video.setOrder_num(playlist_videodto.getOrder_num());

        Optional<Playlist> playlistOptional = playlistRepo.findById(playlist_videodto.getPlaylists());
        Playlist playlist = playlistOptional.get();
        playlist_video.setPlaylists((List<Playlist>) playlist);

        Optional<Video> videoOptional = videoRepo.findById(playlist_videodto.getVideos());
        Video video = videoOptional.get();
        playlist_video.setVideos((List<Video>) video);
        playlist_videoRepo.save(playlist_video);
        return new Result(true, "Playlist created successfully");
    }

    // update
    public Result updatePlaylistVideo(Integer id, Playlist_videodto playlist_videodto) {
        boolean existsbyid = playlist_videoRepo.existsById(id);
        if (existsbyid) {
            Optional<Playlist_video> playlist_videoOptional = playlist_videoRepo.findById(id);
            if (playlist_videoOptional.isPresent()) {
                Playlist_video playlist_video = playlist_videoOptional.get();
                playlist_video.setCreated_Date(playlist_videodto.getCreated_Date());
                playlist_video.setOrder_num(playlist_videodto.getOrder_num());

                Optional<Playlist> playlistOptional = playlistRepo.findById(playlist_videodto.getPlaylists());
                Playlist playlist = playlistOptional.get();
                playlist_video.setPlaylists((List<Playlist>) playlist);

                Optional<Video> videoOptional = videoRepo.findById(playlist_videodto.getVideos());
                Video video = videoOptional.get();
                playlist_video.setVideos((List<Video>) video);
                playlist_videoRepo.save(playlist_video);
                return new Result(true, "Playlist updated successfully");
            }
        }
        return new Result(false, "Playlist not found");
    }

    // delete
    public Result deletePlaylistVideo(Integer id) {
        playlist_videoRepo.deleteById(id);
        return new Result(true, "Playlist deleted successfully");
    }
}
