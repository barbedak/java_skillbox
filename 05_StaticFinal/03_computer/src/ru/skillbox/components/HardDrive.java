package ru.skillbox.components;

import ru.skillbox.components.enums.HardDriveType;

public class HardDrive {
    private final HardDriveType type;
    private final int volume;
    private final double weight;

    public HardDrive(HardDriveType type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public HardDriveType getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
