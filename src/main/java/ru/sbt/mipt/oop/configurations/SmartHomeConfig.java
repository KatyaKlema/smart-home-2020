package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapter.SmartHomeAdapter;
import ru.sbt.mipt.oop.data_reader.JSONData;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.Door;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.smart_home.SmartHomeHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class SmartHomeConfig {
    @Bean
    public SmartHome smartHome(HomeReader homeReader) throws IOException{
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
