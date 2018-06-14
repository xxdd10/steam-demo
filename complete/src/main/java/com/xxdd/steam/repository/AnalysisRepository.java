package com.xxdd.steam.repository;

import com.xxdd.steam.bean.SteamAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Leo.Xu on 2018/6/14.
 */
public interface AnalysisRepository extends JpaRepository<SteamAnalysis, Long> {

    @Query(value = "select s.id,s.name,s.now,s.max,s.time from steam_analysis s")
    List<SteamAnalysis> findAllFormatDate();

}
