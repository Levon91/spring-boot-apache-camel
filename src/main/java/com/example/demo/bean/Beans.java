package com.example.demo.bean;

import com.example.demo.model.Record;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by levont on 7/26/2018.
 */
@Component(value = "beans")
public class Beans {

    private static long counter;

    @Value("${greeting}")
    private String greeting;

    @Autowired
    private RouteRepository repository;

    public boolean route2Bean() throws IOException {
        File file = new File("D:/workspace/camel/output");
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File tmp : files) {
                if (tmp.getName().matches("(.*)(txt)$")) {
                    Date expirationDate = new Date(System.currentTimeMillis() + ((1000 * 60) * 10));
                    System.out.println(expirationDate);
                    String s = new String(Files.readAllBytes(Paths.get(tmp.getPath())));
                    Record saved = repository.save(new Record(s, expirationDate));
                    System.out.println(saved.getRecord());
                    boolean isDeleted = tmp.delete();
                    System.out.println(isDeleted ? tmp.getName() + " deleted" : "failed to delete " + tmp.getName() + " file");
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean route3Bean() throws IOException {
        Integer count = repository.deleteAllByExpirationDateBefore(new Date(System.currentTimeMillis()));
        System.out.println(count + " items deleted");
        return true;
    }

    public void route4Bean(String fileData) throws IOException {
        System.out.println("Route-4: " + fileData);
    }

    public String sayGreeting() {
        counter++;
        StringBuffer buffer = new StringBuffer(greeting + " " + counter + " times");
        return buffer.toString();
    }
}
