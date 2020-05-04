package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapter.SmartHomeAdapter;
import ru.sbt.mipt.oop.events.SensorEventType;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.home_readers.JSONHomeReader;
import ru.sbt.mipt.oop.processors.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
public class SmartHomeConfig {
    @Bean 
    public HomeReader homeReader(){
        return new JSONHomeReader();
    }
    @Bean
    public SmartHome smartHome(HomeReader homeReader){
        return homeReader.read("smart-home-1.js");
    }

    @Bean
    public Processor lighEventProcessor(SmartHome smartHome){
        return new LightEventProcessor(smartHome);
    }

    @Bean
    public Processor doorEventProcessor(SmartHome smartHome){
        return new DoorEventProcessor(smartHome);
    }

    @Bean
    public Processor hallDooeEventProcessor(SmartHome smartHome){
        return new HallDoorEventProcessor(smartHome);
    }

    @Bean
    public Processor triggerAlarmEventProcessor(SmartHome smartHome, List<Processor> processors){
        return new TriggerAlarmEventProcessor(smartHome, processors);
    }

    @Bean
    public Map<String, SensorEventType> name2Type(){
        return Map.of(
                "LightIsOn", SensorEventType.LIGHT_ON,
                "LightIsOff", SensorEventType.LIGHT_OFF,
                "DoorIsOpen", SensorEventType.DOOR_OPEN,
                "DoorIsClosed", SensorEventType.DOOR_CLOSED
        );
    }
    @Bean
    public SmartHomeAdapter smartHomeAdapter(List<Processor> processors, SmartHome smartHome, Map<String, SensorEventType> name2Type){
        return new SmartHomeAdapter(processors, smartHome, name2Type);
    }

    @Bean
    public SensorEventsManager sensorEventManager(SmartHomeAdapter smartHomeAdapter){
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(smartHomeAdapter);
        return sensorEventsManager;
    }

}
