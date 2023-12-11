import java.util.ArrayList;
import java.util.List;

class ManagerInt {
    private final int[] m;
    private final int n;

    public ManagerInt(int[] m, int n) {
        this.m = m;
        this.n = n;
    }

    public void findAndPrintSubsets() {
        List<List<Integer>> result = new ArrayList<>();
        findSubarrays(0, new ArrayList<>(), result);

        if (result.isEmpty()) {
            System.out.println("There is no subsequence with equal sum " + n);
        } else {
            for (List<Integer> subarray : result) {
                printSubset(subarray, n);
            }
        }
    }

    private void findSubarrays(int index, List<Integer> current, List<List<Integer>> result) {
        if (index == m.length) {
            int sum = calculateSum(current);
            if (sum == n && !current.isEmpty()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(m[index]);
        findSubarrays(index + 1, current, result);
        current.remove(current.size() - 1);

        findSubarrays(index + 1, current, result);
    }

    private int calculateSum(List<Integer> subarray) {
        int sum = 0;
        for (int num : subarray) {
            sum += num;
        }
        return sum;
    }

    private void printSubset(List<Integer> subarray, int target) {
        System.out.print("N = " + target + " = ");
        for (int i = 0; i < subarray.size(); i++) {
            System.out.print(subarray.get(i));
            if (i < subarray.size() - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }
}