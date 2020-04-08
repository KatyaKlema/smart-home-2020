package ru.sbt.mipt.oop.smart_home;

import ru.sbt.mipt.oop.events.Iterate;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.processors.Processor;

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
