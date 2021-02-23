package com.example.demo.Controller;

import com.example.demo.Model.Coalition;
import com.example.demo.Model.Result;
import com.example.demo.Service.CoalitionService;
import com.example.demo.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/coalitions")
public class ResultController {

    @Autowired
    ResultService resultService;

    @GetMapping("")
    public List<Result> list(){
        return resultService.listAllResults();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Result> get(@PathVariable Integer id){
        try{
            Result result = resultService.getResult(id);
            return new ResponseEntity<Result>(result, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Result result){

        resultService.saveResult(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Result result, @PathVariable Integer id){
        try{
            Result existResult = resultService.getResult(id);
            result.setId(id);
            resultService.saveResult(result);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        resultService.deleteResult(id);
    }
}
