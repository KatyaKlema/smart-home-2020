package ru.sbt.mipt.oop.events;

public class Iterate {
    public SensorEvent getNextSensorEvent(SensorEvent event){
        RandomEventGenerate tempEvent = new RandomEventGenerate();
        event = tempEvent.randomizeData();
        return event;
    }
}
