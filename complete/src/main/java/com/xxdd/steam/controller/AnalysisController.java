package com.xxdd.steam.controller;

import com.xxdd.steam.bean.SteamAnalysis;
import com.xxdd.steam.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Leo.Xu
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
