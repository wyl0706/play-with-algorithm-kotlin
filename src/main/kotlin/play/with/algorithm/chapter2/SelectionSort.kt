package play.with.algorithm.chapter2

import play.with.algorithm.Sort

class SelectionSort<T : Comparable<T>> : Sort<T> {
    /**
     * 选择排序
     */
    override fun sort(arr: Array<T>) {
        for (i in arr.indices) {
            var min = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            if (i != min) {
                swap(arr, i, min)
            }
        }
    }
}