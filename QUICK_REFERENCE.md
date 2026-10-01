---
title: Quick Reference — open before coding (1–2 min)
---

[← INDEX](INDEX.md)

# ⚡ QUICK REFERENCE

```
DIGITS
  %10  → last digit            /10 → remove last digit
  while(num>0){ d=num%10; use d; num=num/10; }
  reverse: rev = rev*10 + d    palindrome: save orig FIRST
  digit loops destroy num → keep a copy

METHOD
  input → parameters → processing → return → caller (CATCH the value)
  non-void: every path returns   |   arrays are shared, ints are copied

ARRAY BASICS
  arr[0] first · arr[arr.length-1] last · arr.length (NO brackets)
  loop: for (i=0; i<arr.length; i++)

PATTERNS ON ARRAYS
  count      → Traverse → Condition → count++
  max / min  → ASSUME arr[0] → COMPARE from i=1 → UPDATE      (never 0!)
  found      → return immediately       not found → return -1 AFTER loop
  first      → return i at once         last → keep updating
  all        → COUNT → ALLOCATE → FILL (scan the ORIGINAL, store the INDEX)
  first+last → first set ONCE (if first==-1) · last set EVERY time · start both at -1

i / pos
  i   = SCANNER (reads everything)        pos = WRITER (next place to write)
  write at pos, read from i:  arr[pos] = arr[i]; pos++      pos ≤ i always
  after loop: pos = how many kept

TWO POINTERS
  i=0, j=len-1;  while(i<j){ …; i++; j--; }
  palindrome: mismatch → return false.  survived → return true.

SECOND LARGEST (duplicates count)
  seed from arr[0], arr[1] → loop from i=2
SECOND DISTINCT 🔴
  > largest → shift   |   < largest AND > second → second   |   == largest → ignore
  second=MIN_VALUE + secondFound flag → return -1 if none

SORTED REASONING
  sorted ⇔ no pair arr[i-1] > arr[i]
  sorted ⇒ duplicates adjacent (remove-dup)   sorted ⇒ halve search (binary)
  asc/desc/equal/neither: both flags TRUE; a pair can only KILL one
     equal = both true · neither = both false

REMOVE DUP (sorted):  pos=1; if (arr[i] != arr[i-1]) arr[pos++]=arr[i]; return pos
MOVE ZEROS:           copy non-zeros with pos, then fill tail with 0

STRING
  "abc" String · 'a' char · str.length() · str.charAt(i) · equals (never ==)
  vowel: "aeiou".indexOf(ch) != -1 (lowercase!)     digit: ch>='0' && ch<='9'
  alreadySeen(i): for (j=0; j<i; j++) if same → true      ← look BACKWARD only
  charFrequency: if alreadySeen → continue; else countChar over WHOLE string

BINARY SEARCH  (SORTED ONLY)
  left=0 · right=len-1 · while(left<=right)
  middle=(left+right)/2        ← inside loop
  target == arr[middle] → return middle
  target >  arr[middle] → left  = middle+1
  else                  → right = middle-1
  return -1

SCANNER
  nextInt() leaves "\n" → sc.nextLine() once before reading a full line
  char: sc.next().charAt(0)

SWITCH
  every case ends with break (or it falls through)

BIG-O (one line)
  one loop n · loop in loop n² · halving log n · early return best O(1)
  frequency/mostFrequent n² · binary search log n · moveZero/removeDup n, O(1) space

BEFORE YOU SAY "DONE"
  [ ] returns -1 / false when absent   [ ] empty / one element?   [ ] negatives?
  [ ] all equal?                       [ ] return value used by caller?
  [ ] i vs pos right way round?        [ ] sorted if I used a sorted-only trick?
```

## 🧭 Recognise the problem (30-second router)

| Words in the problem | Reach for |
|---|---|
| "how many", "count" | P03 |
| "largest/smallest" | P04 |
| "is there / where" | P05, P06 |
| "all positions" | P13 |
| "first and last" | P12 |
| "in place", "move", "remove" | P08 (`i`/`pos`) |
| "from both ends", "palindrome", "reverse" | P09 |
| "each distinct", "frequency" | P15 + P16 |
| "second largest" | P20 · "distinct" → P21 |
| "sorted" + "find" | P23 |
| "digits of a number" | P07 |
| "menu" | P25 |

## 🆘 Stuck on a blank page?
`Problem → 2 examples → Pattern → Variables → Pseudocode → Code → Test edge cases`
([ritual](BLANK_PAGE_RECONSTRUCTION.md)) · Forgot one pattern → [REPAIR_PROTOCOL](REPAIR_PROTOCOL.md)
