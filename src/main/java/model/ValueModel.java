package model;

import java.util.Date;

public class ValueModel {
    private String value;
    private int timeToLive = 0;
    private long createdAt;

    public ValueModel(String value, int timeToLive) {
        this.value = value;
        this.timeToLive = timeToLive;
        this.createdAt = new Date().getTime();
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

    @Override
    public String toString() {
        String formattedString = "{" +
                "\"value\":\"%s\"," +
                "\"timeToLive\":%s," +
                "\"createdAt\":%s" +
                "}";
        formattedString = String.format(formattedString, value, timeToLive, createdAt);
        return formattedString;
    }
}
