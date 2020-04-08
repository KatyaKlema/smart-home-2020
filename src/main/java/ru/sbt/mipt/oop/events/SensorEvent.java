package ru.sbt.mipt.oop.events;


import java.util.ArrayList;

public class SensorEvent {
    private SensorEventType sensorEventType;
    private String objectId;

    public SensorEvent(){
        this.sensorEventType = SensorEventType.DOOR_OPEN;
        this.objectId = "1";
    }
    public SensorEvent(SensorEventType sensorEventType, String objectId) {
        this.sensorEventType = sensorEventType;
        this.objectId = objectId;
    }

    public SensorEventType getType(){ return this.sensorEventType; }

    public String getObjectId() {
        return objectId;
    }

    public void setSensorEvent(SensorEvent newSensorEvent){
        this.sensorEventType = newSensorEvent.getType();
        this.objectId = newSensorEvent.getObjectId();
    }

    @Override
    public String toString() {

        return "SensorEvent{" +
                "type=" + sensorEventType +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
