---
title: Active Recall System
---

[← INDEX](INDEX.md) · Repair a pattern: [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md)

# 🧠 ACTIVE RECALL

> **Rule:** answer **out loud or on paper first**. Open `<details>` only after. A peek counts as a miss.
> Don't reread the whole book. Pick **one** level per day.

| Level | Time | When |
|---|---|---|
| [5-minute](#-5-minute-recall) | 5 | every day, even tired |
| [15-minute](#-15-minute-recall) | 15 | normal day |
| [30-minute](#-30-minute-revision) | 30 | weekend / before new topic |
| [Full](#-full-revision-checkpoint) | 60+ | every ~2 weeks |
| [Tagged bank](#-tagged-question-bank-by-pattern) | — | repair one pattern |

---

# ⚡ 5-MINUTE RECALL

**Pick 6.** Answer in one sentence each.

1. What does `% 10` give? <details><summary>ans</summary>The last digit.</details>
2. Why do we use `/ 10` in a digit loop? <details><summary>ans</summary>Integer division drops the last digit, so the number shrinks until it hits 0.</details>
3. What does `-1` represent in `findIndex`? <details><summary>ans</summary>"Not found" — it can't be a valid index.</details>
4. Why does `firstIndex` stop changing? <details><summary>ans</summary>Guard `if (first == -1)` is false after the first hit.</details>
5. Why does `lastIndex` keep changing? <details><summary>ans</summary>We can't know a match is the last until the loop ends, so every match overwrites it.</details>
6. What is `i`? <details><summary>ans</summary>The scanner — visits every element, always moves forward.</details>
7. What is `pos`? <details><summary>ans</summary>The writer — the next place to write; moves only when we keep something. After the loop it equals the count of kept items.</details>
8. Why `j < i` in `alreadySeen`? <details><summary>ans</summary>Look only at characters/elements **before** i. First occurrence finds nothing behind it → not seen.</details>
9. Why must Binary Search use a sorted array? <details><summary>ans</summary>Discarding half is only safe if everything on one side is ≤/≥ the middle.</details>
10. When do we move `left`? <details><summary>ans</summary>`target > arr[middle]` → `left = middle + 1`.</details>
11. When do we move `right`? <details><summary>ans</summary>`target < arr[middle]` → `right = middle - 1`.</details>
12. What do you compare `target` with? <details><summary>ans</summary>`arr[middle]` (value), never `middle` (index).</details>
13. What are the 3 rules of second **distinct** largest? <details><summary>ans</summary>bigger → shift · strictly between → second · equal to largest → ignore.</details>
14. Method flow in 5 words? <details><summary>ans</summary>input → parameters → processing → return → caller.</details>
15. `arr.length` vs `str.length()`? <details><summary>ans</summary>Array: no brackets. String: brackets.</details>

**Daily rotation:** Mon digits+arrays · Tue strings · Wed `pos`/`i` · Thu second distinct + sorted · Fri binary search · Sat 15-min · Sun 30-min.

---

# ⏱ 15-MINUTE RECALL

**Do 2 blank-page mini-rebuilds (≈5 min each) + 5 questions (≈5 min).**

### Mini-rebuild menu (choose 2)
- `int findMax(int arr[])` including negatives
- `int index(int arr[], int target)` returning `-1`
- `void reverse(int arr[])`
- `int sumDigits(int n)` / `int reverse(int n)`
- `int countChar(String s, char c)`
- `boolean isPalindrome(String s)` (two pointers)
- `void moveZero(int arr[])`

### Questions
1. Say the 4 steps of the digit loop. <details><summary>ans</summary>`while(num>0)` → `digit = num % 10` → use digit → `num = num / 10`.</details>
2. Why does a palindrome-number program need `orig`? <details><summary>ans</summary>The loop consumes `num` to 0.</details>
3. Why does `findMax` start from `arr[0]`? <details><summary>ans</summary>`0` is not necessarily in the array; all-negative arrays would return 0.</details>
4. Why `i < j` (not `<=`) in reverse? <details><summary>ans</summary>When `i == j` there's one middle element; nothing to swap.</details>
5. Why is the `moveZero` second loop needed? <details><summary>ans</summary>After writing keepers, the tail still holds old values; fill them with 0.</details>
6. What does your remove-duplicates method return? <details><summary>ans</summary>`pos`, the count of unique values (the new logical length).</details>
7. Why does remove-duplicates need a **sorted** array? <details><summary>ans</summary>Only then are equal values adjacent.</details>
8. Equal vs neither? <details><summary>ans</summary>Equal: both flags still true. Neither: both false.</details>

---

# 🕐 30-MINUTE REVISION

**3 blank-page problems (7 min each) + dry run (5 min) + 5 questions (4 min).**

**Set A — arrays:** `findAllIndex` · `firstLast` (with not-found = `{-1,-1}`) · `mostFrequent`.
**Set B — strings:** `charFrequency("banana")` · palindrome (two pointers) · `countVowels` (case-insensitive).
**Set C — logic:** `secondDistinct` · `neither` (asc/desc/equal) · `removeDuplicates`.
**Set D — search:** `binarySearch` + dry run for `50` and `35`.

Dry-run quick card:
```
{10,20,30,40,50,60,70}   target 50 → mid3(40) left=4 → mid5(60) right=4 → mid4(50) ✔ → 4
                         target 35 → mid3(40) right=2 → mid1(20) left=2 → mid2(30) left=3 → -1
```

Questions:
1. Why count before allocating in `findAllIndex`? <details><summary>ans</summary>Array size is fixed; need k first.</details>
2. What's the time/space of `findAllIndex`? <details><summary>ans</summary>O(n) time, O(k) space.</details>
3. What's the complexity of most-frequent with nested `frequency`? <details><summary>ans</summary>O(n²): n calls × O(n).</details>
4. What goes wrong with `j <= i` in `alreadySeen`? <details><summary>ans</summary>Compares the char with itself → always "seen" → nothing printed.</details>
5. What goes wrong with `j < length` in `alreadySeen`? <details><summary>ans</summary>First occurrence sees a later duplicate and skips → some chars never print.</details>

---

# 📋 FULL REVISION CHECKPOINT

Blank file. No notes. Tick honestly.

**Part 1 — Foundations (10 min)**
- [ ] `switch` calculator with `break`s
- [ ] reverse + palindrome of an `int`
- [ ] factorial (and say what limits it)
- [ ] a star triangle + right-aligned triangle

**Part 2 — Arrays (25 min)**
- [ ] largest/smallest (negatives!)
- [ ] index / last index / first+last / all indices
- [ ] reverse (two pointers)
- [ ] second largest AND second **distinct**
- [ ] moveZero · removeDuplicates(sorted)
- [ ] sorted? · asc/desc/equal/neither
- [ ] frequency of each · mostFrequent

**Part 3 — Strings (15 min)**
- [ ] `countChar` · vowels · digits · spaces
- [ ] palindrome (two pointers, ignore case)
- [ ] `charFrequency("banana")` with `alreadySeen` + trace table

**Part 4 — Search (10 min)**
- [ ] `binarySearch` + 2 dry runs
- [ ] explain why the Day 28 test array is invalid

**Part 5 — Meta (5 min)**
- [ ] complexity of each of the above in one word (n, n², log n)
- [ ] 3 bugs you've personally made and how to avoid them

**Scoring:** ≥ 80% clean → move forward · 50–80% → repair the missed patterns · < 50% → repair 1 pattern/day, don't add new topics yet.

---

# 🏷 TAGGED QUESTION BANK (by pattern)

Use with [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md). Tag `R-Pxx`.

### R-P01 Method flow
1. Return type of `isEven`? <details><summary>ans</summary>`boolean`.</details>
2. What happens to a returned value you don't store? <details><summary>ans</summary>It's discarded.</details>
3. Why can `reverse(int arr[])` be `void` yet change the array? <details><summary>ans</summary>Arrays are passed by reference — the method edits the caller's array.</details>
4. Does `sumDigits(num)` change the caller's `num`? <details><summary>ans</summary>No — ints are passed by value (a copy).</details>

### R-P03 / P02 Accumulator + counter
1. Start value for sum? product? count? <details><summary>ans</summary>0 · 1 · 0.</details>
2. Why not `return count;` inside the loop? <details><summary>ans</summary>It would exit after the first element.</details>

### R-P04 Assume→Compare→Update
1. Why `arr[0]` not `0`? <details><summary>ans</summary>Real element; handles negatives.</details>
2. Why loop from `1`? <details><summary>ans</summary>`arr[0]` is already the champion.</details>
3. When is `largest = 0` fine? <details><summary>ans</summary>Digits (0–9).</details>

### R-P05 / P06
1. Where does `return -1` sit? <details><summary>ans</summary>After the loop.</details>
2. Why not `return 0` for not found? <details><summary>ans</summary>0 is a valid index.</details>
3. Best/worst for linear search? <details><summary>ans</summary>O(1) / O(n).</details>

### R-P07 Digits
1. Reverse formula? <details><summary>ans</summary>`rev = rev * 10 + digit`.</details>
2. What does `smallestDigit(0)` return and why? <details><summary>ans</summary>9 — the loop never runs.</details>

### R-P08 `i` vs `pos`
1. Which one reads, which writes? <details><summary>ans</summary>`i` reads; `pos` writes.</details>
2. Is `pos ≤ i` always? <details><summary>ans</summary>Yes — the writer never overtakes the scanner.</details>
3. What is `pos` after the loop? <details><summary>ans</summary>Number of kept elements.</details>

### R-P09 Two pointers
1. Starting positions? <details><summary>ans</summary>`i=0`, `j=length-1`.</details>
2. Palindrome: return value on mismatch? <details><summary>ans</summary>`false` immediately.</details>
3. What was wrong in your first D20 palindrome? <details><summary>ans</summary>`j` never moved; `true` returned on mismatch.</details>

### R-P12 First + last
1. What does `{0,0}` as a not-found answer wrongly suggest? <details><summary>ans</summary>Found at index 0.</details>
2. How to fix? <details><summary>ans</summary>Start `first=last=-1`; return `{first,last}` after the loop.</details>

### R-P13 Count→Allocate→Fill
1. Which array do you loop over? <details><summary>ans</summary>The **original**.</details>
2. What goes into the result? <details><summary>ans</summary>**Indices** (`i`), not values.</details>
3. Result if target is absent? <details><summary>ans</summary>Empty array (`new int[0]`).</details>

### R-P14 Logical size
1. Why loop to `count` and not `name.length`? <details><summary>ans</summary>Slots beyond `count` are unused (`null`/0).</details>

### R-P15 alreadySeen
1. What question does it answer? <details><summary>ans</summary>"Did this value appear before position i?"</details>
2. For `banana`, which `i` are skipped? <details><summary>ans</summary>3, 4, 5.</details>
3. At `i = 0`, what happens? <details><summary>ans</summary>Inner loop doesn't run → `false` → processed.</details>
4. Why compute the count *after* the skip check? <details><summary>ans</summary>Avoid wasted work (D26).</details>

### R-P17 Sorted reasoning
1. `{1,2,2,3}` sorted? <details><summary>ans</summary>Yes (equal allowed).</details>
2. Which tricks need sorted data? <details><summary>ans</summary>Remove-dup by neighbours; binary search.</details>

### R-P18 Move zeros
1. Do zeros get copied in loop 1? <details><summary>ans</summary>No — only non-zeros.</details>
2. Complexity? <details><summary>ans</summary>O(n) time, O(1) space.</details>

### R-P19 Remove duplicates
1. Why `pos = 1`? <details><summary>ans</summary>`arr[0]` is always unique.</details>
2. Why compare with `arr[i-1]`? <details><summary>ans</summary>Sorted ⇒ duplicates adjacent.</details>
3. What do you print afterwards? <details><summary>ans</summary>Only `arr[0 … pos-1]`.</details>

### R-P20 Second largest
1. Where does the loop start and why? <details><summary>ans</summary>`i = 2` — first two were used as the seed.</details>
2. `{50,10,20}` with the D13 version (`i=0`)? <details><summary>ans</summary>50 (wrong); correct is 20.</details>

### R-P21 Second distinct largest 🔴
1. State the 3 rules. <details><summary>ans</summary>bigger → shift · strictly between → second · equal → ignore.</details>
2. Why `secondFound`? <details><summary>ans</summary>`MIN_VALUE` could be real data; the flag says "was it ever set".</details>
3. Why `arr[i] < largest` in rule 2? <details><summary>ans</summary>Duplicates of the max must not become `second`.</details>
4. What do you return for `{3,3,3}`? <details><summary>ans</summary>`-1`.</details>
5. Answer for `{10,120,10,10,10}`? <details><summary>ans</summary>10.</details>
6. Why was D23's active code wrong? <details><summary>ans</summary>It tracked the smallest and its `else if` was unreachable.</details>
7. What does "distinct" change vs plain second largest? <details><summary>ans</summary>`{10,10,5}` → plain = 10; distinct = 5.</details>

### R-P22 Asc/Desc/Equal/Neither
1. Starting flag values? <details><summary>ans</summary>Both `true`.</details>
2. What kills `descending`? <details><summary>ans</summary>A pair where `arr[i] > arr[i-1]`.</details>
3. When do both survive? <details><summary>ans</summary>All elements equal.</details>

### R-P23 Binary Search
1. Pre-condition? <details><summary>ans</summary>Sorted ascending.</details>
2. Loop condition and why `<=`? <details><summary>ans</summary>`left <= right` — window of one element must still be checked.</details>
3. Why `middle ± 1`? <details><summary>ans</summary>`middle` already tested; also guarantees progress.</details>
4. Complexity? <details><summary>ans</summary>O(log n) time, O(1) space.</details>
5. Result of searching `38` in `{10,20,42,10,49,38}`? <details><summary>ans</summary>-1 — invalid input (unsorted).</details>

### R-P25 Menu loop
1. Why `do-while`? <details><summary>ans</summary>Menu must show at least once.</details>
2. What happens without `break` in a case? <details><summary>ans</summary>Falls through into the next case/default.</details>

### R-P28 Shapes
1. What changes per row? <details><summary>ans</summary>Number of spaces and stars (formulas of `i`).</details>
2. Pyramid stars per row? <details><summary>ans</summary>`2*i - 1`.</details>
3. Where is `println()`? <details><summary>ans</summary>After the inner loops.</details>

### R-P29 Scanner trap
1. What does `nextInt()` leave behind? <details><summary>ans</summary>The newline.</details>
2. Fix? <details><summary>ans</summary>`sc.nextLine();` once before the real `nextLine()`.</details>

### R-P31 Strings
1. `'a'` vs `"a"`? <details><summary>ans</summary>char vs String.</details>
2. Compare two Strings? <details><summary>ans</summary>`.equals()`.</details>
3. Digit test for a char? <details><summary>ans</summary>`ch >= '0' && ch <= '9'`.</details>
4. What does `"aeiou".indexOf(ch) != -1` check? <details><summary>ans</summary>Is `ch` one of the vowels?</details>

### R-P33 Most frequent
1. Why `>` not `>=`? <details><summary>ans</summary>Keep the first element that reaches the highest count.</details>
2. Complexity? <details><summary>ans</summary>O(n²).</details>
