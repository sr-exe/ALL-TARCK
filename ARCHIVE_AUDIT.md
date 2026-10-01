---
title: Archive Audit — what is really inside JAVA.zip
---

[← INDEX](INDEX.md)

# 🔍 Archive Audit

**92 entries** → 1 folder, **46 `.java`** (2 of them empty: `for.java`, `26.java`), matching `.class` files (ignored), `01.py`, and `Text File.txt` (empty).
All `.java` files were read completely. `.class` files were ignored (nothing there that the source doesn't show).

---

## 1. How the days were identified

| Evidence | Reliability |
|---|---|
| File names `day6.java … day28.java` | ✅ Strong |
| Comments like `RECALL`, `REVISION`, `DAY continued` | ✅ Strong |
| File timestamps | ⚠ Weak (files get re-saved; `day14.java` was saved Sep 18 but its `.class` is Sep 10) |
| Unnumbered files (`loop1`, `pattern`, `Array`…) | ❌ No day label → **not assigned to a specific day** |

**Two timestamp clusters exist** among unnumbered files:

| Cluster | Files | Note |
|---|---|---|
| Jun 14–22 | `hello, conditional, switch1, pattern, funmeth, ex, exercise, Array` | Older than everything else. Possibly an earlier learning pass. |
| Aug 25 – Sep 5 | `adpattern, java0, switch2, table, plus, fact, count, count1, reverse, loop, loop1, project1, pluseven` | Fits "Day 1 ≈ Aug 28 → Day 6 = Sep 2" |

➡ I treated all unnumbered files as the **Foundation Block (Days 1–5, unlabelled)**.
❓ *Open question for you:* were the June files an earlier pass before Day 1? (Answering just improves labelling — nothing else changes.)

---

## 2. File-by-file status

Legend: ✅ final/good · ⚠ contains bug · 🧪 experiment/scratch · 🚧 unfinished · ♻ duplicate · ⬜ empty · ➖ not Java-learning

### Foundation block

| File | What it holds | Status |
|---|---|---|
| `hello.java` | Scanner, `nextInt`, sum | ✅ |
| `conditional.java` | if/else ladder (button 1–3); older commented: adult check, even/odd, compare two numbers | ✅ (⚠ `age > 18` boundary in commented version) |
| `switch1.java` | switch on button; calculator switch | ⚠ `case '*'` has **no `break`** → falls into `default` |
| `switch2.java` | day-of-week switch, all `break`s, `default`, `sc.close()` | ✅ |
| `java0.java` | even/odd with Scanner | ✅ |
| `for.java`, `Text File.txt`, `26.java` | **0 bytes** | ⬜ empty (`26.java` ≠ `day26.java`) |
| `table.java` | multiplication table | ✅ |
| `loop.java` | for / while / do-while demos (commented) | 🧪 |
| `plus.java` | sum 1..n (commented) → **factorial** active | ⚠ file name says "plus", content is factorial |
| `fact.java` | factorial | ✅ (`int` overflow > 12!) |
| `pluseven.java` | sum of evens 0..n | ⚠ `num % 2` instead of `i % 2` |
| `count.java` / `count1.java` | count digits (`count.java` handles `0`; `count1.java` does not) | ✅ / ⚠ `0` → 0 digits |
| `reverse.java` | prints odd numbers 1–19 | ⚠ name ≠ content (not a reverse) |
| `loop1.java` | loops, break/continue, stars, digit programs, palindrome number | ✅ (many experiments commented) |
| `pattern.java`, `adpattern.java` | 12+ shape/number patterns | 🧪 all commented except last of `adpattern` (diamond halves) |
| `funmeth.java` | first methods: multiply (commented), factorial `pFact` | ✅ |
| `exercise.java` | Q1–Q10 (avg, odd sum, circumference, vote, infinite loop, pos/neg/zero, power, gcd, fibonacci) | ⚠ Q1 int division, Q4 `> 18` |
| `ex.java` | `greater(a,b)` method | ✅ |
| `Array.java` | array input + linear search | ⚠ prints "not found" for **every** mismatch |
| `project1.java` | student result card (if / else-if) | ⚠ integer division in percentage |
| `01.py` | Python turtle drawing, prints a **different name** | ➖ **Excluded** — not Java, not your learning line |

### Numbered days

| File | Real content | Status |
|---|---|---|
| `day6` | digit programs recap + **first methods** | ✅ |
| `day7` | methods with return; digit methods | ✅ (⚠ `largest(a,b,c)` starts at 0) |
| `day8` | **first arrays** | ⚠ largest starts at 0, smallest at 1000 |
| `day9` | big revision + `findSum(arr)` | ⚠ active `findMax` starts at 0 again (regression) |
| `day10` | arrays+methods, `findMax` **fixed with `arr[0]`**, `secondL` | ✅ |
| `day11` | contains, index, count, **reverse**, average | ✅ |
| `day12` | array toolkit + first-index | ✅ |
| `day13` | index, count, sum, reverse, secondL, duplicate | ⚠ `secondL` loop starts at `i = 0` (latent) |
| `day14` | RECALL + frequency of each (alreadySeen, arrays) | ✅ |
| `day15` | RECALL + `mostFrequent` | ✅ |
| `day16` | digit recap + **Analyzer monolith** (menu) | ✅ (⚠ messy names, factorial overflow) |
| `day17` | **exact copy of Day 16** (only class name differs) | ♻ no new learning |
| `day18` | **refactor** of analyzer into methods, nested menus | ✅ (⚠ `int` factorial) |
| `day19` | **first Strings** | ✅ |
| `day20` | palindrome (wrong → fixed), `countChar`, `charFrequency` + `alreadySeen` | ✅ (earlier attempt ⚠ preserved) |
| `day21` | **String Analyzer** | ✅ |
| `day22` | Student manager + array recap + first/all index (scratch stack) | 🚧 unfinished, ⚠ Scanner newline bug |
| `day23` | second largest attempts, **second distinct (wrong)**, moveZero | ⚠ active code is wrong |
| `day24` | moveZero, remove dup, sorted, **asc/desc/equal/neither** | ✅ |
| `day25` | recalls + **second distinct (corrected, commented)** + mostFrequent | ✅ |
| `day26` | `banana` charFrequency rebuilt inline | ✅ (⚠ inefficiencies) |
| `day27` | first/last/all indices, firstLast | ⚠ `firstLast` not-found → `[0,0]` |
| `day28` | **Binary Search** | ✅ algorithm / ⚠ test array not sorted |

---

## 3. Duplicate versions (same problem, many times)

| Problem | Where it repeats | What changed between versions |
|---|---|---|
| Reverse array | D11, 12, 13, 14, 15, 16 | identical every time → real spaced repetition ✅ |
| Second largest | D10, 12, 13, 14, 15, 16, 17, 23 | identical **except** D13 (`i=0` bug) and D23 (`!= largest` attempt) |
| alreadySeen / frequency | D14, 15 (arrays) → D20, 21 (strings, extracted method) → D26 (inline again) | array → string; inline → method → inline |
| Digit sum/reverse/palindrome | loop1, D6, 7, 9, 16, 18 | statement → method |
| moveZero | D23 (comment), D24 ×3, D25 | identical |
| Remove duplicates (sorted) | D24 ×2, D25 | identical |
| Second **distinct** largest | D23 (wrong) → D25 (correct) | see [PATTERN P21](PATTERN_BANK.md#p21--second-distinct-largest) |
| mostFrequent | D15 → D25 | D25 loop starts at `0` instead of `1` (harmless) |
| Analyzer menu | D16 → D17 (copy) → D18 (refactor) → D21 (strings) | monolith → methods |

## 4. Final / "current recommended" version per problem

Kept in the topic files (each shows *Earlier attempt → Problem → Corrected → Current recommended*):
[Arrays & DSA](topics/04_ARRAYS_AND_DSA.md) · [Strings](topics/05_STRINGS.md) · [Binary Search](topics/06_BINARY_SEARCH.md) · [Digits](topics/02_DIGIT_PATTERNS.md)

## 5. Verified by running code

`tools/BugProof.java` reproduces every "📦 verified" claim in this book (Day 13 `i=0`, Day 23 wrong versions, Day 27 `[0,0]`, Day 28 unsorted search, Scanner newline, `switch` fall-through, `pluseven`, overflow). Run it with:

```
java tools/BugProof.java
```
