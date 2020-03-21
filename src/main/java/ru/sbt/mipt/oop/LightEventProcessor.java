package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventTypeLight.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventTypeLight.LIGHT_ON;

public class LightEventProcessor implements Processor<Event> {
    SmartHome smartHome;
    LightIterator lightIterator;
    public LightEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
        this.lightIterator = new LightIterator(smartHome);
    }
    private boolean isLight(Event event){
        return event.getEvent().getTypeLight() == LIGHT_ON || event.getEvent().getTypeLight() == LIGHT_OFF;
    }
    @Override
    public void processing(Event event) {
        if(isLight(event)) {
            // событие от источника света
            lightIterator.iterate(event);
        }
    }
}
