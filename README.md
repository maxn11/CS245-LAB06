# CS245-LAB06

Summary:
- This code has linked list functions made by me and is able to collect and store data.
- All of the functions should work as expected with exception of the removeFromEnd function.

Running Times:
- add(n) ~ Running time is O(n) since add appends to the end of the list
- add(n, m) ~ Running time is O(n). Worst case when m is the last position and O(1) if m is the first position
- contains(n) ~ Running time is O(n). Worst case is when n is the last element in the list
- get(n) ~ Running time is O(n). Worst case is when n is the last element in the list
- removeLast() ~ Running time is O(n) since it must reach the end of the list to remove
- remove(n) ~ Running time is O(n). Worst case is when n is the last element in the list
- removeFromEnd(n) ~ Running time is O(n). Worst case is if n is 1 and has to reach the end of the list
