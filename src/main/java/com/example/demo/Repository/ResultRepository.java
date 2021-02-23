package com.example.demo.Repository;

import com.example.demo.Model.Coalition;
import com.example.demo.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}
