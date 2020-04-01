package ru.sbt.mipt.oop.alarm_states;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmState;
import ru.sbt.mipt.oop.alarm.AlarmStateType;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DeactiveState extends AlarmState {
    public DeactiveState(Alarm alarm){
        this.alarmStateType = AlarmStateType.INACTIVE;
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
                System.out.println("Already the Alarm has been deactivated");
            }
        }
    }

    @Override
    public void alarmTrigger() {
        if(!isIgnore) {
            if (isAlarm()) {
                alarm.setAlarmState(alarm, new TriggerState(alarm));
                System.out.println("TRIGGER !");
            }
        }
    }
}
