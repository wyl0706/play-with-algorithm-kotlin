package play.with.algorithm.chapter2

import play.with.algorithm.Sort

class ShellSort<T : Comparable<T>> : Sort<T> {
    override fun sort(arr: Array<T>) {
        var height = 1
        val length = arr.size
        while (height < length / 3) {
            height = 3 * height + 1
        }
        while (height > 0) {
            for (i in 1 until arr.size) {
                for (j in i downTo height step height) {
                    if (arr[j] < arr[j - height]) {
                        swap(arr, j, j - height)
                    } else {
                        break
                    }
                }
            }
            height /= 3
        }
    }

}