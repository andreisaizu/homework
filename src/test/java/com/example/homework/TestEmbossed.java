package com.example.homework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmbossed {
    @Autowired
    EmbossedNameService embossedNameService;

    @Test
    public void generateEmbossedNameForHorizontalCard() {
        List<String> stringList = embossedNameService.generateEmbossedNameForHorizontalCard("ANDREI-CLAUDIU", "SAIZU-IONESCU");
        int x = 0;
    }
}
