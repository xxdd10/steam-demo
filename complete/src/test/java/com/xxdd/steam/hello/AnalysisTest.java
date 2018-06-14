package com.xxdd.steam.hello;

import com.xxdd.steam.Application;
import com.xxdd.steam.repository.AnalysisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Leo.Xu on 2018/6/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AnalysisTest {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Test
    public void test(){
        System.out.println(analysisRepository.findAllFormatDate());
    }
}
