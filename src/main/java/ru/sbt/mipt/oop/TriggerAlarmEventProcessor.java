package ru.sbt.mipt.oop;

public class TriggerAlarmEventProcessor implements Processor<Event> {
    SmartHome smartHome;
    private Processor<Event> wrapperProcessor;
    public TriggerAlarmEventProcessor(SmartHome smartHome, Processor<Event> wrapperProcessor){
        this.smartHome = smartHome;
        this.wrapperProcessor = wrapperProcessor;
    }
    private boolean isDoor(Event event){
        return event.getSensorEvent().getType() == SensorEventType.DOOR_OPEN || event.getSensorEvent().getType() == SensorEventType.DOOR_CLOSED;
    }

    private boolean isLight(Event event){
        return event.getSensorEvent().getType() == SensorEventType.LIGHT_ON || event.getSensorEvent().getType() == SensorEventType.LIGHT_OFF;
    }
    @Override
    public void processing(Event event){
        if(isLight(event) || isDoor(event)){
            if(smartHome.getAlarm().isActivatedAlarm()){
                smartHome.getAlarm().getAlarmState().ALARM_TRIGGER();
                System.out.println("Sending sms");
            }
            else if(smartHome.getAlarm().isTriggered()){
                smartHome.getAlarm().getAlarmState().ignore();
                System.out.println("Sending sms");
            }
            else{
                wrapperProcessor.processing(event);
            }
        }
    }
}
