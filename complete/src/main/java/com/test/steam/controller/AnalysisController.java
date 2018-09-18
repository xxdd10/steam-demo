package com.test.steam.controller;

import com.test.steam.repository.AnalysisRepository;
import com.test.steam.bean.SteamAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Maybe
 * @date 2018/6/14
 */
@RestController
public class AnalysisController {

    @Autowired
    private AnalysisRepository analysisRepository;

    @GetMapping("/getAll")
    public List<SteamAnalysis> getAll(){
        return analysisRepository.findAll();
    }
}
