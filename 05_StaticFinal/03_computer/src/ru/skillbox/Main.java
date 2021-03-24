package ru.skillbox;

import ru.skillbox.components.*;
import ru.skillbox.components.enums.*;

public class Main {

    public static void main(String[] args) {
        Processor processorFirst = new Processor(2000, 4, ProcessorVendor.INTEL, 50);
        Processor processorSecond = new Processor(1800, 4, ProcessorVendor.INTEL, 48);
        Processor processorThird = new Processor(2200, 4, ProcessorVendor.AMD, 60);

        Memory memoryFirst = new Memory(MemoryType.DDR5, 8, 30);
        Memory memorySecond = new Memory(MemoryType.DDR4, 8, 40);
        Memory memoryThird = new Memory(MemoryType.DDR2, 4, 70);

        HardDrive hardDriveFirst = new HardDrive(HardDriveType.SDD, 240, 300);
        HardDrive hardDriveSecond = new HardDrive(HardDriveType.SDD, 360, 400);
        HardDrive hardDriveThird = new HardDrive(HardDriveType.HDD, 1000, 900);

        Screen screenFirst = new Screen(18, ScreenType.IPS, 1200);
        Screen screenSecond = new Screen(15.6, ScreenType.IPS, 900);
        Screen screenThird = new Screen(14, ScreenType.TN, 1000);

        Keyboard keyboardFirst = new Keyboard(KeyboardType.MECHANIC, Backlight.YES, 1200);
        Keyboard keyboardSecond = new Keyboard(KeyboardType.SLIM, Backlight.NO, 600);
        Keyboard keyboardThird = new Keyboard(KeyboardType.SLIM, Backlight.NO,600);

        Computer computerFirst = new Computer("Asus", "First");
        computerFirst.setProcessor(processorFirst);
        computerFirst.setMemory(memoryFirst);
        computerFirst.setHardDrive(hardDriveFirst);
        computerFirst.setScreen(screenFirst);
        computerFirst.setKeyboard(keyboardFirst);

        Computer computerSecond = new Computer("Acer", "Second");
        computerSecond.setProcessor(processorSecond);
        computerSecond.setMemory(memorySecond);
        computerSecond.setHardDrive(hardDriveSecond);
        computerSecond.setScreen(screenSecond);
        computerSecond.setKeyboard(keyboardThird);

        Computer computerThird = new Computer("HP", "Third");
        computerThird.setProcessor(processorThird);
        computerThird.setMemory(memoryThird);
        computerThird.setHardDrive(hardDriveThird);
        computerThird.setScreen(screenThird);
        computerThird.setKeyboard(keyboardThird);

        System.out.println(computerFirst);
        System.out.println(computerSecond);
        System.out.println(computerThird);
    }
}
