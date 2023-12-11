import java.util.HashMap;
import java.util.Map;

public class MyString {
    private final String value;

    public MyString(String value) {
        this.value = value;
    }

    //a. Tính tổng bảng mã ASCCI của các ký tự trong chuỗi.
    public int calculationAsciiSum() {
        int sum = 0;
        for (char c : value.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    //b. Tính tổng bảng mã ASSI của các ký tự in hoa trong chuỗi.
    public int calculationUpperCaseAsciiSum() {
        int sum = 0;
        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sum += c;
            }
        }
        return sum;
    }

    //c. Liệt kê các ký tự có trong chuỗi có cùng số lần xuất hiện và số lần xuất hiện đó nhiều hơn n lần. n là một prameter của method (phân biệt ký tự hoa và thường)
    public void listCharactersWithOccurrences(int n) {
        Map<Character, Integer> charOccurrences = new HashMap<>();
        for (char c : value.toCharArray()) {
            char lowerC = Character.toLowerCase(c);
            if (Character.isLetter(lowerC)) {
                charOccurrences.put(lowerC, charOccurrences.getOrDefault(lowerC, 0) + 1);
            }
        }
        charOccurrences.forEach((character, occurrences) -> {
            if (occurrences > n) {
                System.out.println("'" + character + "': " + occurrences);
            }
        });
    }

    //d. Cho hai chuỗi s1 và s2, tìm chuỗi con dài nhất có trong s1 và s2.
    public static String findLongestCommonSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}