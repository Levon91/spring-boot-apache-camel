package com.example.demo.repository;

import com.example.demo.model.Record;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by levont on 7/26/2018.
 */
public interface RouteRepository extends CrudRepository<Record, Integer> {

    Record save(Record s);

    List<Record> getAllByExpirationDateBefore(Date expirationDate);

    @Transactional
    Integer deleteAllByExpirationDateBefore(Date expirationDate);
}
