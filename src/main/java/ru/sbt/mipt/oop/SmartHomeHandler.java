package ru.sbt.mipt.oop;

import java.util.List;

public class SmartHomeHandler implements Handler {
    private SmartHome smartHome;
    private List<Processor> processors;
    private Event event;

    public SmartHomeHandler(SmartHome smartHome, Event event, List<Processor> processors){
        this.smartHome = smartHome;
        this.event = event;
        this.processors = processors;
    }

    public void runCycleForEvent(){
        Event tempEvent = this.event;
        while (tempEvent.getSensorEvent() != null) {
            System.out.println("Got event: " + tempEvent.getSensorEvent());
            for(Processor processor : processors){
                processor.processing(tempEvent);
            }
            tempEvent.setSensorEvent(event.getNextSensorEvent());
        }
    }
}
