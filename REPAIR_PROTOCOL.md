---
title: Repair Protocol — "Bro, I forgot X"
---

[← INDEX](INDEX.md)

# 🔧 REPAIR PROTOCOL

You forgot **one** pattern. You repair **one** pattern. You do **not** restart Java.

## The 6-step loop (≈ 15–25 min)

```
1. FIND    → Pattern ID in the table below
2. SEE     → read ONLY that Pattern Bank box (2 min) — don't copy it
3. CHECK   → COMMON_MISTAKES for that ID (your real past bugs)
4. RECALL  → ACTIVE_RECALL questions tagged with that ID (answer out loud)
5. REBUILD → BLANK_PAGE_RECONSTRUCTION problems tagged with that ID (blank file!)
6. LOG     → one line in CURRENT_STATE + update status (🔴→🟡→🟢)
```

**Exit rule:** two blank-page rebuilds on **different days**, both without peeking → 🟢. One rebuild → 🟡. Gave up / peeked → stays 🔴.

## Pattern lookup (say the name → get the ID)

| You say… | ID | Box | Mistakes | Recall | Blank page |
|---|---|---|---|---|---|
| method / return / caller | P01, P24 | [P01](PATTERN_BANK.md#p01--method-flow) | A16, B12 | R-P01 | BP-P01 |
| sum / factorial / count | P02, P03 | [P02](PATTERN_BANK.md#p02--accumulator) | A13 | R-P03 | BP-P03 |
| largest / smallest | P04 | [P04](PATTERN_BANK.md#p04--assume--compare--update) | A1 | R-P04 | BP-P04 |
| found → return / -1 | P05, P06 | [P05](PATTERN_BANK.md#p05--found--return-early-return) | A11, B4 | R-P05 | BP-P05 |
| digits `%10 /10` | P07 | [P07](PATTERN_BANK.md#p07--digit-peeling) | A14 | R-P07 | BP-P07 |
| `i` vs `pos` | P08 | [P08](PATTERN_BANK.md#p08--scanner-vs-writer-i-vs-pos) | B5 | R-P08 | BP-P18 |
| reverse / two pointers | P09 | [P09](PATTERN_BANK.md#p09--two-pointers) | A5 | R-P09 | BP-P09 |
| first / last / both | P10–P12 | [P12](PATTERN_BANK.md#p12--first--last-in-one-pass) | A6 | R-P12 | BP-P12 |
| all indices | P13 | [P13](PATTERN_BANK.md#p13--count--allocate--fill) | B6, B7 | R-P13 | BP-P13 |
| logical size | P14 | [P14](PATTERN_BANK.md#p14--logical-size-vs-physical-array) | A18 | R-P14 | BP-P14 |
| alreadySeen / frequency | P15, P16 | [P15](PATTERN_BANK.md#p15--alreadyseen) | A16 | R-P15 | BP-P15 |
| sorted reasoning | P17 | [P17](PATTERN_BANK.md#p17--sorted-array-reasoning) | A7 | R-P17 | BP-P17 |
| move zeros | P18 | [P18](PATTERN_BANK.md#p18--move-zeros) | B5 | R-P18 | BP-P18 |
| remove duplicates | P19 | [P19](PATTERN_BANK.md#p19--remove-duplicates-from-sorted-array) | B11 | R-P19 | BP-P19 |
| second largest | P20 | [P20](PATTERN_BANK.md#p20--second-largest-duplicates-allowed) | A2 | R-P20 | BP-P20 |
| **second distinct largest** | **P21** | [P21](PATTERN_BANK.md#p21--second-distinct-largest) | A3, A4 | R-P21 | BP-P21 |
| asc/desc/equal/neither | P22 | [P22](PATTERN_BANK.md#p22--ascending--descending--equal--neither) | B10 | R-P22 | BP-P22 |
| **binary search** | **P23** | [P23](PATTERN_BANK.md#p23--binary-search) | A7, B1–B4 | R-P23 | BP-P23 |
| menu loop / switch | P25 | [P25](PATTERN_BANK.md#p25--menu-loop) | A9, A18 | R-P25 | BP-P25 |
| Scanner newline | P29 | [P29](PATTERN_BANK.md#p29--scanner-newline-trap) | A8 | R-P29 | — |
| string scan / palindrome | P31, P09 | [P31](PATTERN_BANK.md#p31--string-scan--char-tests) | A5 | R-P31 | BP-P31 |
| most frequent | P33 | [P33](PATTERN_BANK.md#p33--most-frequent) | | R-P33 | BP-P33 |
| star shapes | P28 | [P28](PATTERN_BANK.md#p28--nested-loops-for-shapes) | | R-P28 | BP-P28 |

## 🩹 Worked repair — "Bro, I forgot second distinct largest" (P21)

**Step 1–2 (SEE, 2 min):** read only the three rules.
```
bigger than largest      → second = largest ; largest = x
strictly between         → second = x
equal to largest         → ignore
```
**Step 3 (CHECK):** your two past mistakes — D23a (`second = arr[0]`) and D23b (tracked smallest, unreachable `else if`).
**Step 4 (RECALL):** R-P21 questions 1–6 (out loud).
**Step 5 (REBUILD):** BP-P21 Level 1 → 2 → 3. Blank file. Write the **3 rules as comments first**, then the code.
**Step 6 (LOG):** `Dxx | P21 rebuilt 1/2 | 🔴→🟡`. Re-test in 2 days.

> Why this works: your weak points are *rules*, not *syntax*. Once the rules are in your head, the code writes itself.

## 🧯 If the rebuild fails

| Where it broke | Do this |
|---|---|
| can't state the problem in your own words | write 3 examples with expected answers first |
| can't name the variables | read the "VARIABLES" line of that pattern only |
| pseudocode OK, code wrong | translate one line at a time; compare with the template |
| code OK, wrong on edge case | test: all equal, one element, negatives, not found |
| brain tired | **stop.** Dry run tomorrow (the Day 28 rule). |

## ⏱ Spaced schedule for a repaired pattern

`+1 day → +3 days → +7 days → +14 days` (one blank-page rebuild each; skip the rest after two clean passes).

## 🛑 Rules
1. One pattern per repair session.
2. Blank file, no tabs open to the solution.
3. A peek = log it as a peek (honest status).
4. Never mark 🟢 on one pass.
