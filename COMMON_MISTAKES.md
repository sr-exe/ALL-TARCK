---
title: Common Mistakes — Bug Book
---

[← INDEX](INDEX.md) · Reproduce the 📦 bugs yourself: `java tools/BugProof.java`

# 🐞 BUG BOOK

Two kinds of entries — **never mixed up**:

| Tag | Meaning |
|---|---|
| 📦 | **Found in your ZIP** and verified (many reproduced by running the code) |
| 💬 | **You reported it from live sessions.** Not visible in the ZIP, so I don't claim a file/day for it |

Format: ❌ Wrong idea → *why wrong* → ✅ Correct idea → 🧠 **Mental rule** · `[Pxx]` = pattern to repair.

---

# PART A — 📦 Bugs found in your files

## A1. `largest = 0` (fails on negatives) — D7, D8, D9 → fixed D10 · `[P04]`
❌ `int largest = 0;` (also `smallest = 1000`)
*Why wrong:* if every number is negative nothing beats `0` → returns `0`, a value **not in the array**.
✅ `int largest = arr[0];` and loop from `1`. (D10 tested it with all-negative data.)
🧠 **Start from a real element, never from a made-up number.**
> 📜 Regression: D9's "revision" file used `largest = 0` again *after* you knew better. Not shameful — it's why revision is needed.

## A2. Second largest loop starts at `i = 0` — D13 · `[P20]`
❌ seeded from `arr[0], arr[1]`, then `for (int i = 0; …)`.
*Why wrong:* the seed already contains `arr[0]`/`arr[1]`; re-processing them can copy `largest` into `second`. Verified: `{50,10,20}` → **50** (should be **20**). Your D13 test passed by luck (max was late in the array).
✅ Seeded with two → **start at `i = 2`** (every other day D10/12/14/15 did this).
🧠 **What you seeded, you don't re-read.**

## A3. Second *distinct* — wrong direction — D23 (active code) · `[P21]`
❌ tracked `smallest`, used `<`, `MAX_VALUE`; `else if (arr[i] < smallest && arr[i] != smallest)` — **unreachable** (the `if` above already caught `arr[i] < smallest`).
*Why wrong:* solves a different problem; `{10,20,30}` → **-1**.
✅ D25 version: `largest`, `MIN_VALUE`, `secondFound`, rule 2 uses `arr[i] < largest`. See [P21](PATTERN_BANK.md#p21--second-distinct-largest).
🧠 **Flip "largest" → flip every comparison. And if an `else if` condition is a subset of the `if`, it can never run.**

## A4. Second largest seeded with `second = arr[0]` — D23 (commented) · `[P21]`
❌ `larget = arr[0]; second = arr[0];` then `!= larget`.
*Why wrong:* if `arr[0]` is the max, `second` starts as the max → `{50,10,20}` → **50**.
✅ `second = Integer.MIN_VALUE` + a flag (`secondFound`).
🧠 **`second` must start as "nothing", not as an element.**

## A5. Palindrome: inverted return + pointer never moved — D20 (earlier attempt) · `[P09]`
❌ ```java
for (int i = 0; i < j; i++) {
    if (str.charAt(i) != str.charAt(j)) return true;   // returns TRUE on mismatch!
}
return false;
```
*Why wrong:* (1) `j` never decrements → always compares against the last char; (2) booleans reversed.
✅ `while (i < j) { if (≠) return false; i++; j--; } return true;`
🧠 **Mismatch ⇒ false immediately. Survived the whole loop ⇒ true.**

## A6. `firstLast` returns `[0,0]` when not found — D27 · `[P12]`
❌ result array created early (defaults `{0,0}`), filled only inside `if`.
*Why wrong:* `[0,0]` reads as "found at index 0". Verified.
✅ Return `new int[]{first, last}` built from `-1` defaults.
🧠 **"Not found" must look different from any real answer** (`-1`).

## A7. Binary Search tested on an unsorted array — D28 · `[P23]`
❌ `int num[] = {10, 20, 42, 10, 49, 38};`
*Why wrong:* Binary Search **assumes sorted**. Verified: searching `38` (exists at index 5) → `-1`; searching `49` "works" **by luck**. 
✅ Algorithm is **correct**; use `{10,20,30,40,50,60,70}`.
🧠 **Sorted first, then Binary Search. A correct program on invalid input still gives wrong output.**

## A8. Scanner newline trap — D22 (had been fixed in D21) · `[P29]`
❌ `choice = sc.nextInt();` then `addStudent` calls `sc.nextLine()` for the name.
*Why wrong:* leftover `\n` is read as an **empty name**. Verified.
✅ `sc.nextLine();` once after `nextInt()` (as in D21).
🧠 **`nextInt()` leaves the Enter key behind.**

## A9. `switch` missing `break` — `switch1.java` · 
❌ `case '*': …` with no `break`.
*Why wrong:* **falls through** into `default` → prints "MUL : 12" **and** "Invalid operation". Verified.
✅ `break;` in every case (all your later switches have it ✅).
🧠 **Every `case` ends with `break` unless you deliberately want fall-through.**

## A10. `pluseven`: `num % 2` instead of `i % 2` — `pluseven.java`
❌ `if (num % 2 == 0) sum = sum + i;`
*Why wrong:* tests the **input** every time. `10` → 55 (sum of all), `9` → 0. Verified. (D9 fixed it correctly with `i % 2`.)
✅ `if (i % 2 == 0)`.
🧠 **Test the loop variable, not the limit.**

## A11. "Not found" printed inside the loop — `Array.java` · `[P27]`
❌ `if (…) print found; else print "not found";` **inside** the `for`.
*Why wrong:* prints "not found" for every non-matching element. Verified.
✅ Return/flag on match; decide "not found" **after** the loop (D11+ use `return -1`).
🧠 **You can only say "not found" after checking everything.**

## A12. Integer division loses decimals — `project1.java`, `exercise.java` Q1
❌ `double percentage = (m1+m2+m3) * 100 / 300;` → all `int` math first → `250` → **83.0** (real 83.33). Q1: `int avg = (a+b+c)/3`.
✅ `* 100.0 / 300` or cast **before** dividing: `(double) total / n` (you did this correctly in D12, D16, D23).
🧠 **Cast (or use a `.0`) *before* the `/`, not after.**

## A13. Factorial overflow — D16 (long), D18 (int), `pFact` · `[P02]`
❌ `int fact` past `12!` → garbage (`13!` → 1932053504, verified). D16 also loops `i <= original` where `original` is the **user's number** (a 5-digit number = 12345 iterations, overflowing).
✅ Limit the input or use `long`/`BigInteger` (🔒 FUTURE). Validate range.
🧠 **`int` holds ≈ 2.1 billion.**

## A14. Digit loops assume `num > 0` — `count1`, D6-D18 · `[P07]`
❌ `while (num > 0)` on `0` never runs → `count1` gives **0 digits**; `smallestDigit(0)` gives **9**.
✅ `count.java` special-cases `0` ✔. Decide what `0`/negatives should do.
🧠 **Test 0 and a one-digit number.**

## A15. Boundary `>` vs `>=` — `conditional.java`, `exercise` Q4
❌ `if (age > 18)` → 18-year-old "not eligible".
✅ `age >= 18`.
🧠 **Ask: does the boundary value belong to the group?**

## A16. Unused / redundant code — D7 (`count`), D25, D26 · `[P24]`
- D26: `int re = frequency(str, ch);` never used → a wasted O(n) call per character.
- D26: `count` computed **before** the `alreadySeen` check → wasted work for skipped chars.
- D26: no `break` in the `alreadySeen` loop (correct, but keeps scanning after it's already true).
- D25 `mostFrequent`: loop starts at `0` (compares `arr[0]` with itself).
✅ Recommended version = D20/D21 (`alreadySeen` as its own method, `continue`).
🧠 **If you don't use the value, don't compute it. Decide *first*, count *after*.**

## A17. Messy names — D16/17
`largest1, largest2, smallest1, temp5, target1, count2` — numeric suffixes because everything lives in one method.
✅ D18 solved it by **splitting into methods** (each has its own `largest`).
🧠 **Numbers in variable names = "this should be a method".**

## A18. Unfinished menu — D22 · `[P25]`
❌ `3. Search students`, `4. Student Statistics` printed, but no `case 3`/`case 4` (no `default` either).
🧠 **Don't advertise a feature you haven't built.** (Status: 🚧 left unfinished.)

## A19. Hard-coded loop bound — D8
❌ `for (int i = 4; i >= 0; i--)` — assumes exactly 5 elements.
✅ `for (int i = arr.length - 1; i >= 0; i--)`.
🧠 **`arr.length`, never a literal.**

## A20. Commented code that wouldn't compile — D10 (`int count = 0;ss`), D12 (`assrr[i]`)
Typos inside commented blocks. Harmless now, but a signal: **commented code is not proven code.**
🧠 **Re-run it before you trust it.**

## A21. Minor logic notes
| File | Note |
|---|---|
| `exercise` Q2 | inner `for (j = i; j <= i; j++)` runs exactly once — pointless loop |
| `exercise` Q10 | `fab(1)` still prints `0 1` (two seeds always printed) |
| `funmeth`/`ex` | ✅ good: `pFact` validates `n < 0` and uses early `return` |
| `switch1` `'/'` | no division-by-zero check |
| `countVowels` (D19/21) | lowercase-only: `"HELLO"` → 0 (verified) |
| files | `plus.java` = factorial, `reverse.java` = prints odd numbers — names don't match content |
| `day17` | exact copy of `day16` (class name aside) |

---

# PART B — 💬 Mistakes you reported from live sessions (not in the ZIP)

I keep them because you asked for them. I do **not** attribute them to a file or day.

## B1. Comparing `target` with `middle` instead of `arr[middle]` · `[P23]`
❌ `if (target == middle)` &nbsp; ✅ `if (target == arr[middle])`
*Why:* `middle` is an **index** (a position), `arr[middle]` is the **value at that position**. You compare value with value.
🧠 **Index is the address; `arr[index]` is what lives there.**

## B2. Forgetting to recalculate `middle` · `[P23]`
❌ computing `middle` once before the loop. ✅ It must be **inside** `while`, because `left`/`right` change every round.
🧠 **New window → new middle.**

## B3. Using `arr[0]` where an index is needed
❌ `return arr[0]` / `arr[0]` as a position. ✅ `return i` (position) vs `return arr[i]` (value).
🧠 **Ask "position or value?" before every return.**

## B4. Returning `target` instead of `-1` · `[P06]`
❌ `return target;` when not found. ✅ `return -1;`
🧠 **Not found = -1, always.** (`target` is what you *asked for*, not an answer.)

## B5. Confusing `i` and `pos` · `[P08]`
❌ `arr[i] = arr[pos]`. ✅ `arr[pos] = arr[i]` — **write at pos, read from i**.
🧠 **`i` reads. `pos` writes.**

## B6. Hard-coding the result-array size · `[P13]`
❌ `new int[3]` because "the sample has 3". ✅ `int count = countOccurence(arr, target); new int[count];`
🧠 **Count first, then allocate.**

## B7. Looping over the result array instead of the original · `[P13]`
❌ `for (i < ar.length) if (ar[i] == target)`. ✅ Scan `arr`, write into `ar[pos]`.
🧠 **Scan the source, write the destination.**

## B8. Forgetting `return`
❌ method with a non-`void` type and a path that ends without `return` → compile error "missing return statement".
✅ Every path returns (usually a final `return -1;` / `return false;`).
🧠 **Non-void ⇒ every road ends in `return`.**

## B9. Wrong boolean logic · partly visible in A5, A3
❌ `return true` on mismatch; wrong `&&`/`||`.
🧠 **Say the condition in English, then translate.**

## B10. Equal vs neither · `[P22]`
❌ treating "not ascending and not descending" as one case.
✅ `equal` = **both** flags true; `neither` = **both** false.
🧠 **Equal = never moved. Neither = moved both ways.**

## B11. Duplicate handling · `[P20, P21, P19]`
❌ treating duplicates as distinct (or the reverse).
✅ Decide first: "second largest" (duplicates count) vs "second **distinct**" (P21) vs "remove duplicates" (needs sorted → P19).
🧠 **Write one sample with duplicates before coding.**

## B12. Calling a method but not using its return value · `[P24]`
❌ `frequency(arr, x);` alone. ✅ `int c = frequency(arr, x);` (or `return`). *(A version of this is visible in D26: `int re`.)*
🧠 **A returned value that isn't caught is thrown away.**

## B13. Unnecessary variables
❌ variables declared but never used. ✅ Delete them; every variable should have a job you can say in one sentence.

## B14. Testing Binary Search on an unsorted array → **see A7** (this is also confirmed in the ZIP).

---

## 🔁 Bug → Pattern quick map

| Bug | Fix pattern |
|---|---|
| A1, A2, A3, A4 | [P04](PATTERN_BANK.md#p04--assume--compare--update), [P20](PATTERN_BANK.md#p20--second-largest-duplicates-allowed), [P21](PATTERN_BANK.md#p21--second-distinct-largest) |
| A5 | [P09](PATTERN_BANK.md#p09--two-pointers) |
| A6, B6, B7 | [P12](PATTERN_BANK.md#p12--first--last-in-one-pass), [P13](PATTERN_BANK.md#p13--count--allocate--fill) |
| A7, B1, B2 | [P23](PATTERN_BANK.md#p23--binary-search) |
| A8 | [P29](PATTERN_BANK.md#p29--scanner-newline-trap) |
| A11, B4 | [P05](PATTERN_BANK.md#p05--found--return-early-return), [P06](PATTERN_BANK.md#p06---1--not-found), [P27](PATTERN_BANK.md#p27--boolean-flag) |
| B5 | [P08](PATTERN_BANK.md#p08--scanner-vs-writer-i-vs-pos) |
| A16, B12 | [P24](PATTERN_BANK.md#p24--method-calling-method) |
