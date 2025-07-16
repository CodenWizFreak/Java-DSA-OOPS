public class LinearSearchString {
    public static int linearSearchChar(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i; // Found target character at index i
            }
        }
        return -1; // Character not found
    }

    public static void main(String[] args) {
        String name = "Ananyo";
        char target = 'y';
        int index = linearSearchChar(name, target);
        System.out.println("Character found at index: " + index);
    }
}
