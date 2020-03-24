package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements Processor<Event>{
    private SmartHome smartHome;
    private DoorIterator doorIterator;
    public DoorEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
        this.doorIterator = new DoorIterator(smartHome);;
    }
    private boolean isDoor(Event event){
        return event.getSensorEvent().getType() == DOOR_OPEN || event.getSensorEvent().getType() == DOOR_CLOSED;
    }
    @Override
    public void processing(Event event) {
        if(isDoor(event)){
            // событие от двери
            doorIterator.iterate(event);
        }
    }
}
