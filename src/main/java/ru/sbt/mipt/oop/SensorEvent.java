package ru.sbt.mipt.oop;

import java.util.ArrayList;

public class SensorEvent {
    private SensorEventType sensorEventType;
    private final String objectId;

    public SensorEvent(SensorEventType sensorEventType, String objectId) {
        this.sensorEventType = sensorEventType;
        this.objectId = objectId;
    }

    public SensorEventType getType(){
        return this.sensorEventType;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {

        return "SensorEvent{" +
                "type=" + sensorEventType +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
