package ru.sbt.mipt.oop;

public class TriggerState extends AlarmState {
    public TriggerState(Alarm alarm){
        this.alarmStateType = AlarmStateType.TRIGGER;
        this.alarm = alarm;
    }

    @Override
    public void ALARM_ACTIVATE(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                alarm.setAlarmState(code, new ActiveState(alarm));
            }
        }
    }

    @Override
    public void ALARM_DEACTIVATE(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.print("The Alarm is deactivated");
            }
        }
    }

    @Override
    public void ALARM_TRIGGER() {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.println("Already the Alarm has been triggered");
            }
        }
    }
}
