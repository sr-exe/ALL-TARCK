---
title: Blank Page Answers (SPOILERS)
---

[← BLANK_PAGE problems](BLANK_PAGE_RECONSTRUCTION.md) · [INDEX](INDEX.md)

# 🔒 ANSWERS — open only AFTER you tried

> ✅ Every solution below was **compiled and tested** (70 checks pass): `java tools/AnswersCheck.java`.
> Format: **Pattern → Variables → Pseudocode → Java**. Compare *your thinking*, not just your code.
> If you peeked, log it. A peek is data, not shame.

---

## L1

### BP-P03-1 `countEven` — P03
**Variables:** `count`. **Pseudo:** loop all → if even → count++ → return.
```java
static int countEven(int arr[]) {
    int count = 0;
    for (int i = 0; i < arr.length; i++)
        if (arr[i] % 2 == 0) count++;
    return count;
}
```

### BP-P04-1 `findMax` — P04
**Variables:** `largest = arr[0]`. **Pseudo:** assume first → compare rest → update.
```java
static int findMax(int arr[]) {
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++)
        if (arr[i] > largest) largest = arr[i];
    return largest;
}
```

### BP-P05-1 `index` — P05 + P06
```java
static int index(int arr[], int target) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) return i;
    return -1;                       // after the loop
}
```

### BP-P07-1 / P07-2 digits — P07, P24
```java
static int sumDigits(int n) {
    int sum = 0;
    while (n > 0) { sum += n % 10; n /= 10; }
    return sum;
}
static int reverse(int n) {
    int rev = 0;
    while (n > 0) { rev = rev * 10 + n % 10; n /= 10; }
    return rev;
}
static boolean isPalindrome(int n) { return n == reverse(n); }   // method calls method
```

### BP-P09-1 `reverse(arr)` — P09 + P26
```java
static void reverse(int arr[]) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        i++; j--;
    }
}
```

### BP-P31-1 `countChar` — P31
```java
static int countChar(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++)
        if (s.charAt(i) == c) count++;
    return count;
}
```

### BP-P01-1 / BP-P25-1
```java
static int square(int n) { return n * n; }
// main: int r = square(7); System.out.println(r);   // 49
```
```java
int choice;
do {
    System.out.println("1.Sum  2.Reverse  3.Exit");
    choice = sc.nextInt();
    switch (choice) {
        case 1: /* sum */ break;
        case 2: /* reverse */ break;
        case 3: System.out.println("Bye"); break;
        default: System.out.println("Invalid");
    }
} while (choice != 3);
```

---

## L2

### BP-P20-1 `secondLargest` — P20
**Variables:** `largest`, `second` (seeded from first two). **Rule:** loop starts at **2**.
```java
static int secondLargest(int arr[]) {
    int largest, second;
    if (arr[0] > arr[1]) { largest = arr[0]; second = arr[1]; }
    else                 { largest = arr[1]; second = arr[0]; }
    for (int i = 2; i < arr.length; i++) {
        if (arr[i] > largest)      { second = largest; largest = arr[i]; }
        else if (arr[i] > second)  { second = arr[i]; }
    }
    return second;
}
```

### BP-P15-1 / P15-2 `alreadySeen` — P15 + P16
```java
// ints, inline
for (int i = 0; i < arr.length; i++) {
    boolean seen = false;
    for (int j = 0; j < i; j++)               // BACKWARD only
        if (arr[i] == arr[j]) { seen = true; break; }
    if (seen) continue;
    int c = 0;
    for (int k = 0; k < arr.length; k++) if (arr[k] == arr[i]) c++;
    System.out.println(arr[i] + " > " + c);
}
```
```java
// Strings, extracted (your recommended D20/21 shape)
static boolean alreadySeen(String s, int index) {
    for (int j = 0; j < index; j++)
        if (s.charAt(j) == s.charAt(index)) return true;
    return false;
}
static void charFrequency(String s) {
    for (int i = 0; i < s.length(); i++) {
        if (alreadySeen(s, i)) continue;                 // decide FIRST
        System.out.println(s.charAt(i) + " > " + countChar(s, s.charAt(i)));   // count AFTER
    }
}
```
"hello" → `h>1 e>1 l>2 o>1` (second `l` at i=3 is skipped).

### BP-P31-2 palindrome (ignore case) — P09
```java
static boolean isPalindrome(String str) {
    str = str.toLowerCase();
    int i = 0, j = str.length() - 1;
    while (i < j) {
        if (str.charAt(i) != str.charAt(j)) return false;
        i++; j--;
    }
    return true;
}
```

### BP-P12-1 `lastIndex` — P11 (+ firstIndex = P10)
```java
static int lastIndex(int arr[], int target) {
    int last = -1;
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) last = i;      // keep updating
    return last;
}
```

### BP-P17-1 `sorted` — P17
```java
static boolean sorted(int arr[]) {
    for (int i = 1; i < arr.length; i++)
        if (arr[i - 1] > arr[i]) return false;
    return true;
}
```

### BP-P18-1 `moveZero` — P08 + P18
**Variables:** `i` scanner, `pos` writer. **Pseudo:** copy non-zeros forward → fill tail with 0.
```java
static void moveZero(int arr[]) {
    int pos = 0;
    for (int i = 0; i < arr.length; i++)
        if (arr[i] != 0) { arr[pos] = arr[i]; pos++; }
    for (int i = pos; i < arr.length; i++) arr[i] = 0;
}
```

### BP-P19-1 `removeDuplicates` — P19
```java
static int removeDuplicates(int arr[]) {
    if (arr.length == 0) return 0;
    int pos = 1;
    for (int i = 1; i < arr.length; i++)
        if (arr[i] != arr[i - 1]) { arr[pos] = arr[i]; pos++; }
    return pos;
}
```

### BP-P33-1 `mostFrequent` — P33
```java
static int mostFrequent(int arr[]) {
    int best = arr[0];
    int bestCount = frequency(arr, arr[0]);
    for (int i = 1; i < arr.length; i++) {
        int c = frequency(arr, arr[i]);
        if (c > bestCount) { best = arr[i]; bestCount = c; }
    }
    return best;
}
```

### BP-P23-1 / P23-2 `binarySearch` — P23
```java
static int binarySearch(int arr[], int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (target == arr[middle])      return middle;
        else if (target > arr[middle])  left = middle + 1;
        else                            right = middle - 1;
    }
    return -1;
}
```
**Trace (`{10,20,30,40,50,60,70}`)**

| target | round | left | right | mid | arr[mid] | action |
|---|---|---|---|---|---|---|
| 50 | 1 | 0 | 6 | 3 | 40 | `left = 4` |
| 50 | 2 | 4 | 6 | 5 | 60 | `right = 4` |
| 50 | 3 | 4 | 4 | 4 | 50 | **return 4** |
| 35 | 1 | 0 | 6 | 3 | 40 | `right = 2` |
| 35 | 2 | 0 | 2 | 1 | 20 | `left = 2` |
| 35 | 3 | 2 | 2 | 2 | 30 | `left = 3` |
| 35 | — | 3 | 2 | | | stop → **-1** |

---

## L3

### BP-P21-1 / P21-2 `secondDistinct` 🔴 — P21
**Write the rules FIRST:**
```
1. arr[i] >  largest                      → second = largest ; largest = arr[i]
2. arr[i] >  second AND arr[i] < largest  → second = arr[i]
3. arr[i] == largest                      → ignore
```
**Variables:** `largest = arr[0]` · `second = Integer.MIN_VALUE` · `secondFound = false`.
```java
static int secondDistinct(int arr[]) {
    int largest = arr[0];
    int second = Integer.MIN_VALUE;
    boolean secondFound = false;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > largest) {
            second = largest; largest = arr[i]; secondFound = true;
        } else if (arr[i] > second && arr[i] < largest) {
            second = arr[i]; secondFound = true;
        }
    }
    if (!secondFound) return -1;
    return second;
}
```
**Test table (all verified)**

| Input | Expected | Why |
|---|---|---|
| `{10,120,10,10,10}` | 10 | 120 is max, 10 is the only other value |
| `{3,3,3}` | -1 | nothing differs |
| `{10,20,30}` | 20 | 20 shifts when 30 arrives |
| `{30,20,10}` | 20 | 20 hits rule 2 |
| `{5}` | -1 | single value |
| `{50,10,20}` | 20 | the case that broke D23a |

### BP-P13-1 `findAllIndex` — P13
```java
static int[] findAllIndex(int arr[], int target) {
    int count = frequency(arr, target);        // pass 1
    int ar[] = new int[count];                 // exact size
    int pos = 0;
    for (int i = 0; i < arr.length; i++)       // pass 2 over the ORIGINAL
        if (arr[i] == target) { ar[pos] = i; pos++; }   // store the INDEX
    return ar;
}
```

### BP-P12-2 `firstLast` — P12
```java
static int[] firstLast(int arr[], int target) {
    int first = -1, last = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            if (first == -1) first = i;        // once
            last = i;                          // every time
        }
    }
    return new int[]{first, last};             // {-1,-1} when absent
}
```

### BP-P22-1 `classify` — P22
```java
static String classify(int arr[]) {
    boolean asc = true, desc = true;
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > arr[i - 1])      desc = false;
        else if (arr[i - 1] > arr[i]) asc  = false;
    }
    if (asc && !desc) return "ascending";
    if (desc && !asc) return "descending";
    if (asc && desc)  return "equal";
    return "neither";
}
```

### BP-P14-1 students — P14 + P29
```java
static int count = 0;                              // logical size
static void addStudent(Scanner sc, String name[], int marks[]) {
    if (count < name.length) {                     // physical limit
        sc.nextLine();                             // swallow the newline left by nextInt()
        System.out.print("Name: ");  name[count] = sc.nextLine();
        System.out.print("Marks: "); marks[count] = sc.nextInt();
        count++;
    } else System.out.println("No space remaining");
}
static void viewStudents(String name[], int marks[]) {
    for (int i = 0; i < count; i++)                // LOGICAL size
        System.out.println((i + 1) + ": " + name[i] + " - " + marks[i]);
}
```
> Note: this version swallows the newline **before** the name (menu `nextInt()` left it). Your D22 read the name straight after the menu's `nextInt()`, so each name came out as `""` (verified in `BugProof`).

### BP-P24-1 → see L1 (`isPalindrome` calls `reverse`).

### BP-P28-1 pyramid — P28
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n - i; j++) System.out.print(" ");
    for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
    System.out.println();
}
```

### BP-P16-1 most frequent char — P15 + P33
```java
static char mostFrequentChar(String s) {
    char best = s.charAt(0);
    int bestCount = countChar(s, best);
    for (int i = 1; i < s.length(); i++) {
        int c = countChar(s, s.charAt(i));
        if (c > bestCount) { best = s.charAt(i); bestCount = c; }
    }
    return best;
}
```

### BP-P09-2 reverse a String — P34
```java
static String reverseStr(String s) {
    String r = "";
    for (int i = s.length() - 1; i >= 0; i--) r = r + s.charAt(i);
    return r;
}
```

---

## L4 — unseen variations (hints first, then code)

### BP-P08-4 evens first, order kept
💡 *Hint:* two passes writing into a helper array: evens, then odds. (In-place order-preserving is harder — don't force it.)
```java
static void evensFirst(int arr[]) {
    int[] tmp = new int[arr.length];
    int pos = 0;
    for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) tmp[pos++] = arr[i];
    for (int i = 0; i < arr.length; i++) if (arr[i] % 2 != 0) tmp[pos++] = arr[i];
    for (int i = 0; i < arr.length; i++) arr[i] = tmp[i];
}
```
`{1,2,3,4,5,6}` → `{2,4,6,1,3,5}` ✔

### BP-P18-4 remove all occurrences of a value
💡 *Hint:* `moveZero`'s first loop with `!= val`.
```java
static int removeAll(int arr[], int val) {
    int pos = 0;
    for (int i = 0; i < arr.length; i++)
        if (arr[i] != val) { arr[pos] = arr[i]; pos++; }
    return pos;                          // new logical length
}
```

### BP-P21-4 third largest distinct
💡 *Hint:* three boxes; first **skip values already in a box**.
```java
static int thirdDistinct(int arr[]) {
    long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        long x = arr[i];
        if (x == a || x == b || x == c) continue;
        if (x > a)      { c = b; b = a; a = x; }
        else if (x > b) { c = b; b = x; }
        else if (x > c) { c = x; }
    }
    return c == Long.MIN_VALUE ? -1 : (int) c;
}
```
`{10,20,20,30,5}` → 10 ✔ · `{10,10,20}` → -1 ✔ (uses `long` as the "empty" marker so `Integer.MIN_VALUE` data stays safe).

### BP-P21-5 second smallest distinct — mirror every comparison
```java
static int secondSmallestDistinct(int arr[]) {
    int smallest = arr[0], second = Integer.MAX_VALUE;
    boolean found = false;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < smallest) { second = smallest; smallest = arr[i]; found = true; }
        else if (arr[i] < second && arr[i] > smallest) { second = arr[i]; found = true; }
    }
    return found ? second : -1;
}
```
`{5,1,1,9,3}` → 3 ✔ · `{4,4,4}` → -1 ✔. *(This is exactly what D23b tried to be — but D23b only had half the flips.)*

### BP-P04-4 largest and its index
```java
static int[] maxAndIndex(int arr[]) {
    int best = arr[0], idx = 0;
    for (int i = 1; i < arr.length; i++)
        if (arr[i] > best) { best = arr[i]; idx = i; }
    return new int[]{best, idx};
}
```

### BP-P13-4 indices of even elements
```java
static int[] evenIndices(int arr[]) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) count++;
    int[] r = new int[count]; int pos = 0;
    for (int i = 0; i < arr.length; i++) if (arr[i] % 2 == 0) r[pos++] = i;
    return r;
}
```

### BP-P23-4 Binary Search, descending array
💡 flip the two comparisons.
```java
else if (target < arr[middle]) left = middle + 1;   // target is smaller → it's to the RIGHT now
else                           right = middle - 1;
```
`{70,60,50,40,30}`, 50 → 2 ✔

### BP-P23-5 insertion position
💡 when the loop ends, `left` is where the target *would* go.
```java
// same loop; at the end:  return left;      // instead of -1
```
`{10,20,30,40}`, 35 → 3 ✔ · 5 → 0 ✔ · 99 → 4 ✔

### BP-P15-4 characters appearing exactly once
```java
static String appearsOnce(String s) {
    String out = "";
    for (int i = 0; i < s.length(); i++) {
        if (alreadySeen(s, i)) continue;
        if (countChar(s, s.charAt(i)) == 1) out = out + s.charAt(i);
    }
    return out;
}
```
`"swiss"` → `wi` ✔ (`s` occurs 3 times; `w`, `i` once).

### BP-P31-4 count words (no `split`)
💡 a word starts where a non-space follows a space (or the start).
```java
static int countWords(String s) {
    int words = 0;
    for (int i = 0; i < s.length(); i++)
        if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) words++;
    return words;
}
```
`"hello bro how are you"` → 5 ✔ · `"  hi   there "` → 2 ✔

### BP-P09-4 / P17-4 / P07-4
```java
static boolean arrayPalindrome(int arr[]) {
    int i = 0, j = arr.length - 1;
    while (i < j) { if (arr[i] != arr[j]) return false; i++; j--; }
    return true;
}
static boolean sortedDesc(int arr[]) {
    for (int i = 1; i < arr.length; i++) if (arr[i - 1] < arr[i]) return false;
    return true;
}
static int countDigitsGreaterThan5(int n) {
    int c = 0;
    while (n > 0) { if (n % 10 > 5) c++; n /= 10; }
    return c;
}
```
`1672983` → digits 6,7,9,8 → **4** ✔

### BP-P28-4 hollow pyramid
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n - i; j++) System.out.print(" ");
    int width = 2 * i - 1;
    for (int j = 1; j <= width; j++)
        System.out.print((j == 1 || j == width || i == n) ? "*" : " ");
    System.out.println();
}
```
```
   *
  * *
 *   *
*******
```
