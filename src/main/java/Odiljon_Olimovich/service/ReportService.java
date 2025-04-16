package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Reportdto;
import Odiljon_Olimovich.model.Channel;
import Odiljon_Olimovich.model.Profile;
import Odiljon_Olimovich.model.Report;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.repository.ChannelRepo;
import Odiljon_Olimovich.repository.ProfileRepo;
import Odiljon_Olimovich.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportRepo reportRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ChannelRepo channelRepo;

    // get all
    public List<Report> findByChannel_all() {
        return reportRepo.findAll();
    }

    // get by id
    public Report findById(Integer id) {
        return reportRepo.findById(id).get();
    }

    // create
    public Result save(Reportdto reportdto) {
        boolean existsbyid = reportRepo.existsById(reportdto.getProfiles());
        if (existsbyid) {
            return new Result(false, "not found");
        }
        Report report = new Report();
        report.setContent(reportdto.getContent());
        report.setEntity_id(reportdto.getEntity_id());
        report.setType(reportdto.getType());

        Optional<Profile> profileOptional = profileRepo.findById(reportdto.getProfiles());
        Profile profile = profileOptional.get();
        report.setProfiles((List<Profile>) profile);

        Optional<Channel> channelOptional = channelRepo.findById(reportdto.getChannels());
        Channel channel = channelOptional.get();
        report.setChannels((List<Channel>) channel);
        reportRepo.save(report);
        return new Result(true, "saved");
    }

    // update
    public Result update(Integer id, Reportdto reportdto) {
        boolean existsbyid = reportRepo.existsById(reportdto.getProfiles());
        if (existsbyid) {
            Optional<Report> reportOptional = reportRepo.findById(id);
            if (reportOptional.isPresent()) {
                Report report = reportOptional.get();
                report.setContent(reportdto.getContent());
                report.setEntity_id(reportdto.getEntity_id());
                report.setType(reportdto.getType());

                Optional<Profile> profileOptional = profileRepo.findById(reportdto.getProfiles());
                Profile profile = profileOptional.get();
                report.setProfiles((List<Profile>) profile);

                Optional<Channel> channelOptional = channelRepo.findById(reportdto.getChannels());
                Channel channel = channelOptional.get();
                report.setChannels((List<Channel>) channel);
                reportRepo.save(report);
                return new Result(true, "updated");
            }
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        reportRepo.deleteById(id);
        return new Result(true, "deleted");
    }
}
