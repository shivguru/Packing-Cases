# Packing-Cases
#Problem Definition:

Just recently, during Lea's visit at her uncle's house, she was reminded that while some
people are quite tall, sadly she is not. She could not even reach the glasses that were
stored in the topmost shelf in the kitchen. Luckily for her, there were a lot of packing
cases lying around and she could use them to build a tower and then climb on it to reach
the glasses.
Building such a tower is of course a very shaky endeavour, and Lea does not want to fall.
So she imposed the following restriction on the tower: Given two packing cases a and b
with dimensions xa; ya; za and xb; yb; zb, case a may only be stacked onto case b if xa < xb
and ya < yb. Please remember that a case can be rotated to t that restriction.
Lea now has to gure out whether it is possible to reach the desired height if she stacks
the cases optimally, or not.

Input
The first line of the input contains an integer t. t test cases follow, each of them separated
by a blank line.
Each test case starts with two integers, h and n, the height the tower should reach and
the number of case types, n lines follow. The i-th line describes the i-th case layout and
contains three integers xi; yi; zi. Lea has exactly 5 Boxes of each type at her disposal.

Output
For each test case, output one line containing \Case #i: x"where i is its number, starting
at 1, and x is either \yes" if Lea can build a tower of height at least h according to the
constraints, or \no" if it is not possible to do so. Each line of the output should end with
a line break.

Constraints
 1 <= t <= 20
 1 <= n <= 1000
 1 <= xi, yi, zi <= 40000
 1 <= h <= 5 * 10^6

#Sample Data: 
Input
2
9 1
5 4 3

7 2
4 2 2
3 1 5

Output
Case #1: no
Case #2: yes
9
