package model;

public class Process {
    private final int[] possibleSizes = {20, 38, 38, 20, 40, 8};
    private final int id;
    private final int sizeInMemory;

    public Process(int id, int sizeInMemory) {
        this.id = id;
        this.sizeInMemory = possibleSizes[sizeInMemory];
    }

    public int getId() {
        return id;
    }

    public int getSizeInMemory() {
        return sizeInMemory;
    }
}