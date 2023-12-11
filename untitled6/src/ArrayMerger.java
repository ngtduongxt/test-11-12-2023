class ArrayMerger {
    private int[] ar1;
    private int[] ar2;

    public ArrayMerger(int[] ar1, int[] ar2) {
        this.ar1 = ar1;
        this.ar2 = ar2;
    }

    public int findMedian() {
        int m = ar1.length;
        int n = ar2.length;

        if (m > n) {
            int[] temp = ar1;
            ar1 = ar2;
            ar2 = temp;

            int tempSize = m;
            m = n;
            n = tempSize;
        }

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionAr1 = (low + high) / 2;
            int partitionAr2 = (m + n + 1) / 2 - partitionAr1;

            int maxLeftAr1 = (partitionAr1 == 0) ? Integer.MIN_VALUE : ar1[partitionAr1 - 1];
            int minRightAr1 = (partitionAr1 == m) ? Integer.MAX_VALUE : ar1[partitionAr1];

            int maxLeftAr2 = (partitionAr2 == 0) ? Integer.MIN_VALUE : ar2[partitionAr2 - 1];
            int minRightAr2 = (partitionAr2 == n) ? Integer.MAX_VALUE : ar2[partitionAr2];

            if (maxLeftAr1 <= minRightAr2 && maxLeftAr2 <= minRightAr1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftAr1, maxLeftAr2) + Math.min(minRightAr1, minRightAr2)) / 2;
                } else {
                    return Math.max(maxLeftAr1, maxLeftAr2);
                }
            } else if (maxLeftAr1 > minRightAr2) {
                high = partitionAr1 - 1;
            } else {
                low = partitionAr1 + 1;
            }
        }

        throw new IllegalArgumentException("Arrays are not sorted");
    }
}