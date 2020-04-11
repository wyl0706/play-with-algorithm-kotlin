package play.with.algorithm

interface Sort<T : Comparable<T>> {
    fun sort(arr: Array<T>)

    fun swap(arr: Array<T>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}