package play.with.algorithm.chapter3

import play.with.algorithm.Sort

open class QuickSort<T : Comparable<T>> : Sort<T> {

    override fun sort(arr: Array<T>) {
        quickSort(arr, 0, arr.size - 1)
    }

    private fun quickSort(arr: Array<T>, start: Int, end: Int) {
        if (start >= end) return
        val p = partition(arr, start, end)
        quickSort(arr, start, p - 1)
        quickSort(arr, p + 1, end)
    }

    /**
     * 对arr[start ... end]进行partition操作
     * 返回值为p，使得arr[start ... p-1] < arr[p] 且 arr[p] > arr[p+1 ... end]
     */
    protected open fun partition(arr: Array<T>, start: Int, end: Int): Int {
        val v = arr[start]
        var j = start
        for (i in j + 1..end) {
            if (v > arr[i]) {
                swap(arr, i, ++j)
            }
        }
        swap(arr, start, j)
        return j
    }
}

open class BetterQuickSort<T : Comparable<T>> : QuickSort<T>() {

    override fun sort(arr: Array<T>) {
        quickSort(arr, 0, arr.size - 1)
    }

    private fun quickSort(arr: Array<T>, start: Int, end: Int) {
        if (end - start < 16) {
            insertSort(arr, start, end)
            return
        }
        val p = partition(arr, start, end)
        quickSort(arr, start, p - 1)
        quickSort(arr, p + 1, end)
    }

    /**
     * 先获取一个随机值，再进行partition
     */
    override fun partition(arr: Array<T>, start: Int, end: Int): Int {
        swap(arr, start, (start..end).random())
        return super.partition(arr, start, end)
    }
}

open class BetterQuickSort2<T : Comparable<T>> : BetterQuickSort<T>() {

    /**
     * 先获取一个随机值，再进行partition
     */
    override fun partition(arr: Array<T>, start: Int, end: Int): Int {
        swap(arr, start, (start..end).random())

        val v = arr[start]
        // arr[start+1...i) <= v ; arr(j...end] >=v
        var i = start + 1
        var j = end

        while (true) {
            while (i <= end && arr[i] < v) i++
            while (j >= start + 1 && arr[j] > v) j--
            if (i > j) break

            swap(arr, i, j)
            i++
            j--
        }
        swap(arr, start, j)
        return j
    }
}