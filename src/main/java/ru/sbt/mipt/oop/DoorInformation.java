package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorInformation {
    public void toggleDoorLight(Event event, Door door, SmartHome smartHome, Room room){
        if (event.getSensorEvent().getType() == DOOR_OPEN) {
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
        } else {
            door.setOpen(false);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
            HallDoorIterator hallDoorIterator = new HallDoorIterator(smartHome);
            HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor(smartHome);
            hallDoorEventProcessor.processing(room);
        }
    }
}
