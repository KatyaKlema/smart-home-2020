package ru.sbt.mipt.oop;

public class Alarm {
    private final Integer code;
    private AlarmState alarmState;


    public Alarm(Integer code, AlarmState alarmState) {
        this.code = code;
        this.alarmState = alarmState;
    }

    public Alarm(Integer code){
        this.code = code;
        this.alarmState = new DeactiveState(this);
    }

    public Integer getCode(){
        return this.code;
    }
    public AlarmState getAlarmState(){
        return this.alarmState;
    }

    public boolean isActivatedAlarm(){
        return this.alarmState instanceof ActiveState;
    }
    public boolean isTriggered(){
        return this.alarmState instanceof TriggerState;
    }
    public void setAlarmState(Integer code, AlarmState alarmState){
        if(code != this.code){
            this.alarmState = new TriggerState(this);
        }
        else {
            this.alarmState = alarmState;
        }
    }



}
