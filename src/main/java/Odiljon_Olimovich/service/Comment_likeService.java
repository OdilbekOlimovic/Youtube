package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Comment_likedto;
import Odiljon_Olimovich.model.Comment;
import Odiljon_Olimovich.model.Comment_like;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.repository.CommentRepo;
import Odiljon_Olimovich.repository.Comment_likeRepo;
import Odiljon_Olimovich.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Comment_likeService {

    @Autowired
    Comment_likeRepo comment_likeRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    CommentRepo commentRepo;

    // get all
    public List<Comment_like> findAllByComment() {
        return comment_likeRepo.findAll();
    }

    // get by id
    public Comment_like findById(Integer id) {
        return comment_likeRepo.findById(id).get();
    }

    // create
    public Result create(Comment_likedto comment_likedto) {
        boolean existsbyid = comment_likeRepo.existsById(comment_likedto.getProfiles());
        if (existsbyid) {
            return new Result(false, "Profile already exists");
        }
        Comment_like comment_like = new Comment_like();
        comment_like.setCreated_date(comment_likedto.getCreated_date());
        comment_like.setType(comment_likedto.getType());

        Optional<Profile> profile = profileRepo.findById(comment_likedto.getProfiles());
        Profile profile1 = profile.get();
        comment_like.setProfiles((List<Profile>) profile1);

        Optional<Comment> comment = commentRepo.findById(comment_likedto.getComments());
        Comment comment1 = comment.get();
        comment_like.setComments((List<Comment>) comment1);
        comment_likeRepo.save(comment_like);
        return new Result(true, "Comment created");
    }

    // update
    private Result update(Integer id, Comment_likedto comment_likedto) {
       Optional<Comment_like> commentLikeOptional = comment_likeRepo.findById(id);
       if (commentLikeOptional.isPresent()) {
           Comment_like commentLike = commentLikeOptional.get();
           commentLike.setCreated_date(comment_likedto.getCreated_date());
           commentLike.setType(comment_likedto.getType());

           Optional<Profile> profile = profileRepo.findById(comment_likedto.getProfiles());
           Profile profile1 = profile.get();
           commentLike.setProfiles((List<Profile>) profile1);

           Optional<Comment> comment = commentRepo.findById(comment_likedto.getComments());
           Comment comment1 = comment.get();
           commentLike.setComments((List<Comment>) comment1);
           comment_likeRepo.save(commentLike);
           return new Result(true, "Comment updated");
       }
       return new Result(false, "Comment not found");
    }

    // delete
    public Result delete(Integer id) {
        comment_likeRepo.deleteById(id);
        return new Result(true, "Comment deleted");
    }
}
