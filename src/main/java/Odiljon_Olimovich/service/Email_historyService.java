package Odiljon_Olimovich.service;


import Odiljon_Olimovich.dto.Email_historydto;
import Odiljon_Olimovich.model.Email_History;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.repository.Email_historyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;

@Service
public class Email_historyService {

    @Autowired
    Email_historyrepo email_historyrepo;

    // get all
    public List<Email_History> findall() {
        return email_historyrepo.findAll();
    }

    // get by id
    public Email_History findById(Integer id) {
        return email_historyrepo.findById(id).get();
    }

    // create
    public Result save(Email_historydto email_historydto) {
        Email_History email_history = new Email_History();
        email_history.setTo_email(email_historydto.getTo_email());
        email_history.setTitle(email_historydto.getTitle());
        email_history.setMessage(email_historydto.getMessage());
        email_history.setCreated_date(email_historydto.getCreated_date());
        email_historyrepo.save(email_history);
        return new Result(true, "successfully");
    }

    // update
    public Result update(Integer id, Email_historydto email_historydto) {
        Optional<Email_History> emailHistoryOptional = email_historyrepo.findById(id);
        if (emailHistoryOptional.isPresent()) {
            Email_History emailHistory = emailHistoryOptional.get();
            emailHistory.setTo_email(email_historydto.getTo_email());
            emailHistory.setTitle(email_historydto.getTitle());
            emailHistory.setMessage(email_historydto.getMessage());
            emailHistory.setCreated_date(email_historydto.getCreated_date());
            email_historyrepo.save(emailHistory);
            return new Result(true, "successfully");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        email_historyrepo.deleteById(id);
        return new Result(true, "successfully");
    }
}
