package model;

public class MemoryManager {

   private int tamMemory = 128;
    private int[] physicalMemory = new int[tamMemory];
    private int strategy = 0;

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

        return fitInMemory;
    }

    public int[] getPhysicalMemory() {
        return physicalMemory;
    }

    public boolean writeWithFirstFit(Process p) {
        boolean processFitsInSpace = true;
        for (int i = 0; i < tamMemory; i++) {
            if (physicalMemory[i] == 0) {
                processFitsInSpace = true;
                for (int j = i; j < i + p.getSizeInMemory() -1 && j < tamMemory; j++)
                    if (physicalMemory[j] != 0 || j == tamMemory -1){
                        processFitsInSpace = false;
                        break;
                    }


                if (processFitsInSpace) {
                    for (int k = i; k < i + p.getSizeInMemory(); k++)
                        physicalMemory[k] = p.getId();
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

        for(int i = tamMemory - 1; i >= 0; i--) {
            boolean processFitsInSpace = true;
            if(physicalMemory[i] == 0 && (i - p.getSizeInMemory() + 1 ) >= 0) {
                for(int j = i; j > i - p.getSizeInMemory(); j--)
                    if(physicalMemory[j] != 0) {
                        processFitsInSpace = false;
                        break;
                    }

                if(processFitsInSpace) {
                    int countR = 0;
                    int countL = 0;

                    // Verifica espaço vazio à direita
                    while((i + countR) < tamMemory && physicalMemory[i + countR] == 0)
                        countR++;

                    // Verifica espaço vazio à esquerda
                    while((i - p.getSizeInMemory() - countL) >= 0 && physicalMemory[i - p.getSizeInMemory() - countL] == 0)
                        countL++;

                    // Calcula espaço total disponível
                    int totalSpace = countR + countL;

                    if(totalSpace <= countReal) {
                        countReal = totalSpace;
                        indice_bestFit = i;
                        oneProcessFit = true;
                    }
                }
            }

        }

        if(oneProcessFit)
            for(int k = indice_bestFit; k > indice_bestFit - p.getSizeInMemory(); k--)
                physicalMemory[k] = p.getId();

        return oneProcessFit;
    }


    public boolean writeWithWorstFit(Process p) {
        boolean oneProcessFit = false;
        int countReal = 0;
        int indice_bestFit = 0;

        for(int i = tamMemory -1 ; i >= 0; i--) {
            boolean processFitsInSpace = true;
            if(physicalMemory[i] == 0 && (i - p.getSizeInMemory() + 1 ) >= 0) {
                for(int j = i; j > i - p.getSizeInMemory(); j--)
                    if(physicalMemory[j] != 0) {
                        processFitsInSpace = false;
                        break;
                    }

                if(processFitsInSpace) {
                    int countR = 0;
                    int countL = 0;

                    // Verifica espaço vazio à direita
                    while((i + countR) < tamMemory && physicalMemory[i + countR] == 0)
                        countR++;

                    // Verifica espaço vazio à esquerda
                    while((i - p.getSizeInMemory() - countL) >= 0 && physicalMemory[i - p.getSizeInMemory() - countL] == 0)
                        countL++;

                    // Calcula espaço total disponível
                    int totalSpace = countR + countL;

                    if(totalSpace >= countReal) {
                        countReal = totalSpace;
                        indice_bestFit = i;
                        oneProcessFit = true;
                    }
                }
            }
        }

        if(oneProcessFit)
            for(int k = indice_bestFit; k > indice_bestFit - p.getSizeInMemory(); k--)
                physicalMemory[k] = p.getId();
        return oneProcessFit;
    }


    public void deleteProcess(Process p) {
        int id = p.getId();
        for (int i = 0; i < tamMemory; i++)
            if (physicalMemory[i] == id)
                physicalMemory[i] = 0;
    }
}
