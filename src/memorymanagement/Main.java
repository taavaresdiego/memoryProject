package memorymanagement;

import model.MemoryManager;
import model.Process;
import util.ScreenUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoryManager mm = new MemoryManager();
        int strategy = 0, menu = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique a estratégia a ser utilizada:\n"
                + "0 - FirstFit\n"
                + "1 - BestFit\n"
                + "2 - WorstFit\n");

        strategy = scanner.nextInt();
        mm.setStrategy(strategy);
        ScreenUtil.clearScreen();

        // Main menu loop
        while (menu != 0) {
            System.out.println("O que deseja?\n"
                    + "1 - Escrever um novo processo\n"
                    + "2 - Apagar um processo\n"
                    + "3 - Ler a memória\n"
                    + "0 - Sair\n");

            menu = scanner.nextInt();
            ScreenUtil.clearScreen();

            switch (menu) {
                case 1:
                    System.out.println("Informe o tamanho do processo a ser criado:\n");
                    int processSize = scanner.nextInt();
                    Execute.createAndWriteProcess(mm, processSize);
                    break;

                case 2:
                    System.out.println("Qual processo deseja apagar?\n");
                    int processId = scanner.nextInt();
                    Execute.deleteProcess(mm, processId);
                    ScreenUtil.clearScreen();
                    break;

                case 3:
                    int[] memory = mm.getPhysicalMemory();
                    List<Process> registeredProcesses = mm.getRegisteredProcesses();

                    // Imprime a memória
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 16; j++) {
                            System.out.print(memory[i * 16 + j] + ", ");
                        }
                        System.out.println();
                    }

                    // Imprime os processos registrados
                    System.out.println("\nProcessos Registrados:");
                    for (Process process : registeredProcesses) {
                        System.out.println("ID: " + process.getId() + ", Tamanho: " + process.getSizeInMemory());
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
