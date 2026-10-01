import java.util.*;

/** Runs every solution from BLANK_PAGE_ANSWERS.md against tests.  java tools/AnswersCheck.java */
public class AnswersCheck {
    static int fails = 0;
    static void check(String name, Object got, Object want) {
        String g = got instanceof int[] ? Arrays.toString((int[]) got) : String.valueOf(got);
        String w = want instanceof int[] ? Arrays.toString((int[]) want) : String.valueOf(want);
        boolean ok = g.equals(w);
        if (!ok) fails++;
        System.out.println((ok ? "PASS " : "FAIL ") + name + " -> " + g + (ok ? "" : "   (want " + w + ")"));
    }

    // ---------- L1 ----------
    static int countEven(int arr[]) { int c = 0; for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) c++; return c; }
    static int findMax(int arr[]) { int largest = arr[0]; for (int i = 1; i < arr.length; i++) if (arr[i] > largest) largest = arr[i]; return largest; }
    static int index(int arr[], int target) { for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i; return -1; }
    static int sumDigits(int n) { int s = 0; while (n > 0) { s += n % 10; n /= 10; } return s; }
    static int reverseNum(int n) { int rev = 0; while (n > 0) { rev = rev * 10 + n % 10; n /= 10; } return rev; }
    static boolean isPalindromeNum(int n) { return n == reverseNum(n); }
    static void reverse(int arr[]) { int i = 0, j = arr.length - 1; while (i < j) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; i++; j--; } }
    static int countChar(String s, char c) { int n = 0; for (int i = 0; i < s.length(); i++) if (s.charAt(i) == c) n++; return n; }

    // ---------- L2 ----------
    static int secondLargest(int arr[]) {
        int largest, second;
        if (arr[0] > arr[1]) { largest = arr[0]; second = arr[1]; } else { largest = arr[1]; second = arr[0]; }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) { second = largest; largest = arr[i]; }
            else if (arr[i] > second) { second = arr[i]; }
        }
        return second;
    }
    static String freqInts(int arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            boolean seen = false;
            for (int j = 0; j < i; j++) if (arr[i] == arr[j]) { seen = true; break; }
            if (seen) continue;
            int c = 0;
            for (int k = 0; k < arr.length; k++) if (arr[k] == arr[i]) c++;
            sb.append(arr[i]).append('>').append(c).append(' ');
        }
        return sb.toString().trim();
    }
    static boolean alreadySeen(String s, int index) {
        for (int j = 0; j < index; j++) if (s.charAt(j) == s.charAt(index)) return true;
        return false;
    }
    static String charFrequency(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (alreadySeen(s, i)) continue;
            sb.append(s.charAt(i)).append('>').append(countChar(s, s.charAt(i))).append(' ');
        }
        return sb.toString().trim();
    }
    static boolean isPalindromeStr(String str) {
        str = str.toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) { if (str.charAt(i) != str.charAt(j)) return false; i++; j--; }
        return true;
    }
    static int lastIndex(int arr[], int target) { int last = -1; for (int i = 0; i < arr.length; i++) if (arr[i] == target) last = i; return last; }
    static boolean sorted(int arr[]) { for (int i = 1; i < arr.length; i++) if (arr[i - 1] > arr[i]) return false; return true; }
    static void moveZero(int arr[]) {
        int pos = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] != 0) { arr[pos] = arr[i]; pos++; }
        for (int i = pos; i < arr.length; i++) arr[i] = 0;
    }
    static int removeDuplicates(int arr[]) {
        if (arr.length == 0) return 0;
        int pos = 1;
        for (int i = 1; i < arr.length; i++) if (arr[i] != arr[i - 1]) { arr[pos] = arr[i]; pos++; }
        return pos;
    }
    static int frequency(int arr[], int t) { int c = 0; for (int i = 0; i < arr.length; i++) if (arr[i] == t) c++; return c; }
    static int mostFrequent(int arr[]) {
        int best = arr[0], bestCount = frequency(arr, arr[0]);
        for (int i = 1; i < arr.length; i++) { int c = frequency(arr, arr[i]); if (c > bestCount) { best = arr[i]; bestCount = c; } }
        return best;
    }
    static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) return middle;
            else if (target > arr[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    // ---------- L3 ----------
    static int secondDistinct(int arr[]) {
        // RULES: 1) bigger than largest -> shift  2) strictly between -> second  3) equal to largest -> ignore
        int largest = arr[0];
        int second = Integer.MIN_VALUE;
        boolean secondFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) { second = largest; largest = arr[i]; secondFound = true; }
            else if (arr[i] > second && arr[i] < largest) { second = arr[i]; secondFound = true; }
        }
        return secondFound ? second : -1;
    }
    static int[] findAllIndex(int arr[], int target) {
        int count = frequency(arr, target);
        int ar[] = new int[count];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) { ar[pos] = i; pos++; }
        return ar;
    }
    static int[] firstLast(int arr[], int target) {
        int first = -1, last = -1;
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) { if (first == -1) first = i; last = i; }
        return new int[]{first, last};
    }
    static String classify(int arr[]) {
        boolean asc = true, desc = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) desc = false;
            else if (arr[i - 1] > arr[i]) asc = false;
        }
        if (asc && !desc) return "ascending";
        if (desc && !asc) return "descending";
        if (asc && desc) return "equal";
        return "neither";
    }
    static String pyramid(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) sb.append(' ');
            for (int j = 1; j <= 2 * i - 1; j++) sb.append('*');
            sb.append('\n');
        }
        return sb.toString();
    }
    static char mostFrequentChar(String s) {
        char best = s.charAt(0); int bestCount = countChar(s, best);
        for (int i = 1; i < s.length(); i++) { int c = countChar(s, s.charAt(i)); if (c > bestCount) { best = s.charAt(i); bestCount = c; } }
        return best;
    }
    static String reverseStr(String s) { String r = ""; for (int i = s.length() - 1; i >= 0; i--) r = r + s.charAt(i); return r; }

    // ---------- L4 ----------
    static void evensFirst(int arr[]) {                         // BP-P08-4 stable: evens first, odds after
        int[] tmp = new int[arr.length]; int pos = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) tmp[pos++] = arr[i];
        for (int i = 0; i < arr.length; i++) if (arr[i] % 2 != 0) tmp[pos++] = arr[i];
        for (int i = 0; i < arr.length; i++) arr[i] = tmp[i];
    }
    static int removeAll(int arr[], int val) {                  // BP-P18-4
        int pos = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] != val) { arr[pos] = arr[i]; pos++; }
        return pos;
    }
    static int thirdDistinct(int arr[]) {                       // BP-P21-4
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long x = arr[i];
            if (x == a || x == b || x == c) continue;           // ignore repeats of tracked values
            if (x > a) { c = b; b = a; a = x; }
            else if (x > b) { c = b; b = x; }
            else if (x > c) { c = x; }
        }
        return c == Long.MIN_VALUE ? -1 : (int) c;
    }
    static int secondSmallestDistinct(int arr[]) {              // BP-P21-5
        int smallest = arr[0]; int second = Integer.MAX_VALUE; boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) { second = smallest; smallest = arr[i]; found = true; }
            else if (arr[i] < second && arr[i] > smallest) { second = arr[i]; found = true; }
        }
        return found ? second : -1;
    }
    static int[] maxAndIndex(int arr[]) {                       // BP-P04-4
        int best = arr[0], idx = 0;
        for (int i = 1; i < arr.length; i++) if (arr[i] > best) { best = arr[i]; idx = i; }
        return new int[]{best, idx};
    }
    static int[] evenIndices(int arr[]) {                       // BP-P13-4
        int count = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) count++;
        int[] r = new int[count]; int pos = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) r[pos++] = i;
        return r;
    }
    static int binarySearchDesc(int arr[], int target) {        // BP-P23-4
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) return middle;
            else if (target < arr[middle]) left = middle + 1;   // flipped
            else right = middle - 1;                            // flipped
        }
        return -1;
    }
    static int insertPosition(int arr[], int target) {          // BP-P23-5  (left ends at the insertion point)
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == arr[middle]) return middle;
            else if (target > arr[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
    static String appearsOnce(String s) {                       // BP-P15-4
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (alreadySeen(s, i)) continue;
            if (countChar(s, s.charAt(i)) == 1) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    static int countWords(String s) {                           // BP-P31-4 : count transitions space -> non-space
        int words = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) words++;
        return words;
    }
    static boolean arrayPalindrome(int arr[]) {                 // BP-P09-4
        int i = 0, j = arr.length - 1;
        while (i < j) { if (arr[i] != arr[j]) return false; i++; j--; }
        return true;
    }
    static boolean sortedDesc(int arr[]) { for (int i = 1; i < arr.length; i++) if (arr[i - 1] < arr[i]) return false; return true; }
    static int countDigitsGreaterThan5(int n) { int c = 0; while (n > 0) { if (n % 10 > 5) c++; n /= 10; } return c; }
    static String hollowPyramid(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) sb.append(' ');
            int width = 2 * i - 1;
            for (int j = 1; j <= width; j++)
                sb.append((j == 1 || j == width || i == n) ? '*' : ' ');
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] a) {
        System.out.println("== L1");
        check("countEven", countEven(new int[]{2,4,5}), 2);
        check("countEven empty", countEven(new int[]{}), 0);
        check("findMax negatives", findMax(new int[]{-5,-2,-9}), -2);
        check("index present", index(new int[]{10,43,32}, 43), 1);
        check("index absent", index(new int[]{10,43,32}, 99), -1);
        check("sumDigits", sumDigits(1234), 10);
        check("reverseNum", reverseNum(123), 321);
        check("isPalindromeNum 121", isPalindromeNum(121), true);
        check("isPalindromeNum 123", isPalindromeNum(123), false);
        int[] r = {1,2,3,4}; reverse(r); check("reverse", r, new int[]{4,3,2,1});
        int[] r2 = {1,2,3}; reverse(r2); check("reverse odd", r2, new int[]{3,2,1});
        check("countChar", countChar("programming", 'g'), 2);

        System.out.println("== L2");
        check("secondLargest {50,10,20}", secondLargest(new int[]{50,10,20}), 20);
        check("secondLargest {10,10,5}", secondLargest(new int[]{10,10,5}), 10);
        check("secondLargest {23,53,14,65,-13,43}", secondLargest(new int[]{23,53,14,65,-13,43}), 53);
        check("freqInts", freqInts(new int[]{5,5,7,5,9,7}), "5>3 7>2 9>1");
        check("charFrequency hello", charFrequency("hello"), "h>1 e>1 l>2 o>1");
        check("charFrequency banana", charFrequency("banana"), "b>1 a>3 n>2");
        check("isPalindromeStr MAdam", isPalindromeStr("MAdam"), true);
        check("isPalindromeStr abca", isPalindromeStr("abca"), false);
        check("lastIndex", lastIndex(new int[]{10,20,10,40,10}, 10), 4);
        check("sorted true", sorted(new int[]{1,2,2,3}), true);
        check("sorted false", sorted(new int[]{1,3,2}), false);
        int[] z = {0,1,0,3,12}; moveZero(z); check("moveZero", z, new int[]{1,3,12,0,0});
        int[] d = {1,1,2,2,3}; check("removeDuplicates len", removeDuplicates(d), 3);
        check("removeDuplicates head", Arrays.copyOf(d, 3), new int[]{1,2,3});
        check("mostFrequent", mostFrequent(new int[]{1,3,3,2,3}), 3);
        int[] sortedArr = {10,20,30,40,50,60,70};
        check("binarySearch 50", binarySearch(sortedArr, 50), 4);
        check("binarySearch 35", binarySearch(sortedArr, 35), -1);
        check("binarySearch 10", binarySearch(sortedArr, 10), 0);
        check("binarySearch 70", binarySearch(sortedArr, 70), 6);

        System.out.println("== L3");
        check("secondDistinct {10,120,10,10,10}", secondDistinct(new int[]{10,120,10,10,10}), 10);
        check("secondDistinct {3,3,3}", secondDistinct(new int[]{3,3,3}), -1);
        check("secondDistinct {10,20,30}", secondDistinct(new int[]{10,20,30}), 20);
        check("secondDistinct {30,20,10}", secondDistinct(new int[]{30,20,10}), 20);
        check("secondDistinct {5}", secondDistinct(new int[]{5}), -1);
        check("secondDistinct {10,32,10,32,35,35,10}", secondDistinct(new int[]{10,32,10,32,35,35,10}), 32);
        check("secondDistinct {50,10,20}", secondDistinct(new int[]{50,10,20}), 20);
        check("findAllIndex", findAllIndex(new int[]{10,20,10,20,10,20,39,43}, 20), new int[]{1,3,5});
        check("findAllIndex absent", findAllIndex(new int[]{1,2}, 9), new int[]{});
        check("firstLast", firstLast(new int[]{10,20,30,49,30,30,20,30}, 30), new int[]{2,7});
        check("firstLast absent", firstLast(new int[]{10,20,30}, 99), new int[]{-1,-1});
        check("classify asc", classify(new int[]{1,2,2,3}), "ascending");
        check("classify desc", classify(new int[]{9,5,5,1}), "descending");
        check("classify equal", classify(new int[]{50,50,50}), "equal");
        check("classify neither", classify(new int[]{1,3,2}), "neither");
        check("pyramid 3", pyramid(3), "  *\n ***\n*****\n");
        check("mostFrequentChar", mostFrequentChar("banana"), 'a');
        check("reverseStr", reverseStr("shubham24"), "42mahbuhs");

        System.out.println("== L4");
        int[] e = {1,2,3,4,5,6}; evensFirst(e); check("evensFirst", e, new int[]{2,4,6,1,3,5});
        int[] ra = {3,2,2,3,4}; int len = removeAll(ra, 3); check("removeAll len", len, 3); check("removeAll head", Arrays.copyOf(ra, len), new int[]{2,2,4});
        check("thirdDistinct", thirdDistinct(new int[]{10,20,20,30,5}), 10);
        check("thirdDistinct none", thirdDistinct(new int[]{10,10,20}), -1);
        check("secondSmallestDistinct", secondSmallestDistinct(new int[]{5,1,1,9,3}), 3);
        check("secondSmallestDistinct none", secondSmallestDistinct(new int[]{4,4,4}), -1);
        check("maxAndIndex", maxAndIndex(new int[]{3,9,2,9}), new int[]{9,1});
        check("evenIndices", evenIndices(new int[]{1,2,3,4,6}), new int[]{1,3,4});
        check("binarySearchDesc", binarySearchDesc(new int[]{70,60,50,40,30}, 50), 2);
        check("insertPosition", insertPosition(new int[]{10,20,30,40}, 35), 3);
        check("insertPosition front", insertPosition(new int[]{10,20,30,40}, 5), 0);
        check("insertPosition end", insertPosition(new int[]{10,20,30,40}, 99), 4);
        check("appearsOnce", appearsOnce("swiss"), "wi");
        check("countWords", countWords("hello bro how are you"), 5);
        check("countWords spaces", countWords("  hi   there "), 2);
        check("arrayPalindrome", arrayPalindrome(new int[]{1,2,3,2,1}), true);
        check("sortedDesc", sortedDesc(new int[]{9,5,5,1}), true);
        check("digits>5", countDigitsGreaterThan5(1672983), 4);
        check("hollowPyramid 4", hollowPyramid(4), "   *\n  * *\n *   *\n*******\n");

        System.out.println(fails == 0 ? "\nALL PASSED" : "\nFAILURES: " + fails);
    }
}
