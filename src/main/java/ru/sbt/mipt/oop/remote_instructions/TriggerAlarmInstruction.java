package ru.sbt.mipt.oop.remote_instructions;


import ru.sbt.mipt.oop.alarm.*;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class TriggerAlarmInstruction implements Instruction {
    SmartHome smartHome;

    public TriggerAlarmInstruction(SmartHome smartHome){
        this.smartHome= smartHome;
    }
    @Override
    public void execute() {
        if(smartHome.getAlarm() != null){
            smartHome.getAlarm().triggerAlarm();
        }
    }
}
