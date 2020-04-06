package play.with.algorithm.chapter2

interface Sort<T> {
    fun sort(arr: Array<T>, compare: (c1: T, c2: T) -> Int)

    fun swap(arr: Array<T>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}