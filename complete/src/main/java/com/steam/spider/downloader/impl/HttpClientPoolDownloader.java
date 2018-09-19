package com.steam.spider.downloader.impl;


import com.steam.spider.downloader.Downloader;
import com.steam.spider.module.Page;
import com.steam.spider.module.UrlSeed;
import com.steam.spider.utils.HttpUtils;

/**
 *
 * @author Maybe
 * @date 2018/9/19
 */
public class HttpClientPoolDownloader implements Downloader {

    @Override
    public Page download(UrlSeed urlSeed) {
        String html = HttpUtils.getInstance().get(urlSeed.getUrl());
        Page page = new Page(urlSeed, html);
        return page;
    }
}
