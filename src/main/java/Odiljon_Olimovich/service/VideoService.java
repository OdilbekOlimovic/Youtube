package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Videodto;
import Odiljon_Olimovich.model.*;
import Odiljon_Olimovich.model.entity.Status;
import Odiljon_Olimovich.repository.AttachRepo;
import Odiljon_Olimovich.repository.CategoryRepo;
import Odiljon_Olimovich.repository.ChannelRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepo videoRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    AttachRepo attachRepo;

    @Autowired
    ChannelRepo channelRepo;

    // get all
    public List<Video> findAll() {
        return videoRepo.findAll();
    }

    // get by id
    public Video findById(Integer id) {
        return videoRepo.findById(id).get();
    }

    // create
    public Result save(Videodto videodto) {
        boolean existsbyid = videoRepo.existsById(videodto.getCategories());
        if (existsbyid) {
            return new Result(false, "not found");
        }
        Video video = new Video();
        video.setPreview_attach_id(videodto.getCategories());
        video.setTitle(videodto.getTitle());
        video.setCreated_date(videodto.getCreated_date());
        video.setPublished_date(videodto.getPublished_date());
        video.setStatus(Status.ACTIVE);
        video.setType(videodto.getType());
        video.setView_count(videodto.getView_count());
        video.setShared_count(videodto.getShared_count());
        video.setDescription(videodto.getDescription());
        video.setLikes_count(videodto.getLikes_count());
        video.setDislikes_count(videodto.getDislikes_count());

        Optional<Category> categoryOptional = categoryRepo.findById(videodto.getCategories());
        Category category = categoryOptional.get();
        video.setCategories((List<Category>) category);

        Optional<Attach> attachOptional = attachRepo.findById(videodto.getAttachs());
        Attach attach = attachOptional.get();
        video.setAttachs((List<Attach>) attach);

        Optional<Channel> channelOptional = channelRepo.findById(videodto.getChannels());
        Channel channel = channelOptional.get();
        video.setChannels((List<Channel>) channel);
        videoRepo.save(video);
        return new Result(true, "saved");
    }

    // update
    public Result update(Integer id, Videodto videodto) {
        boolean existsbyid = videoRepo.existsById(id);
        if (existsbyid) {
            Optional<Video> videoOptional = videoRepo.findById(id);
            if (videoOptional.isPresent()) {
                Video video = videoOptional.get();
                video.setTitle(videodto.getTitle());
                video.setPublished_date(videodto.getPublished_date());
                video.setStatus(videodto.getStatus());
                video.setType(videodto.getType());
                video.setView_count(videodto.getView_count());
                video.setShared_count(videodto.getShared_count());
                video.setDescription(videodto.getDescription());
                video.setLikes_count(videodto.getLikes_count());
                video.setDislikes_count(videodto.getDislikes_count());

                Optional<Category> categoryOptional = categoryRepo.findById(videodto.getCategories());
                Category category = categoryOptional.get();
                video.setCategories((List<Category>) category);

                Optional<Attach> attachOptional = attachRepo.findById(videodto.getAttachs());
                Attach attach = attachOptional.get();
                video.setAttachs((List<Attach>) attach);

                Optional<Channel> channelOptional = channelRepo.findById(videodto.getChannels());
                Channel channel = channelOptional.get();
                video.setChannels((List<Channel>) channel);

                videoRepo.save(video);
                return new Result(true, "updated");
            }
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        videoRepo.deleteById(id);
        return new Result(true, "deleted");
    }
}
