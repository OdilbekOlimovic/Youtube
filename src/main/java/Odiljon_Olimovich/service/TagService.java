package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Tagdto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Tag;
import Odiljon_Olimovich.repository.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepo tagRepo;

    // get all
    public List<Tag> findAll() {
        return tagRepo.findAll();
    }

    // get by id
    public Tag findById(Integer id) {
        return tagRepo.findById(id).get();
    }

    // create
    public Result save(Tagdto tagdto) {
        Tag tag = new Tag();
        tag.setName(tagdto.getName());
        tagRepo.save(tag);
        return new Result(true, "succesfully");
    }

    // update
    public Result update(Integer id, Tagdto tagdto) {
        Optional<Tag> tag = tagRepo.findById(id);
        if (tag.isPresent()) {
            tag.get().setName(tagdto.getName());
            tagRepo.save(tag.get());
            return new Result(true, "succesfully");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        tagRepo.deleteById(id);
        return new Result(true, "succesfully");
    }
}
