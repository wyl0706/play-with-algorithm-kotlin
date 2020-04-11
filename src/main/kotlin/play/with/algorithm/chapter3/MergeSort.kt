package play.with.algorithm.chapter3

import play.with.algorithm.Sort

class MergeSort<T : Comparable<T>> : Sort<T> {
    // 将[start...end]进行排序
    override fun sort(arr: Array<T>) {

    }

    // 对[start...end]进行归并排序
    private fun mergeSort(arr: Array<T>, start: Int, end: Int) {
        if (start >= end) return
        val mid = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid + 1, end)
        merge(arr, start, mid, end)
    }

    // 对[start...mid]和[mid+1...end]进行归并
    private fun merge(arr: Array<T>, start: Int, mid: Int, end: Int) {

    }

}