package dev.matias.utils;

public class Utils {
    public static void clearTerminal() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        System.out.println("Project Running...");
    }
}
