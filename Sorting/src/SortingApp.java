public class SortingApp {
    public static void main(String[] args) {

        int[] dataAleatorio100 = SortingUtils.loadCSV("data/aleatorio_100.csv");
        int[] dataAleatorio1000 = SortingUtils.loadCSV("data/aleatorio_1000.csv");
        int[] dataAleatorio10000 = SortingUtils.loadCSV("data/aleatorio_10000.csv");

        int[] dataCrescente100 = SortingUtils.loadCSV("data/crescente_100.csv");
        int[] dataCrescente1000 = SortingUtils.loadCSV("data/crescente_1000.csv");
        int[] dataCrescente10000 = SortingUtils.loadCSV("data/crescente_10000.csv");

        int[] dataDecrescente100 = SortingUtils.loadCSV("data/decrescente_100.csv");
        int[] dataDecrescente1000 = SortingUtils.loadCSV("data/decrescente_1000.csv");
        int[] dataDecrescente10000 = SortingUtils.loadCSV("data/decrescente_10000.csv");

        System.out.println("===== Resultados dos Algoritmos de Ordenação =====\n");

        System.out.println("Conjunto Aleatório:");
        printSortResults("Aleatório 100", dataAleatorio100);
        printSortResults("Aleatório 1000", dataAleatorio1000);
        printSortResults("Aleatório 10000", dataAleatorio10000);

        System.out.println("\nConjunto Crescente:");
        printSortResults("Crescente 100", dataCrescente100);
        printSortResults("Crescente 1000", dataCrescente1000);
        printSortResults("Crescente 10000", dataCrescente10000);

        System.out.println("\nConjunto Decrescente:");
        printSortResults("Decrescente 100", dataDecrescente100);
        printSortResults("Decrescente 1000", dataDecrescente1000);
        printSortResults("Decrescente 10000", dataDecrescente10000);
    }

    private static void printSortResults(String datasetLabel, int[] data) {
        System.out.println("  " + datasetLabel + ":");

        measureAndPrintTime("Bubble Sort", SortingUtils::bubbleSort, data);
        measureAndPrintTime("Insertion Sort", SortingUtils::insertionSort, data);
        measureAndPrintTime("Quick Sort", arr -> SortingUtils.quickSort(arr, 0, arr.length - 1), data);

        System.out.println();
    }

    private static void measureAndPrintTime(String algorithmName, SortingUtils.SortingAlgorithm algorithm, int[] data) {
        int[] dataCopy = data.clone();
        long startTime = System.nanoTime();
        algorithm.sort(dataCopy);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.printf("    %-15s demorou: %d nanosegundos%n", algorithmName, duration);
    }
}
