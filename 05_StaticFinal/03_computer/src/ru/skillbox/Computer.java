package ru.skillbox;

import ru.skillbox.components.*;

public class Computer {
    private final String vendor;
    private final String name;
    private Processor processor;

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    private Memory memory;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    private HardDrive hardDrive;

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    private Screen screen;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private Keyboard keyboard;

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public double getWeightAllComponent(){
        return processor.getWeight() +
                memory.getWeight() +
                hardDrive.getWeight() +
                screen.getWeight() +
                keyboard.getWeight();
    }
    public String toString(){
        return "Computer - " + name +
                "\n\tVendor : " + vendor +
                "\n\tProcessor : " +
                "\n\t\tVendor : " + processor.getVendor() +
                "\n\t\tFrequency : " + processor.getFrequency() +
                "\n\t\tCore Number : " + processor.getCoreNumber() +
                "\n\t\tWeight : " + processor.getWeight() +
                "\n\tMemory : " +
                "\n\t\tVolume : " + memory.getVolume() +
                "\n\t\tType : " + memory.getType() +
                "\n\t\tWeight : " + memory.getWeight() +
                "\n\tHardDrive : " +
                "\n\t\tVolume : " + hardDrive.getVolume() +
                "\n\t\tType : " + hardDrive.getType() +
                "\n\t\tWeight : " + hardDrive.getWeight() +
                "\n\tScreen : " +
                "\n\t\tDiagonal : " + screen.getDiagonal() +
                "\n\t\tType : " + screen.getType() +
                "\n\t\tWeight : " + screen.getWeight() +
                "\n\tKeyboard" +
                "\n\t\tType : " + keyboard.getType() +
                "\n\t\tBacklight : " + keyboard.getBacklight() +
                "\n\t\tWeight : " + keyboard.getWeight();
    }

}
