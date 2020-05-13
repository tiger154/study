# study

This repo is for study of algorithm and data structure. 

# Basic knowledge

  1. Big-O 
     - In computer science, big O notation is used to classify algorithms according to how their running time or space requirements grow as the input size grows 
     
     1) O(1) : HashTable - Only once step     
     2) O(log2n) : Binary search
     3) O(n) : Linear search
     4) O(nlog2n) : Between O(n) and O(n2) But much smaller 
     5) O(n^2): Linear search with for inner for
     6) O(n^3) :
  
  2. log2n  

      - 수학에서 이진 로그 (binary logarithm)는 밑이 2인 로그이다. log 2  또는 lb[1]로 표기하며, 2의 거듭제곱의 역함수이다. 
        양의 실수 n과 실수 x에 대하여 x = log 2 n은 2x = n이라는 것과 같다.
      - ex) log 2 1 = 0, log 2 2 = 1, log 2 4 = 2, log 2 32 = 5




* Resources
  - Even if you don't go to any of these colleges, might as well copy the curriculum at top universities, since they have proven to work and the content is mostly public anyway.
CS61B and CS170 at UC Berkeley, 
CS50 at Harvard, 
6.006 at MIT(https://www.youtube.com/watch?v=HtSuA80QTyo&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb), 
15-121 at Carnegie Mellon,
or the appropriate classes at Waterloo, Stanford, CalTech, Princeton, etc. (not sure what the're called)


   
* Video Tutorial Links
  - How I Passed Coding Interviews at Facebook, Google, Lyft, Bloomberg: https://www.youtube.com/watch?v=lDTKnzrX6qU
   

#### 1. What to study(Data Structure & Algorithm)
```
  - 1) Iteration + Recursion
  - 2) Arrays + Matrices
  - 3) Linked Lists
  - 4) Queues + Stacks + Heaps 
  - 5) Sets + Hash Maps 
  - 6) Trees + Binary Search
  - 7) Graphs + DFS + BFS 
  - 8) Tries + Sorting : 30%
    - Merge or Quick is important 

  - 9) Sliding window Algorithm
  - 10) Longest Common SubString/ Longest Common SubSequence Algorithm

  - 1) Memorize implementation + Complexity + Big O notation    
  - 2) Dynamic Programming
    - Memoization(Caching)
    - Divide - and Conquer (Big O faster)
  - 3) Multiple Pointer, Sliding window, Greedy Algoghs
```

#### 2. Most useful Data structure
``` 
   1) HashMap
   2) Queue , Stack
   3) Sets, DFS(Depth First Searh) 
```

#### 3. Test practice 
```
	- Leetcode
	- can find questions by companys , topics etc 
	https://leetcode.com

	- Data Structures sections on GeeksForGeeks:
	1) https://www.geeksforgeeks.org/data-st...
    2) HackerRank site 
    3) Cracking Coding Interview - Find youtube video that is good 

	Gayle Laakmann McDowell's video series on Youtube:
	https://www.youtube.com/watch?v=GKgAV...

	I 10/10 recommend this algorithms book (used at UC Berkeley for CS170): 
	http://algorithmics.lsi.upc.edu/docs/... 
  
  Also algoexpert as well 
 ``` 
  
  
#### 5. How to prepare 
```
  1) Be experienced 
    - Many time is not important, But How to do is more important
    - Find If i would've known everything easier -> My own rule set
      Make it patternize and simple 
    (1) Mistake list  
      - Write code before you know how to solve the problem.. This is soooo right   
      - Multiple pointers 
      - Frequency counting
    (2) Thing why This Im learning would be good at Interview 
      - White board practice to explain 
      - Practice as realistically as possible 
    (3) Do a lot of interview 
      - Mock interviews

  2) Know What you are doing 
    (1) Check all you need to know and Visualize 
       - Description of the problem
       - Sample input outputt
       - Constratints
       - Whiteboard / Shared screen 
    (2) Structure
       1) Explain solution in plain english
       2) Step-by-Step (bullets)
       3) Pseduocode
       4) Functions
       5) Implement 
       * Showing your resonable though process is most important 
   3) Be Smart
```
### Etc 

```
  1. Calculate 2^24 using only paper and explain thought process. 
    - link: https://m.cafe.daum.net/basicgm/KbDY/28
    1) Remember basic 
      - 2 squared 1 ~ 10. 
      - 2^1=2, 2^2=4, 2^3=8, 2^4=16, 2^5=32....2^10=1024 
    2) 1024 ≈ 1000   
    3) If we want to know 2^15 
      - 2^15 = 2^(10+5) = 2^10 * 2^5 
      - We know 2^10 = 1024 ≈ 1000 
      - And we know 2^5 = 32 
      - So => 1000 * 32 = 32,000 can be the result(Approximation)
    4) Now 2^24 would be => 2^(20+4) =>  2^(10+10+4)  => 2^10 * 2^10 * 2^4 
       - 1000 * 1000 * 16 => 16,000,000 would be answer! 
       
  2. What’s the best case and worst case complexity of quick sort and merge sort?
  3. What’s the worst case complexity of an insertion in a hash table?    
```      
       
