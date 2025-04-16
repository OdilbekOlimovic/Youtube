package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Subscriptiondto;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.Subscription;
import Odiljon_Olimovich.model.entity.Status;
import Odiljon_Olimovich.repository.ChannelRepo;
import Odiljon_Olimovich.repository.ProfileRepo;
import Odiljon_Olimovich.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ChannelRepo channelRepo;

    // get all
    public List<Subscription> findAll() {
        return subscriptionRepo.findAll();
    }

    // get by id
    public Subscription findById(Integer id) {
        return subscriptionRepo.findById(id).get();
    }

    // create
    public Result create(Subscriptiondto subscriptiondto) {
        boolean existsbyid = subscriptionRepo.existsById(subscriptiondto.getProfiles());
        if (existsbyid) {
            return new Result(false, "Profile already exists");
        }
        Subscription subscription = new Subscription();
        subscription.setCreated_date(subscriptiondto.getCreated_date());
        subscription.setUnsubscribe_date(subscriptiondto.getUnsubscribe_date());
        subscription.setStatus(Status.ACTIVE);
        subscription.setNotification_type(subscriptiondto.getNotification_type());

        Optional<Profile> profile = profileRepo.findById(subscriptiondto.getProfiles());
        Profile profile1 = profile.get();
        subscription.setProfiles((List<Profile>) profile1);

        Optional<Channel> channel = channelRepo.findById(subscriptiondto.getChannels());
        Channel channel1 = channel.get();
        subscription.setChannels((List<Channel>) channel1);
        subscriptionRepo.save(subscription);
        return new Result(true, "Subscription created");
    }

    // update
    public Result update(Integer id, Subscriptiondto subscriptiondto) {
        boolean existsbyid = subscriptionRepo.existsById(subscriptiondto.getProfiles());
        if (existsbyid) {
            Optional<Subscription> subscription = subscriptionRepo.findById(id);
            if (subscription.isPresent()) {
                Subscription subscription1 = subscription.get();
                subscription1.setCreated_date(subscriptiondto.getCreated_date());
                subscription1.setUnsubscribe_date(subscriptiondto.getUnsubscribe_date());
                subscription1.setStatus(Status.ACTIVE);
                subscription1.setNotification_type(subscriptiondto.getNotification_type());

                Optional<Profile> profile = profileRepo.findById(subscriptiondto.getProfiles());
                Profile profile1 = profile.get();
                subscription1.setProfiles((List<Profile>) profile1);

                Optional<Channel> channel = channelRepo.findById(subscriptiondto.getChannels());
                Channel channel1 = channel.get();
                subscription1.setChannels((List<Channel>) channel1);
                subscriptionRepo.save(subscription1);
                return new Result(true, "Subscription updated");
            }
        }
        return new Result(false, "Profile does not exist");
    }

    // delete
    public Result delete(Integer id) {
        subscriptionRepo.deleteById(id);
        return new Result(true, "Subscription deleted");
    }
}
