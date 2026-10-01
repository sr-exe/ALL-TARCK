---
title: Day by Day — Foundation block + Day 6 → Day 28
---

[← INDEX](INDEX.md)

# 📅 DAY BY DAY (real history — not polished)

**How to read:** each day lists what the **file actually contains**. Mistakes are kept. Mastery is *day-level, evidence-based*.
Legend → [README](README.md). Pattern IDs → [PATTERN_BANK](PATTERN_BANK.md).

## Timeline at a glance

| Day | Main topic | Status | Flag |
|---|---|---|---|
| F | Foundation block (unlabelled Days 1–5) | 🟢/🟡 mix | days not identifiable |
| 6 | Digits recap + first methods | 🟢 | |
| 7 | Methods with return, digit methods | 🟢 | `largest` init 0 |
| 8 | **Arrays begin** | 🟡 | `largest = 0` |
| 9 | Revision + array-in-method | 🟡 | regression `largest = 0` |
| 10 | Arrays+methods, `findMax` fixed, **second largest** | 🟡 | |
| 11 | contains / index / count / reverse | 🟢 | |
| 12 | Array toolkit | 🟢 | |
| 13 | Toolkit + duplicate | 🟡 | `i = 0` latent bug |
| 14 | RECALL + **frequency / alreadySeen** | 🟡 | |
| 15 | RECALL + **mostFrequent** | 🟡 | |
| 16 | Analyzer monolith | 🟡 | messy |
| 17 | *(copy of Day 16)* | ⚪ | no new code |
| 18 | Analyzer **refactor** into methods | 🟡 | |
| 19 | **Strings** begin | 🟡 | |
| 20 | Palindrome (wrong→fixed), `charFrequency` | 🟡 | earlier attempt kept |
| 21 | **String Analyzer** | 🟡 | |
| 22 | Student manager + first/all index | 🟡 | 🚧 unfinished, newline bug |
| 23 | Second largest / **second distinct** / moveZero | 🔴 | active code wrong |
| 24 | moveZero, remove-dup, sorted, asc/desc | 🟡 | |
| 25 | Recalls, **second distinct fixed**, mostFrequent | 🟡 | |
| 26 | `banana` charFrequency rebuild | 🟡 ⚠ | inefficient |
| 27 | first / last / all indices | 🟡 | `[0,0]` bug |
| 28 | **Binary Search** | 🟡 | unsorted test, dry run pending |

---

# 🧱 FOUNDATION BLOCK — Days 1–5 (unnumbered files)

> The ZIP has no `day1…day5`. Files below are **topic-grouped**. Timestamps suggest an Aug 28 → Sep 2 stretch plus older June files ([ARCHIVE_AUDIT](ARCHIVE_AUDIT.md)).

| Block | Files | Topics | Status |
|---|---|---|---|
| F1 Basics & conditions | `hello, java0, conditional, switch1, switch2, project1` | Scanner, arithmetic, if/else, else-if, `switch`, grade ladder | 🟢 (switch: 🟢 after `switch1` bug) |
| F2 Loops & accumulators | `table, loop, plus, fact, pluseven, count, count1, reverse, loop1` | for/while/do-while, break/continue, sum, factorial, digit count/sum/reverse/even count, **palindrome number** | 🟢 |
| F3 Shapes | `pattern, adpattern` | nested loops, 12+ shapes | 🟡 |
| F4 Methods & exercises | `funmeth, ex, exercise` | first methods, Q1–Q10 | 🟢 / 🟡 |
| F5 Arrays intro | `Array.java` | declaration, input loop, linear search | 🟡 |

**Mistakes found:** `switch1` no `break` · `pluseven` `num%2` · `count1` fails on 0 · `project1` int-division percentage · `Array.java` prints "not found" per mismatch · `> 18` boundary · Q1 int division · file names ≠ content (`plus`, `reverse`).
**Correct logic:** see [topics/01](topics/01_FOUNDATIONS_AND_CONTROL_FLOW.md), [02](topics/02_DIGIT_PATTERNS.md), [07](topics/07_STAR_PATTERNS.md).
**Complexity:** loops O(n); digit loops O(d); shapes O(n²).
**Patterns added:** P02, P03, P07, P25 seed (`switch`), P28.
**Revision questions:** (1) Why does a `case` need `break`? (2) What must `orig` do in the palindrome program? (3) When does a `do-while` differ from `while`? (4) What does `%` return? (5) Why `i += 2` prints odd numbers without `if`?
**Reconstruction challenge:** print the multiplication table of `n`, then the sum of digits of a number — blank file, no peeking.

---

# DAY 6 — Digits recap + **first methods**  ·  🟢

**Topics learned:** digit programs revisited (count, sum, even count, largest digit, combined) · **methods**: `greet(String)`, `mul(a,b)` void, `add(a,b)` returns.
**Concepts:** `%10`/`/10`; `void` vs return; caller stores the result.
**Important code:** combined analyzer (`count, sum, largest, even`) — `12864 → 5, 21, 8, 4`; active `add(15,25)`.
**What I was supposed to understand:** a method is *input → processing → return → caller*.
**Mistakes:** none in active code. (`// old concepts` comment = intentional recap.)
**Correct logic:** [topics/03](topics/03_METHODS.md).
**Complexity:** digit loops O(d)/O(1); `add` O(1).
**Mastery:** 🟢
**Revision Qs:** 1) Which operator gives the last digit? 2) What does `void` mean? 3) What is the difference between `mul` (prints) and `add` (returns)? 4) Where does the returned value go?
**Reconstruction:** write `int square(int n)` and call it from `main`.
**Patterns:** P01, P07.

# DAY 7 — Methods with return + digit methods  ·  🟢

**Topics:** `square`, `isEven` (boolean), `largest(a,b,c)`, `sumDigit`, `even`, `odd`; active `evenSum(58392) → 10`.
**Concepts:** return types; boolean methods; wrapping digit loops in methods.
**Mistakes:** `largest(a,b,c)` starts at `0` (breaks for negatives) · unused `int count` inside `evenSum`.
**Correct logic:** start from the first argument: `int largest = a;`.
**Complexity:** O(d) / O(1).
**Mastery:** 🟢
**Revision Qs:** 1) Return type of `isEven`? 2) Why must `largest` not start at 0? 3) What does `evenSum(58392)` add? (8+2)
**Reconstruction:** `boolean isOdd(int n)`.
**Patterns:** P01, P04 (seed), P07.

# DAY 8 — **Arrays begin**  ·  🟡

**Topics:** index access, traversal, sum, largest, smallest, count evens, reverse print, `found` flag, active: **average** (`float`).
**Concepts:** index `0…length-1`, `arr.length`, accumulator over an array.
**Mistakes:** 📦 `largest = 0`; `smallest = 1000`; reverse loop hard-codes `i = 4`; `avg` variable used as *total*.
**Correct logic:** [topics/04 §3](topics/04_ARRAYS_AND_DSA.md).
**Complexity:** O(n)/O(1) each.
**Mastery:** 🟡 — traversal solid; the *starting value* idea not yet solid.
**Revision Qs:** 1) Last valid index? 2) Why start `largest` from `arr[0]`? 3) Average of `{10,20,37,40,50}`? (31.4) 4) What does `arr.length` return?
**Reconstruction:** find the smallest without a magic number.
**Patterns:** P02, P03, P04, P27.

# DAY 9 — Saturday revision + array in a method  ·  🟡

**Topics:** re-does Scanner, even/odd, arithmetic, loops, factorial, digit programs, methods, then `findSum(int arr[])` and `findMax(int arr[])`.
**Concepts:** passing an **array** to a method.
**Mistakes:** 📦 **regression:** active `findMax` uses `largest = 0` again — a bug you already had a fix for on the next day.
**Correct logic:** `arr[0]` + loop from 1 (D10).
**Complexity:** O(n)/O(1).
**Mastery:** 🟡
**Revision Qs:** 1) What breaks `findMax` on negatives? 2) How does a method receive an array? 3) Difference between `findSum` and printing the sum?
**Reconstruction:** `findMax` that survives `{-5,-2,-9}`.
**Patterns:** P01, P04.

# DAY 10 — Arrays + methods, **findMax fixed**, **second largest**  ·  🟡

**Topics:** print array, print evens, sum, **`findMax` with `arr[0]` tested on negatives**, smallest, count even/odd, even sum; **active: `secondL`** (first appearance).
**Concepts:** seed-with-first-two logic for second largest.
**Mistakes:** commented code has a typo (`count = 0;ss`); `secondL` returns the max again when the top two are equal (`{10,10,5}` → 10).
**Correct logic:** [P04](PATTERN_BANK.md#p04--assume--compare--update), [P20](PATTERN_BANK.md#p20--second-largest-duplicates-allowed).
**Complexity:** O(n)/O(1).
**Mastery:** 🟡 (fix of the negative bug is real progress 🟢; second largest is still a memorised template).
**Revision Qs:** 1) Why does the loop start at `2`? 2) What happens to `second` when a new max arrives? 3) `{23,53,14,65,-13,43}` → ? (53) 4) Why did `arr[0]` fix negatives?
**Reconstruction:** second largest on a blank page.
**Patterns added:** P04 (fixed), **P20**.

# DAY 11 — contains / index / count / **reverse** / average  ·  🟢

**Topics:** `newArray(arr,target)` → boolean; `indexS` → index or `-1`; count occurrence; **reverse** (two-pointer swap); active `averageI` (double).
**Concepts:** flag vs early `return`; `-1` sentinel; swap with `temp`; `j--` inside loop.
**Mistakes:** `contains` scans to the end after finding (works, wasteful).
**Complexity:** search best O(1)/worst O(n); reverse O(n)/O(1).
**Mastery:** 🟢
**Revision Qs:** 1) Why `-1` for not found? 2) Why `i < j`? 3) Why need `temp`? 4) `{10,229,308,4012,503}` reversed?
**Reconstruction:** `reverse` from blank.
**Patterns:** P05, P06, P09, P26, P27.

# DAY 12 — Array toolkit  ·  🟢

**Topics:** findLargest, findSmallest, countEvenOdd, searchElement, secondL, reverse, `average` with `(double) total / arr.length`, active **`index`** (first occurrence).
**Mistakes:** typo `assrr[i]` inside a commented block (wouldn't compile).
**Mastery:** 🟢 (all previously seen; cast placed correctly).
**Revision Qs:** 1) Why cast before dividing? 2) Return of `index` when absent? 3) Second largest of `{110,32,14,23,42,13}`? (42)
**Reconstruction:** `countEvenOdd` printing both.
**Patterns:** P03, P04, P10.

# DAY 13 — Toolkit + **duplicate**  ·  🟡

**Topics:** index, occurrence, `sumOfElements` (seed `arr[0]`), reverse, `secondL`, **`duplicate`** (nested `j = i + 1`).
**Mistakes:** 📦 `secondL` loop starts at **`i = 0`** although seeded with two → wrong on `{50,10,20}` (verified); passes the day's own test by luck. `sumOfElements` crashes on empty array.
**Correct logic:** start at `i = 2` ([P20](PATTERN_BANK.md#p20--second-largest-duplicates-allowed)).
**Complexity:** `duplicate` O(n²).
**Mastery:** 🟡
**Revision Qs:** 1) Why is `j = i + 1`? 2) What does `duplicate` return for no duplicates? 3) What is wrong with `i = 0` in `secondL`?
**Reconstruction:** find the first repeated value.
**Patterns added:** **P32**.

# DAY 14 — RECALL + **frequency / alreadySeen (arrays)**  ·  🟡

**Topics:** recalls reverse, `secondL`, occurrence · **new:** frequency of each element using `alreadySeen` + `break`.
**Concepts:** "process each distinct value once" — nested loop looking **backward** (`j < i`).
**Mistakes:** none in active code.
**Correct logic:** [P15](PATTERN_BANK.md#p15--alreadyseen), [P16](PATTERN_BANK.md#p16--frequency-counting).
**Complexity:** O(n²)/O(1).
**Mastery:** 🟡 (first exposure; recalled again D15, D20, D21, D26).
**Revision Qs:** 1) Why `j < i`? 2) What does `alreadySeen` stay `false` for? 3) Output for `{10,32,10,42,10,20,20}`? 4) Why `break` after finding?
**Reconstruction:** frequency of each on `{5,5,7,5,9,7}`.
**Patterns added:** **P15, P16**.

# DAY 15 — RECALL + **mostFrequent**  ·  🟡

**Topics:** reverse ✔, second largest ✔, frequency of each ✔ (marked `DONE` in comments) · **new:** `mostFrequent`.
**Concepts:** assume→compare→update, but the compared value is a **frequency**.
**Mistakes:** none; ties → first wins.
**Complexity:** O(n²).
**Mastery:** 🟡 (`DONE` markers show successful recalls).
**Revision Qs:** 1) Why `>` and not `>=`? 2) What are `mostfrequent` and `highestFrequency` for? 3) Result for `{10,10,20,13,2,3,23,2,3,3}`? (3)
**Reconstruction:** most frequent element from a blank file.
**Patterns added:** **P33**.

# DAY 16 — Revision + **Analyzer monolith**  ·  🟡

**Topics:** digit programs revisited (sum, reverse, factorial, palindrome, count, largest, smallest, evens, even sum) · **active:** a menu app (`do-while` + `switch`) with *Number Analyzer* and *Student Marks Analyzer* (5 marks: total, average, largest, smallest, even count, search, count target, second largest, reverse).
**Concepts:** menu loop, `switch` inside `do-while`, integrating many earlier patterns.
**Mistakes:** 📦 numeric-suffixed names (`largest1/2`, `smallest1`, `temp2/3/5`, `target1`, `count2`) · `long fact` loops `i <= original` (the *user's number*) → overflow · everything in `main`.
**Correct logic:** split into methods → Day 18.
**Complexity:** each feature O(n) or O(d); whole menu O(n) per action.
**Mastery:** 🟡 — everything worked; organisation is weak.
**Revision Qs:** 1) Why `do-while` for a menu? 2) Why did each digit loop need its own copy of `num`? 3) What breaks in the factorial for large input? 4) What does `default` handle?
**Reconstruction:** a 3-option menu (1 sum, 2 reverse, 3 exit) from a blank file.
**Patterns added:** **P25**.

# DAY 17 — *(copy of Day 16)*  ·  ⚪

**What the file is:** the active code is **identical to Day 16** (verified: only `class day17` vs `class day16` differs; the commented experiments were stripped).
**New learning in file:** none. **Mastery:** ⚪ n/a (no evidence either way — I do not credit it or blame it).
**Use:** treat as a clean copy used to start the Day 18 refactor.

# DAY 18 — **Refactor into methods** + nested menus  ·  🟡

**Topics:** array methods (`contains, countOccurrence, index, sumOfArray`) + `arrayAnalyzer(Scanner, int[])`; digit methods (`sumDigits, reverse, isPalindrome, factorial, largestDigit, smallestDigit, countEvenDigits, sumEvenDigits`) + `digitAnalyzer(Scanner)`; top-level menu.
**Concepts:** **method calling method** (`isPalindrome → reverse`), passing `Scanner`/array into methods, nested `do-while`, input asked only for choices 1–8 (`if (choice >= 1 && choice <= 8)`).
**Mistakes:** 📦 `int factorial` overflows after `12!` · digit methods assume `num > 0` (`smallestDigit(0)` = 9).
**Correct logic:** [topics/03](topics/03_METHODS.md), [P24](PATTERN_BANK.md#p24--method-calling-method), [P25](PATTERN_BANK.md#p25--menu-loop).
**Complexity:** unchanged per feature.
**Mastery:** 🟡 — big structural step; single day of evidence.
**Revision Qs:** 1) What does `isPalindrome` call? 2) Why pass `sc` instead of creating a new `Scanner`? 3) Why is `largest` no longer `largest1`? 4) What does `choice != 9` control?
**Reconstruction:** rewrite Day 16's *Student Marks* case as three methods.
**Patterns added:** **P24** consolidated.

# DAY 19 — **Strings begin**  ·  🟡

**Topics:** `charAt` traversal, `countVowels` (via `indexOf`), `countDigits` (char range), `countSpaces`, `reverseString`, active **`palindromeString`** = reverse + `equals`.
**Concepts:** `String` vs `char`, `length()`, `charAt(i)`, `equals`, building a String.
**Mistakes:** `countVowels` only lowercase → `"HELLO"` → 0 (verified).
**Complexity:** counts O(n); reverse by `+` O(n²) in theory (immutable Strings).
**Mastery:** 🟡
**Revision Qs:** 1) `"shubham".length()`? (7) 2) `'a'` vs `"a"`? 3) Why `.equals` not `==`? 4) What does `"aeiou".indexOf(ch) != -1` test?
**Reconstruction:** count spaces in a sentence.
**Patterns added:** **P31, P34**.

# DAY 20 — Palindrome **(wrong → fixed)**, `countChar`, **`charFrequency` + `alreadySeen`**  ·  🟡

**Topics:** palindrome two pointers · ignore-case · `countChar` · active: `charFrequency(str)` calling `alreadySeen(str, index)` and `countChar`.
**Concepts:** two pointers on a String; **extracting `alreadySeen` as its own method**; `continue`.
**📜 Earlier attempt (kept):** `for` loop, `j` never moved, `return true` on mismatch. **Problem:** inverted booleans + no `j--`. **Corrected:** `while (i<j)`, `i++; j--`, `return false` on mismatch, `return true` at end. **Recommended:** the corrected version.
**Complexity:** palindrome O(n)/O(1); `charFrequency("programming")` O(n²).
**Mastery:** 🟡
**Revision Qs:** 1) Why did the first palindrome fail? 2) Why `i < j`? 3) What does `alreadySeen(str, 4)` look at? (indices 0–3) 4) What does `continue` do?
**Reconstruction:** palindrome check from blank; then `charFrequency("hello")`.
**Patterns added:** P09 (strings), P15 (method form).

# DAY 21 — **String Analyzer** (menu app)  ·  🟡

**Topics:** `countChar, countVowels, countDigits, countSpaces, charFrequency, alreadySeen` + `stringAnalyzer(Scanner)` + main menu. Commented Fibonacci at the bottom.
**Concepts:** integrating string helpers; **`sc.nextLine()` to swallow the leftover newline** before reading the string.
**Mistakes:** lowercase-only vowels.
**Complexity:** as Day 19/20.
**Mastery:** 🟡
**Revision Qs:** 1) Why `sc.nextLine()` before `str2 = sc.nextLine()`? 2) Which methods does case 5 depend on? 3) How is a single `char` read from the keyboard?
**Reconstruction:** a 3-option String menu (count vowels / reverse / exit).
**Patterns added:** **P29** (fixed here).

# DAY 22 — Student manager (🚧 unfinished) + first/all index  ·  🟡

**Topics:** `static int count`, `addStudent`, `viewStudents` (parallel arrays `name[]`, `marks[]`) · `lowest`, `largest` · first occurrence · **`findAllIndex` printing** · active: `countOccurence`.
**Concepts:** **logical size vs physical array**, parallel arrays, `static` field.
**Mistakes:** 📦 menu shows *Search* and *Statistics* but no `case 3`/`4` · 📦 **Scanner newline bug returns** (name read as `""`, verified) even though Day 21 fixed it · the file is a scratch stack (several days' experiments).
**Correct logic:** [P14](PATTERN_BANK.md#p14--logical-size-vs-physical-array), [P29](PATTERN_BANK.md#p29--scanner-newline-trap), [P30](PATTERN_BANK.md#p30--parallel-arrays).
**Complexity:** view O(count); search would be O(count).
**Mastery:** 🟡 (array ideas fine) — *student manager itself unfinished*.
**Revision Qs:** 1) What is `count` in `addStudent`? 2) Why loop to `count`, not `name.length`? 3) What does `nextInt()` leave in the buffer? 4) Why do two arrays share an index?
**Reconstruction:** implement option 3 (search by name) — the piece that was never built.
**Patterns added:** **P14, P30**.

# DAY 23 — Second largest / **second distinct (wrong)** / moveZero  ·  🔴

**Topics:** `secondLargest` with `!= larget` (commented) · sum/avg/smallest recalls (commented) · **active `secondDistinct`** · `moveZero` (commented).
**Concepts:** "distinct" second largest; sentinel `MAX_VALUE`; first appearance of `pos` writer.
**📜 Earlier attempts:** (a) `second = arr[0]` — fails `{50,10,20}` → 50. (b) **active code**: tracks `smallest` with `<`, `else if` unreachable — fails `{10,20,30}` → -1.
**Corrected:** Day 25 ([P21](PATTERN_BANK.md#p21--second-distinct-largest)).
**Note:** output `-1` on `{3,3,3,3,3}` looked right, but the logic was wrong.
**Complexity:** O(n)/O(1).
**Mastery:** 🔴 for second distinct · 🟡 for moveZero.
**Revision Qs:** 1) What must `second` be compared against (largest)? 2) Why is the `else if` in D23b unreachable? 3) What does `-1` mean? 4) What does `pos` represent in `moveZero`?
**Reconstruction:** second **distinct** largest with three rules written *first*.
**Patterns added:** P08 (first), **P21 (attempt)**.

# DAY 24 — moveZero, remove duplicates, sorted, **asc/desc/equal/neither**  ·  🟡

**Topics:** `moveZero` (×3) · `duplicate` (remove from sorted, returns `pos`) · `sorted` (commented) · **active `neither(arr)`** with two flags.
**Concepts:** in-place writing (`pos`), sorted ⇒ duplicates adjacent, flags that can only be killed.
**Mistakes:** method name `neither` returns four different words (naming). Empty/1-element array → `"equal"`.
**Correct logic:** [P18](PATTERN_BANK.md#p18--move-zeros), [P19](PATTERN_BANK.md#p19--remove-duplicates-from-sorted-array), [P22](PATTERN_BANK.md#p22--ascending--descending--equal--neither).
**Complexity:** all O(n)/O(1).
**Mastery:** 🟡 (repeated identically → likely templated; blank-page verification still pending).
**Revision Qs:** 1) What does `pos` mean? 2) Why compare `arr[i]` with `arr[i-1]`? 3) Result for `{50,50,50}`? (equal) 4) When are both flags true?
**Reconstruction:** classify `{1,3,2}`, `{5,5,5}`, `{9,4,4,1}` by hand, then code it.
**Patterns added:** **P17, P18, P19, P22**.

# DAY 25 — Recalls, **second distinct fixed**, mostFrequent  ·  🟡

**Topics:** `duplicate` ✔, `moveZero` ✔, **`secondDistinct` corrected (commented)**, active `mostFrequent`.
**Concepts:** `Integer.MIN_VALUE` + `secondFound` flag; the `arr[i] < largest` guard makes it *distinct*.
**Mistakes:** `mostFrequent` loop starts at `0` (harmless self-compare).
**Correct logic:** [P21](PATTERN_BANK.md#p21--second-distinct-largest).
**Mastery:** 🟡 (fix is right, but **it is commented out** and only one appearance → stays a repair-queue item).
**Revision Qs:** 1) Why `MIN_VALUE`? 2) Why `secondFound`? 3) Why `< largest`? 4) Output for `{10,120,10,10,10}`? (10)
**Reconstruction:** rebuild D25 `secondDistinct` from the 3 rules only.
**Patterns:** P21 (correct), P33.

# DAY 26 — `banana` **charFrequency rebuilt inline**  ·  🟡 ⚠

**Topics:** `frequency(String, char)` + `charFrequency` with the `alreadySeen` loop **inside** the method.
**Concepts:** same logic as D20, rewritten from scratch.
**Mistakes:** 📦 `count` computed **before** the skip; unused `int re = frequency(...)`; no `break`.
**Correct logic:** [topics/05](topics/05_STRINGS.md#4-alreadyseen-banana-dry-run).
**Complexity:** O(n²).
**Mastery:** 🟡 — the logic was rebuilt (good sign) but with leftovers (needs spaced recall).
**Revision Qs:** 1) Output for `banana`? 2) Why is `alreadySeen` false at `i=0`? 3) Why is the `re` line useless? 4) When should `count` be computed?
**Reconstruction:** `charFrequency("mississippi")` blank page.
**Patterns:** P15, P16, P24.

# DAY 27 — first / last / **all indices** (count → allocate → fill)  ·  🟡

**Topics:** `findIndex` printing all (commented) · **active `findAllIndex` returns `int[]`** · `lastIndex`/`firstIndex` (commented) · `firstLast` (commented).
**Concepts:** returning an array; `pos` writer in the result; `first` set once vs `last` updated always.
**Mistakes:** 📦 `firstLast` not found → `[0,0]` (verified).
**Correct logic:** [P11](PATTERN_BANK.md#p11--last-occurrence), [P12](PATTERN_BANK.md#p12--first--last-in-one-pass), [P13](PATTERN_BANK.md#p13--count--allocate--fill).
**Complexity:** O(n); result O(k).
**Mastery:** 🟡 — **Day 27 is closed** (per you).
**Revision Qs:** 1) Why count first? 2) Why does `first` stop changing? 3) Why does `last` keep changing? 4) What does the result array store? (indices) 5) `pos` vs `i`?
**Reconstruction:** `int[] findAllIndex(...)` from blank.
**Patterns added:** **P11, P12, P13**.

# DAY 28 — **Binary Search**  ·  🟡

**Topics:** `binarySearch(int[] arr, int target)` — built by you.
**Concepts:** sorted precondition, `left/right/middle`, halving, `-1`.
**Mistakes:** 📦 test array `{10,20,42,10,49,38}` is **unsorted** (verified: `38 → -1` though present). *Algorithm is correct.*
**Correct logic:** [topics/06](topics/06_BINARY_SEARCH.md).
**Complexity:** best O(1) · avg/worst O(log n) · space O(1).
**Mastery:** 🟡 · **dry run not completed** (session tiring).
**Revision Qs:** 1) Why sorted? 2) When `left = middle + 1`? 3) When `right = middle - 1`? 4) Why `left <= right`? 5) Why `arr[middle]`, not `middle`? 6) What does `-1` mean?
**Reconstruction:** rebuild `binarySearch` and dry-run `50` and `35` on `{10,20,30,40,50,60,70}`.
**Patterns added:** **P23**.

---

## 🧭 What the timeline shows (honest reading)

1. **Recall works when repeated:** reverse (D11→16) and second largest (D10→16) stayed identical for days — strong.
2. **Bugs repeat until the pattern is understood, not memorised:** `largest = 0` (D7,8,9), `i = 0` (D13), Scanner newline (D21 → D22).
3. **Days 23–28 are the densest, hardest stretch** (writer pointer, distinct logic, count→fill, binary search). Uneven mastery there is *expected*.
4. **Weak points = where you had to write a wrong version first:** second distinct (D23), palindrome (D20), `firstLast` not-found (D27).
5. **The repair unit is one pattern, not one day.** See [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md).
