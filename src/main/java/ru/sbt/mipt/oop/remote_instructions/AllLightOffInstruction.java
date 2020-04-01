package ru.sbt.mipt.oop.remote_instructions;

import ru.sbt.mipt.oop.actions.LightOff;
import ru.sbt.mipt.oop.actions.LightOn;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class AllLightOffInstruction implements Instruction {
    SmartHome smartHome;
    public AllLightOffInstruction(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.execute(new LightOff());
    }
}
