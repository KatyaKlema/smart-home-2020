package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.Door;
import ru.sbt.mipt.oop.home_components.SmartHome;


import static ru.sbt.mipt.oop.events.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.events.SensorEventType.DOOR_OPEN;


public class DoorEventProcessor implements Processor {
    private SmartHome smartHome;
    public DoorEventProcessor(){ this.smartHome = new SmartHome(); }
    public DoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    private boolean isDoor(SensorEvent event){
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
    public void processing(SensorEvent event) {
        if(isDoor(event)){
            // событие от двери
            smartHome.execute(object -> {
                if (object instanceof Door) {
                    Door door = (Door) object;
                    if (event.getObjectId().equals(door.getId())) {
                        if (event.getType() == DOOR_OPEN) {
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
