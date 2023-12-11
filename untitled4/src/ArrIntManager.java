public class ArrIntManager {
    private final int[] arrInt;

    public ArrIntManager(int[] arrInt) {
        this.arrInt = arrInt;
    }

    public int calculateSum() {
        int sum = 0;
        for (int num : arrInt) {
            sum += num;
        }
        return sum;
    }

    public int calculatePrimeSum() {
        int primeSum = 0;
        for (int num : arrInt) {
            if (isPrime(num)) {
                primeSum += num;
            }
        }
        return primeSum;
    }

    public void findAndPrintConsecutiveTriplets() {
        for (int i = 0; i < arrInt.length - 2; i++) {
            if (arrInt[i] + arrInt[i + 1] == arrInt[i + 2]) {
                System.out.println("(" + arrInt[i] + ", " + arrInt[i + 1] + ", " + arrInt[i + 2] + ")");
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //chưa làm được câu E.
}