package ru.sbt.mipt.oop.send_command;

import ru.sbt.mipt.oop.sensor_command.SensorCommand;

public class SendCommand {
    public SendCommand(SensorCommand command){
        System.out.println("Pretent we're sending command " + command);
    }
}
