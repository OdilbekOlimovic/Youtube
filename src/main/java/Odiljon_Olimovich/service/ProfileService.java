package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Profiledto;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.entity.Permisionrole;
import Odiljon_Olimovich.model.entity.Status;
import Odiljon_Olimovich.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    // get all
    public List<Profile> findAll() {
        return profileRepo.findAll();
    }

    // get by id
    public Profile findById(Integer id) {
        return profileRepo.findById(id).get();
    }

    // create
    public Result save(Profiledto profiledto) {
        Profile profile = new Profile();
        profile.setName(profiledto.getName());
        profile.setSurname(profiledto.getSurname());
        profile.setEmail(profiledto.getEmail());
        profile.setPassword(profiledto.getPassword());
        profile.setPhoto(profiledto.getPhoto());
        profile.setPermisionrole(Permisionrole.ADMIN);
        profile.setStatus(Status.ACTIVE);
        profileRepo.save(profile);
        return new Result(true, "successfully");
    }

    // update
    public Result update(Profiledto profiledto, Integer id) {
        Optional<Profile> profileOptional = profileRepo.findById(id);
        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            profile.setName(profiledto.getName());
            profile.setSurname(profiledto.getSurname());
            profile.setEmail(profiledto.getEmail());
            profile.setPassword(profiledto.getPassword());
            profile.setPhoto(profiledto.getPhoto());
            profile.setPermisionrole(Permisionrole.ADMIN);
            profile.setStatus(Status.ACTIVE);
            profileRepo.save(profile);
            return new Result(true, "successfully");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        profileRepo.deleteById(id);
        return new Result(true, "successfully");
    }
}
