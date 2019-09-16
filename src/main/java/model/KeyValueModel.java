package model;

import java.util.Date;

public class KeyValueModel {
    private String key;
    private String value;
    private int timeToLive = 0;
    private long createdAt = new Date().getTime();

    public KeyValueModel(String key, String value, int timeToLive, long createdAt) {
        this.key = key;
        this.value = value;
        this.timeToLive = timeToLive;
        this.createdAt = createdAt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
