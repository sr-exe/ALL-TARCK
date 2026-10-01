---
title: Pattern Bank
---

[← INDEX](INDEX.md) · Repair a pattern: [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md) · Practise: [BLANK_PAGE](BLANK_PAGE_RECONSTRUCTION.md)

# 🧩 PATTERN BANK

> **Remember patterns, not programs.** Each box: *purpose → mental model → pseudocode → template → dry run → mistake → complexity → when to use.*
> Pattern IDs (`P01`…`P34`) are used everywhere in this book.

## Index

| ID | Pattern | Status | | ID | Pattern | Status |
|---|---|---|---|---|---|---|
| [P01](#p01--method-flow) | Method flow | 🟢 | | [P18](#p18--move-zeros) | Move zeros | 🟡 |
| [P02](#p02--accumulator) | Accumulator | 🟢 | | [P19](#p19--remove-duplicates-from-sorted-array) | Remove dup (sorted) | 🟡 |
| [P03](#p03--traverse--condition--counter) | Traverse→Condition→Counter++ | 🟢 | | [P20](#p20--second-largest-duplicates-allowed) | Second largest | 🟡 |
| [P04](#p04--assume--compare--update) | Assume→Compare→Update | 🟢 | | [P21](#p21--second-distinct-largest) | **Second distinct largest** | 🔴 |
| [P05](#p05--found--return-early-return) | Found→Return | 🟢 | | [P22](#p22--ascending--descending--equal--neither) | Asc/Desc/Equal/Neither | 🟡 |
| [P06](#p06---1--not-found) | -1 = Not found | 🟢 | | [P23](#p23--binary-search) | **Binary Search** | 🟡 |
| [P07](#p07--digit-peeling) | Digit peeling `%10 /10` | 🟢 | | [P24](#p24--method-calling-method) | Method calling method | 🟡 |
| [P08](#p08--scanner-vs-writer-i-vs-pos) | Scanner vs Writer | 🟡 | | [P25](#p25--menu-loop) | Menu loop | 🟢 |
| [P09](#p09--two-pointers) | Two pointers | 🟢/🟡 | | [P26](#p26--swap-with-temp) | Swap with temp | 🟢 |
| [P10](#p10--first-occurrence) | First occurrence | 🟢 | | [P27](#p27--boolean-flag) | Boolean flag | 🟢 |
| [P11](#p11--last-occurrence) | Last occurrence | 🟡 | | [P28](#p28--nested-loops-for-shapes) | Nested loops (shapes) | 🟡 |
| [P12](#p12--first--last-in-one-pass) | First + Last one pass | 🟡 | | [P29](#p29--scanner-newline-trap) | Scanner newline trap | 🟡 |
| [P13](#p13--count--allocate--fill) | Count→Allocate→Fill | 🟡 | | [P30](#p30--parallel-arrays) | Parallel arrays | ⚪ |
| [P14](#p14--logical-size-vs-physical-array) | Logical vs physical size | 🟡 | | [P31](#p31--string-scan--char-tests) | String scan + char tests | 🟡 |
| [P15](#p15--alreadyseen) | **alreadySeen** | 🟡 ⚠ | | [P32](#p32--duplicate-detection-pair-check) | Duplicate detection | 🟡 |
| [P16](#p16--frequency-counting) | Frequency counting | 🟡 | | [P33](#p33--most-frequent) | Most frequent | 🟡 |
| [P17](#p17--sorted-array-reasoning) | Sorted-array reasoning | 🟡 | | [P34](#p34--build-a-string-result) | Build a String result | 🟡 |

---

## P01 — Method flow
**Status** 🟢 · **Seen** D6 → all later · **Full:** [topics/03](topics/03_METHODS.md)

| | |
|---|---|
| **Purpose** | Package logic once, reuse it, keep `main` small. |
| **Mental model** | A machine: **input → parameters → processing → return → caller uses it** |

```java
static int square(int n) {        // parameters = what comes in
    return n * n;                 // processing + return = what goes out
}
int result = square(7);           // caller must CATCH the value
```
- `void` = does something, returns nothing. `int/boolean/String/int[]` = returns a value of that type.
- **Dry run:** `square(7)` → `n=7` → returns `49` → `result = 49`.
- ❌ **Mistake:** calling `square(7);` and ignoring the result (📦 D26 `int re = frequency(...)` never used).
- **Complexity:** depends on body. **Use when:** any logic used twice or needing a name.

---

## P02 — Accumulator
**Status** 🟢 · **Seen** D1-5 (sum, factorial), D8, D10, D16

| | |
|---|---|
| **Purpose** | Build one result while looping (sum, product, count). |
| **Mental model** | A bucket that starts at the **identity value** and collects. |

| Goal | Start | Update |
|---|---|---|
| sum | `0` | `sum = sum + x` |
| product / factorial | `1` | `fact = fact * i` |
| count | `0` | `count++` |

- **Dry run** sum of `{10,20,30}`: `0 → 10 → 30 → 60`.
- ❌ Start a **product** at `0` → always `0`. 📦 `int` factorial overflows after `12!` (D18, verified).
- **Complexity:** O(n) time, O(1) space.

---

## P03 — Traverse → Condition → Counter++
**Status** 🟢 · **Seen** D8, 10, 11, 13, 14, 15, 22

```java
int count = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {       // the condition IS the problem
        count++;
    }
}
return count;
```
- **Mental model:** *walk through everything, tick a tally when the rule is true.*
- **Dry run** `{10,20,20}`, target 20 → i0 no · i1 count=1 · i2 count=2 → `2`.
- ❌ Putting `return count;` **inside** the loop (returns after first element).
- Same skeleton solves: count evens, count occurrences, count vowels, count digits, count spaces, count positives.
- **O(n) / O(1).**

---

## P04 — Assume → Compare → Update
**Status** 🟢 (after D10 fix) · **Seen** D8, 9, 10, 12, 22, 23

| | |
|---|---|
| **Purpose** | Largest / smallest. |
| **Mental model** | **Assume** the first element is the champion, **compare** every challenger, **update** the champion. |

```java
int largest = arr[0];                    // ASSUME
for (int i = 1; i < arr.length; i++) {   // start at 1: arr[0] already the champion
    if (arr[i] > largest) {              // COMPARE
        largest = arr[i];                // UPDATE
    }
}
```
- **Dry run** `{-10,-111,-23}`: largest=-10 → -111? no → -23? no → `-10` ✔
- 📦 **Earlier attempt (D7, D8, D9):** `int largest = 0;` → **all-negative arrays return 0.** Also `smallest = 1000` (magic number, D8).
- ✅ **Corrected (D10):** `arr[0]`, tested with negatives. ⚠ *It reappeared once in D9's "revision" file* — historical regression preserved.
- For **digits** `largest = 0` / `smallest = 9` is legitimately fine (digits only 0–9).
- **O(n) / O(1).** Needs a **non-empty** array.

---

## P05 — Found → Return (early return)
**Status** 🟢 · **Seen** D11, 12, 13, 18

```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        return i;          // stop the moment you know
    }
}
return -1;                 // only reached if the loop never returned
```
- **Rule:** *answer known → return now.* Return stops the **whole method**, not just the loop.
- **Best case O(1)** (first element), worst O(n).
- ❌ 📦 D11 `contains` used a flag and kept looping after finding (works, wastes time). D18 rewrote it with early `return true` ✅.

---

## P06 — -1 = Not found
**Status** 🟢

- **Why -1?** Valid indices are `0 … n-1`. `-1` can never be a real index, so it safely means "nothing".
- Caller must check: `if (index != -1) …`.
- ❌ 💬 Returning the `target` instead of `-1`. ❌ Using `0` as "not found" (0 is a real index!).
- 📦 D27 `firstLast` returns `[0,0]` when not found — same mistake in array form.

---

## P07 — Digit peeling
**Status** 🟢 · **Seen** loop1, D6, 7, 9, 16, 18 · **Full:** [topics/02](topics/02_DIGIT_PATTERNS.md)

| Expression | Meaning |
|---|---|
| `num % 10` | **last digit** |
| `num / 10` | **remove last digit** |
| `while (num > 0)` | until no digits left |

```java
while (num > 0) {
    int digit = num % 10;   // grab
    // ... use digit ...
    num = num / 10;         // drop
}
```
- **Dry run** `1234` sum: `4→3→2→1` → 4+3+2+1 = **10**.
- **Reverse:** `rev = rev*10 + digit` (`123 → 3 → 32 → 321`).
- **Palindrome:** save `orig = num` **before** the loop; compare after.
- ❌ 📦 Forgetting to save the original (num becomes 0). ❌ Not handling `0` or negatives (`smallestDigit(0)` → 9, verified).
- **O(d)** where d = number of digits (= O(log₁₀ n)). **O(1)** space.

---

## P08 — Scanner vs Writer (`i` vs `pos`)
**Status** 🟡 · **Seen** D23, 24, 25, 27

```
i   = SCANNER : visits EVERY element, always moves forward
pos = WRITER  : marks the NEXT PLACE to write; moves only when we keep something
```
```
arr = [10, 0, 40, 0, 3]
       i→                    pos starts at 0
i=0: keep 10 → arr[pos=0]=10, pos=1
i=1: 0 skip           (pos stays 1)
i=2: keep 40 → arr[1]=40, pos=2
```
- Always **`pos ≤ i`** → the writer never overtakes the scanner, so unread data is never overwritten.
- After the loop **`pos` = number of kept items** (new logical size).
- ❌ 💬 Confusing `i` and `pos` (e.g. `arr[i] = arr[pos]` — reversed).
- Used by [P18](#p18--move-zeros), [P19](#p19--remove-duplicates-from-sorted-array), [P13](#p13--count--allocate--fill) (`pos` in the result array).

---

## P09 — Two pointers
**Status** 🟢 array reverse · 🟡 string palindrome · **Seen** D11–16 (reverse), D20 (palindrome)

```java
int i = 0, j = arr.length - 1;
while (i < j) {
    // work with arr[i] and arr[j]
    i++;
    j--;
}
```
- **Mental model:** two people walking toward the middle.
- **Why `i < j` (not `<=`)?** When `i == j` there is one middle item — nothing to swap/compare.
- **Dry run** reverse `{10,20,30,40}`: (0,3) swap → `40,20,30,10`; (1,2) swap → `40,30,20,10`; (2,1) stop.
- 📦 **Earlier attempt (D20, wrong):** `for (int i=0;i<j;i++)` with `j` never decremented → compared every char against the *last* char; and `return true` on **mismatch**. ✅ Corrected to `while` + `i++; j--;` + `return false` on mismatch.
- **O(n) / O(1)** (n/2 steps).

---

## P10 — First occurrence
**Status** 🟢 · = [P05](#p05--found--return-early-return) applied to "where is target first?"

```java
for (int i = 0; i < arr.length; i++)
    if (arr[i] == target) return i;
return -1;
```
- Best O(1), average/worst O(n).

---

## P11 — Last occurrence
**Status** 🟡 · **Seen** D27

```java
int lastIndex = -1;
for (int i = 0; i < arr.length; i++)
    if (arr[i] == target) lastIndex = i;   // KEEP updating
return lastIndex;
```
- **Why it keeps changing:** we can't know a match is the *last* until the loop ends, so every match overwrites the previous one.
- Alternative (scan from the right, return at first hit) — not in your files.
- **O(n) / O(1).**

---

## P12 — First + Last in one pass
**Status** 🟡 · **Seen** D27 (commented)

```java
static int[] firstLast(int arr[], int target) {
    int first = -1, last = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            if (first == -1) first = i;   // guard → set ONCE
            last = i;                     // no guard → updates EVERY match
        }
    }
    return new int[]{first, last};        // {-1,-1} if never found
}
```
- **Why `firstIndex` stops changing:** after the first hit `first != -1`, so the guard is false forever.
- **Dry run** `{10,20,30,49,30,30,20,30}`, target 30: i2 → first=2,last=2 · i4 → last=4 · i5 → last=5 · i7 → last=7 → `[2,7]` ✔
- 📦 **Bug in D27:** `ar` is created as `new int[2]` (`{0,0}`) and only filled *inside* the `if`. **Not found → returns `[0,0]`** — which looks like "found at index 0". Verified.
- ✅ **Fix:** build the array *after* the loop from `first`/`last`.
- **O(n) / O(1)** (result array is always size 2).

---

## P13 — Count → Allocate → Fill
**Status** 🟡 · **Seen** D27 (single day) · **Full:** [topics/04](topics/04_ARRAYS_AND_DSA.md#9-find-all-indices)

```
pass 1: COUNT  matches         → k
allocate: new int[k]           → exact size, not a guess
pass 2: FILL result[pos++] = i  → positions
```
```java
static int[] findAllIndex(int arr[], int target) {
    int count = countOccurence(arr, target);   // pass 1
    int ar[] = new int[count];                 // allocate EXACT size
    int pos = 0;
    for (int i = 0; i < arr.length; i++) {     // pass 2: loop the ORIGINAL array
        if (arr[i] == target) {
            ar[pos] = i;                       // store the INDEX, not the value
            pos++;
        }
    }
    return ar;
}
```
- **Why two passes?** Java arrays have fixed size; you must know `k` before creating the result.
- **Dry run** `{10,20,10,20,10,20,39,43}`, target 20 → count=3 → `ar=[_,_,_]` → i1→ar[0]=1 · i3→ar[1]=3 · i5→ar[2]=5 → **[1,3,5]**.
- ❌ 💬 Hardcoding the result size · ❌ looping over `ar` instead of `arr` · ❌ storing `arr[i]` instead of `i`. ❌ Nothing found → `count=0` → `new int[0]` (empty array, that's correct, not `-1`).
- **O(n) time** (2 passes = 2n → O(n)), **O(k) extra space.**

---

## P14 — Logical size vs physical array
**Status** 🟡 · **Seen** D22 (`count` for students), D24/25 (`pos` returned by remove-dup)

```
physical: arr.length   = how many boxes exist          (fixed)
logical : count / pos  = how many boxes are USED       (changes)
```
```java
String name[] = new String[5];   // physical = 5
static int count = 0;            // logical  = 0 students so far
for (int i = 0; i < count; i++)  // loop to LOGICAL size, not name.length
```
- After `removeDuplicates` returns `pos`, only `arr[0 … pos-1]` is meaningful; the tail is **leftover junk**.
- ❌ Looping to `arr.length` and printing leftovers / `null`.

---

## P15 — alreadySeen
**Status** 🟡 ⚠ *spaced-recall topic* · **Seen** D14, 15 (arrays), D20, 21 (strings, as method), D26 (inline) · **Full dry run:** [topics/05](topics/05_STRINGS.md#4-alreadyseen-banana-dry-run)

| | |
|---|---|
| **Purpose** | Process each **distinct** item **once**, at its **first** appearance. |
| **Mental model** | At position `i`, ask: *"Have I already met this value in positions **before** i?"* If yes → skip. |

```java
static boolean alreadySeen(String str, int index) {
    for (int j = 0; j < index; j++) {            // ONLY positions before index
        if (str.charAt(j) == str.charAt(index)) {
            return true;                          // met before
        }
    }
    return false;                                 // first time
}
```
- **Why `j < i`?** Looking only backwards makes exactly **one** occurrence (the first) pass as "not seen". Looking at the whole string would mark the first occurrence "seen" because of a *later* duplicate → everything skipped. Including `j == i` compares a char with itself → always "seen".
- **banana:** `b a n a n a` → processed at i = 0, 1, 2 · skipped at i = 3, 4, 5.
- ❌ Computing `count` *before* the skip check (D26 — wasted work). ❌ Unused `int re = frequency(...)` (D26).
- **O(n²)** overall with `frequency`.

---

## P16 — Frequency counting
**Status** 🟡 · **Seen** D14, 15, 20, 21, 26

```
for each i:
    if alreadySeen(i) → skip
    count = how many times value appears in WHOLE array
    print value > count
```
- Arrays: `frequency(arr, target)` · Strings: `countChar(str, ch)` (same function, different type).
- **Dry run** `{10,32,10,42,10,20,20}` → `10>3, 32>1, 42>1, 20>2` (first-appearance order).
- **Complexity:** each `i`: alreadySeen O(i) + count O(n) → O(n) each × n = **O(n²)**.
- *(Faster counting with a counting array or a map exists — 🔒 FUTURE, not in your files.)*

---

## P17 — Sorted-array reasoning
**Status** 🟡 · **Seen** D24 (`sorted`), D24/25 (remove-dup), D28 (binary search)

- **Sorted (non-decreasing)** ⇔ **no** neighbour pair with `arr[i-1] > arr[i]`.
- Sorted ⇒ **equal values sit next to each other** ⇒ duplicates can be found by comparing neighbours (P19).
- Sorted ⇒ comparing with the **middle** tells which half can be thrown away ⇒ Binary Search (P23).
- ❌ Using sorted-only tricks on unsorted data (📦 D28 test array).

```java
static boolean sorted(int arr[]) {
    for (int i = 1; i < arr.length; i++)
        if (arr[i - 1] > arr[i]) return false;   // one violation is enough
    return true;
}
```
- **O(n) / O(1)**; best case O(1) (violation at the start).

---

## P18 — Move zeros
**Status** 🟡 · **Seen** D23 (comment), D24 ×3, D25 — identical each time

| | |
|---|---|
| **Purpose** | Push all `0`s to the end, keep the other elements in order, **in place**. |
| **Mental model** | Scanner `i` reads everything · writer `pos` copies only non-zeros forward · then **fill the rest with zeros**. |

```java
static void moveZero(int arr[]) {
    int pos = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {        // keeper
            arr[pos] = arr[i];    // write at pos
            pos++;
        }
    }
    for (int i = pos; i < arr.length; i++) {   // everything after pos = zeros
        arr[i] = 0;
    }
}
```
**Dry run** `{10,0,40,0,10,4,53,0,0,3}`

| i | arr[i] | action | pos after |
|---|---|---|---|
| 0 | 10 | arr[0]=10 | 1 |
| 1 | 0 | skip | 1 |
| 2 | 40 | arr[1]=40 | 2 |
| 3 | 0 | skip | 2 |
| 4 | 10 | arr[2]=10 | 3 |
| 5 | 4 | arr[3]=4 | 4 |
| 6 | 53 | arr[4]=53 | 5 |
| 7,8 | 0,0 | skip | 5 |
| 9 | 3 | arr[5]=3 | 6 |

Fill `arr[6..9] = 0` → `10 40 10 4 53 3 0 0 0 0` ✔ (your D24 output).
- ❌ 💬 Mixing `i` / `pos`. ❌ Forgetting the **second loop** (zeros never written → old values stay).
- **O(n) time** (two loops = n + ≤n), **O(1) extra space.**

---

## P19 — Remove duplicates from sorted array
**Status** 🟡 · **Seen** D24 ×2, D25 · returns the **new logical length** (P14)

```java
static int duplicate(int arr[]) {
    int pos = 1;                          // arr[0] is always unique
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] != arr[i - 1]) {       // differs from its neighbour = NEW value
            arr[pos] = arr[i];
            pos++;
        }
    }
    return pos;                           // count of unique values
}
// print only the first `pos` items
```
**Dry run** `{1,1,2,2,3}`: pos=1 · i1: 1≠1? no · i2: 2≠1 → arr[1]=2,pos=2 · i3: 2≠2? no · i4: 3≠2 → arr[2]=3,pos=3 → returns **3**, array starts `1 2 3` (tail leftover).
- **Why it works:** sorted ⇒ equal values are adjacent ⇒ a value is new exactly when it differs from its left neighbour.
- **Safe to compare with `arr[i-1]`** because `pos ≤ i`: the writer never overwrites something the scanner still needs.
- ❌ Using it on an **unsorted** array (duplicates aren't adjacent). ❌ Printing to `arr.length` (shows junk tail).
- **O(n) time, O(1) extra space.**

---

## P20 — Second largest (duplicates allowed)
**Status** 🟡 · **Seen** D10, 12, 13, 14, 15, 16 (template), D23 (attempt)

| | |
|---|---|
| **Meaning** | Second position in descending order: `{10,10,5}` → **10** (duplicates count separately). |
| **Mental model** | Two boxes: `largest`, `second`. New champion → old champion becomes runner-up. |

```java
int largest, second;
if (arr[0] > arr[1]) { largest = arr[0]; second = arr[1]; }
else                 { largest = arr[1]; second = arr[0]; }   // seed with FIRST TWO
for (int i = 2; i < arr.length; i++) {                        // then start at 2
    if (arr[i] > largest) { second = largest; largest = arr[i]; }
    else if (arr[i] > second) { second = arr[i]; }
}
return second;
```
**Dry run** `{23,53,14,65,-13,43}`: seed largest=53, second=23 · 14 no · 65 → second=53, largest=65 · -13 no · 43 no (43 > 53? no) → **53**.

- ⚠ **Your loop-start rule:** seeded from `arr[0], arr[1]` ⇒ loop **must start at 2**.
  - 📦 **D13 wrote `i = 0`.** It passed its own test but is wrong: `{50,10,20}` → **50** (should be 20). Verified in `BugProof`.
- Needs **≥ 2** elements (`arr[1]`).
- **O(n) / O(1).**
- 📌 **Not distinct-aware.** For "second *different* value" use **P21**.

---

## P21 — Second distinct largest
**Status** 🔴 · **Seen** D23 (wrong) → D25 (corrected, commented out) · *the "Bro I forgot…" pattern*

| | |
|---|---|
| **Meaning** | The second-biggest **different** value. `{10,120,10,10,10}` → **10**. `{3,3,3,3,3}` → **none → -1**. |
| **Mental model** | Champion (`largest`) + runner-up (`second`) where **runner-up must be strictly smaller than the champion**. |

### The three rules (memorise these, not the code)
```
1. arr[i] >  largest                       → old largest becomes second, arr[i] becomes largest
2. arr[i] <  largest  AND  arr[i] > second → arr[i] becomes second
3. arr[i] == largest                       → IGNORE   (this is what makes it "distinct")
```

### Current recommended version (your D25 corrected code)
```java
static int secondDistinct(int arr[]) {
    int largest = arr[0];
    int second = Integer.MIN_VALUE;
    boolean secondFound = false;              // "was second ever set?"

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > largest) {
            second = largest;
            largest = arr[i];
            secondFound = true;
        } else if (arr[i] > second && arr[i] < largest) {   // strictly between
            second = arr[i];
            secondFound = true;
        }
    }
    if (!secondFound) return -1;              // all equal → no second distinct
    return second;
}
```
### Dry runs
`{10,120,10,10,10}` → largest=10, second=MIN, found=false
| i | arr[i] | rule | largest | second | found |
|---|---|---|---|---|---|
| 0 | 10 | none (10>10 no; 10<10 no) | 10 | MIN | F |
| 1 | 120 | **rule 1** | 120 | 10 | T |
| 2–4 | 10 | 10>120 no; 10>10 no | 120 | 10 | T |

→ returns **10** ✔

`{3,3,3,3,3}` → nothing ever changes → `found=false` → **-1** ✔

### 📜 History (preserved)
| Attempt | Code idea | Problem |
|---|---|---|
| **D23a** *(commented)* `secondLargest` | `second = arr[0]`, `else if (arr[i] > second && arr[i] != larget)` | Seeding `second = arr[0]` is wrong when `arr[0]` is the max: `{50,10,20}` → **50** ✘ |
| **D23b** *(the ACTIVE code)* `secondDistinct` | tracks **`smallest`** with `<`, `MAX_VALUE` | Direction inverted (finds smallest-side), and `else if (arr[i] < smallest && arr[i] != smallest)` is **unreachable** (already handled by the `if`). `{10,20,30}` → **-1** ✘ |
| **D25** *(commented)* | `largest`, `MIN_VALUE`, `secondFound`, `arr[i] < largest` guard | ✔ correct on every test |

- **Why `secondFound` and not "second == MIN_VALUE"?** `MIN_VALUE` might be a legitimate element; the boolean answers "did we ever set it?" without ambiguity.
- **Why `arr[i] < largest` in rule 2?** Without it, a duplicate of the max would become `second` → not distinct.
- ⚠ **Edge:** if `arr` contains `Integer.MIN_VALUE` as the true second value, `arr[i] > second` skips it. Rare; note only.
- **O(n) time, O(1) space.**

**🔧 Repair route:** [ACTIVE_RECALL → P21 questions](ACTIVE_RECALL.md) → [BLANK_PAGE → P21 problems](BLANK_PAGE_RECONSTRUCTION.md).

---

## P22 — Ascending / descending / equal / neither
**Status** 🟡 · **Seen** D24 (method is named `neither`, returns 4 words)

| | |
|---|---|
| **Mental model** | Start by assuming **both** `ascending` and `descending` are true. Each neighbour pair can only **kill** a flag. |

```java
boolean ascending = true, descending = true;
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > arr[i - 1])      descending = false;   // went UP  → can't be descending
    else if (arr[i - 1] > arr[i]) ascending  = false;   // went DOWN → can't be ascending
    // equal neighbours kill nothing
}
if (ascending && !descending) return "ascending";
if (descending && !ascending) return "descending";
if (ascending && descending)  return "equal";           // never went up or down
return "neither";                                       // went up AND down
```
| Array | `asc` | `desc` | Result |
|---|---|---|---|
| `{1,2,2,3}` | T | F | ascending |
| `{9,5,5,1}` | F | T | descending |
| `{50,50,50}` | T | T | **equal** |
| `{1,3,2}` | F | F | **neither** |

- **Why "equal" is separate:** both flags survive only when *nothing changed*.
- ❌ 💬 Confusing **equal** and **neither** (they look alike — "not ascending/descending"). ❌ Using `else` instead of `else if` on the second test.
- 🔍 Empty/1-element array → `"equal"` (both flags stay true). Decide if that's what you want.
- **O(n) / O(1).**

---

## P23 — Binary Search
**Status** 🟡 (Day 28, dry run pending) · **Full:** [topics/06](topics/06_BINARY_SEARCH.md)

| | |
|---|---|
| **Precondition** | ✅ array **sorted ascending**. Without it the algorithm silently gives wrong answers. |
| **Mental model** | Guess the **middle**. Too small? throw away the **left** half. Too big? throw away the **right** half. |

```java
static int binarySearch(int arr[], int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int middle = (left + right) / 2;          // RECALCULATE every round
        if (target == arr[middle]) {
            return middle;                         // found
        } else if (target > arr[middle]) {
            left = middle + 1;                     // target is to the RIGHT
        } else {
            right = middle - 1;                    // target is to the LEFT
        }
    }
    return -1;                                     // window collapsed → not present
}
```
- `left = middle + 1` when `target > arr[middle]` (→ **move left pointer right**). `right = middle - 1` when `target < arr[middle]`.
- **Best O(1) · Average/Worst O(log n) · Space O(1).**
- 📦 Test data `{10,20,42,10,49,38}` in D28 is **unsorted** → wrong answers (searching `38` returns `-1` though it exists at index 5). **Algorithm is correct; input is invalid.**

---

## P24 — Method calling method
**Status** 🟡 · **Seen** D18 (`isPalindrome → reverse`), D19 (`palindromeString → reverseString`), D20/21 (`charFrequency → alreadySeen + countChar`), D25 (`mostFrequent → frequency`)

```java
static boolean isPalindrome(int num) {
    int rev = reverse(num);      // call helper, CATCH its return value
    return num == rev;
}
```
- **Mental model:** small tools, then a bigger tool that uses them.
- **Rule:** *every call whose result matters must be assigned or returned.*
- ❌ 📦 D26 `int re = frequency(str, ch);` — value never used.
- Benefit: `charFrequency` reads like English; `alreadySeen` can be tested alone.

---

## P25 — Menu loop
**Status** 🟢 · **Seen** D16, 17, 18, 21, 22

```java
int choice;
do {
    // print menu
    choice = sc.nextInt();
    switch (choice) {
        case 1: /* ... */ break;
        case 2: /* ... */ break;
        case 3: System.out.println("Exit"); break;
        default: System.out.println("Invalid");
    }
} while (choice != 3);          // 3 = Exit
```
- `do-while` because the menu must show **at least once**.
- Nested menus: pass **one** `Scanner` into methods (`arrayAnalyzer(sc, arr)`) — don't create a new one per method.
- ❌ 📦 D22: menu options 3 and 4 printed but **no `case`** — unfinished. ❌ `break` missing (📦 `switch1` case `'*'`).

---

## P26 — Swap with temp
**Status** 🟢 · **Seen** D11–16

```java
int temp = a[i];
a[i] = a[j];
a[j] = temp;
```
- Without `temp`, `a[i] = a[j]` **destroys** the old `a[i]`.
- Mental picture: three glasses — pour A into the empty glass, B into A, temp into B.

---

## P27 — Boolean flag
**Status** 🟢 · **Seen** D8, 11, 12, 16

```java
boolean found = false;
for (...) { if (match) { found = true; } }
if (found) ... else ...
```
- Use when you must **finish the loop** anyway (e.g. printing *all* matches, D22 `findAllIndex`).
- If you only need "does it exist?", **early return** (P05) is cleaner.
- ❌ 📦 `Array.java`: printing "Element not found" **inside** the loop → printed for every mismatch. Decision ("not found") can only be made **after** the loop.

---

## P28 — Nested loops for shapes
**Status** 🟡 (June/Aug files, not revisited since) · **Full:** [topics/07](topics/07_STAR_PATTERNS.md)

```
outer i  = ROW      inner j = COLUMN (or a count of things in that row)
per row: spaces = n - i     stars = i   or   2*i - 1
```
- Always ask: **what changes with the row?** (count of spaces, count of stars, the value printed).
- `System.out.println()` **after the inner loop** = next row.

---

## P29 — Scanner newline trap
**Status** 🟡 · fixed in D21, **reappeared D22**

```
Scanner:  nextInt()/next()  → read the token, LEAVE the "\n"
          nextLine()        → read to end of line (returns "" if only "\n" is left)
```
```java
int choice = sc.nextInt();   // leaves "\n"
sc.nextLine();               // swallow it
String name = sc.nextLine(); // now reads the real name
```
- 📦 D21 fixed it (`sc.nextLine();` before reading the string). 📦 D22 `addStudent` read the name right after the menu's `nextInt()` → **name = ""** (verified).
- Rule: **`nextInt()` then `nextLine()` ⇒ swallow first.**

---

## P30 — Parallel arrays
**Status** ⚪ · **Seen** D22 (`name[]`, `marks[]`)

```java
String name[] = new String[5];
int marks[]   = new int[5];
name[count] = n;  marks[count] = m;  count++;     // same index = same student
```
- Index `i` links the arrays. Fragile (must be kept in sync) — this is why **classes** exist. 🔒 FUTURE (OOP).

---

## P31 — String scan + char tests
**Status** 🟡 · **Seen** D19, 20, 21 · **Full:** [topics/05](topics/05_STRINGS.md)

```java
for (int i = 0; i < str.length(); i++) {   // length() WITH brackets for String
    char ch = str.charAt(i);
    if ("aeiou".indexOf(ch) != -1) { }     // vowel test (indexOf → -1 = not found, P06!)
    if (ch >= '0' && ch <= '9')    { }     // digit test
    if (ch == ' ')                 { }     // space test
}
```
- `'a'` = **char** (single quotes) · `"a"` = **String** (double quotes).
- 📦 **Gap:** `countVowels` only checks lowercase `"aeiou"` → `"HELLO"` counts **0** (uppercase `E` and `O` are not in `"aeiou"`). Fix: `Character.toLowerCase(ch)` or `str.toLowerCase()` first (you used `toLowerCase()` for the palindrome in D20).
- Strings compare with **`.equals()`**, never `==` (you used `.equals` correctly in D19).

---

## P32 — Duplicate detection (pair check)
**Status** 🟡 · **Seen** D13

```java
for (int i = 0; i < arr.length; i++)
    for (int j = i + 1; j < arr.length; j++)     // j starts AFTER i → no self-compare, no repeat pairs
        if (arr[i] == arr[j]) return arr[i];
return -1;
```
- **`j = i + 1`** (look **forward**) — contrast with P15 `j < i` (look **backward**).
- Returns the first value that has a later twin. **O(n²)** worst, O(1) space.
- ⚠ `-1` is ambiguous if `-1` is a valid element.

---

## P33 — Most frequent
**Status** 🟡 · **Seen** D15, D25

```java
int best = arr[0];
int bestCount = frequency(arr, arr[0]);
for (int i = 1; i < arr.length; i++) {
    int c = frequency(arr, arr[i]);
    if (c > bestCount) { best = arr[i]; bestCount = c; }    // strictly greater
}
return best;
```
- = **P04 (assume→compare→update)** where the value being compared is a **count** from P03.
- **Dry run** `{1,12,20,332,30,10,49,20,20}`: best=1(1) · … · 20→3 > 1 → best=20 · later 20s → 3 > 3? no → **20**.
- Ties: the **first** value to reach the max wins (strict `>`).
- D25 loops from `i = 0` (compares `arr[0]` with itself — harmless, one wasted call).
- **O(n²)** (n calls × O(n) each), O(1) space.

---

## P34 — Build a String result
**Status** 🟡 · **Seen** D19

```java
String reverse = "";
for (int i = str.length() - 1; i >= 0; i--)
    reverse = reverse + str.charAt(i);      // accumulator (P02) for text: start ""
```
- Accumulator for text starts at `""` (like `0` for sums).
- Strings are **immutable** → every `+` builds a *new* string → real cost **O(n²)** for long strings. (`StringBuilder` — 🔒 FUTURE — fixes this.)
- Palindrome by reverse: `str.equals(reverse)` ✔ (D19) — simpler but heavier than two pointers (D20).
