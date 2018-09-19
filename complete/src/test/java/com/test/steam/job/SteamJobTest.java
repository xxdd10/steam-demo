package com.test.steam.job;

import com.steam.spider.Spider;
import com.steam.spider.downloader.Downloader;
import com.steam.spider.downloader.impl.HttpClientPoolDownloader;
import com.steam.spider.module.Page;
import com.steam.spider.module.UrlSeed;
import com.steam.spider.parser.SteamParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class SteamJobTest {


    @Test
    public void test() {
        System.out.println(1231313);
        String url = "https://store.steampowered.com/stats";
        Page page = new HttpClientPoolDownloader().download(new UrlSeed(url));
        SteamParser.getInstance().getData(page);
    }
}