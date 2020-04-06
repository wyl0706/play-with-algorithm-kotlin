package play.with.algorithm.chapter2

import play.with.algorithm.SortTestHelper

fun main() {
    val helper = SortTestHelper<Int>()
    val insertionSort = InsertionSort<Int>()
    val selectionSort = SelectionSort<Int>()
    val betterInsertionSort = BetterInsertionSort<Int>()
    val shellSort = ShellSort<Int>()
    val testArr = helper.generateNearlyOrderedRandomArray(20000, 1000, 10000000, 10)
    //val testArr = helper.generateRandomArray(20000, 1000, 10000000)
    val testArr2 = testArr.clone()
    val testArr3 = testArr.clone()
    val testArr4 = testArr.clone()
    helper.testSort("SelectionSort", selectionSort, testArr, helper.compare)
    helper.testSort("InsertionSort", insertionSort, testArr2, helper.compare)
    helper.testSort("BetterInsertionSort", betterInsertionSort, testArr3, helper.compare)
    helper.testSort("ShellSort", shellSort, testArr4, helper.compare)
}