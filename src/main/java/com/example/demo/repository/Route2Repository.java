package com.example.demo.repository;

import com.example.demo.model.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by levont on 7/26/2018.
 */
public interface Route2Repository extends CrudRepository<Record, Integer> {

    Record save(Record s);
}
