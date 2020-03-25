package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class Event {
    private static SensorEvent event;

    public Event (){
        RandomEventGenerate tempEvent = new RandomEventGenerate();
        this.event = tempEvent.randomizeData();
    }
    public Event(SensorEvent _event){
        this.event = _event;
    }

    public SensorEvent getNextSensorEvent(){
        RandomEventGenerate tempEvent = new RandomEventGenerate();
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
