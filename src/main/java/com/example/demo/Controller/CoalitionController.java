package com.example.demo.Controller;

import com.example.demo.Model.Coalition;
import com.example.demo.Service.CoalitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/coalitions")
public class CoalitionController {
    @Autowired
    CoalitionService coalitionService;

    @GetMapping("")
    public List<Coalition> list(){
        return coalitionService.listAllCoalitions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Coalition> get(@PathVariable Integer id){
        try{
            Coalition coalition = coalitionService.getCoalition(id);
            return new ResponseEntity<Coalition>(coalition, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Coalition>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Coalition coalition){

        coalitionService.saveCoalition(coalition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Coalition coalition, @PathVariable Integer id){
        try{
            Coalition existCoalition = coalitionService.getCoalition(id);
            coalition.setId(id);
            coalitionService.saveCoalition(coalition);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        coalitionService.deleteCoalition(id);
    }
}
