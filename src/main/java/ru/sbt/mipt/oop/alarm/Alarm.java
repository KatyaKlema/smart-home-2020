package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.alarm_states.ActiveState;
import ru.sbt.mipt.oop.alarm_states.DeactiveState;
import ru.sbt.mipt.oop.alarm_states.TriggerState;

public class Alarm {
    private final int code;
    private AlarmState alarmState;


    public Alarm(Integer code, AlarmState alarmState) {
        this.code = code;
        this.alarmState = alarmState;
    }

    public Alarm(Integer code){
        this.code = code;
        this.alarmState = new DeactiveState(this);
    }

    public boolean isEqual(int code){
        return this.code == code;
    }

    public AlarmState getAlarmState(){
        return this.alarmState;
    }
    public void triggerAlarm(){ alarmState.alarmTrigger(); }
    public boolean isActivatedAlarm(){
        return this.alarmState instanceof ActiveState;
    }
    public boolean isTriggered(){
        return this.alarmState instanceof TriggerState;
    }
    public void setAlarmState(Alarm alarm, AlarmState alarmState){
        if(!alarm.isEqual(this.code)){
            this.alarmState = new TriggerState(this);
        }
        else {
            this.alarmState = alarmState;
        }
    }



}
