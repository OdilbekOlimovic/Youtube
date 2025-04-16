package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Video_watcheddto;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.model.Video_watched;
import Odiljon_Olimovich.repository.ProfileRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import Odiljon_Olimovich.repository.Video_watchedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Video_watchedService {

    @Autowired
    Video_watchedRepo video_watchedRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    VideoRepo videoRepo;

    // get all
    public List<Video_watched> getVideos() {
        return video_watchedRepo.findAll();
    }

    // get by id
    public Video_watched getVideoById(Integer id) {
        return video_watchedRepo.findById(id).get();
    }

    // create
    public Result save(Video_watcheddto video_watcheddto) {
        boolean existsbyid = video_watchedRepo.existsById(video_watcheddto.getProfiles());
        if(existsbyid){
            return new Result(false, "not found");
        }

        Video_watched video_watched = new Video_watched();
        video_watched.setCreated_Date(video_watcheddto.getCreated_Date());

        Optional<Profile> profile = profileRepo.findById(video_watcheddto.getProfiles());
        Profile profile1 = profile.get();
        video_watched.setProfiles((List<Profile>) profile1);

        Optional<Video> videoOptional = videoRepo.findById(video_watcheddto.getVideos());
        Video video = videoOptional.get();
        video_watched.setVideos((List<Video>) video);
        video_watchedRepo.save(video_watched);
        return new Result(true, "saved");
    }

    // update
    public Result update(Integer id, Video_watcheddto video_watcheddto) {
        boolean existsbyid = video_watchedRepo.existsById(id);
        if(existsbyid){
            Optional<Video_watched> video_watched = video_watchedRepo.findById(id);
            if(video_watched.isPresent()){
                Video_watched video_watched1 = video_watched.get();
                video_watched1.setCreated_Date(video_watcheddto.getCreated_Date());

                Optional<Profile> profile = profileRepo.findById(video_watcheddto.getProfiles());
                Profile profile1 = profile.get();
                video_watched1.setProfiles((List<Profile>) profile1);

                Optional<Video> videoOptional = videoRepo.findById(video_watcheddto.getVideos());
                Video video = videoOptional.get();
                video_watched1.setVideos((List<Video>) video);
                video_watchedRepo.save(video_watched1);
                return new Result(true, "updated");
            }
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        video_watchedRepo.deleteById(id);
        return new Result(true, "deleted");
    }
}
