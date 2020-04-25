package play.with.algorithm.chapter3

import play.with.algorithm.Sort

open class MergeSort<T : Comparable<T>> : Sort<T> {
    // 将[start...end]进行排序
    override fun sort(arr: Array<T>) {
        mergeSort(arr, 0, arr.size - 1)
    }

    // 对[start...end]进行归并排序
    protected open fun mergeSort(arr: Array<T>, start: Int, end: Int) {
        if (start >= end) return

        val mid = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid + 1, end)
        merge(arr, start, mid, end)
    }

    // 对[start...mid]和[mid+1...end]进行归并
    protected fun merge(arr: Array<T>, start: Int, mid: Int, end: Int) {
        // copyOfRange是取[start...end),所以需要end+1
        val temp = arr.copyOfRange(start, end + 1)

        var i = start
        var j = mid + 1
        for (k in start..end) {
            when {
                i > mid -> {
                    arr[k] = temp[j - start]
                    j++
                }
                j > end || temp[i - start] < temp[j - start] -> {
                    arr[k] = temp[i - start]
                    i++
                }
                else -> {
                    arr[k] = temp[j - start]
                    j++
                }
            }
        }
    }
}

class BatterMergeSort<T : Comparable<T>> : MergeSort<T>() {
    // 对[start...end]进行归并排序
    override fun mergeSort(arr: Array<T>, start: Int, end: Int) {
        if (end - start < 16) {
            insertSort(arr, start, end)
            return
        }

        val mid = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid + 1, end)
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, start, mid, end)
        }
    }
}

