---
title: Binary Search (Day 28)
---

[← INDEX](../INDEX.md) · [P23](../PATTERN_BANK.md#p23--binary-search) · [Recall](../ACTIVE_RECALL.md) · [Blank page](../BLANK_PAGE_RECONSTRUCTION.md)

# 🔎 BINARY SEARCH

**Status:** 🟡 understood · algorithm **constructed by you** · **dry run still pending** (session was tiring) · not mastery-verified.

## 1. What / why / recognise

| Question | Answer |
|---|---|
| **What is it?** | Search a **sorted** array by repeatedly checking the **middle** and discarding half. |
| **Why?** | Linear search checks up to `n` items. Binary Search needs about `log₂ n` (1,000,000 items → ~20 checks). |
| **How do I recognise the problem?** | "Find X in a **sorted** array" (or "sorted" + "fast"). Words: *sorted, ascending, search, find index*. |
| **Big warning** | **If the array is not sorted, the answer is meaningless.** |

## 2. Your Day 28 code — explained

```java
static int binarySearch(int arr[], int target) {
    int left = 0;                        // ① left edge of the window
    int right = arr.length - 1;          // ② right edge of the window

    while (left <= right) {              // ③ while the window still has ≥ 1 element
        int middle = (left + right) / 2; // ④ centre of the CURRENT window

        if (target == arr[middle]) {     // ⑤ hit → answer is the INDEX
            return middle;
        } else if (target > arr[middle]) {
            left = middle + 1;           // ⑥ target is bigger → it can only be to the RIGHT
        } else {
            right = middle - 1;          // ⑦ target is smaller → it can only be to the LEFT
        }
    }
    return -1;                           // ⑧ window is empty → not present
}
```

| Line | Meaning | Why it's written this way |
|---|---|---|
| ①② | Whole array is the first window | indices run `0 … length-1` |
| ③ `left <= right` | window non-empty | with `<`, a window of **one** element (`left == right`) would be skipped |
| ④ | middle **inside** the loop | window changes every round → recompute (💬 B2) |
| ⑤ `arr[middle]` | compare **value with value** | `middle` is a position; `arr[middle]` is the value there (💬 B1) |
| ⑥ `middle + 1` | `middle` itself is already **known not** to be the target | `+1` guarantees the window shrinks (no infinite loop) |
| ⑦ `middle - 1` | same, other side | |
| ⑧ `-1` | not found | `-1` is never a valid index (P06) |

✅ **The algorithm is correct** for an ascending sorted array.

### Move left or move right? (say it both ways)

| Situation | "Which half stays?" | Pointer that changes |
|---|---|---|
| `target > arr[middle]` | **right half** stays | `left = middle + 1` (the **left pointer moves right**) |
| `target < arr[middle]` | **left half** stays | `right = middle - 1` (the **right pointer moves left**) |
| `target == arr[middle]` | done | `return middle` |

> 🧠 *"Too small? raise the floor (`left`). Too big? lower the ceiling (`right`)."*

## 3. Why the array MUST be sorted

Sorted means: everything left of `middle` is **≤** `arr[middle]`, everything right is **≥**.
So if `target > arr[middle]`, **nothing on the left half can equal target** → discarding it is safe.
In an unsorted array that guarantee is false → you can throw away the half that contains the answer.

## 4. Dry runs (use these — the Day 28 dry run was left unfinished)

### A. Found — sorted `{10, 20, 30, 40, 50, 60, 70}`, target **50**
```
index:  0   1   2   3   4   5   6
value: 10  20  30  40  50  60  70
```
| Round | left | right | middle | arr[middle] | Compare | Action |
|---|---|---|---|---|---|---|
| 1 | 0 | 6 | 3 | 40 | 50 > 40 | `left = 4` |
| 2 | 4 | 6 | 5 | 60 | 50 < 60 | `right = 4` |
| 3 | 4 | 4 | 4 | 50 | equal | **return 4** ✔ |

### B. Not found — same array, target **35**
| Round | left | right | middle | arr[middle] | Compare | Action |
|---|---|---|---|---|---|---|
| 1 | 0 | 6 | 3 | 40 | 35 < 40 | `right = 2` |
| 2 | 0 | 2 | 1 | 20 | 35 > 20 | `left = 2` |
| 3 | 2 | 2 | 2 | 30 | 35 > 30 | `left = 3` |
| — | 3 | 2 | | | `left > right` → loop ends | **return -1** ✔ |

### C. Target at the far left — **10**
Round 1: mid=3 (40) → `right=2` · Round 2: mid=1 (20) → `right=0` · Round 3: mid=0 (10) → **return 0**.

## 5. ⚠ The Day 28 test data is INVALID

```java
int num[] = {10, 20, 42, 10, 49, 38};     // ❌ NOT sorted (42 then 10; 49 then 38)
int res = binarySearch(num, 49);          //   returned 4 … by luck
```

Verified by running your algorithm on that array:

| Search | Result | Truth |
|---|---|---|
| 49 | 4 | ✔ (lucky) |
| 20 | 1 | ✔ (lucky) |
| **38** | **-1** | ❌ **exists at index 5** |

Trace of `38`: mid=2 (42) → `38<42`, `right=1` · mid=0 (10) → `38>10`, `left=1` · mid=1 (20) → `left=2` · `left>right` → `-1`. The algorithm threw away the right half — where 38 lives — because the array wasn't sorted.

✅ **Use:** `int num[] = {10, 20, 30, 40, 50, 60, 70};`
🧠 *Your bug was the test input, not the algorithm.* (Reproduce: `java tools/BugProof.java`, section 5.)

## 6. Complexity

| | |
|---|---|
| Best | **O(1)** — first middle is the target |
| Average | **O(log n)** |
| Worst | **O(log n)** — halves each round until 1 element |
| Space | **O(1)** — `left, right, middle` only |

## 7. Common mistakes (this topic)

| # | ❌ | ✅ |
|---|---|---|
| 1 | `target == middle` 💬 | `target == arr[middle]` |
| 2 | `middle` computed before the loop 💬 | inside the loop |
| 3 | `return target` when missing 💬 | `return -1` |
| 4 | `left = middle` / `right = middle` (no ±1) | `middle + 1` / `middle - 1` |
| 5 | `while (left < right)` | `while (left <= right)` |
| 6 | unsorted data 📦 | sort first / use sorted sample |
| 7 | descending array with the ascending code | flip the comparisons (or reverse first) |

## 8. Optional refinement (not a mistake in your code)

`(left + right) / 2` can overflow `int` if `left + right` exceeds ~2.1 billion (arrays that large are rare).
The safe habit: `int middle = left + (right - left) / 2;` — same result, no overflow. *Keep your version while learning; know this exists.*

## 9. One-page recall

```
SORTED ✔
left = 0 · right = length-1
while (left <= right)
   middle = (left + right) / 2      ← inside loop
   target == arr[middle] → return middle
   target >  arr[middle] → left  = middle + 1
   else                  → right = middle - 1
return -1
```

> 🔒 FUTURE (not in ZIP): recursive binary search, first/last occurrence with binary search, binary search on answer.
