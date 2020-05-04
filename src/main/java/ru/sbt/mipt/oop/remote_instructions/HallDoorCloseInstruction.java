package ru.sbt.mipt.oop.remote_instructions;

import ru.sbt.mipt.oop.actions.DoorClose;
import ru.sbt.mipt.oop.home_components.Room;
import ru.sbt.mipt.oop.home_components.SmartHome;

public class HallDoorCloseInstruction implements Instruction {
    SmartHome smartHome;
    public HallDoorCloseInstruction(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.execute(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(new DoorClose());
                }
            }
        });
    }
}
