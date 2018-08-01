package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "expiration_date")
    private Date expirationDate;

    public Record(String record, Date expirationDate) {
        this.record = record;
        this.expirationDate = expirationDate;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record1 = (Record) o;

        if (id != record1.id) return false;
        if (record != null ? !record.equals(record1.record) : record1.record != null) return false;
        return expirationDate != null ? expirationDate.equals(record1.expirationDate) : record1.expirationDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (record != null ? record.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Record{")
                .append("id=")
                .append(id)
                .append(", record='")
                .append(record)
                .append('\'')
                .append(", expirationDate=")
                .append(expirationDate)
                .append('}')
                .toString();
    }
}
