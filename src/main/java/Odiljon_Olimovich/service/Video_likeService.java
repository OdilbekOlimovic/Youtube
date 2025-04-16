package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Video_likedto;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.model.Video_like;
import Odiljon_Olimovich.repository.ProfileRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import Odiljon_Olimovich.repository.Video_likeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Video_likeService {

    @Autowired
    Video_likeRepo video_likeRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    VideoRepo videoRepo;

    // get all
    public List<Video_like> findByVideo_all() {
        return video_likeRepo.findAll();
    }

    // get by id
    public Video_like findById(Integer id) {
        return video_likeRepo.findById(id).get();
    }

    // create
    public Result save(Video_likedto video_likedto) {
        boolean existsbyid = video_likeRepo.existsById(video_likedto.getProfiles());
        if (existsbyid) {
            return new Result(false, "Video liked already exists");
        }
        Video_like video_like = new Video_like();
        video_like.setCreated_date(video_likedto.getCreated_date());
        video_like.setType(video_likedto.getType());

        Optional<Profile> profile = profileRepo.findById(video_likedto.getProfiles());
        Profile profile1 = profile.get();
        video_like.setProfiles((List<Profile>) profile1);

        Optional<Video> videoOptional = videoRepo.findById(video_likedto.getVideos());
        Video video = videoOptional.get();
        video_like.setVideos((List<Video>) video);
        video_likeRepo.save(video_like);
        return new Result(true, "Video liked added");
    }

    // update
    public Result update(Integer id, Video_likedto video_likedto) {
        boolean existsbyid = video_likeRepo.existsById(id);
        if (existsbyid) {
            Optional<Video_like> video_like = video_likeRepo.findById(id);
            if (video_like.isPresent()) {
                Video_like video_like1 = video_like.get();
                video_like1.setCreated_date(video_likedto.getCreated_date());
                video_like1.setType(video_likedto.getType());

                Optional<Profile> profile = profileRepo.findById(video_likedto.getProfiles());
                Profile profile1 = profile.get();
                video_like1.setProfiles((List<Profile>) profile1);

                Optional<Video> videoOptional = videoRepo.findById(id);
                Video video = videoOptional.get();
                video_like1.setVideos((List<Video>) video);
                video_likeRepo.save(video_like1);
                return new Result(true, "Video liked updated");
            }
        }
        return new Result(false, "Video liked not found");
    }

    // delete
    public Result delete(Integer id) {
        video_likeRepo.deleteById(id);
        return new Result(true, "Video liked deleted");
    }
}
