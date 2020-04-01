package ru.sbt.mipt.oop;

import java.util.List;

public class SmartHomeHandler implements Handler {
    private SmartHome smartHome;
    private List<Processor> processors;
    private SensorEvent event;

    public SmartHomeHandler(SmartHome smartHome, SensorEvent event, List<Processor> processors){
        this.smartHome = smartHome;
        this.event = event;
        this.processors = processors;
    }

    public void runCycleForEvent(){
        SensorEvent tempEvent = this.event;
        while (tempEvent != null) {
            System.out.println("Got event: " + tempEvent);
            for(Processor processor : processors){
                processor.processing(tempEvent);
            }
            Iterate next = new Iterate();
            tempEvent.setSensorEvent(next.getNextSensorEvent(event));
        }
    }
}
