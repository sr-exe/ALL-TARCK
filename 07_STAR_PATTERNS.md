---
title: Nested Loops — Star & Number Patterns
---

[← INDEX](../INDEX.md) · [P28](../PATTERN_BANK.md#p28--nested-loops-for-shapes)

# ⭐ NESTED LOOPS — SHAPES

**Status 🟡** — 12+ shapes were written correctly in `pattern.java`, `adpattern.java`, `loop1.java` (all but the last are commented out, with the expected output beside them).
⚠ These files are **not revisited after the foundation block** → they are a **spaced-recall candidate**, not a mastered topic.

## The 4-question method (use it on a blank page)

```
1. How many ROWS?                     → outer loop  i = 1..n
2. In row i, what comes first?        → spaces?  how many? (formula in i)
3. Then what?                         → stars/numbers, how many? (formula in i)
4. End of row?                        → System.out.println();  AFTER the inner loops
```

Skeleton:
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= /* spaces(i) */; j++) System.out.print(" ");
    for (int j = 1; j <= /* stars(i)  */; j++) System.out.print("*");
    System.out.println();
}
```

## Formula table (from your files)

| Shape | Row `i` prints | Formula | Your file |
|---|---|---|---|
| Solid rectangle `m×n` | `n` stars | `j <= n` | `pattern` |
| **Hollow rectangle** | star if border else space | `i==1 \|\| j==1 \|\| i==m \|\| j==n` | `pattern`, `adpattern` |
| Right triangle | `i` stars | `j <= i` | `pattern`, `loop1` |
| Inverted triangle | `n-i+1` stars | `i` from n→1, `j <= i` (or `j <= n-i+1`) | `pattern`, `loop1` |
| Right-aligned triangle | spaces `n-i`, stars `i` | 2 inner loops | `pattern` |
| Number triangle `1..i` | `j` | print `j + " "` | `pattern` |
| Inverted number triangle | `1..n-i+1` | `j <= n-i+1` | `pattern` |
| **Floyd's triangle** | running counter | `num` declared **outside** both loops, `num++` | `pattern`, `loop1` |
| 0-1 triangle | 1 if `(i+j)` even else 0 | `(i + j) % 2 == 0` | `pattern` |
| Parallelogram | spaces `n-i`, then `n` stars | | `adpattern` |
| Hollow parallelogram | spaces `n-i`, then border test | | `adpattern` |
| Repeated-number pyramid | spaces `n-i`, then `i` printed `i` times | `print(i + " ")` | `adpattern` |
| **Palindrome pyramid** | spaces `n-i`, `i…1`, then `2…i` | two number loops | `adpattern` |
| **Butterfly** | stars `i`, spaces `2*(n-i)`, stars `i`; then mirrored | 3 inner loops, then bottom half `i = n → 1` | `adpattern` |
| **Pyramid** | spaces `n-i`, stars `2*i-1` | **odd numbers** | `adpattern` (active) |
| **Diamond** | pyramid + inverted pyramid | second loop `i = n → 1` | `adpattern` (active, n=4) |

## Worked examples

### Right-aligned triangle (n = 4)
| i | spaces `n-i` | stars `i` | row |
|---|---|---|---|
| 1 | 3 | 1 | `···*` |
| 2 | 2 | 2 | `··**` |
| 3 | 1 | 3 | `·***` |
| 4 | 0 | 4 | `****` |

### Pyramid (your active `adpattern`, n = 4)
| i | spaces `n-i` | stars `2i-1` |
|---|---|---|
| 1 | 3 | 1 |
| 2 | 2 | 3 |
| 3 | 1 | 5 |
| 4 | 0 | 7 |
```
   *
  ***
 *****
*******
*******      ← second loop runs i = n → 1 with the SAME formulas
 *****
  ***
   *
```
> Note: the second half **repeats** the widest row (`*******` twice). To get a real diamond, start the second loop at `n-1`. (Your output comment shows the repeated row — it's what the code prints.)

### Floyd's triangle — why the counter is outside
```java
int num = 1;                       // OUTSIDE: keeps counting across rows
for (i…) { for (j…) { print(num + " "); num++; } println(); }
```
Put `num = 1` **inside** the outer loop and every row would restart at 1.

### 0-1 triangle
`(i + j) % 2 == 0 → "1 "` else `"0 "` → rows: `1` · `0 1` · `1 0 1` · `0 1 0 1` …

## Mistakes
| ❌ | ✅ |
|---|---|
| `println()` inside the inner loop | after it |
| spaces printed **after** stars (📦 an experiment in `loop1` did this → trailing spaces are invisible, looks left-aligned) | spaces **first** |
| hard-coded `5` in the inner bound (📦 `adpattern` uses `j <= 5`) | use `n` |
| `2*i - 1` vs `2*i` | odd counts → `2i-1` |
| forgetting `" "` between numbers | `print(j + " ")` |

## Blank-page drill (5 min)
Write the 4 questions, then produce: **right triangle → right-aligned triangle → pyramid → hollow rectangle.**
Solutions live only in your own `pattern.java` / `adpattern.java` (commented) — go compare *after* trying.
