---
title: Arrays & DSA (Days 8–27)
---

[← INDEX](../INDEX.md) · [PATTERN_BANK](../PATTERN_BANK.md) · [COMPLEXITY](../COMPLEXITY_CHEATSHEET.md)

# 🧱 ARRAYS + DSA

Every algorithm below uses the same 8 steps:

```
PROBLEM → PATTERN → VARIABLES → PSEUDOCODE → JAVA → DRY RUN → COMPLEXITY → COMMON MISTAKES
```

## 0. Array basics (Day 8)

```java
int arr[] = {10, 20, 30, 40, 50};   // declare + fill      (Array.java also: int numbers[] = new int[size];)
arr[0]                              // first element   → 10
arr[arr.length - 1]                 // last element    → 50
arr.length                          // 5  (NO brackets — that's Strings)
```
| Index | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| value | 10 | 20 | 30 | 40 | 50 |

- Arrays are **fixed size**. Valid indices: `0 … length-1`. Anything else → `ArrayIndexOutOfBoundsException`.
- Arrays passed to methods are passed **by reference**: `reverse(arr)` / `moveZero(arr)` change the *original* (that's why they can be `void`).

### Status board

| Algorithm | Pattern | Status |
|---|---|---|
| Traversal | P03 | 🟢 |
| Sum / Average | P02 | 🟢 |
| Largest / Smallest | P04 | 🟢 |
| Contains | P05 | 🟢 |
| Count occurrence | P03 | 🟢 |
| First index | P10 | 🟢 |
| Reverse | P09/P26 | 🟢 |
| Second largest | P20 | 🟡 |
| **Second distinct largest** | P21 | 🔴 |
| Last index | P11 | 🟡 |
| All indices | P13 | 🟡 |
| First + Last | P12 | 🟡 |
| Move zeros | P18 | 🟡 |
| Remove duplicates (sorted) | P19 | 🟡 |
| Sorted check | P17 | 🟡 |
| Asc/Desc/Equal/Neither | P22 | 🟡 |
| Frequency of each / Most frequent | P16/P33 | 🟡 |
| Binary Search | P23 | 🟡 → [own page](06_BINARY_SEARCH.md) |

---

## 1. Traversal (print everything)

| | |
|---|---|
| **PROBLEM** | Visit every element. |
| **PATTERN** | P03 skeleton. |
| **VARIABLES** | `i` (index). |
| **PSEUDOCODE** | `for i from 0 to length-1: use arr[i]` |

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```
**Dry run** `{10,20,30}` → i=0 prints 10 · i=1 prints 20 · i=2 prints 30 · i=3 stops (`3 < 3` false).
**Complexity** O(n) / O(1).
**Mistakes** `i <= arr.length` (one too far → exception) · 📦 hard-coded bound `i = 4` (D8) instead of `arr.length - 1`.

## 2. Sum & Average

| | |
|---|---|
| **PATTERN** | Accumulator (P02) |
| **VARIABLES** | `sum = 0` |

```java
static int sumOfArray(int arr[]) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) sum = sum + arr[i];
    return sum;
}
static double avgOfArray(int arr[]) {
    int total = 0;
    for (int i = 0; i < arr.length; i++) total += arr[i];
    return (double) total / arr.length;      // cast BEFORE dividing
}
```
**Dry run** `{10,20,30,403,50}` → total=513 → 513/5 = **102.6** ✔ (your D23).
**Complexity** O(n)/O(1).
**Mistakes** integer division (`total / arr.length` with two ints → truncates) · 📦 D13 seeded `sum = arr[0]` and looped from `1` → works but crashes on an **empty** array.

## 3. Largest / Smallest

**PATTERN** P04 · **VARIABLES** `largest = arr[0]`

```java
int largest = arr[0];
for (int i = 1; i < arr.length; i++)
    if (arr[i] > largest) largest = arr[i];
```
**Dry run** `{22,39,12,53,24,14}` → 22 → 39 → 39 → 53 → 53 → 53 = **53** ✔.
**Complexity** O(n)/O(1).
**Mistakes** 📜 *Earlier (D7/8/9):* `largest = 0` → all-negative array wrong · `smallest = 1000` magic number · ✅ *Corrected D10:* `arr[0]`.

## 4. Contains / Linear search / First index

**PROBLEM** "Is target present? Where first?" · **PATTERN** P05 + P06 + P10

```java
static boolean contains(int arr[], int target) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) return true;    // early exit
    return false;                             // only after the loop
}
static int index(int arr[], int target) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) return i;
    return -1;
}
```
**Dry run** `index({10,43,32,63,22}, 43)` → i0 no · i1 yes → **1**. Target 99 → loop ends → **-1**.
**Complexity** best O(1) · avg O(n) · worst O(n) · space O(1).
**Mistakes** 📜 *Earlier (`Array.java`):* printed "not found" inside the loop · 📜 D11 `contains` kept scanning after finding (✅ D18 uses early return) · 💬 returning `target` instead of `-1`.

## 5. Count occurrence

**PATTERN** P03. `count++` when `arr[i] == target`. (D11, 13, 14, 22, 27)
**Dry run** `{10,20,20,20,109,10}`, target 20 → **3** ✔.
**Complexity** O(n)/O(1). **Mistake** return inside the loop.

## 6. Reverse (two pointers + swap)

**PATTERN** P09 + P26 · **VARIABLES** `i=0`, `j=length-1`, `temp`

```java
static void reverse(int arr[]) {
    int temp;
    int j = arr.length - 1;
    for (int i = 0; i < j; i++) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
    }
}
```
**Dry run** `{10,20,30,40,50}`

| step | i | j | swap | array |
|---|---|---|---|---|
| 1 | 0 | 4 | 10↔50 | 50 20 30 40 10 |
| 2 | 1 | 3 | 20↔40 | 50 40 30 20 10 |
| stop | 2 | 2 | `2 < 2` false | ✔ |

**Complexity** O(n) time (n/2 swaps), O(1) space.
**Mistakes** forgetting `j--` · swapping without `temp` · `i <= j` (harmless but pointless).
**Status 🟢** — repeated identically on D11, 12, 13, 14, 15, 16 (spaced).

## 7. Second largest (duplicates allowed)

Full box → [P20](../PATTERN_BANK.md#p20--second-largest-duplicates-allowed). Key points:
- Seed with the first two, **loop from `i = 2`**.
- 📦 D13 loop from `i = 0` → wrong on `{50,10,20}` (verified).
- `{10,10,5}` → `10` (duplicates count).

## 8. Second **distinct** largest 🔴

Full box → [P21](../PATTERN_BANK.md#p21--second-distinct-largest).

```
3 rules:  bigger than largest → shift.   strictly between → second.   equal to largest → ignore.
```
| Attempt | Verdict |
|---|---|
| D23a `second = arr[0]` + `!= larget` | ❌ `{50,10,20}` → 50 |
| D23b (active) tracks smallest | ❌ inverted, `else if` unreachable |
| **D25** `MIN_VALUE` + `secondFound` + `< largest` | ✅ **current recommended** |

## 9. Find all indices

**PROBLEM** Return **every** position where `target` appears.
**PATTERN** Count → Allocate → Fill (P13) + Scanner/Writer (P08)
**VARIABLES** `count`, `ar[]` (result), `pos` (writer), `i` (scanner)
**PSEUDOCODE**
```
count = how many times target appears
ar = new int[count]
pos = 0
for i over ORIGINAL array: if arr[i] == target: ar[pos] = i ; pos++
return ar
```
```java
static int[] findAllIndex(int arr[], int target) {
    int pos = 0;
    int count = countOccurence(arr, target);
    int ar[] = new int[count];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) { ar[pos] = i; pos++; }
    }
    return ar;
}
```
**Dry run** `{10,20,10,20,10,20,39,43}`, target **20** → `count=3` → `ar=[0,0,0]`

| i | arr[i] | match? | ar | pos |
|---|---|---|---|---|
| 0 | 10 | no | [_,_,_] | 0 |
| 1 | 20 | ✔ `ar[0]=1` | [1,_,_] | 1 |
| 2 | 10 | no | | 1 |
| 3 | 20 | ✔ `ar[1]=3` | [1,3,_] | 2 |
| 4 | 10 | no | | 2 |
| 5 | 20 | ✔ `ar[2]=5` | [1,3,5] | 3 |
| 6,7 | 39,43 | no | | 3 |

Result **[1, 3, 5]** ✔. (📜 D27 first draft `findIndex` only **printed** each index; the returned-array version is the improvement.)
**Complexity** O(n) time, O(k) result space.
**Mistakes** 💬 hard-coded size · 💬 looping over `ar` · storing `arr[i]` (value) instead of `i` · confusing `i`/`pos`.

## 10. Last index & First + Last

Full boxes → [P11](../PATTERN_BANK.md#p11--last-occurrence), [P12](../PATTERN_BANK.md#p12--first--last-in-one-pass).
📦 **D27 bug:** not found → `[0,0]`. Recommended: `return new int[]{first, last};` built from `-1` defaults.

## 11. Move zeros / Remove duplicates (sorted)

Full boxes with tables → [P18](../PATTERN_BANK.md#p18--move-zeros), [P19](../PATTERN_BANK.md#p19--remove-duplicates-from-sorted-array).
Both = **Scanner `i` + Writer `pos`** (P08), in place, O(n)/O(1).

## 12. Sorted check

**PATTERN** P17 · a single violation proves "not sorted".
```java
for (int i = 1; i < arr.length; i++)
    if (arr[i - 1] > arr[i]) return false;
return true;
```
`{1,2,3,4,4,5}` → `true` ✔ (equal neighbours are allowed — non-decreasing).
**Complexity** best O(1) · worst O(n).
**Mistakes** `>=` (would reject duplicates) · starting `i = 0` (`arr[-1]` crash).

## 13. Ascending / descending / equal / neither

Full box → [P22](../PATTERN_BANK.md#p22--ascending--descending--equal--neither). Two flags, each pair can only *kill* a flag.

## 14. Frequency of each element & Most frequent

```java
static int frequency(int arr[], int target) { /* P03 */ }

// frequency of each (D14/15)
for (int i = 0; i < num.length; i++) {
    boolean alreadySeen = false;
    for (int j = 0; j < i; j++)
        if (num[i] == num[j]) { alreadySeen = true; break; }
    if (!alreadySeen) System.out.println(num[i] + " > " + frequency(num, num[i]));
}

// most frequent (D15/25)
int mostFrequent = arr[0];
int highestFrequency = frequency(arr, arr[0]);
for (int i = 1; i < arr.length; i++) {
    int count = frequency(arr, arr[i]);
    if (count > highestFrequency) { mostFrequent = arr[i]; highestFrequency = count; }
}
```
**Dry run** (most frequent) `{10,10,20,13,2,3,23,2,3,3}` → start `10 (2)` · 20→1 · 13→1 · 2→2 (not >2) · 3→**3** > 2 → most=3 · 23→1 · 2→2 · 3→3 (not >3) · 3→3 → **3** ✔ (your D15).
**Complexity** O(n²)/O(1). **Mistakes** forgetting `alreadySeen` (repeats printed) · `>=` instead of `>` (last tie wins instead of first) · D25 starts at `0` (extra self-compare).

## 15. Duplicate detection (first repeated value, D13)

```java
for (int i = 0; i < arr.length; i++)
    for (int j = i + 1; j < arr.length; j++)
        if (arr[i] == arr[j]) return arr[i];
return -1;
```
`{10,20,30,10,32,43}` → **10** ✔. O(n²). `-1` ambiguous if `-1` is data.

## 16. Binary Search → [06_BINARY_SEARCH.md](06_BINARY_SEARCH.md)

---

## Menu-driven array project (D16 → D18)

D16: everything in `main` (numeric-suffixed names). D18 split it into `contains`, `countOccurrence`, `index`, `sumOfArray` + `arrayAnalyzer(sc, arr)` with its own `do-while` menu → **the jump from "code that works" to "code that is organised."**
