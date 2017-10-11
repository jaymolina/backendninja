package com.udemy.repository;

import com.udemy.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("LogRepository")
public interface LogRepository extends JpaRepository<Log, Serializable>{
}
