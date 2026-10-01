---
title: Master Checklist
---

[← INDEX](INDEX.md)

# ✅ MASTER CHECKLIST

Legend: 🟢 mastered · 🟡 familiar · 🔴 weak · ⚪ introduced · 🔒 FUTURE (**not in the ZIP**)
`[x]` = learned/present in the ZIP · `[ ]` = not yet (or not proven). A `[x]` with 🟡 means *understood*, not *mastered*.

> **Rule:** 🟢 needs repeated or independent proof. Single-day exposure = 🟡 at most.

---

## CORE JAVA (Days 1–28)

| Done | Topic | Status | Evidence / note |
|---|---|---|---|
| [x] | Program skeleton, `main`, print | 🟢 | every file |
| [x] | Scanner input | 🟢 | `hello` … D22 |
| [x] | Scanner `nextLine` newline trap | 🟡 | fixed D21, **bug returned D22** |
| [x] | Variables & data types (`int, double, float, long, char, boolean, String`) | 🟢 | many |
| [x] | Arithmetic, `%`, `/`, compound ops | 🟢 | |
| [x] | Integer division pitfall | 🟡 | bug in `project1`, Q1; correct casts D12/16/23 |
| [x] | `if / else-if / else` | 🟢 | `conditional`, `project1` |
| [x] | Logical operators `&&  \|\|  !` | 🟢 | hollow shapes, D16 |
| [x] | `switch` | 🟢 | `switch1` bug → fixed later |
| [x] | `for` loop | 🟢 | |
| [x] | `while` loop | 🟢 | |
| [x] | `do-while` | 🟢 | menus D16+ |
| [x] | `break`, `continue` | 🟡 | `loop1`, D14, D20 |
| [x] | Nested loops (shapes) | 🟡 | 12+ shapes, not revisited |
| [x] | Methods: void / return | 🟢 | D6+ |
| [x] | Methods with array parameters | 🟢 | D9+ |
| [x] | Method calling method | 🟡 | D18–D21, D25 |
| [x] | Method returning an array | 🟡 | D27 (single day) |
| [x] | Passing `Scanner` to methods | 🟡 | D18, D21 |
| [x] | Arrays: declare, index, `length` | 🟢 | |
| [x] | Array input / output | 🟢 | `Array.java`, D16 |
| [x] | Parallel arrays | ⚪ | D22 (unfinished) |
| [x] | Strings: `length`, `charAt`, traversal | 🟡 | D19–21, 26 |
| [x] | `String` vs `char`, `equals` | 🟡 | |
| [x] | `toLowerCase` | ⚪ | D20 |
| [x] | `static` field (`static int count`) | ⚪ | D22 |
| [x] | `Integer.MIN_VALUE / MAX_VALUE` | 🟡 | D23, D25 |
| [x] | Type casting `(double)` | 🟢 | |
| [x] | `Math.PI` | ⚪ | Q3 |
| [x] | Menu-driven programs | 🟢 | D16, 17, 18, 21 |
| [ ] | `StringBuilder` | 🔒 | |
| [ ] | 2D arrays | 🔒 | |
| [ ] | `Arrays` class (`sort`, `toString`) | 🔒 | |
| [ ] | `split`, `substring`, `compareTo` | 🔒 | |
| [ ] | Recursion | 🔒 | |
| [ ] | Wrapper classes, `Math` methods beyond `PI` | 🔒 | |

## DSA (Days 8–28)

| Done | Topic | Status | Pattern |
|---|---|---|---|
| [x] | Array traversal | 🟢 | P03 |
| [x] | Sum / average | 🟢 | P02 |
| [x] | Largest / smallest | 🟢 | P04 (regressed once D9) |
| [x] | Contains / linear search | 🟢 | P05 |
| [x] | Count occurrence | 🟢 | P03 |
| [x] | First index (`-1` = absent) | 🟢 | P10, P06 |
| [x] | Last index | 🟡 | P11 |
| [x] | First + last, one pass | 🟡 | P12 (⚠ `[0,0]` bug) |
| [x] | All indices (count→allocate→fill) | 🟡 | P13 |
| [x] | Reverse (two pointers + swap) | 🟢 | P09 — repeated D11→16 |
| [x] | Second largest | 🟡 | P20 |
| [x] | **Second distinct largest** | 🔴 | P21 — D23 wrong → D25 right (commented) |
| [x] | Move zeros | 🟡 | P18 |
| [x] | Remove duplicates (sorted) | 🟡 | P19 |
| [x] | Sorted check | 🟡 | P17 |
| [x] | Ascending / descending / equal / neither | 🟡 | P22 |
| [x] | Frequency of each (alreadySeen) | 🟡 | P15, P16 |
| [x] | Most frequent | 🟡 | P33 |
| [x] | Duplicate detection (pair check) | 🟡 | P32 |
| [x] | Two pointers (arrays) | 🟢 | P09 |
| [x] | Two pointers (strings / palindrome) | 🟡 | P09 |
| [x] | Scanner `i` / writer `pos` | 🟡 | P08 |
| [x] | Logical vs physical size | 🟡 | P14 |
| [x] | **Binary Search** | 🟡 | P23 — dry run pending |
| [x] | Digit manipulation | 🟢 | P07 |
| [x] | **Big-O reasoning** | ⚪ | **added by this book**, not in your files |
| [ ] | Sorting algorithms (bubble, selection, insertion…) | 🔒 | |
| [ ] | Prefix sum, sliding window | 🔒 | |
| [ ] | Hashing / frequency maps | 🔒 | |
| [ ] | Recursion & backtracking | 🔒 | |
| [ ] | Linked list, stack, queue | 🔒 | |
| [ ] | Trees, graphs | 🔒 | |
| [ ] | Dynamic programming | 🔒 | |
| [ ] | Binary search variants (first/last occurrence, on answer) | 🔒 | |

## 🔴 WEAK / REPAIR QUEUE

| Priority | Item | Next action |
|---|---|---|
| 1 | Second distinct largest (P21) | BP-P21-1, BP-P21-2, BP-P21-4 |
| 2 | Binary Search dry run (P23) | trace `50` and `35` |
| 3 | `alreadySeen` / `charFrequency` (P15) | BP-P15-2, BP-P15-4 |
| 4 | `firstLast` not-found (P12) | BP-P12-2 |
| 5 | Scanner newline (P29) | the 3-line fix, practise once |

## FUTURE — JAVA FULL STACK (all 🔒, **none** appear in the ZIP)

| Area | Topics |
|---|---|
| **OOP** | classes, objects, constructors, `this`, encapsulation, inheritance, polymorphism, abstraction, interfaces, `static` vs instance (beyond one `static int count`) |
| **Core library** | Collections (List, Set, Map), Generics, Exceptions, File Handling, Streams, Lambdas |
| **Concurrency** | Multithreading |
| **Databases** | SQL, JDBC |
| **Frontend** | HTML, CSS, JavaScript, React |
| **Backend** | Spring, Spring Boot, REST APIs, JPA/Hibernate, Maven/Gradle, Git (not in ZIP) |
| **Other** | Testing (JUnit), Security, Deployment |

> ⚠ `01.py` (Python turtle drawing) is in the ZIP but is **not** Java learning — not counted.

## 📈 Summary counts (core + DSA rows, by status)

| 🟢 | 🟡 | 🔴 | ⚪ | 🔒 |
|---|---|---|---|---|
| 25 | 25 | 1 | 5 | 14 |

*(70 rows counted from the tables above. 🟢 and 🟡 are tied — honest, because most Day 23–28 material is understood but not yet independently rebuilt on a blank page. Only **one** item is 🔴: second distinct largest.)*
