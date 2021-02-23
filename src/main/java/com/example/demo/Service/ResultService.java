package com.example.demo.Service;

import com.example.demo.Model.Coalition;
import com.example.demo.Model.Result;
import com.example.demo.Repository.CoalitionRepository;
import com.example.demo.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    public List<Result> listAllResults() {
        return resultRepository.findAll();
    }

    public void saveResult(Result result) {
        resultRepository.save(result);
    }

    public Result getResult(Integer id) {
        return resultRepository.findById(id).get();
    }
    public void deleteResult(Integer id) {
        resultRepository.deleteById(id);
    }
}
