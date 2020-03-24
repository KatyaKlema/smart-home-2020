package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class PrintLightInformation {
    public static void printLight(Event event, Light light, Room room){
        if (event.getSensorEvent().getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        }
        else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
    }
}