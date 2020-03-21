package ru.sbt.mipt.oop;

public class EventProcessing {
    public SensorEvent next(SensorEvent event) {
        RandomEvent tempEvent = new RandomEvent();
        event = tempEvent.randomData();
        return event;
    }
}
