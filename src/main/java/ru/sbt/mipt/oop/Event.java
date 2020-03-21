package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventTypeLight.*;
import static ru.sbt.mipt.oop.SensorEventTypeDoor.*;

public class Event {
    private static SensorEvent event;

    public Event (){
        RandomEvent tempEvent = new RandomEvent();
        this.event = tempEvent.randomData();
    }
    public Event(SensorEvent _event){
        this.event = _event;
    }


    public SensorEvent getEvent(){
        return this.event;
    }
    public void setEvent(SensorEvent newEvent){
        this.event = newEvent;
    }
}
