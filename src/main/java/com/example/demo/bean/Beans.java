package com.example.demo.bean;

import com.example.demo.model.Record;
import com.example.demo.repository.Route2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by levont on 7/26/2018.
 */
@Component(value = "beans")
public class Beans {

    @Autowired
    private Route2Repository repository;

    public boolean route2Bean() throws IOException {
        File file = new File("D:/workspace/camel/output");
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File tmp : files) {
                if (tmp.getName().matches("(.*)(txt)$")) {
                    String s = new String(Files.readAllBytes(Paths.get(tmp.getPath())));
                    Record saved = repository.save(new Record(s));
                    System.out.println(saved.getRecord());
                    boolean isDeleted = tmp.delete();
                    System.out.println(isDeleted ? "file deleted" : "failed to delete file");
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
