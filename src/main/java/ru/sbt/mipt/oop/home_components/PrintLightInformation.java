package ru.sbt.mipt.oop.home_components;

import ru.sbt.mipt.oop.events.SensorEvent;

import static ru.sbt.mipt.oop.events.SensorEventType.LIGHT_ON;


public class PrintLightInformation {
    public static void printLight(SensorEvent event, Light light, Room room){
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        }
        else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
    }
}