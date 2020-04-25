package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.events.SensorEventType;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.processors.Processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeAdapter implements EventHandler {
    private List<Processor> processors;
    private SmartHome smartHome;
    private Map<String, SensorEventType> name2Type;

    public SmartHomeAdapter(List<Processor> processors){
        this.processors = processors;
        this.smartHome = new SmartHome();
        this.name2Type = new HashMap<String, SensorEventType>();
    }
    public SmartHomeAdapter(List<Processor> processors, SmartHome smartHome, Map<String, SensorEventType> name2Type){
        this.processors = processors;
        this.smartHome = smartHome;
        this.name2Type = name2Type;
    }

    private SensorEvent adapterConvert(CCSensorEvent event){
        return new SensorEvent(name2Type.get(event.getEventType()), event.getEventType());
    }
    @Override
    public void handleEvent(CCSensorEvent event) {
        for(Processor processor : processors){
            processor.processing(adapterConvert(event));
        }
    }
}
