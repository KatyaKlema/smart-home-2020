package ru.sbt.mipt.oop.processors;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.events.SensorEventType;
import ru.sbt.mipt.oop.home_components.SmartHome;

import java.util.List;

public class TriggerAlarmEventProcessor implements Processor{
    private SmartHome smartHome;
    private boolean isSended;
    private List<Processor>processors;
    public TriggerAlarmEventProcessor(SmartHome smartHome, List<Processor>processors){
        this.smartHome = smartHome;
        this.processors = processors;
        isSended = false;
    }
    private boolean isCorrectType(SensorEvent event){
        boolean ret = false;
        SensorEventType fixedType = event.getType();
        for(SensorEventType sensorEventType : SensorEventType.values()){
            ret = ret || (fixedType == sensorEventType);
        }
        return ret;
    }

    public void processing(SensorEvent event){
        if(isCorrectType(event)){
            if(smartHome.getAlarm().isActivatedAlarm()){
                smartHome.getAlarm().getAlarmState().alarmTrigger();
                System.out.println("Sending sms");
            }
            else if(smartHome.getAlarm().isTriggered()){
                if(!isSended)
                    System.out.println("Sending sms");
                isSended = true;
            }
            else{
                for(Processor processor : processors){
                    processor.processing(event);
                }
            }
        }
    }
}