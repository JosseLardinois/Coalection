package com.example.demo.Service;

import com.example.demo.Model.Coalition;
import com.example.demo.Repository.CoalitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoalitionService {
    @Autowired
    private CoalitionRepository coalitionRepository;
    public List<Coalition> listAllCoalitions() {
        return coalitionRepository.findAll();
    }

    public void saveCoalition(Coalition coalition) {
        coalitionRepository.save(coalition);
    }

    public Coalition getCoalition(Integer id) {
        return coalitionRepository.findById(id).get();
    }
    public void deleteCoalition(Integer id) {
        coalitionRepository.deleteById(id);
    }
}
