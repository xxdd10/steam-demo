package com.test.steam.repository;

import com.test.steam.bean.SteamAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Maybe on 2018/6/14.
 */
public interface AnalysisRepository extends JpaRepository<SteamAnalysis, Long> {

    @Query(value = "select s.id,s.name,s.now,s.max,s.time from SteamAnalysis s")
    List<SteamAnalysis> findAllFormatDate();

}
