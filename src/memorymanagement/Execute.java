package memorymanagement;

import model.MemoryManager;
import model.Process;

public class Execute {
    private static int lastProcessId = 0;

    public static void createAndWriteProcess(MemoryManager mm, int processSize) {
        lastProcessId++; // Incrementa o ID do processo
        Process newProcess = new Process(lastProcessId, processSize);
        boolean fitInMemory = mm.write(newProcess);
        if (!fitInMemory) {
            System.out.println("O processo não coube na memória! \n\n");
        }
    }

    public static void deleteProcess(MemoryManager mm, int processId) {
        boolean processFound = false;
        int[] physicalMemory = mm.getPhysicalMemory();
        for (int i = 0; i < physicalMemory.length; i++) {
            if (physicalMemory[i] == processId) {
                // Encontrou o processo com o ID correspondente, agora apaga
                mm.deleteProcess(new Process(processId, 0)); // Criamos um novo processo apenas com o ID
                processFound = true;
                break; // Não precisamos continuar procurando
            }
        }
        if (!processFound) {
            System.out.println("Processo com o ID " + processId + " não encontrado na memória.");
        }
    }
}
