package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventTypeLight.LIGHT_ON;

public class LightInformation {
    public static void printLight(Event event, Light light, Room room){
        if (event.getEvent().getTypeLight() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        }
        else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
    }
}