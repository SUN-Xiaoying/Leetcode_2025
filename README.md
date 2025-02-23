# Jackpot

## `HashSet`&& `HashMap`
### `==`

For Built-in class(8): 
String, Integer, Long, Double, Booealn, Character, Byte, Short.

`HashSet` and `HashMap` only care about values.

`==` 比较内存地址

```java
String str1 = new String("Hello");
String str2 = new String("Hello");

System.out.println(str1 == str2); // False
System.out.println(str1.equals(str2)); // True
```


```java
HashSet<String> set = new HashSet<>();
set.add(str1);
set.add(str2);

System.out.println(set.size()); // 1
```

# 有序表 `TreeMap` && `TreeMap`

底层红黑树, O(logN)。

```java
TreeMap<Integer, String> treeMap = new TreeMap<>();
//5, 7, 1, 2, 3, 4, 8

treeMap.firstKey();     // 1， 最小
treeMap.lastKey();      // 8， 最大

treeMap.remove(4);
treeMap.floorKey(4);    // 3， 下确界
treeMap.ceilingKey(4);  // 5， 上确界
```

`TreeSet` 会**自动去重**。

```java
treeSet.pollFirst(); // 从小到大弹出
treeSet.pollLast();
```

# 堆 PriorityQueue

完全二叉树

父： (i-1)/2
左：i*2+1
右：i*2+2

```java
PriorityQueue<Integer> heap = new PriorityQueue<>(); // 默认小根堆

heap.poll(); // 从小到大弹出
```

[26:17 比较器定制](https://www.bilibili.com/list/8888480?sid=3509640&desc=1&oid=702104456&bvid=BV13m4y1p7VB)