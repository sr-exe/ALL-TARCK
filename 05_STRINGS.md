---
title: Strings (Days 19–21, 26)
---

[← INDEX](../INDEX.md) · Patterns: [P15](../PATTERN_BANK.md#p15--alreadyseen) · [P16](../PATTERN_BANK.md#p16--frequency-counting) · [P31](../PATTERN_BANK.md#p31--string-scan--char-tests) · [P09](../PATTERN_BANK.md#p09--two-pointers)

# 🔤 STRINGS — the strong revision section

> Strings are a **known retention weakness**. This page is built to be re-read in pieces.
> **Spaced-recall topic:** `alreadySeen` / `charFrequency` (see [CURRENT_STATE](../CURRENT_STATE.md)).

**Status snapshot**

| Topic | Status | Evidence |
|---|---|---|
| `charAt`, `length()`, traversal | 🟢 | D19, 20, 21, 26 |
| vowel / digit / space counting | 🟡 | D19, 21 (lowercase-only vowels) |
| `countChar` | 🟡 | D20, 21 |
| reverse string | 🟡 | D19 |
| palindrome (two pointers) | 🟡 | D20 — first attempt wrong, then fixed |
| **`alreadySeen`, `charFrequency`** | 🟡 ⚠ | D20, 21, 26 (arrays: D14, 15) |
| String Analyzer (menu app) | 🟡 | D21 |
| `StringBuilder`, `split`, `substring`, `compareTo`, … | 🔒 | not in ZIP |

---

## 1. Basics

### Declaration
```java
String str = "banana";     // DOUBLE quotes → String (many characters)
char   ch  = 'b';          // SINGLE quotes → char   (exactly one character)
```

| | `String` | `char` |
|---|---|---|
| Quotes | `"a"` | `'a'` |
| Holds | text (0..many chars) | one character |
| Compare | **`.equals()`** | `==` (or `<`, `>=`) |
| Example test | `str.equals(reverse)` | `ch == ' '` , `ch >= '0' && ch <= '9'` |

> ❌ Comparing Strings with `==`. ✅ `equals`. (You used `.equals` correctly in D19.)

### `length()` and `charAt()`
```java
str.length()      // number of characters → 6 for "banana"     (brackets! arrays use .length without brackets)
str.charAt(0)     // 'b'   first character
str.charAt(5)     // 'a'   last = length() - 1
```
| Index | 0 | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|---|
| char | b | a | n | a | n | a |

> 🧠 `arr.length` (no brackets) vs `str.length()` (brackets).

### Traversal
```java
for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    // use ch
}
```
Same skeleton as arrays — only `arr[i]` becomes `str.charAt(i)`.

---

## 2. Counting tools (all = *Traverse → Condition → Counter++*, [P03](../PATTERN_BANK.md#p03--traverse--condition--counter))

### vowel checking (D19, D21)
```java
static int countVowels(String str) {
    int count = 0;
    String vowels = "aeiou";
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (vowels.indexOf(ch) != -1) {   // indexOf returns -1 when NOT found → != -1 means "is a vowel"
            count++;
        }
    }
    return count;
}
```
- `"shubham"` → `u, a` → **2** ✔ (your D19 output).
- ⚠ **Gap (verified):** `"HELLO"` → **0** (uppercase not in `"aeiou"`). Fix: `vowels.indexOf(Character.toLowerCase(ch))`.

### digit checking
```java
if (ch >= '0' && ch <= '9') count++;
```
`"shu3833wdje193nn391"` → **10** ✔ (D19).
*Why it works:* characters are stored as numbers; `'0'…'9'` are consecutive.

### space checking
```java
if (ch == ' ') count++;
```
`"Hello bro how are you"` → **4** ✔.

### `countChar` (D20, D21) — the building block
```java
static int countChar(String str, char target) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == target) count++;
    }
    return count;
}
```
`countChar("programming", 'g')` → **2** ✔.

> `frequency(arr, target)` (arrays, D14) and `countChar(str, target)` (strings, D20) are **the same pattern**: only the container type changes.

---

## 3. Reverse + palindrome

### Reverse (D19)
```java
String reverse = "";
for (int i = str.length() - 1; i >= 0; i--) {
    reverse = reverse + str.charAt(i);
}
```

### Palindrome — two attempts (D19 vs D20)

| | D19 — reverse then `equals` | D20 — two pointers |
|---|---|---|
| idea | build reverse, compare | compare ends moving inward |
| code | `str.equals(reverseString(str))` | see below |
| cost | O(n) extra space, builds new String | O(1) extra space, stops early |

**📜 D20 earlier attempt (wrong):**
```java
int j = str.length() - 1;
for (int i = 0; i < j; i++) {
    if (str.charAt(i) != str.charAt(j)) return true;   // ❌ true on mismatch
}
return false;                                          // ❌ (and j never changes)
```
**Problem:** `j` is never decremented, and the returns are inverted.
**✅ Corrected (current recommended):**
```java
int i = 0, j = str.length() - 1;
while (i < j) {
    if (str.charAt(i) != str.charAt(j)) return false;  // mismatch → NOT palindrome
    i++;
    j--;
}
return true;                                           // survived everything
```
Ignore-case version (D20): `str = str.toLowerCase();` first → `"MAdam"` → `true`.

---

## 4. `alreadySeen`: banana dry run

### The problem
`charFrequency("banana")` must print **each distinct character once, with its count**:
```
b > 1
a > 3
n > 2
```
Naively looping over every character would print `a` three times. We need a way to say **"skip if this character appeared earlier."**

### The two helper methods (D20 / D21 — *current recommended version*)
```java
static boolean alreadySeen(String str, int index) {
    for (int i = 0; i < index; i++) {                    // only characters BEFORE `index`
        if (str.charAt(i) == str.charAt(index)) {
            return true;
        }
    }
    return false;
}

static void charFrequency(String str) {
    for (int i = 0; i < str.length(); i++) {
        if (alreadySeen(str, i)) {
            continue;                                    // skip repeats
        }
        int frequency = countChar(str, str.charAt(i));   // count in the WHOLE string
        System.out.println(str.charAt(i) + " > " + frequency);
    }
}
```
> (Inside `alreadySeen` the loop variable is `i` and the outer position is `index`. Below I call the outer position **i** and the inner loop **j**, as in D14 / D26.)

### Full trace, `"banana"`

| i | current char | previous chars (`j < i`) | match found? | alreadySeen | processed? | frequency printed |
|---|---|---|---|---|---|---|
| 0 | `b` | *(none — loop doesn't run)* | – | **false** | ✅ yes | `b > 1` |
| 1 | `a` | `b` | no | **false** | ✅ yes | `a > 3` |
| 2 | `n` | `b a` | no | **false** | ✅ yes | `n > 2` |
| 3 | `a` | `b a n` | `a` at j=1 ✔ | **true** | ⛔ skip | – |
| 4 | `n` | `b a n a` | `n` at j=2 ✔ | **true** | ⛔ skip | – |
| 5 | `a` | `b a n a n` | `a` at j=1 ✔ | **true** | ⛔ skip | – |

Output (order = **order of first appearance**): `b > 1`, `a > 3`, `n > 2`.

Where do the counts come from? `countChar("banana", 'a')` scans **all 6** characters → `a` at 1, 3, 5 → **3**.

### Why is the loop `for (int j = 0; j < i; j++)`?

Ask: *"Did this character already appear BEFORE position i?"* → only positions **0 … i-1** matter.

| Variation | What happens on `"banana"` | Verdict |
|---|---|---|
| **`j < i`** (yours) | first occurrence never sees itself → processed once | ✅ |
| `j <= i` | `j == i` compares the char with **itself** → always true → **everything skipped**, prints nothing | ❌ |
| `j < str.length()` (whole string) | first `a` (i=1) sees the later `a` at 3 → "seen" → skipped; the later `a`s see earlier `a`s → skipped → **`a` never printed** (prints only `b > 1`) | ❌ |
| `j = i+1 …` (forward) | that's the *duplicate-detection* pattern (P32), a different question | ❌ here |

> 🧠 **`j < i` = "look BACKWARD only".** Exactly one occurrence of each character — the **first** — finds nothing behind it, so exactly one occurrence gets processed.

### Picture
```
b a n a n a
0 1 2 3 4 5
        ^ i=3  looks back at [0..2] = b a n  → finds 'a' → skip
```

### 📜 Your three versions (history preserved)

| Version | Where | Shape | Note |
|---|---|---|---|
| Arrays, inline | D14, D15 | `alreadySeen` boolean + `break` inside `main` | ✅ correct |
| **Strings, extracted** | **D20, D21** | separate `alreadySeen(str, index)` + `continue` | ✅ **recommended** — cleanest |
| Strings, inline again | D26 (`banana`) | `count` computed **first**, no `break`, unused `int re` | ⚠ works, but wasteful |

D26 issues (all verified by reading): `int count = frequency(str, ch);` is computed **before** the skip check (wasted for repeats); `int re = frequency(str, ch);` is calculated and never used; the inner loop lacks `break`.

### Recall checklist (say aloud)
1. What does `alreadySeen(i)` answer? → *"Has this char appeared earlier?"*
2. Why `j < i`? → *look back only.*
3. When is it `false`? → *first occurrence.*
4. What happens when `true`? → `continue` (skip).
5. Where does the count come from? → `countChar` over the **whole** string.
6. Complexity? → O(n²).

---

## 5. Method calling method (P24)

```
charFrequency ──calls──▶ alreadySeen   (decide: skip?)
              └─calls──▶ countChar     (how many?)

palindromeString ──calls──▶ reverseString
stringAnalyzer   ──calls──▶ countChar / countVowels / countDigits / countSpaces / charFrequency
```
Rule: **input → parameters → processing → return → caller uses the return value.**

---

## 6. String Analyzer architecture (D21)

```
main()
 └─ do { menu 1.String Analyzer  2.Exit } while (choices1 != 2)
        └─ stringAnalyzer(Scanner sc)
             ├─ sc.nextLine();                   ← swallow the leftover "\n"  (P29)
             ├─ String str2 = sc.nextLine();     ← read the whole text
             └─ do { menu 1..6 } while (choices != 6)
                   case 1 → countChar(str2, target)
                   case 2 → countVowels(str2)
                   case 3 → countDigits(str2)
                   case 4 → countSpaces(str2)
                   case 5 → charFrequency(str2)
                   6      → exit to previous menu
```
Design wins ✅: one shared `Scanner`, helper methods reused, nested menus, char read via `sc.next().charAt(0)`.
Watch-outs ⚠: the `sc.nextLine()` fix must be remembered every time (it came back as a bug in D22).

---

## 7. Mistakes specific to Strings

| ❌ | ✅ |
|---|---|
| `str.length` (no brackets) | `str.length()` |
| `"a"` vs `'a'` mixed up | char → `'a'`, String → `"a"` |
| `str1 == str2` | `str1.equals(str2)` |
| palindrome returns `true` on mismatch | `false` on mismatch |
| vowels lowercase only | `toLowerCase()` first |
| `nextInt()` then `nextLine()` | swallow `\n` first |
| computing counts before deciding to skip | decide first, count after |
