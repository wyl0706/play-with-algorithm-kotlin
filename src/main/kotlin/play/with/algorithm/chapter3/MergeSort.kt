package play.with.algorithm.chapter3

import play.with.algorithm.chapter2.Sort

class MergeSort<T> : Sort<T> {
    override fun sort(arr: Array<T>, compare: (c1: T, c2: T) -> Int) {

    }
    // 将[start...end]进行排序
    fun mergeSort(arr: Array<T>, compare: (c1: T, c2: T) -> Int, start: Int, end: Int) {
        if (start >= end) return
    }

}