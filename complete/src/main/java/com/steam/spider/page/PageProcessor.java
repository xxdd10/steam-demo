package com.steam.spider.page;


import com.steam.spider.module.Page;

/**
 * 解析页面使用
 * process函数需要完成的有：
 * 1.解析有用的信息，丢进去Page的List items中。之后save会进行存储！
 * 2.解析新的 url ，丢进去Page的List  newUrlSeed中。
 *
 */
public interface PageProcessor {


    void process(Page page);


    default void processNewUrlSeeds(Page page) {

    }
}
