package ru.skillbox.components;

import ru.skillbox.components.enums.ProcessorVendor;

public class Processor {
    private final int frequency;
    private final int coreNumber;
    private final ProcessorVendor vendor;
    private final double weight;

    public Processor(int frequency, int coreNumber, ProcessorVendor vendor, double weight) {
        this.frequency = frequency;
        this.coreNumber = coreNumber;
        this.vendor = vendor;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public ProcessorVendor getVendor() {
        return vendor;
    }

    public double getWeight() {
        return weight;
    }
}
