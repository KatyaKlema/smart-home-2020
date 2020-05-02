package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.adapter.SmartHomeAdapter;
import ru.sbt.mipt.oop.events.SensorEventType;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.processors.DoorEventProcessor;
import ru.sbt.mipt.oop.processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.processors.LightEventProcessor;
import ru.sbt.mipt.oop.processors.Processor;
import ru.sbt.mipt.oop.remote.RemoteController;
import ru.sbt.mipt.oop.remote_instructions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class RemoteControlConfig {
    @Bean
    public SmartHome smartHome(HomeReader homeReader) throws IOException{
        return homeReader.read("smart-home-1.js");
    }
    @Bean
    public Instruction hallDoorCloseInstruction(SmartHome smartHome) {
        return new HallDoorCloseInstruction(smartHome);
    }

    @Bean
    public Instruction allLightOnInstruction(SmartHome smartHome) {
        return new AllLightOnInstruction(smartHome);
    }

    @Bean
    public Instruction hallLightOnInstruction(SmartHome smartHome) {
        return new HallLightOnInstruction(smartHome);
    }

    @Bean
    public Instruction allLightOffInstruction(SmartHome smartHome) {
        return new AllLightOffInstruction(smartHome);
    }

    @Bean
    public int code() {
        return 123;
    }

    @Bean
    public Instruction alarmActivateInstruction(SmartHome smartHome, int codeForActivate) {
        return new AlarmActivateInstruction(smartHome, codeForActivate);
    }

    @Bean
    public Instruction triggerAlarmInstruction(SmartHome smartHome) {
        return new TriggerAlarmInstruction(smartHome);
    }

    @Bean
    public String rcId() {
        return "1";
    }
    
    @Bean
    public RemoteControl remoteController(String rcId) {
        return new RemoteController(rcId);
    }


    @Bean
    public RemoteControlRegistry remoteControlRegistry(RemoteController remoteControl, String rcId) {
        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();
        remoteControlRegistry.registerRemoteControl(remoteControl, rcId);
        return remoteControlRegistry;
    }

    @Bean
    public Processor doorEventProcessor(SmartHome smartHome) {
        return new DoorEventProcessor(smartHome);
    }

    @Bean
    public Processor lightEventProcessor(SmartHome smartHome) {
        return new LightEventProcessor(smartHome);
    }

    @Bean
    public Processor hallDoorEventProcessor(SmartHome smartHome) {
        return new HallDoorEventProcessor(smartHome);
    }

    @Bean
    public List<Processor> handlers(Processor hallDoorEventProcessor, Processor lightEventProcessor,
                                       Processor doorEventProcessor) {
        return Arrays.asList(hallDoorEventProcessor, lightEventProcessor, doorEventProcessor);
    }

    @Bean
    public Map<String, SensorEventType> typeMap () {
        return Map.of(
                "LightIsOn", SensorEventType.LIGHT_ON,
                "LightIsOff", SensorEventType.LIGHT_OFF,
                "DoorIsOpen", SensorEventType.DOOR_OPEN,
                "DoorIsClosed", SensorEventType.DOOR_CLOSED
        );
    }

    @Bean
    public SensorEventsManager sensorEventsManager(List<Processor> processors, SmartHome smartHome,
                                                   Map<String, SensorEventType> typeMap) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new SmartHomeAdapter(processors));
        return sensorEventsManager;
    }

}
