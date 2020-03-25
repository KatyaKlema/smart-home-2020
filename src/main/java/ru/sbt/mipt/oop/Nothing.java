package ru.sbt.mipt.oop;

public class Nothing implements Instruction {
    @Override
    public void execute() {
        System.out.print("Nothing");
    }

}
