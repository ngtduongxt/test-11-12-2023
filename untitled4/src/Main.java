public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 1, 3, 4, 5, 4, 5, 9, 7, 0, 11, 13, 10, 23};
        ArrIntManager manager = new ArrIntManager(arr);

        System.out.println("Sum of the array: " + manager.calculateSum());
        System.out.println("Sum of prime numbers: " + manager.calculatePrimeSum());

        System.out.println("Consecutive triplets:");
        manager.findAndPrintConsecutiveTriplets();
    }
}
