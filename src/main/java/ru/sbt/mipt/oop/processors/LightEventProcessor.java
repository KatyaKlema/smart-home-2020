package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.home_components.Light;
import ru.sbt.mipt.oop.home_components.SmartHome;

import static ru.sbt.mipt.oop.events.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.events.SensorEventType.LIGHT_ON;


public class LightEventProcessor implements Processor {
    SmartHome smartHome;

    public LightEventProcessor(){ this.smartHome = new SmartHome(); }

    public LightEventProcessor(SmartHome smartHome){
        this.smartHome = smartHome;
    }
    private boolean isLight(SensorEvent event){
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
    @Override
    public void processing(SensorEvent event) {
        if(isLight(event)) {
            // событие от источника света
            smartHome.execute( object -> {
                if ( object instanceof Light) {
                    Light light = (Light) object;
                    if (event.getObjectId().equals(light.getId())) {
                        if ( event.getType() == LIGHT_OFF) {
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
