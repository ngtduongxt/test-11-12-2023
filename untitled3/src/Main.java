public class Main {
    public static void main(String[] args) {
        MyString myString = new MyString("Hello programers. Im Developer");

        System.out.println("Total ASCII encoding of the string: " + myString.calculationAsciiSum());

        System.out.println("Total ASCII encoding of uppercase characters in the string: " + myString.calculationUpperCaseAsciiSum());

        myString.listCharactersWithOccurrences(2);

        String s1 = "abcabc";
        String s2 = "bcaabc";
        System.out.println("Longest substring: " + MyString.findLongestCommonSubstring(s1, s2));
    }
}
