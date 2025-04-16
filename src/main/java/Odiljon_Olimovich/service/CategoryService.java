package Odiljon_Olimovich.service;

import Odiljon_Olimovich.dto.Categorydto;
import Odiljon_Olimovich.model.Category;
import Odiljon_Olimovich.model.Result;
import Odiljon_Olimovich.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    // get all
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    // get by id
    public Category findById(Integer id) {
        return categoryRepo.findById(id).get();
    }

    // create
    public Result save(Categorydto categorydto) {
        Category category = new Category();
        category.setName(categorydto.getName());
        categoryRepo.save(category);
        return new Result(true, "successfully");
    }

    // update
    public Result update(Integer id, Categorydto categorydto) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categorydto.getName());
            categoryRepo.save(category);
            return new Result(true, "successfully");
        }
        return new Result(false, "not found");
    }

    // delete
    public Result delete(Integer id) {
        categoryRepo.deleteById(id);
        return new Result(true, "successfully");
    }
}
