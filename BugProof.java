import java.util.*;

/**
 * BugProof.java  —  run with:  java tools/BugProof.java
 *
 * Reproduces every "verified" bug claimed in the Java Revision Book.
 * These are COPIES of your logic (your original files are untouched).
 * Read the printed output next to COMMON_MISTAKES.md.
 */
public class BugProof {

    // ---------- Second largest ----------
    // Day 10/12/14/15 template (loop starts at i = 2)
    static int secondL(int arr[]) {
        int second, largest;
        if (arr[0] > arr[1]) { largest = arr[0]; second = arr[1]; }
        else { largest = arr[1]; second = arr[0]; }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) { second = largest; largest = arr[i]; }
            else if (arr[i] > second) { second = arr[i]; }
        }
        return second;
    }

    // Day 13 variant (loop starts at i = 0)  -> latent bug
    static int secondL_day13(int arr[]) {
        int second, largest;
        if (arr[0] > arr[1]) { largest = arr[0]; second = arr[1]; }
        else { largest = arr[1]; second = arr[0]; }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) { second = largest; largest = arr[i]; }
            else if (arr[i] > second) { second = arr[i]; }
        }
        return second;
    }

    // Day 23 commented attempt: second = arr[0], skips "!= largest" correctly only sometimes
    static int secondLargest_day23(int arr[]) {
        int larget = arr[0]; int second = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > larget) { second = larget; larget = arr[i]; }
            else if (arr[i] > second && arr[i] != larget) { second = arr[i]; }
        }
        return second;
    }

    // Day 23 ACTIVE secondDistinct -> logic is inverted (works on "smallest")
    static int secondDistinct_day23(int arr[]) {
        int smallest = arr[0]; int second = Integer.MAX_VALUE; boolean secondFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) { second = smallest; smallest = arr[i]; secondFound = true; }
            else if (arr[i] < smallest && arr[i] != smallest) { second = arr[i]; secondFound = true; } // unreachable
        }
        if (!secondFound) return -1;
        return second;
    }

    // Day 25 corrected version (was commented out in your file)
    static int secondDistinct_day25(int arr[]) {
        int largest = arr[0]; int second = Integer.MIN_VALUE; boolean secondFound = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) { second = largest; largest = arr[i]; secondFound = true; }
            else if (arr[i] > second && arr[i] < largest) { second = arr[i]; secondFound = true; }
        }
        if (!secondFound) return -1;
        return second;
    }

    // ---------- Day 27 firstLast ----------
    static int[] firstLast(int arr[], int target) {
        int firstIndex = -1, lastIndex = -1; int ar[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (firstIndex == -1) firstIndex = i;
                lastIndex = i;
                ar[0] = firstIndex; ar[1] = lastIndex;
            }
        }
        return ar;   // not found -> {0,0}  (should be {-1,-1})
    }

    // ---------- Day 28 binary search (your exact algorithm) ----------
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

    static String p(int[] a) { return Arrays.toString(a); }

    public static void main(String[] args) {
        System.out.println("=== 1. Day 13: secondL with i=0  vs  template i=2 ===");
        for (int[] t : new int[][]{{10,32,42,543,2344,13,3222,5,432,3221}, {50,10,20}, {32,10,20,5}})
            System.out.println(p(t) + "  i=0 -> " + secondL_day13(t) + "   i=2 -> " + secondL(t));

        System.out.println("\n=== 2. Day 23 commented secondLargest ===");
        for (int[] t : new int[][]{{10,32,10,32,35,35,10}, {50,10,20}, {10,10,5}})
            System.out.println(p(t) + " -> " + secondLargest_day23(t));

        System.out.println("\n=== 3. Day 23 ACTIVE secondDistinct (wrong) vs Day 25 (correct) ===");
        for (int[] t : new int[][]{{3,3,3,3,3}, {10,20,30}, {30,20,10}, {10,32,10,32,35,35,10}, {10,120,10,10,10}})
            System.out.println(p(t) + "  day23 -> " + secondDistinct_day23(t) + "   day25 -> " + secondDistinct_day25(t));

        System.out.println("\n=== 4. Day 27 firstLast ===");
        System.out.println("found 30      : " + p(firstLast(new int[]{10,20,30,49,30,30,20,30}, 30)));
        System.out.println("NOT found 99  : " + p(firstLast(new int[]{10,20,30}, 99)) + "   <-- should be [-1, -1]");

        System.out.println("\n=== 5. Day 28 binarySearch on your UNSORTED test array ===");
        int[] bad = {10, 20, 42, 10, 49, 38};
        for (int x : bad) System.out.println("search " + x + " -> " + binarySearch(bad, x) + (x == 38 ? "   <-- 38 IS at index 5 but result is -1" : ""));
        System.out.println("-- same algorithm on a SORTED array --");
        int[] good = {10,20,30,40,50,60,70};
        for (int x : new int[]{10, 40, 70, 35, 99}) System.out.println("search " + x + " -> " + binarySearch(good, x));

        System.out.println("\n=== 6. Scanner newline trap (Day 22 addStudent) ===");
        Scanner sc = new Scanner("1\nRahul\n80\n");
        int choice = sc.nextInt();
        String name = sc.nextLine();
        System.out.println("name read = [" + name + "]   <-- empty: leftover newline was consumed");

        System.out.println("\n=== 7. switch1: case '*' has no break ===");
        char op = '*'; int a = 3, b = 4;
        switch (op) {
            case '+': System.out.println("SUM"); break;
            case '*': System.out.println("MUL : " + (a * b));      // no break
            default:  System.out.println("Invalid operation");     // also runs!
        }

        System.out.println("\n=== 8. pluseven: num % 2 instead of i % 2 ===");
        for (int num : new int[]{10, 9}) {
            int sum = 0;
            for (int i = 0; i <= num; i++) if (num % 2 == 0) sum += i;   // bug
            System.out.println("num=" + num + " -> " + sum + "   (evens sum should be " + (num == 10 ? 30 : 20) + ")");
        }

        System.out.println("\n=== 9. Factorial overflow ===");
        int f = 1; for (int i = 1; i <= 13; i++) f *= i;
        System.out.println("int  13! = " + f + "   (real: 6227020800)");
        long lf = 1; for (int i = 1; i <= 21; i++) lf *= i;
        System.out.println("long 21! = " + lf + "   (overflowed)");

        System.out.println("\n=== 10. Digit loops assume num > 0 ===");
        int n = 0, count = 0; while (n > 0) { n /= 10; count++; }
        System.out.println("count1 style on 0 -> " + count + " digits (should be 1)");
        int smallest = 9; n = 0; while (n > 0) { }
        System.out.println("smallestDigit(0)   -> " + smallest + " (should be 0)");

        System.out.println("\n=== 11. project1: integer division in percentage ===");
        int total = 250;
        double wrong = total * 100 / 300;          // int math first
        double right = total * 100.0 / 300;
        System.out.println("wrong = " + wrong + "   right = " + right);
    }
}
