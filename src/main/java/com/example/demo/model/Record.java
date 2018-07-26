package com.example.demo.model;

import javax.persistence.*;

/**
 * Created by levont on 7/26/2018.
 */
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String record;

    public Record(String record) {
        this.record = record;
    }

    public Record() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
