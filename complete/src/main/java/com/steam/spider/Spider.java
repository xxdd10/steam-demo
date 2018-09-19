package com.steam.spider;

import com.steam.spider.downloader.Downloader;
import com.steam.spider.module.Page;
import com.steam.spider.module.UrlSeed;
import com.steam.spider.scheduler.Scheduler;
import com.steam.spider.utils.TimeSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Maybe
 * @date 2018/9/19
 */
public class Spider {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //下载器
    private Downloader downloader;

    //线程数
    private int threadNum = 5;

    private Scheduler scheduler;


    private ThreadPoolExecutor pool;


    //build
    public static Spider build() {
        return new Spider();
    }

    //初始化线程数字
    public Spider thread(int num) {
        this.threadNum = num;
        if (threadNum <= 0) {
            threadNum = 5;
        }
        pool = new ThreadPoolExecutor(threadNum, threadNum, 1500L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        return this;
    }

    public Spider addUrlSeed(String url) {
        scheduler.push(new UrlSeed(url));
        return this;
    }

    public void run() {
        logger.info("steam data run");
        UrlSeed urlSeed = null;
        while (true) {
            if (pool.getQueue().size() > pool.getCorePoolSize()) {
                TimeSleep.sleep(1000);
                continue;
            }
            urlSeed = scheduler.poll();
            if (urlSeed == null && pool.getActiveCount() == 0) {
                pool.shutdown();
                try {
                    pool.awaitTermination(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    logger.error("close thread pool error");
                }
                break;
            } else if (urlSeed == null) {
                TimeSleep.sleep(1000);
            } else {
                pool.execute(new SpiderTask(urlSeed.clone()));
            }
        }


    }


    class SpiderTask implements Runnable{
        private UrlSeed urlSeed;

        public SpiderTask(UrlSeed urlSeed) {
            this.urlSeed = urlSeed;
        }

        @Override
        public void run() {
            //download url
            Page page = downloader.download(urlSeed);





        }
    }


}
