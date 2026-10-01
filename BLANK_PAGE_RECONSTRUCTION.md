---
title: Blank Page Reconstruction
---

[← INDEX](INDEX.md) · Solutions (open LAST): [BLANK_PAGE_ANSWERS](BLANK_PAGE_ANSWERS.md) · [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md)

# 📄 BLANK PAGE RECONSTRUCTION

**Your weakness:** you understand a solution when you *see* it, but struggle to *build* it from nothing.
**The cure:** a fixed ritual. **Never jump to code.**

## 🔁 The 5-step ritual (every problem)

```
1. PROBLEM   → say it in your own words + write 2 examples (one normal, one edge)
2. PATTERN   → which pattern ID is this?  (look at the list below ONLY if stuck)
3. VARIABLES → what do I need to remember while looping?  (name each one's job)
4. PSEUDOCODE→ 3–6 plain-English lines  (no Java)
5. CODE      → translate line by line, then test on your 2 examples
   ── only now ── open BLANK_PAGE_ANSWERS.md and compare
```

### Pattern cheat-list (for step 2 — peek only if stuck, and log it)
`P03 count` · `P04 max/min` · `P05 found→return` · `P07 digits` · `P08 i/pos` · `P09 two pointers` · `P12 first+last` · `P13 count→allocate→fill` · `P15 alreadySeen` · `P17 sorted` · `P18 move zeros` · `P19 remove dup` · `P20 second largest` · `P21 second distinct` · `P22 asc/desc` · `P23 binary search`

## 📊 Levels

| Level | Meaning | Pass rule |
|---|---|---|
| **L1 — easy** | something you've done many times | no hints, ≤ 5 min |
| **L2 — familiar** | done once or twice, with a twist | variables + pseudocode first |
| **L3 — combination** | uses ≥ 2 patterns | draw a trace table |
| **L4 — unseen variation** | not in your files | the ritual is the only help |

**Log format:** `ID | level | blank? Y/N | peeked? Y/N | result` → paste into [CURRENT_STATE](CURRENT_STATE.md).

---

# L1 — EASY

| ID | Problem | Examples to write |
|---|---|---|
| **BP-P03-1** | `int countEven(int arr[])` | `{2,4,5}`→2 · `{}`→0 |
| **BP-P04-1** | `int findMax(int arr[])` that works with negatives | `{-5,-2,-9}`→-2 |
| **BP-P05-1** | `int index(int arr[], int target)` | present → index · absent → -1 |
| **BP-P07-1** | `int sumDigits(int n)` | 1234→10 |
| **BP-P07-2** | `int reverse(int n)` + `boolean isPalindrome(int n)` | 123→321 · 121→true |
| **BP-P09-1** | `void reverse(int arr[])` | `{1,2,3,4}`→`{4,3,2,1}` |
| **BP-P31-1** | `int countChar(String s, char c)` | ("programming",'g')→2 |
| **BP-P01-1** | `int square(int n)` called from `main`, result printed | 7→49 |
| **BP-P25-1** | 3-option menu: 1 sum, 2 reverse, 3 exit | |

# L2 — FAMILIAR

| ID | Problem | Examples |
|---|---|---|
| **BP-P20-1** | `int secondLargest(int arr[])` (duplicates count) | `{50,10,20}`→20 · `{10,10,5}`→10 |
| **BP-P15-1** | print each distinct element of an int array once with its frequency | `{5,5,7,5,9,7}`→`5>3, 7>2, 9>1` |
| **BP-P15-2** | `charFrequency(String)` using `alreadySeen(String,int)` | "hello"→`h>1 e>1 l>2 o>1` |
| **BP-P31-2** | `boolean isPalindrome(String s)` two pointers, ignore case | "MAdam"→true |
| **BP-P12-1** | `int lastIndex(int[], int)` and `int firstIndex(int[], int)` | |
| **BP-P17-1** | `boolean sorted(int arr[])` | `{1,2,2,3}`→true |
| **BP-P18-1** | `void moveZero(int arr[])` | `{0,1,0,3,12}`→`{1,3,12,0,0}` |
| **BP-P19-1** | `int removeDuplicates(int arr[])` on a sorted array, return new length | `{1,1,2,2,3}`→3 |
| **BP-P33-1** | `int mostFrequent(int arr[])` | `{1,3,3,2,3}`→3 |
| **BP-P23-1** | `int binarySearch(int[], int)` | `{10,20,30,40,50,60,70}`, 50→4 · 35→-1 |
| **BP-P23-2** | Dry-run trace table for the two lines above | table only, no code |

# L3 — COMBINATION

| ID | Problem | Combines |
|---|---|---|
| **BP-P21-1 🔴** | `int secondDistinct(int arr[])`, `-1` if none. **First write the 3 rules as comments.** | P04 + P20 + flag |
| **BP-P21-2 🔴** | Same, but test on: `{10,120,10,10,10}`, `{3,3,3}`, `{10,20,30}`, `{30,20,10}`, `{5}` | edge-case design |
| **BP-P13-1** | `int[] findAllIndex(int[], int)` | P03 + P08 + allocate |
| **BP-P12-2** | `int[] firstLast(int[], int)` returning `{-1,-1}` if absent | P05 + P06 + P11 |
| **BP-P22-1** | `String classify(int[])` → "ascending"/"descending"/"equal"/"neither" | P17 + flags |
| **BP-P14-1** | `addStudent` + `viewStudents` with `count` (logical size) | P14 + P29 |
| **BP-P24-1** | `boolean isPalindrome(int n)` that *calls* `reverse(n)` | P01 + P07 + P24 |
| **BP-P28-1** | Print a pyramid of height `n` using spaces + `2*i-1` stars | P28 |
| **BP-P16-1** | Print the **most frequent character** of a String | P15 + P33 |
| **BP-P09-2** | `String reverseStr(String s)` built with a loop (no library reverse) | P34 + P09 idea |

# L4 — UNSEEN VARIATIONS (not in your files)

Same patterns, new clothes. Use the ritual. These are **tests of transfer**, not trivia.

| ID | Problem | Which pattern is hiding? |
|---|---|---|
| **BP-P08-4** | Move all **even** numbers to the front, keep their order, odds after | P18 (writer `pos`) |
| **BP-P18-4** | Remove **all occurrences** of a value in place; return new length | P08 / P19 |
| **BP-P21-4** | **Third** largest distinct value, `-1` if fewer than 3 distinct | P21 extended |
| **BP-P21-5** | Second **smallest** distinct | P21 mirrored (flip every comparison) |
| **BP-P04-4** | Largest and **its index** in one pass | P04 + P05 |
| **BP-P13-4** | Return the indices of all **even** elements (count → allocate → fill) | P13 with a new condition |
| **BP-P23-4** | Binary search on a **descending** array | P23 mirrored |
| **BP-P23-5** | Binary search that returns the **insertion position** if absent | P23 variation |
| **BP-P15-4** | Print characters that appear **exactly once** | P15 + P16 |
| **BP-P31-4** | Count words in a sentence (spaces between words, no `split`) | P31 |
| **BP-P09-4** | Check if an array is a palindrome | P09 |
| **BP-P17-4** | Check if an array is sorted **descending** | P17 flipped |
| **BP-P07-4** | Count how many digits of a number are **greater than 5**; then the largest digit's *position* | P07 |
| **BP-P28-4** | Hollow pyramid | P28 + border test |

---

## 🎯 Suggested progression (one per day, ≈ 15 min)

```
Week 1: L1 (pick 3) → L2 (pick 2)         ← only if confidence is low
Week 2: BP-P21-1, BP-P23-1, BP-P15-2      ← your repair queue
Week 3: BP-P13-1, BP-P12-2, BP-P22-1
Week 4: two L4 problems per week
```

## 📝 Honest scoring
- 🟢 for a pattern = **two** blank, unpeeked, correct rebuilds on **different days**
- 🟡 = one clean rebuild
- 🔴 = needed a peek or a hint

## Rule
> Tired? Stop after step 4 (pseudocode). Code tomorrow. A half-finished ritual beats a forced one.
