package memorymanagement;

import model.MemoryManager;
import model.Process;
import util.ScreenUtil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoryManager mm = new MemoryManager();
        boolean fitInMemory = true;
        int[] memory;
        int strategy = 0, menu = 1, processId = 1;
        Random rand = new Random();

        // Process objects creation
        Process p1 = new Process(1, 0);
        Process p2 = new Process(2, 1);
        Process p3 = new Process(3, 2);
        Process p4 = new Process(4, 3);
        Process p5 = new Process(5, 4);
        Process p6 = new Process(6, 5);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique a estrategia a ser utilizada:\n"
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
                    + "3 - Ler a memoria\n"
                    + "0 - Sair\n");

            menu = scanner.nextInt();
            ScreenUtil.clearScreen();

            switch (menu) {
                case 1:
                    System.out.println("Qual processo deseja escrever?\n");
                    System.out.println("Process \t Size\n"
                            + "1 \t\t " + p1.getSizeInMemory() + "\n"
                            + "2 \t\t " + p2.getSizeInMemory() + "\n"
                            + "3 \t\t " + p3.getSizeInMemory() + "\n"
                            + "4 \t\t " + p4.getSizeInMemory() + "\n"
                            + "5 \t\t " + p5.getSizeInMemory() + "\n"
                            + "6 \t\t " + p6.getSizeInMemory() + "\n");


                    processId = scanner.nextInt();
                    switch (processId) {
                        case 1:
                            fitInMemory = mm.write(p1);
                            break;
                        case 2:
                            fitInMemory = mm.write(p2);
                            break;
                        case 3:
                            fitInMemory = mm.write(p3);
                            break;
                        case 4:
                            fitInMemory = mm.write(p4);
                            break;
                        case 5:
                            fitInMemory = mm.write(p5);
                            break;
                        case 6:
                            fitInMemory = mm.write(p6);
                            break;

                    }
                    ScreenUtil.clearScreen();
                    if (!fitInMemory){
                        System.out.println("O processo não coube na memória! \n\n");
                    }
                    break;

                case 2:
                    System.out.println("Qual processo deseja apagar?\n");
                    processId = scanner.nextInt();
                    switch (processId) {
                        case 1:
                            mm.deleteProcess(p1);
                            break;
                        case 2:
                            mm.deleteProcess(p2);
                            break;
                        case 3:
                            mm.deleteProcess(p3);
                            break;
                        case 4:
                            mm.deleteProcess(p4);
                            break;
                        case 5:
                            mm.deleteProcess(p5);
                            break;
                        case 6:
                            mm.deleteProcess(p6);
                            break;

                    }
                    ScreenUtil.clearScreen();
                    break;

                case 3:
                    memory = mm.getPhysicalMemory();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 16; j++) {
                            System.out.print(memory[i * 16 + j] + ", ");
                        }
                        System.out.println();
                    }
                    System.out.println("\n");
                    System.out.println("Process \t Size\n"
                            + "1 \t\t " + p1.getSizeInMemory() + "\n"
                            + "2 \t\t " + p2.getSizeInMemory() + "\n"
                            + "3 \t\t " + p3.getSizeInMemory() + "\n"
                            + "4 \t\t " + p4.getSizeInMemory() + "\n"+
                            "5 \t\t " + p5.getSizeInMemory() +
                            "\n"
                            + "6 \t\t " + p6.getSizeInMemory() + "\n");
                    break;
            }
        }
    }
}
