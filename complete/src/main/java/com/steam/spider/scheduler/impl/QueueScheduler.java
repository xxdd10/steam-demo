package com.steam.spider.scheduler.impl;

import com.steam.spider.module.UrlSeed;
import com.steam.spider.scheduler.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Maybe on 2018/09/19.
 */
public class QueueScheduler implements Scheduler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private BlockingQueue<UrlSeed> queue = new LinkedBlockingQueue<>();
    private Set<UrlSeed> urlSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void push(UrlSeed urlSeed) {
        if (urlSeed.getUrl() == null
                || urlSeed.getUrl().trim().equals("")
                || urlSeed.getUrl().trim().equals("#")
                || urlSeed.getUrl().trim().toLowerCase().contains("javascript:")) {
            return;
        }
        if (urlSet.add(urlSeed)) {
            queue.add(urlSeed);
        } else {
            //            logger.info("UrlSeed重复:" + urlSeed.getUrl());

        }
    }

    @Override
    public UrlSeed poll() {
        return queue.poll();
    }
}
