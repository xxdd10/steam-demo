package com.test.steam.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maybe
 * @date 2018/6/14
 */
@Component
public class SteamJob {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count0 = 1;
    private Integer count1 = 1;
    private Integer count2 = 1;

    @Scheduled(fixedRate = 20000)
    public void reportCurrentTime() throws InterruptedException {
        System.out.println(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));

        //提取url
        String url = "https://store.steampowered.com/stats";

        try {
            System.out.println(getURLInfo(url,null));
            String pattern = "<span class=\"currentServers\">1,460,575</span>";



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String getURLInfo(String urlInfo,String charset) throws Exception {
        //读取目的网页URL地址，获取网页源码
        URL url = new URL(urlInfo);
        HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            //这里是对链接进行处理
//            line = line.replaceAll("</?a[^>]*>", "");
            //这里是对样式进行处理
//            line = line.replaceAll("<(\\w+)[^>]*>", "<$1>");
            sb.append(line);
        }
        is.close();
        br.close();
        //获得网页源码
        return sb.toString().trim();
    }
}
