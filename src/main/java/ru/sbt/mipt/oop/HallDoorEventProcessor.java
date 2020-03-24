package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements Processor{
    SmartHome smartHome;
    public HallDoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    @Override
    public void processing(Event event) {
        if ( event.getSensorEvent().getType() == DOOR_CLOSED) {
            for ( Room room : smartHome.getRooms() ) {
                for ( Door door : room.getDoors() ) {
                    if (door.getId().equals(event.getSensorEvent().getObjectId()) && room.getName().equals("hall")) {
                        iterate(smartHome);
                        door.setOpen(false);
                    }
                }
            }
        }
    }

    private void iterate(SmartHome smartHome) {
        smartHome.execute(object -> {
            if (object instanceof Light) {
                Light light = (Light) object;
                light.setOn(false);
            }
        });
    }
}
