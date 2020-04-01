package ru.sbt.mipt.oop;

public class TriggerState extends AlarmState {
    public TriggerState(Alarm alarm){
        this.alarmStateType = AlarmStateType.TRIGGER;
        this.alarm = alarm;
    }

    @Override
    public void alarmActivate(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                Alarm tempAlarm = new Alarm(code);
                alarm.setAlarmState(tempAlarm, new ActiveState(alarm));
            }
        }
    }

    @Override
    public void alarmDeactivate(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.print("The Alarm is deactivated");
            }
        }
    }

    @Override
    public void alarmTrigger() {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.println("Already the Alarm has been triggered");
            }
        }
    }
}
