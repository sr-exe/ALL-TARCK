---
title: Digit Patterns (Days 2–7, 9, 16, 18)
---

[← INDEX](../INDEX.md) · [P07](../PATTERN_BANK.md#p07--digit-peeling)

# 🔢 DIGIT PATTERNS

**Status: 🟢** — repeated across `count`, `loop1`, D6, D7, D9, D16, D18 (statement form → method form).

## The two tools

```
num % 10   →  LAST digit          1234 % 10 = 4
num / 10   →  REMOVE last digit   1234 / 10 = 123      (integer division drops the remainder)
```

**Why does it work?** In base 10, the last digit is what's left after dividing by 10 (the *remainder*), and `/10` shifts every digit one place right.

## The skeleton (memorise this)

```java
while (num > 0) {
    int digit = num % 10;    // 1. grab the last digit
    // 2. USE digit  (sum / count / compare / build)
    num = num / 10;          // 3. drop it
}
```

```
1234 → digit 4, num 123
123  → digit 3, num 12
12   → digit 2, num 1
1    → digit 1, num 0   ← loop stops
```

| Program | Before loop | Inside (step 2) | After |
|---|---|---|---|
| **Count digits** | `count = 0` | `count++` | print `count` |
| **Sum of digits** | `sum = 0` | `sum = sum + digit` | print `sum` |
| **Reverse** | `rev = 0` | `rev = rev * 10 + digit` | print `rev` |
| **Palindrome** | `orig = num; rev = 0` | build `rev` | `orig == rev` |
| **Largest digit** | `largest = 0` | `if (digit > largest) largest = digit` | |
| **Smallest digit** | `smallest = 9` | `if (digit < smallest) smallest = digit` | |
| **Count even digits** | `count = 0` | `if (digit % 2 == 0) count++` | |
| **Sum of even digits** | `sum = 0` | `if (digit % 2 == 0) sum += digit` | |

> For **digits** it's legitimate to start `largest = 0` / `smallest = 9` (digits are only 0–9). For **arrays** that's the bug A1.

## Dry runs

**Sum of `1234`** → 4 → 7 → 9 → 10 ✔ (D6).

**Reverse of `123`**

| digit | rev before | `rev*10 + digit` | rev after | num after |
|---|---|---|---|---|
| 3 | 0 | 0 + 3 | 3 | 12 |
| 2 | 3 | 30 + 2 | 32 | 1 |
| 1 | 32 | 320 + 1 | **321** | 0 |

**Palindrome `121`:** `orig = 121` saved first → rev = 121 → equal ✔.

**Count even digits of `123456`:** digits 6,5,4,3,2,1 → evens 6,4,2 → **3** ✔ (D6).

## Combined analyzer (D6/D7/D16)

One loop can update several accumulators at once (`count, sum, largest, even`) — D6:
`12864 → Digits 5 · sum 21 · largest 8 · even 4`.
D16 used **separate loops per feature** (needs separate copies `temp, temp2, temp3` because each loop *destroys* `num`). D18 fixed the mess by giving every feature its own **method** (`num` is a private copy inside each).

> 🧠 **The loop destroys `num`.** If you need the number again, keep a copy (`orig`, `temp`) **before** the loop.

## Methods version (D7, D18) — current recommended

```java
static int sumDigits(int num) {
    int sum = 0;
    while (num > 0) { int digit = num % 10; sum += digit; num /= 10; }
    return sum;
}
static int reverse(int num) {
    int rev = 0;
    while (num > 0) { int digit = num % 10; rev = rev * 10 + digit; num /= 10; }
    return rev;
}
static boolean isPalindrome(int num) { return num == reverse(num); }   // method calling method
```
D7 examples: `sumDigit(58392)=27`, `even(58923)=2`, `odd(23451)=3`, `evenSum(58392)=8+2=10`.

## ⚠ Mistakes & edge cases

| ❌ | Why | ✅ |
|---|---|---|
| Not saving `orig` before the loop | after the loop `num == 0` | `int orig = num;` first |
| `while (num > 0)` on **0** | body never runs → `count1` says 0 digits, `smallestDigit(0)` says 9 (verified) | special-case `0` (as in `count.java`) |
| Negative numbers | `-123 > 0` is false → nothing happens | use `Math.abs` / decide behaviour |
| `int` overflow | `factorial(13)` → 1932053504 (verified); reversing `1999999999` overflows | `long`; range check |
| Reverse of `120` = `21` | trailing zero vanishes; palindrome check still fine | know it |
| Wrong test var | 📦 `pluseven` used `num % 2` instead of `i % 2` | test the **loop variable** |

## Recall (10 seconds each)
- `% 10` gives? → **last digit** · `/ 10` gives? → **the rest** · loop ends when? → `num == 0`
- Reverse formula? → `rev * 10 + digit`
- Why `orig`? → the loop consumes `num`.
