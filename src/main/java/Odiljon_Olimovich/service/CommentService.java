package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Commentdto;
import Odiljon_Olimovich.model.Comment;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Video;
import Odiljon_Olimovich.repository.CommentRepo;
import Odiljon_Olimovich.repository.ProfileRepo;
import Odiljon_Olimovich.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    VideoRepo videoRepo;

    // get all
    public List<Comment> getComments() {
        return commentRepo.findAll();
    }

    // get by id
    public Comment getComment(Integer id) {
        return commentRepo.findById(id).get();
    }

    // create
    public Result addComment(Commentdto commentdto) {
        boolean existsbyid = commentRepo.existsById(commentdto.getProfiles());
        if (existsbyid) {
            return new Result(false, "Comment already exists");
        }
        Comment comment = new Comment();
        comment.setContent(commentdto.getContent());
        comment.setReply_id(commentdto.getReply_id());
        comment.setLike_count(commentdto.getLike_count());
        comment.setDislike_count(commentdto.getDislike_count());

        Optional<Profile> profile = profileRepo.findById(commentdto.getProfiles());
        Profile profile1 = profile.get();
        comment.setProfiles((List<Profile>) profile1);

        Optional<Video> video = videoRepo.findById(commentdto.getVideos());
        Video video1 = video.get();
        comment.setVideos((List<Video>) video1);
        commentRepo.save(comment);
        return new Result(true, "Comment added");
    }

    // update
    public Result updateComment(Integer id, Commentdto commentdto) {
        boolean existsbyid = commentRepo.existsById(commentdto.getProfiles());
        if (existsbyid) {
            Optional<Comment> comment = commentRepo.findById(id);
            if (comment.isPresent()) {
                Comment comment1 = comment.get();
                comment1.setContent(commentdto.getContent());
                comment1.setReply_id(commentdto.getReply_id());
                comment1.setLike_count(commentdto.getLike_count());
                comment1.setDislike_count(commentdto.getDislike_count());

                Optional<Profile> profile = profileRepo.findById(commentdto.getProfiles());
                Profile profile1 = profile.get();
                comment1.setProfiles((List<Profile>) profile1);

                Optional<Video> video = videoRepo.findById(commentdto.getVideos());
                Video video1 = video.get();
                comment1.setVideos((List<Video>) video1);
                commentRepo.save(comment1);
                return new Result(true, "Comment updated");
            }
        }
        return new Result(false, "Comment not found");
    }

    // delete
    public Result deleteComment(Integer id) {
        commentRepo.deleteById(id);
        return new Result(true, "Comment deleted");
    }
}
