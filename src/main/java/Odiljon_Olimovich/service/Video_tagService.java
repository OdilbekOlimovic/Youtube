package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Video_tagdto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Tag;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.model.Video_tag;
import Odiljon_Olimovich.repository.TagRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import Odiljon_Olimovich.repository.Video_tagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Video_tagService {

    @Autowired
    Video_tagRepo video_tagRepo;

    @Autowired
    VideoRepo videoRepo;

    @Autowired
    TagRepo tagRepo;

    // get all
    public List<Video_tag> getTags() {
        return video_tagRepo.findAll();
    }

    // get by id
    public Video_tag getvideo_Tag(@PathVariable Integer id) {
        return video_tagRepo.findById(id).get();
    }

    // create
    public Result createVideo_tag(Video_tagdto videoTagdto) {
        boolean exists = video_tagRepo.existsById(videoTagdto.getVideos());
        if (exists) {
            return new Result(false, "Video tag already exists");
        }
        Video_tag video_tag = new Video_tag();
        video_tag.setCreated_Date(videoTagdto.getCreated_Date());

        Optional<Video> videoOptional = videoRepo.findById(videoTagdto.getVideos());
        Video video = videoOptional.get();
        video_tag.setVideos((List<Video>) video);

        Optional<Tag> tagOptional = tagRepo.findById(videoTagdto.getTags());
        Tag tag = tagOptional.get();
        video_tag.setTags((List<Tag>) tag);
        video_tagRepo.save(video_tag);
        return new Result(true, "succesfully");
    }

    // update
    public Result updateVideo_tag(Integer id, Video_tagdto videoTagdto) {
        boolean exists = video_tagRepo.existsById(videoTagdto.getVideos());
        if (exists) {
            Optional<Video_tag> video_tag = video_tagRepo.findById(id);
            if (video_tag.isPresent()) {
                Video_tag video_tag1 = video_tag.get();
                video_tag1.setCreated_Date(videoTagdto.getCreated_Date());

                Optional<Video> videoOptional = videoRepo.findById(videoTagdto.getVideos());
                Video video = videoOptional.get();
                video_tag1.setVideos((List<Video>) video);

                Optional<Tag> tagOptional = tagRepo.findById(videoTagdto.getTags());
                Tag tag = tagOptional.get();
                video_tag1.setTags((List<Tag>) tag);
                video_tagRepo.save(video_tag1);
                return new Result(true, "succesfully");
            }
        }
        return new Result(false, "Video tag does not exist");
    }

    // delete
    public Result deleteVideo_tag(@PathVariable Integer id) {
        video_tagRepo.deleteById(id);
        return new Result(true, "succesfully");
    }
}
