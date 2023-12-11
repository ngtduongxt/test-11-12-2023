public class Main {
    public static void main(String[] args) {
        int[] m = {1, 4, 6, 3, 2, 8, 2};
        int n = 10;

        ManagerInt managerInt = new ManagerInt(m, n);
        managerInt.findAndPrintSubsets();
    }
}