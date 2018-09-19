package com.steam.spider.page.impl;

import com.steam.spider.module.Page;
import com.steam.spider.page.PageProcessor;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maybe on 2018/09/19.
 */
public class TextPageProcessor implements PageProcessor {


    @Override
    public void process(Page page) {
        Document doc = page.getDocument();

        String title = doc.title();
        String text = doc.text();
        Map<String, String> items = new HashMap<String, String>();
        items.put("title", title);
        items.put("text", text);
        items.put("url", page.getUrlSeed().getUrl());

        page.setItems(items);
    }



    @Override
    public void processNewUrlSeeds(Page page) {

    }
}
