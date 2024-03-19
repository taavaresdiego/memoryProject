package model;

public class Process {
    private final int id;
    private final int sizeInMemory;

    public Process(int id, int sizeInMemory) {
        this.id = id;
        this.sizeInMemory = sizeInMemory;
    }

    public int getId() {
        return id;
    }

    public int getSizeInMemory() {
        return sizeInMemory;
    }
}