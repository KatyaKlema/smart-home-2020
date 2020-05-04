package ru.sbt.mipt.oop.remote_instructions;

import ru.sbt.mipt.oop.actions.LightOn;
import ru.sbt.mipt.oop.home_components.Room;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class HallLightOnInstruction implements Instruction {
    SmartHome smartHome;
    public HallLightOnInstruction(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(new LightOn());
                }
            }
        });
    }
}
