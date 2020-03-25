package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements Processor{
    private SmartHome smartHome;
    public DoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    private boolean isDoor(Event event){
        return event.getSensorEvent().getType() == DOOR_OPEN || event.getSensorEvent().getType() == DOOR_CLOSED;
    }
    public void processing(Event event) {
        if(isDoor(event)){
            // событие от двери
            smartHome.execute(object -> {
                if (object instanceof Door) {
                    Door door = (Door) object;
                    if (event.getSensorEvent().getObjectId().equals(door.getId())) {
                        if (event.getSensorEvent().getType() == DOOR_OPEN) {
                            door.setOpen(true);
                        } else {
                            door.setOpen(false);
                        }
                    }
                }
            });
        }
    }
}
