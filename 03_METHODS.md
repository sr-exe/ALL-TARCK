---
title: Methods (Day 6 onward)
---

[← INDEX](../INDEX.md) · [P01](../PATTERN_BANK.md#p01--method-flow) · [P24](../PATTERN_BANK.md#p24--method-calling-method)

# 🧰 METHODS

**Status:** basics 🟢 (used in every file from D6) · method-calling-method 🟡 · passing `Scanner` to methods 🟡.
*Earlier exposure:* `funmeth.java`, `ex.java`, `exercise.java` (unnumbered) already used methods; D6 re-introduces them ("METHODS" heading).

## 1. Flow

```
INPUT → PARAMETERS → PROCESSING → RETURN → CALLER
```
```java
static int add(int a, int b) {     // return type · name · (parameters)
    return a + b;                  // processing + return
}
public static void main(String args[]) {
    int sum = add(15, 25);         // CALLER stores the returned value
    System.out.println("sum = " + sum);   // 40
}
```

## 2. Anatomy

| Part | Example | Meaning |
|---|---|---|
| `static` | `static int add(...)` | callable from `static main` without an object (objects = 🔒 FUTURE) |
| return type | `int`, `boolean`, `double`, `String`, `int[]`, `void` | what comes **out** |
| name | `add`, `isEven`, `findAllIndex` | verb-ish, describes the job |
| parameters | `(int a, int b)`, `(int arr[], int target)` | what goes **in** |
| `return` | `return a + b;` | hands the value back **and ends the method** |

### `void` vs value-returning

| | `void` | returns a value |
|---|---|---|
| D6 | `greet(String name)`, `mul(a,b)` (prints) | `add(a,b)` |
| Use | do something (print, modify array) | compute something the caller needs |
| Caller | just call it | **catch** it: `int r = f();` |

## 3. Progression seen in your files

| Day | New idea | Example |
|---|---|---|
| unnumbered | first methods | `cal(a,b)`, `pFact(n)` with **early return** on invalid input, `greater(a,b)` |
| D6 | void / value | `greet("Shubham")`, `mul(7,6)`, `add(15,25)` |
| D7 | return types | `square`, `isEven` (**boolean**), `largest(a,b,c)`, `sumDigit`, `even`, `odd` |
| D9 | **array parameter** | `findSum(int arr[])`, `findMax(int arr[])` |
| D10–15 | array algorithms as methods | second largest, reverse (`void`, changes original), frequency |
| D18 | **method calls method**; `Scanner` as a parameter; nested menus | `isPalindrome → reverse`, `arrayAnalyzer(sc, arr)` |
| D19–21 | String parameters | `countChar(String, char)`, `alreadySeen(String, int)` |
| D27 | **returning an array** | `int[] findAllIndex(...)`, `int[] firstLast(...)` |

## 4. Rules to keep

1. **Return type must match what you `return`** (`int` method → `return` an int).
2. **Every path returns** (non-void): finish with a `return -1;` / `return false;`.
3. **Catch the return value** or it is lost (📦 D26 `int re`).
4. **Local variables belong to their method.** `num` inside `sumDigits` is a *copy*; the caller's `num` is unchanged (ints are passed by value).
5. **Arrays are the exception:** the method gets a reference to the *same* array → `reverse(arr)` / `moveZero(arr)` change the caller's array.
6. Create **one** `Scanner` and pass it down (`stringAnalyzer(sc)`); don't make a new one per method.
7. If a variable name ends in a number (`largest1`, `largest2`) → make it a method (D16 → D18).

## 5. Dry run — method calling method

```java
static int reverse(int num) { ... }
static boolean isPalindrome(int num) {
    int original = num;
    int rev = reverse(num);        // ① jump to reverse(121) → returns 121
    return original == rev;        // ② 121 == 121 → true
}
isPalindrome(121);                 // caller receives true
```
```
main ──▶ isPalindrome(121) ──▶ reverse(121) ──▶ returns 121
                          ◀── true          ◀──
```

## 6. Mistakes
| ❌ | ✅ |
|---|---|
| `add(2,3);` and expecting to use the answer | `int r = add(2,3);` |
| `void` method with `return 5;` | change type, or print instead |
| missing `return` on some path | add final `return` |
| passing wrong types (`double` into `int` param) | match or cast |
| putting everything in `main` (D16) | split into methods (D18) |
