package Odiljon_Olimovich.service;


import Odiljon_Olimovich.dto.Channeldto;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.entity.Status;
import Odiljon_Olimovich.repository.ChannelRepo;
import Odiljon_Olimovich.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChannelService {

    @Autowired
    ChannelRepo channelRepo;

    @Autowired
    ProfileRepo profileRepo;

    // get all
    public List<Channel> getChannels() {
        return channelRepo.findAll();
    }

    // get by id
    public Channel getChannel(Integer id) {
        return channelRepo.findById(id).get();
    }

    // create
    public Result addChannel(Channeldto channeldto) {
        boolean existsbyid = channelRepo.existsById(channeldto.getProfiles());
        if (existsbyid) {
            return new Result(false, "succesfully");
        }
        Channel channel = new Channel();
        channel.setName(channeldto.getName());
        channel.setPhoto(channeldto.getPhoto());
        channel.setDescription(channeldto.getDescription());
        channel.setStatus(Status.ACTIVE);
        channel.setBanner(channeldto.getBanner());

        Optional<Profile> profileOptional = profileRepo.findById(channeldto.getProfiles());
        Profile profile = profileOptional.get();
        channel.setProfiles((List<Profile>) profile);
        channelRepo.save(channel);
        return new Result(true, "succesfully");
    }

    // update
    public Result updateChannel(Integer id, Channeldto channeldto) {
      Optional<Channel> channelOptional =channelRepo.findById(id);
        if (channelOptional.isPresent()) {
            Channel channel1 = channelOptional.get();
            channel1.setName(channeldto.getName());
            channel1.setPhoto(channeldto.getPhoto());
            channel1.setDescription(channeldto.getDescription());
            channel1.setStatus(Status.ACTIVE);
            channel1.setBanner(channeldto.getBanner());
            Optional<Profile> profileOptional = profileRepo.findById(channeldto.getProfiles());
            Profile profile = profileOptional.get();
            channel1.setProfiles((List<Profile>) profile);
            channelRepo.save(channel1);
            return new Result(true, "succesfully");
        }
        return new Result(false, "succesfully");
    }

    // delete
    public Result deleteChannel(Integer id) {
        channelRepo.deleteById(id);
        return new Result(true, "succesfully");
    }
}
