package play.with.algorithm

import play.with.algorithm.chapter2.BetterInsertionSort
import play.with.algorithm.chapter2.InsertionSort
import play.with.algorithm.chapter2.SelectionSort
import play.with.algorithm.chapter2.ShellSort

class SortTestHelper<T : Comparable<T>> {
    // 生成完全随机的测试数据
    fun generateRandomArray(length: Int, rangeL: Int, rangeR: Int): Array<Int> {
        assert(rangeL < rangeR)
        return Array(length) { (rangeL..rangeR).random() }
    }

    // 生成近乎于有序的测试数据
    fun generateNearlyOrderedRandomArray(length: Int, rangeL: Int, rangeR: Int, swapTimes: Int): Array<Int> {
        val start = (rangeL..rangeR).random()
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

    private fun isSort(arr: Array<T>): Boolean {
        for (i in 0..arr.size - 2) {
            if (arr[i] > arr[i + 1]) {
                return false
            }
        }
        return true
    }

    fun testSort(name: String, sort: Sort<T>, arr: Array<T>) {
        val startTime = System.currentTimeMillis()
        sort.sort(arr)
        val endTime = System.currentTimeMillis()
        println(isSort(arr))
        println("$name use time:${(endTime - startTime).toDouble() / 1000}s")
    }
}

fun main() {
    val helper = SortTestHelper<Int>()
    //val testArr = helper.generateNearlyOrderedRandomArray(40000, 1000, 10000000, 10)
    val testArr = helper.generateRandomArray(40000, 1000, 10000000)
    // 此处的compare是测试Helper校验对比结果使用
    helper.testSort("SelectionSort", SelectionSort(), testArr.clone())
    helper.testSort("InsertionSort", InsertionSort(), testArr.clone())
    helper.testSort("BetterInsertionSort", BetterInsertionSort(), testArr.clone())
    helper.testSort("ShellSort", ShellSort(), testArr.clone())
}

