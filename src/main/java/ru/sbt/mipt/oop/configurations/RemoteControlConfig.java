package ru.sbt.mipt.oop.configurations;

import com.coolcompany.smarthome.ControlService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControl;
import ru.sbt.mipt.oop.actions.Action;
import ru.sbt.mipt.oop.actions.DoorClose;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmState;
import ru.sbt.mipt.oop.alarm_states.ActiveState;
import ru.sbt.mipt.oop.button.Button;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.SmartHome;
import ru.sbt.mipt.oop.home_readers.HomeReader;
import ru.sbt.mipt.oop.remote.RemoteController;
import ru.sbt.mipt.oop.remote_instructions.Instruction;
import ru.sbt.mipt.oop.remote_instructions.Nothing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
public class RemoteControlConfig {
    @Bean
    RemoteController remoteControl1(List<Instruction> instructions, Map<String, Instruction> instructionMap) {
        RemoteController remoteController1 = new RemoteController("1");
        return remoteController1;
    }

    @Bean
    RemoteController remoteControl2(List<Instruction> instructions, Map<String, Instruction> instructionMap) {
        RemoteController remoteController2 = new RemoteController("1");
        return remoteController2;
    }


    @Bean
    void registerAdaptController1(RemoteController remoteController1, ControlService controlService) {
        controlService.registerAdaptController(remoteController1, new Integer(remoteController1.getId()).toString());
    }

    @Bean
    void registerAdaptController2(RemoteController remoteController2, ControlService controlService) {
        controlService.registerAdaptController(remoteController2, new Integer(remoteController2.getId()).toString());
    }
    

}