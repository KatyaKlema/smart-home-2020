package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class SmartHomeConfig {
    @Bean
    public SmartHome smartHome() throws IOException{
        JSONData tempJSON = new JSONData("smart-home-1.js");
        Gson gson = new Gson();
        SmartHome smartHome = gson.fromJson(tempJSON.getData(), SmartHome.class);
        return smartHome;
    }

    @Bean
    TriggerAlarmEventProcessor triggerAlarmEventProcessorLight(SmartHome smartHome){
        return new TriggerAlarmEventProcessor(smartHome, new LightEventProcessor(smartHome));
    }

    @Bean
    TriggerAlarmEventProcessor triggerAlarmEventProcessorDoor(SmartHome smartHome){
        return new TriggerAlarmEventProcessor(smartHome, new DoorEventProcessor(smartHome));
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
    public SmartHomeHandler smartHomeHandler(SmartHome smartHome, SensorEvent event, List<Processor> processors){
        return new SmartHomeHandler(smartHome, event, processors);
    }

    @Bean
    public SensorEventsManager smartHomeAdapter(SmartHomeAdapter smartHomeAdapter){
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(smartHomeAdapter);
        return sensorEventsManager;
    }


}
