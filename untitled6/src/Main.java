public class Main {

    public static void main(String[] args) {
        int[] ar1 = {1, 2, 5, 7, 8};
        int[] ar2 = {3, 4, 6};

        ArrayMerger arrayMerger = new ArrayMerger(ar1, ar2);
        int median = arrayMerger.findMedian();

        System.out.println("The median element is: " + median);
    }
}