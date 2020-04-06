package play.with.algorithm

import play.with.algorithm.chapter2.*

class SortTestHelper<T> {
    private var compareNumber = 0

    fun generateRandomArray(length: Int, rangeL: Int, rangeR: Int): Array<Int> {
        assert(rangeL < rangeR)
        return Array(length) { (rangeL..rangeR).random() }
    }

    fun generateNearlyOrderedRandomArray(length: Int, rangeL: Int, rangeR: Int, swapTimes: Int): Array<Int> {
        val start = (rangeL..rangeR).random();
        val arr = Array(length) { 0 }
        for (i in 0 until length) {
            arr[i] = start + i
        }
        for (i in 0..swapTimes) {
            val x = (0 until length).random()
            val y = (0 until length).random()
            val temp = arr[y]
            arr[y] = arr[x]
            arr[x] = temp
        }
        return arr
    }

    fun printArr(arr: Array<T>) {
        arr.forEach { println(it) }
    }

    fun isSort(arr: Array<T>, compare: (c1: T, c2: T) -> Int): Boolean {
        for (i in 0..arr.size - 2) {
            if (compare(arr[i], arr[i + 1]) > 0) {
                return false
            }
        }
        return true
    }

    fun testSort(name: String, sort: Sort<T>, arr: Array<T>, compare: (c1: T, c2: T) -> Int) {
        compareNumber = 0
        val startTime = System.currentTimeMillis()
        sort.sort(arr, compare)
        val endTime = System.currentTimeMillis()
        println(isSort(arr, compare))
        println("$name use time:${(endTime - startTime).toDouble() / 1000}s, compareNumber=$compareNumber")
    }

    val compare = { c1: Int, c2: Int -> compareNumber++;c1 - c2 }
}

