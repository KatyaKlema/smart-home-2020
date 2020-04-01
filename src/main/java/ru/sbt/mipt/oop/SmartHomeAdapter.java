package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeAdapter implements EventHandler {
    private Processor processor;
    private SmartHome smartHome;
    private Map<String, SensorEventType> name2Type;

    public SmartHomeAdapter(){
        this.processor = new DoorEventProcessor();
        this.smartHome = new SmartHome();
        this.name2Type = new HashMap<String, SensorEventType>();
    }
    public SmartHomeAdapter(Processor processor, SmartHome smartHome, Map<String, SensorEventType> name2Type){
        this.processor = processor;
        this.smartHome = smartHome;
        this.name2Type = name2Type;
    }

    public SensorEvent adapterConvert(CCSensorEvent event){
        return new SensorEvent(name2Type.get(event.getEventType()), event.getEventType());
    }
    @Override
    public void handleEvent(CCSensorEvent event) {
        processor.processing(adapterConvert(event));
    }
}
