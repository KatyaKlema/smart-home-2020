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
