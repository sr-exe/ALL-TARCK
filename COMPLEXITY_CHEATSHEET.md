---
title: Complexity Cheat Sheet
---

[← INDEX](INDEX.md)

# ⏱ COMPLEXITY CHEAT SHEET

> ⚪ **Status: INTRODUCED by this book.** Your ZIP contains **no** Big-O notes. Learn it as a *habit of counting loops*, not as a formula.

## 0. How to count (beginner rules)

| You see… | Cost |
|---|---|
| one statement (`sum = sum + x`) | **O(1)** — constant |
| **one** loop over `n` items | **O(n)** |
| loop **inside** a loop (both up to n) | **O(n × n) = O(n²)** |
| two loops **one after another** | O(n) + O(n) = **O(2n) → O(n)** (drop constants) |
| a loop that **halves** the problem each round | **O(log n)** |
| loop over the **digits** of a number | **O(d)** where d = number of digits ≈ log₁₀ n |

- **Best / Average / Worst** = the luckiest / typical / unluckiest input.
- **Space** = *extra* memory beyond the input. Reusing the input array = **O(1)**.
- Big-O drops constants: `2n`, `n/2`, `3n+5` are all **O(n)**.

---

## 1. Master table

| Algorithm | Best | Average | Worst | Space | Why (how derived) |
|---|---|---|---|---|---|
| Sum / average of array | O(n) | O(n) | O(n) | O(1) | must touch every element exactly once |
| Largest / smallest (P04) | O(n) | O(n) | O(n) | O(1) | every element is a possible champion → all n compared |
| Count occurrences (P03) | O(n) | O(n) | O(n) | O(1) | can't stop early: any later element could match |
| **Linear search** / `contains` / first index (P05, P10) | **O(1)** | O(n) | O(n) | O(1) | best: target is first → return at once. Worst: last or absent → all n checked |
| Last index (P11) | O(n) | O(n) | O(n) | O(1) | must scan to the end to be sure no later match |
| First + Last, one pass (P12) | O(n) | O(n) | O(n) | O(1) | one loop; result array is always size 2 |
| **Find all indices** — count + fill (P13) | O(n) | O(n) | O(n) | **O(k)** | two passes = 2n → O(n); result array holds `k` matches |
| Reverse array (P09) | O(n) | O(n) | O(n) | O(1) | n/2 swaps → O(n); swaps in place |
| Second largest (P20) | O(n) | O(n) | O(n) | O(1) | one pass, two variables |
| **Second distinct largest** (P21) | O(n) | O(n) | O(n) | O(1) | one pass, `largest` + `second` + flag |
| **Move zeros** (P18) | O(n) | O(n) | O(n) | **O(1)** | pass 1 = n, fill pass ≤ n → ≤ 2n → O(n); done in place |
| **Remove duplicates, sorted** (P19) | O(n) | O(n) | O(n) | **O(1)** | single pass comparing neighbours; in place |
| Sorted check (P17) | **O(1)** | O(n) | O(n) | O(1) | best: violation at the very start (returns instantly) |
| Asc/Desc/Equal/Neither (P22) | O(n) | O(n) | O(n) | O(1) | flags can only be killed, but we still scan everything |
| Duplicate detect, nested (P32) | **O(1)** | O(n²) | O(n²) | O(1) | best: first two equal. Worst: no duplicate → all pairs ≈ n²/2 |
| Frequency of each — nested (P16) | O(n²) | O(n²) | O(n²) | O(1) | for each `i`: `alreadySeen` O(i) + `frequency` O(n) → n × O(n) |
| **Most frequent** using `frequency()` (P33) | O(n²) | O(n²) | O(n²) | O(1) | n calls × O(n) per call |
| `alreadySeen` (single call) (P15) | O(1) | O(i) | O(i) | O(1) | best: match at j = 0; worst: scans all `i` earlier chars |
| `charFrequency` on a String (P16) | O(n²) | O(n²) | O(n²) | O(1) | same shape as array frequency |
| Digit loops: sum, reverse, count (P07) | O(d) | O(d) | O(d) | O(1) | each `/10` removes one digit; d ≈ log₁₀ n |
| Factorial (loop) (P02) | O(n) | O(n) | O(n) | O(1) | n multiplications |
| Palindrome — two pointers (P09) | **O(1)** | O(n) | O(n) | O(1) | best: first & last differ → false instantly |
| Palindrome — reverse + `equals` (D19) | O(n²)* | O(n²)* | O(n²)* | O(n) | *building the reversed String by `+` copies each time (immutable Strings) → n² in theory |
| Reverse a String by `+` (P34) | O(n²)* | O(n²)* | O(n²)* | O(n) | same reason; `StringBuilder` (🔒 FUTURE) makes it O(n) |
| **Binary Search** (P23) | **O(1)** | O(log n) | O(log n) | **O(1)** | best: hit the middle first. Each round halves the window |

---

## 2. Deriving the important ones

### Linear search — best O(1), average O(n), worst O(n)
```
[ 7 | 3 | 9 | 2 | 5 ]
Target 7 → 1 comparison            (best)
Target 5 → 5 comparisons           (worst)
Target 100 (absent) → 5 comparisons (worst)
Average (target equally likely anywhere) ≈ n/2 → still O(n)
```

### Binary Search — why **log n**?
Each comparison throws away **half** of the remaining window:

```
n = 16   → 8   → 4   → 2   → 1     ⇒  4 rounds  (log₂ 16 = 4)
n = 1000 → 500 → 250 → 125 → … → 1 ⇒  ≈ 10 rounds
n = 1,000,000                       ⇒  ≈ 20 rounds   (vs 1,000,000 for linear!)
```
- **Best O(1):** target is at the first middle.
- **Worst O(log n):** target is absent or found at the last possible round.
- **Space O(1):** only `left`, `right`, `middle` (this iterative version).
- ⚠ Requires **sorted** input. Sorting itself is a separate cost — 🔒 FUTURE.

### Move zeros — O(n) time, O(1) space
```
loop 1 (scanner i)   : n steps
loop 2 (fill zeros)  : n - pos steps      total ≤ 2n → O(n)
no new array         : only `pos`, `i`    → O(1) extra space
```

### Remove duplicates from sorted array — O(n) / O(1)
One loop, `i` from 1 to n-1, one neighbour comparison, writes at `pos` in the **same** array.

### Most frequent with nested `frequency()` — O(n²)
```
for i in 0..n-1:          ← n iterations
    frequency(arr, ...)   ← each call is a loop of n
→ n × n = n²
n = 10  → 100 steps        n = 1,000 → 1,000,000 steps
```

### Find all indices (count + fill) — O(n) time, O(k) space
```
count pass : n
fill pass  : n              → 2n → O(n)
result     : new int[k]     → O(k) extra space   (k = number of matches, worst case k = n)
```

### Digit loops — O(d)
`12345 → 1234 → 123 → 12 → 1 → 0` = 5 iterations = number of digits. For an `int`, d ≤ 10, so effectively tiny.

### Nested `alreadySeen` on "banana" (n = 6)
Comparisons inside `alreadySeen` at `i = 0..5`: 0+1+2+3+4+5 = **15** ≈ n²/2. Plus `countChar` for the 3 processed chars: 3 × 6 = 18. Same growth: **O(n²)**.

---

## 3. Growth intuition

| n | O(log n) | O(n) | O(n²) |
|---|---|---|---|
| 10 | 3 | 10 | 100 |
| 100 | 7 | 100 | 10,000 |
| 1,000 | 10 | 1,000 | 1,000,000 |
| 1,000,000 | 20 | 1,000,000 | 10¹² |

## 4. One-line memory hooks

```
one loop            → O(n)
loop in loop        → O(n²)
halving             → O(log n)
extra array of k    → O(k) space
in place            → O(1) space
early return        → best case O(1)
```

> 🔒 **FUTURE (not in your files):** sorting algorithms, recursion, hashing/maps, StringBuilder, amortized analysis.
