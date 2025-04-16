package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.View_countdto;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.model.View_count;
import Odiljon_Olimovich.repository.View_countRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class View_CountService {
    @Autowired
    View_countRepo view_countRepo;

    // get all
    public List<View_count> findAll() {
        return view_countRepo.findAll();
    }

    // get by id
    public View_count findById(Integer id) {
        return view_countRepo.findById(id).get();
    }

    // create
    public Result save(View_countdto view_countdto) {
        View_count viewCount = new View_count();
        viewCount.setCount(view_countdto.getCount());
        view_countRepo.save(viewCount);
        return new Result(true, "success");
    }

    // update
    public Result update(Integer id, View_countdto view_countdto) {
        Optional<View_count> viewCount = view_countRepo.findById(id);
        if (viewCount.isPresent()) {
            View_count view_count = viewCount.get();
            view_count.setCount(view_countdto.getCount());
            view_countRepo.save(view_count);
            return new Result(true, "success");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        view_countRepo.deleteById(id);
        return new Result(true, "success");
    }
}
