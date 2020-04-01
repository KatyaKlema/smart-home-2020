package ru.sbt.mipt.oop.remote_instructions;

public class Nothing implements Instruction {
    @Override
    public void execute() {
        System.out.print("Nothing");
    }

}
