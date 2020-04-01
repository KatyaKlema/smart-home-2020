package ru.sbt.mipt.oop.sensor_command;

import ru.sbt.mipt.oop.comand_type.CommandType;

public class SensorCommand {
    private final CommandType type;
    private final String objectId;

    public SensorCommand(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "SensorCommand{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
