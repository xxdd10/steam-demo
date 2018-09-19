package com.steam.spider.module;

/**
 * Created by Maybe on 2018/09/19.
 */
public class UrlSeed implements Cloneable {




    private long priority = 5;
    private String url;

    @Override
    public String toString() {
        return "UrlSeed{" +
                "priority=" + priority +
                ", url='" + url + '\'' +
                '}';
    }

    public UrlSeed(long priority, String url) {
        this.priority = priority;
        this.url = url;
    }

    public UrlSeed(String url) {
        this.priority = 5;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    public UrlSeed setUrl(String url) {
        this.url = url;
        return this;
    }

    public long getPriority() {
        return priority;
    }

    public UrlSeed setPriority(long priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        UrlSeed urlSeed = (UrlSeed) o;
        return urlSeed.getUrl().equals(this.url);
    }

    @Override
    public UrlSeed clone() {
        UrlSeed urlSeed = null;
        try {
            urlSeed = (UrlSeed) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return urlSeed;
        }
    }
}
