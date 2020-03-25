package ru.sbt.mipt.oop;

public class TriggerAlarmEventProcessor implements Processor{
    private SmartHome smartHome;
    private boolean isSended;
    private Processor wrapperProcessor;
    public TriggerAlarmEventProcessor(SmartHome smartHome, Processor wrapperProcessor){
        this.smartHome = smartHome;
        this.wrapperProcessor = wrapperProcessor;
        isSended = false;
    }
    private boolean isCorrect(Event event){
        return event.getSensorEvent().getType() == SensorEventType.DOOR_OPEN || event.getSensorEvent().getType() == SensorEventType.DOOR_CLOSED
                || event.getSensorEvent().getType() == SensorEventType.LIGHT_ON || event.getSensorEvent().getType() == SensorEventType.LIGHT_OFF;
    }

    public void processing(Event event){
        if(isCorrect(event)){
            if(smartHome.getAlarm().isActivatedAlarm()){
                smartHome.getAlarm().getAlarmState().ALARM_TRIGGER();
                System.out.println("Sending sms");
            }
            else if(smartHome.getAlarm().isTriggered()){
                smartHome.getAlarm().getAlarmState().ignore();
                if(!isSended)
                    System.out.println("Sending sms");
                isSended = true;
            }
            else{
                wrapperProcessor.processing(event);
            }
        }
    }
}
