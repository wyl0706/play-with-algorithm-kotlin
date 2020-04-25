package play.with.algorithm

interface Sort<T : Comparable<T>> {
    fun sort(arr: Array<T>)

    // 对i j指向的位置进行交换
    fun swap(arr: Array<T>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun insertSort(arr: Array<T>, start: Int, end: Int) {
        for (i in start..end) {
            val value = arr[i]
            var insertIndex = 0
            for (j in i downTo start) {
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