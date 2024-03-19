package model;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private int tamMemory = 128;
    private int[] physicalMemory = new int[tamMemory];
    private int strategy = 0;
    private List<Process> registeredProcesses = new ArrayList<>();

    public void setStrategy(int strategy) {
        this.strategy = strategy;
        for (int i = 0; i < tamMemory; i++) {
            physicalMemory[i] = 0;
        }
    }

    public boolean write(Process p) {
        boolean fitInMemory = true;

        if (strategy == 0)
            fitInMemory = writeWithFirstFit(p);
        if (strategy == 1)
            fitInMemory = writeWithBestFit(p);
        if (strategy == 2)
            fitInMemory = writeWithWorstFit(p);

        if (fitInMemory) {
            registeredProcesses.add(p); // Adiciona o processo à lista de processos registrados
        }

        return fitInMemory;
    }

    public int[] getPhysicalMemory() {
        return physicalMemory;
    }

    public List<Process> getRegisteredProcesses() {
        return registeredProcesses;
    }

    public boolean writeWithFirstFit(Process p) {
        boolean processFitsInSpace = false;
        for (int i = 0; i < tamMemory; i++) {
            if (physicalMemory[i] == 0) {
                int spaceAvailable = 0;
                for (int j = i; j < tamMemory && physicalMemory[j] == 0; j++) {
                    spaceAvailable++;
                }
                if (spaceAvailable >= p.getSizeInMemory()) {
                    // Há espaço contíguo suficiente para alocar o processo
                    for (int k = i; k < i + p.getSizeInMemory(); k++) {
                        physicalMemory[k] = p.getId();
                    }
                    processFitsInSpace = true;
                    break;
                }
            }
        }
        return processFitsInSpace;
    }

    public boolean writeWithBestFit(Process p) {
        boolean oneProcessFit = false;
        int countReal = tamMemory;
        int indice_bestFit = 0;

        for (int i = tamMemory - 1; i >= 0; i--) {
            boolean processFitsInSpace = true;
            if (physicalMemory[i] == 0 && (i - p.getSizeInMemory() + 1) >= 0) {
                for (int j = i; j > i - p.getSizeInMemory(); j--)
                    if (physicalMemory[j] != 0) {
                        processFitsInSpace = false;
                        break;
                    }

                if (processFitsInSpace) {
                    int countR = 0;
                    int countL = 0;

                    // Verifica espaço vazio à direita
                    while ((i + countR) < tamMemory && physicalMemory[i + countR] == 0)
                        countR++;

                    // Verifica espaço vazio à esquerda
                    while ((i - p.getSizeInMemory() - countL) >= 0 && physicalMemory[i - p.getSizeInMemory() - countL] == 0)
                        countL++;

                    // Calcula espaço total disponível
                    int totalSpace = countR + countL;

                    if (totalSpace <= countReal) {
                        countReal = totalSpace;
                        indice_bestFit = i;
                        oneProcessFit = true;
                    }
                }
            }

        }

        if (oneProcessFit)
            for (int k = indice_bestFit; k > indice_bestFit - p.getSizeInMemory(); k--)
                physicalMemory[k] = p.getId();

        return oneProcessFit;
    }

    public boolean writeWithWorstFit(Process p) {
        boolean oneProcessFit = false;
        int countReal = 0;
        int indice_bestFit = 0;

        for (int i = tamMemory - 1; i >= 0; i--) {
            boolean processFitsInSpace = true;
            if (physicalMemory[i] == 0 && (i - p.getSizeInMemory() + 1) >= 0) {
                for (int j = i; j > i - p.getSizeInMemory(); j--)
                    if (physicalMemory[j] != 0) {
                        processFitsInSpace = false;
                        break;
                    }

                if (processFitsInSpace) {
                    int countR = 0;
                    int countL = 0;

                    // Verifica espaço vazio à direita
                    while ((i + countR) < tamMemory && physicalMemory[i + countR] == 0)
                        countR++;

                    // Verifica espaço vazio à esquerda
                    while ((i - p.getSizeInMemory() - countL) >= 0 && physicalMemory[i - p.getSizeInMemory() - countL] == 0)
                        countL++;
                    // Calcula espaço total disponível
                    int totalSpace = countR + countL;

                    if (totalSpace >= countReal) {
                        countReal = totalSpace;
                        indice_bestFit = i;
                        oneProcessFit = true;
                    }
                }
            }
        }

        if (oneProcessFit)
            for (int k = indice_bestFit; k > indice_bestFit - p.getSizeInMemory(); k--)
                physicalMemory[k] = p.getId();
        return oneProcessFit;
    }

    public void deleteProcess(Process p) {
        int id = p.getId();
        for (int i = 0; i < tamMemory; i++)
            if (physicalMemory[i] == id)
                physicalMemory[i] = 0;

        registeredProcesses.removeIf(process -> process.getId() == id); // Remove o processo da lista de processos registrados
    }

}