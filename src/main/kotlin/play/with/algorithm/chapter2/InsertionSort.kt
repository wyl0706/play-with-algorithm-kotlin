package play.with.algorithm.chapter2

import play.with.algorithm.Sort

class InsertionSort<T : Comparable<T>> : Sort<T> {
    /**
     * 插入排序，原始版，交换次数较多，速度慢
     */
    override fun sort(arr: Array<T>) {
        for (i in 1 until arr.size) {
            for (j in i downTo 1) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1)
                } else {
                    break
                }
            }
        }
    }
}

class BetterInsertionSort<T : Comparable<T>> : Sort<T> {
    /**
     * 插入排序
     */
    override fun sort(arr: Array<T>) {
        for (i in 1 until arr.size) {
            val value = arr[i]
            var insertIndex = 0
            for (j in i downTo 0) {
                insertIndex = j
                if (j == 0) {
                    break
                }
                if (value < arr[j - 1]) {
                    arr[j] = arr[j - 1]
                } else {
                    break
                }
            }
            arr[insertIndex] = value
        }
    }
}