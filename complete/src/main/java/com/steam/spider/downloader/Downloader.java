package com.steam.spider.downloader;

import com.steam.spider.module.Page;
import com.steam.spider.module.UrlSeed;

/**
 * Created by Maybe on 2018/9/19.
 */
public interface Downloader {

    Page download(UrlSeed urlSeed);
}
