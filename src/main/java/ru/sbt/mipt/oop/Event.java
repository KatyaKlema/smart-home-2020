package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class Event {
    private static SensorEvent event;

    public Event (){
        RandomEvent tempEvent = new RandomEvent();
        this.event = tempEvent.randomizeData();
    }
    public Event(SensorEvent _event){
        this.event = _event;
    }

    public SensorEvent getNextSensorEvent(){
        RandomEvent tempEvent = new RandomEvent();
        event = tempEvent.randomizeData();
        return event;
    }
    public SensorEvent getSensorEvent(){
        return this.event;
    }
    public void setSensorEvent(SensorEvent newEvent){
        this.event = newEvent;
    }
}
