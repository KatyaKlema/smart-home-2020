package ru.sbt.mipt.oop;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DeactiveState extends AlarmState {
    public DeactiveState(Alarm alarm){
        this.alarmStateType = AlarmStateType.INACTIVE;
        this.alarm = alarm;
    }
    @Override
    public void ALARM_ACTIVATE(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                Alarm tempAlarm = new Alarm(code);
                alarm.setAlarmState(tempAlarm, new ActiveState(alarm));
            }
        }
    }

    @Override
    public void ALARM_DEACTIVATE(Integer code) {
        if(!isIgnore) {
            if (isAlarm()) {
                System.out.println("Already the Alarm has been deactivated");
            }
        }
    }

    @Override
    public void ALARM_TRIGGER() {
        if(!isIgnore) {
            if (isAlarm()) {
                alarm.setAlarmState(alarm, new TriggerState(alarm));
                System.out.println("TRIGGER !");
            }
        }
    }
}
