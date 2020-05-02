package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import ru.sbt.mipt.oop.adapter.SmartHomeAdapter;
import ru.sbt.mipt.oop.data_reader.JSONData;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.processors.*;
import ru.sbt.mipt.oop.smart_home.SmartHomeHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
public class SmartHomeConfig {
    @Bean
    public SmartHome smartHome(HomeReader homeReader){
        return homeReader.read("smart-home-1.js");
    }

    @Bean
    public SensorEvent sensorEvent(){
        return new SensorEvent();
    }

    @Bean
    public Processor doorEventProcessor(){
        return new DoorEventProcessor();
    }

    @Bean
    public Processor lightEventProcessor(){
        return new LightEventProcessor();
    }

    @Bean
    public Processor hallDoorEventProcessor(){
        return new HallDoorEventProcessor();
    }

    @Bean
    public SensorEventsManager sensorEventManager(SmartHomeAdapter smartHomeAdapter){
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(smartHomeAdapter);
        return sensorEventsManager;
    }


}
