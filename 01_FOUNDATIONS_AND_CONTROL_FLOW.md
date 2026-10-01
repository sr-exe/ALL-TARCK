---
title: Java Foundations, Conditions & Loops (Foundation block, Days 1–5)
---

[← INDEX](../INDEX.md)

# 🏗 FOUNDATIONS · CONDITIONS · LOOPS

> These files are **unnumbered** in your ZIP (no `day1…day5`). They are grouped here by **topic**, not by an invented day.
> Status legend → [README](../README.md).

| Topic | Status | Evidence |
|---|---|---|
| Program skeleton, `main`, `System.out.println` | 🟢 | every file |
| `Scanner` (`nextInt`, `nextDouble`, `next().charAt(0)`, `nextLine`) | 🟢 basics · 🟡 newline trap | `hello`, `project1`, D21/22 |
| Data types: `int, double, float, long, char, boolean, String` | 🟢 | many |
| Arithmetic / `%` / compound `+= ++ --` | 🟢 | many |
| `if / else / else-if` | 🟢 | `conditional`, `project1` |
| `switch` | 🟢 (after first bug) | `switch1` ⚠ → `switch2` ✔ → analyzers |
| `for`, `while`, `do-while` | 🟢 | `loop`, `loop1` |
| `break`, `continue` | 🟡 | `loop1` demo, D20 `continue` |
| Nested loops / shapes | 🟡 | [07](07_STAR_PATTERNS.md) |
| Type casting `(double)` | 🟢 | D12, D16, D23 |
| `Math.PI` | ⚪ | `exercise` Q3 |
| `Integer.MIN_VALUE / MAX_VALUE` | 🟡 | D23, D25 |

## 1. Skeleton
```java
import java.util.*;                       // Scanner lives here
public class hello {                      // class name = file name
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("The sum is : " + (a + b));
    }
}
```
- File `hello.java` ↔ `public class hello`. (The ZIP holds both `Hello.class` and `hello.class`, which hints the class was once named with a capital `H` — I can't confirm more than that.)
- `sc.close()` used from `java0`/`switch2` onward (good habit; closing is optional in tiny programs).

### Scanner cheat
| Read | Code |
|---|---|
| int | `sc.nextInt()` |
| double | `sc.nextDouble()` |
| one word | `sc.next()` |
| one **char** | `sc.next().charAt(0)` |
| whole line | `sc.nextLine()` |
> ⚠ **Newline trap** (P29): after `nextInt()`, call `sc.nextLine()` once before reading a full line.

### `+` with text vs numbers
`"Sum : " + (a + b)` — **parentheses** decide: `"S" + a + b` concatenates digits; `"S" + (a+b)` adds first.

## 2. Conditions

```java
if (number % 2 == 0) { even } else { odd }             // java0, conditional (commented)
if (a == b) ... else { if (a > b) ... else ... }       // nested
if (button == 1) ... else if (button == 2) ... else if (button == 3) ... else ...   // ladder
```
`project1` — grade ladder (order matters: highest threshold **first**):
```java
if (percentage >= 85) A else if (>= 75) B else if (>= 65) C else fail
```
| Note | |
|---|---|
| ⚠ 📦 `(m1+m2+m3)*100/300` is **int math** → 250 → `83.0` (truth `83.33`) | use `100.0` |
| ⚠ 📦 `age > 18` (Adult/vote) excludes 18 | `>=` |
| `%` even/odd test | `n % 2 == 0` even |

### switch
```java
switch (num) {
    case 1: System.out.println("Monday"); break;    // ← break !
    case 2: ...
    default: System.out.println("Invalid day");
}
```
- 📜 **Earlier attempt (`switch1`):** `case '*'` had no `break` → also printed the `default` message (verified). ✅ `switch2` has all breaks; the analyzers (D16–D22) too.
- `switch` on `char` uses single quotes `case '+':`. Division case has **no zero check**.
- When `switch`? → *one variable, several fixed values.* When `if`? → *ranges / conditions.*

## 3. Loops

| Loop | Use when | Example in your files |
|---|---|---|
| `for (init; cond; step)` | you know how many times | table, patterns, arrays |
| `while (cond)` | repeat until something changes | digit peeling |
| `do { } while (cond);` | must run **at least once** | menus (D16+) |

```java
for (int i = 1; i <= 10; i++) System.out.println(num * i);     // table.java
for (int i = 2; i <= 20; i += 2) ...                            // evens without `if` (loop1)
```
`loop.java` comments show the **difference** experiment: `while(i<11)` with `i=12` prints nothing; `do…while(i<11)` prints **once**.

### break / continue (loop1)
```java
if (i == 7) break;       // leave the loop entirely   → prints 1..6
if (i == 5) continue;    // skip THIS round only       → prints 1..4, 6..10
```
Used later: `alreadySeen` uses `break` (D14) and `continue` (D20).

## 4. Loop mini-programs (foundation)

| Program | Pattern | Note |
|---|---|---|
| multiplication table | loop `1..10` | |
| sum `1..n` | accumulator `0` | |
| factorial | accumulator `1` | 📦 overflow `> 12!` (int) |
| sum of evens | `if (i % 2 == 0)` | 📦 `pluseven` tested `num` |
| count digits | digit peeling | `count.java` handles `0` |
| odd numbers | `i += 2` | `reverse.java` (misnamed) |
| pos/neg/zero counter | 3 counters + else-if | `exercise` Q7 |
| power `x^n` | product `1`, loop `n` times | Q8 |
| GCD | try `1..min`, keep the last common divisor | Q9 (brute force, O(min(a,b))) |
| Fibonacci | `first, second, next` shift | Q10 (`first=second; second=next;`) |
| average of 3 | ⚠ `int` division | Q1 |
| circumference | `2 * Math.PI * r` with `double` | Q3 |

### Fibonacci shift (memory picture)
```
first=0 second=1     next = first + second = 1
                     first = second (1) ; second = next (1)
                     → 0 1 1 2 3 5 8 …
```
⚠ Q10 always prints the two seeds, so `fab(1)` shows `0 1`.

## 5. Recall
1. `%` vs `/` on ints? 2. What does `do-while` guarantee? 3. Why does a `case` need `break`? 4. What do `break` and `continue` do differently? 5. Why parentheses in `"Sum: " + (a+b)`?
