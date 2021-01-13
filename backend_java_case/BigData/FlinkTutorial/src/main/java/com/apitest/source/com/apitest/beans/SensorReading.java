package com.apitest.source.com.apitest.beans;

/**
 * @author yangzl 2020.01.13
 * @version 1.00.00
 * @Description:传感器温度读数的数据类型
 * @history:
 */
public class SensorReading {
    //属性:id、时间戳、温度值
    private String id;

    private long timestamp;

    private Double temperature;

    @Override
    public String toString() {
        return "SensorReading{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", temperature=" + temperature +
                '}';
    }

    public SensorReading() {

    }

    public SensorReading(String id, long timestamp, Double temperature) {
        this.id = id;
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
