package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements Processor {
    SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    private boolean isLight(Event event){
        return event.getSensorEvent().getType() == LIGHT_ON || event.getSensorEvent().getType() == LIGHT_OFF;
    }
    @Override
    public void processing(Event event) {
        if(isLight(event)) {
            // событие от источника света
            smartHome.execute( object -> {
                if ( object instanceof Light) {
                    Light light = (Light) object;
                    if (event.getSensorEvent().getObjectId().equals(light.getId())) {
                        if ( event.getSensorEvent().getType() == LIGHT_OFF) {
                            light.setOn(false);
                        }
                        else {
                            light.setOn(true);
                        }
                    }
                }
            });
        }
    }
}
