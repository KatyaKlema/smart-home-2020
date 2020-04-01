package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventProcessor implements Processor{
    SmartHome smartHome;

    public HallDoorEventProcessor(){ this.smartHome = new SmartHome(); }
    public HallDoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void processing(SensorEvent event) {
        if ( event.getType() == DOOR_CLOSED) {
            smartHome.execute(object -> {
                if (!(event.getType() == DOOR_CLOSED && object instanceof Room)) {
                    return;
                }

                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.execute(hallInstance -> {
                        if (hallInstance instanceof Door) {
                            Door door = (Door) hallInstance;
                            if (door.getId().equals((event.getObjectId()))) {
                                smartHome.execute(homeInstance -> {
                                    if (homeInstance instanceof Light) {
                                        Light light = (Light) homeInstance;
                                        light.setOn(false);
                                        System.out.println("Light " + light.getId() + " was turned off.");
                                    }
                                });
                            }
                        }
                    });
                }

            });
        }
    }
}
