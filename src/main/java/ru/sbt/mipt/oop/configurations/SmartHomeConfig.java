package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import ru.sbt.mipt.oop.adapter.SmartHomeAdapter;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.processors.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class SmartHomeConfig {
    @Bean
    public SmartHome smartHome(HomeReader homeReader) throws IOException{
        return homeReader.read("smart-home-1.js");
    }
    
    @Bean 
    public List<Processor> getProcessers(SmartHome smartHome){
        return Arrays.asList(new LightEventProcessor(smartHome), new DoorEventProcessor(smartHome),
                new HallDoorEventProcessor(smartHome));
    }
    @Bean
    public SmartHomeAdapter smartHomeAdapter(List<Processor> processors){
        return new SmartHomeAdapter(processors);
    }
    @Bean
    public SensorEventsManager sensorEventManager(SmartHomeAdapter smartHomeAdapter){
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(smartHomeAdapter);
        return sensorEventsManager;
    }
}
