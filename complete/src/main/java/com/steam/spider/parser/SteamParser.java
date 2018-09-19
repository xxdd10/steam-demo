package com.steam.spider.parser;

import com.steam.spider.module.Page;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * steam html parse
 *
 * @author Leo.Xu
 * @date 2018/9/19
 */
public class SteamParser {

    private static class Lazy {
        private static final SteamParser instance = new SteamParser();
    }

    public static final SteamParser getInstance() {
        return Lazy.instance;
    }

    /**
     * 获取steam页面的数据
     *
     * @param page
     * @return
     */
    public List getData(Page page) {
        Document document = page.getDocument();
        //这个下面是一个table
        Element element = document.getElementById("detailStats");
        //从第二个tr开始选
        for (int i = 2; i < 12; i++) {
            Elements elements = element.getElementsByTag("tr").eq(i);
            for (Element e : elements) {
                Elements nums = e.getElementsByClass("currentServers");
                for (Element num : nums) {
//                    895,889
//                    994,205
//                    646,576
//                    650,922
//                    435,419
//                    482,772
//                    119,943
//                    124,025
//                    92,532
//                    92,532
//                    62,088
//                    62,834
//                    51,518
//                    57,112
//                    39,451
//                    46,058
//                    38,468
//                    45,844
//                    37,450
//                    37,450
                    System.out.println(num.getElementsByTag("span").html());
                }
            }
        }

        return null;


    }


//    public Map getData(Element element) {
//
//
//    }


}
