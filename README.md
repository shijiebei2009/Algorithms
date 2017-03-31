Algorithms [![Build Status](https://api.travis-ci.org/shijiebei2009/Algorithms.svg?branch=master)](https://travis-ci.org/shijiebei2009/Algorithms)  [![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
==========

Algorithms playground for common questions solved in Java syntax.

This repository contains my solution for some common algorithms. I've created this repository to learn about algorithms and improve solving different common computer science problems. I'll try to add more solutions if I have time :)

Each solved problem has a program written in Java. Every solution is tested and some problems contains more than one solution with different implementations.

You can check the solution executing tests inside tests directory. Some of this problems have been resolved using TDD.

Problems

--------

### Arrays

* [Clockwise print array - 顺时针打印数组](src/main/java/cn/codepub/algorithms/arrays/PrintArray.java)

### Commons

* [Hex conversion utility - 进制转换工具](src/main/java/cn/codepub/algorithms/commons/ConversionOfNumberSystems.java)
* [Majority number - 大多数，超过一半的数](src/main/java/cn/codepub/algorithms/commons/MajorityNumber.java)
* [Maximum product - 最大乘积](src/main/java/cn/codepub/algorithms/commons/MaximumProduct.java)
* [TOPK algorithm - TOPK算法](src/main/java/cn/codepub/algorithms/commons/TopK.java)

### Graph

* [Dijkstra algorithm - 迪杰斯特拉算法](src/main/java/cn/codepub/algorithms/graph/Dijkstra.java)
* [Directed graph depth first and breadth-first by adjacency table - 邻接表实现有向图深度优先和广度优先](src/main/java/cn/codepub/algorithms/graph/DirectedGraphByAdjacencyList.java)
* [Directed graph depth first and breadth-first by adjacency matrix - 邻接矩阵实现有向图深度优先和广度优先](src/main/java/cn/codepub/algorithms/graph/DirectedGraphByAdjacencyMatrix.java)
* [Floyd warshall - 弗洛伊德算法](src/main/java/cn/codepub/algorithms/graph/FloydWarshall.java)
* [Kruskal - 克鲁斯卡尔算法](src/main/java/cn/codepub/algorithms/graph/Kruskal.java)
* [Prim - 普里姆算法](src/main/java/cn/codepub/algorithms/graph/Prim.java)
* [Undirected graph depth first and breadth-first by adjacency table - 邻接表实现无向图深度优先和广度优先](src/main/java/cn/codepub/algorithms/graph/UndirectedGraphByAdjacencyList.java)
* [Undirected graph depth first and breadth-first by adjacency matrix - 邻接矩阵实现无向图深度优先和广度优先](src/main/java/cn/codepub/algorithms/graph/UndirectedGraphByAdjacencyMatrix.java)

### Matrix

* [Matrix multiplication - 方阵乘法](src/main/java/cn/codepub/algorithms/matrix/Matrix.java)

### Multithread

* [Thread synchronization - 线程同步](src/main/java/cn/codepub/algorithms/multithread/ThreadSynchronization.java)

### Queue

* [Simple priority queue - 简单的优先级队列](src/main/java/cn/codepub/algorithms/queue/PriorityApp.java)

### Similarity

* [Words similarity by Tongyici CiLin - 基于同义词词林的词语相似度](src/main/java/cn/codepub/algorithms/similarity/cilin/WordSimilarity.java)

### Sorting Algorithm

* [Bubble sort - 冒泡排序](src/main/java/cn/codepub/algorithms/sorting/BubbleSort.java)
* [Insertion sort - 插入排序](src/main/java/cn/codepub/algorithms/sorting/InsertSort.java)
* [Quick sort - 快速排序](src/main/java/cn/codepub/algorithms/sorting/QuickSort.java)
* [Selection sort - 选择排序](src/main/java/cn/codepub/algorithms/sorting/SelectionSort.java)
* [Shell sort - 希尔排序](src/main/java/cn/codepub/algorithms/sorting/ShellSort.java)

### Chinese to Spelling

* [Chinese to spelling - 中文转拼音](src/main/java/cn/codepub/algorithms/spelling/ChineseToSpelling.java)

### Stack

* [Analyzing brackets match - 判断括号是否匹配](src/main/java/cn/codepub/algorithms/stack/BracketsApp.java)
* [Check stack sequence - 检查栈的弹出序列](src/main/java/cn/codepub/algorithms/stack/CheckStackSequence.java)
* [Infix expression turn to postfix expression - 中缀表达式转后缀表达式](src/main/java/cn/codepub/algorithms/stack/InfixApp.java)
* [Maintain a minimum number of stacks - 保持最小数的栈](src/main/java/cn/codepub/algorithms/stack/MinStack.java)
* [Postfix expression evaluation - 后缀表达式求值](src/main/java/cn/codepub/algorithms/stack/PostfixApp.java)

### Strings

* [Binary search - 二分查找](src/main/java/cn/codepub/algorithms/strings/BinarySearch.java)
* [Combination - 组合](src/main/java/cn/codepub/algorithms/strings/Combination.java)
* [Jaccard similarity coefficient - 杰卡德相似度系数](src/main/java/cn/codepub/algorithms/strings/JaccardSimilarityCoefficient.java)
* [Longest common subsequence - 最长公共子序列](src/main/java/cn/codepub/algorithms/strings/LCS.java)
* [Longest common substring 1 - 最长公共子串1](src/main/java/cn/codepub/algorithms/strings/LCS2.java)
* [Longest common substring 2 - 最长公共子串2](src/main/java/cn/codepub/algorithms/strings/LCS3.java)
* [Levenshtein distance - 编辑距离](src/main/java/cn/codepub/algorithms/strings/LevenshteinDistance.java)
* [Longest decreasing subsequence - 最长递减子序列](src/main/java/cn/codepub/algorithms/strings/LongestDecreasingSubSequence.java)
* [Pattern string match - 模式串查找](src/main/java/cn/codepub/algorithms/strings/PatternStringMatch.java)
* [Permutation - 全排列](src/main/java/cn/codepub/algorithms/strings/Permutation.java)
* [Reverse string - 反转字符串](src/main/java/cn/codepub/algorithms/strings/ReverseString.java)
* [Lexicographical - 字典序排序](src/main/java/cn/codepub/algorithms/strings/StringSort.java)
* [Manacher algorithms - 最长回文字符串](src/main/java/cn/codepub/algorithms/strings/Manacher.java)

### Trees

* [Depth-first traversal of a binary tree - 二叉树的深度优先遍历](src/main/java/cn/codepub/algorithms/trees/DepthFirstTraversal.java)
* [Get all path by given a number - 二叉树中结点值的和为输入整数的所有路径](src/main/java/cn/codepub/algorithms/trees/GetPathsBySum.java)
* [Level binary tree traversal - 二叉树的层次遍历](src/main/java/cn/codepub/algorithms/trees/LevelTraverseBinaryTree.java)
* [Binary tree traversal - 二叉树的遍历](src/main/java/cn/codepub/algorithms/trees/TraverseBinaryTree.java)
* [Verify sequence Of binary search tree - 验证二叉搜索树序列](src/main/java/cn/codepub/algorithms/trees/VerifySequenceOfBST.java)

### Design Patterns

* [Deep clone - 深拷贝](src/main/java/cn/codepub/patterns/core/DeepClone.java)
* [Singleton - 单例](src/main/java/cn/codepub/patterns/core/Singleton.java)
* [Static proxy - 静态代理](src/main/java/cn/codepub/patterns/proxy/StaticProxyHandler.java)
* [JDK dynamic proxy - JDK实现动态代理](src/main/java/cn/codepub/patterns/proxy/JDKProxyHandler.java)
* [CGLib dynamic proxy - CGLib实现动态代理](src/main/java/cn/codepub/patterns/proxy/CGLibProxyHandler.java)

Author
------------

* Developed By [Xu Wang](http://codepub.cn)

License
-------

Copyright 2015 Xu Wang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.