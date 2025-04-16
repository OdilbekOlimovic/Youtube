package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Attachdto;
import Odiljon_Olimovich.model.Attach;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.repository.AttachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachService {
    @Autowired
    AttachRepo attachRepo;

    // get all
    public List<Attach> findAll() {
        return attachRepo.findAll();
    }

    // get by id
    public Attach findById(UUID uuid) {
        return attachRepo.findById(uuid).get();
    }

    // create
    public Result save(Attachdto attachdto) {
        Attach attach = new Attach();
        attach.setOrigin_name(attachdto.getOrigin_name());
        attach.setSize(attachdto.getSize());
        attach.setType(attachdto.getType());
        attach.setPath(attachdto.getPath());
        attach.setDuration(attachdto.getDuration());
        attachRepo.save(attach);
        return new Result(true, "successfully");
    }

    // update
    public Result update(UUID uuid, Attachdto attachdto) {
        Optional<Attach> attachOptional = attachRepo.findById(uuid);
        if (attachOptional.isPresent()) {
            Attach attach = attachOptional.get();
            attach.setOrigin_name(attachdto.getOrigin_name());
            attach.setSize(attachdto.getSize());
            attach.setType(attachdto.getType());
            attach.setPath(attachdto.getPath());
            attach.setDuration(attachdto.getDuration());
            attachRepo.save(attach);
            return new Result(true, "successfully");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(UUID uuid) {
        attachRepo.deleteById(uuid);
        return new Result(true, "successfully");
    }
}
