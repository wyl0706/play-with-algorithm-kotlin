package play.with.algorithm.chapter2

class ShellSort<T> : Sort<T> {
    override fun sort(arr: Array<T>, compare: (c1: T, c2: T) -> Int) {
        var height = 1
        val length = arr.size
        while (height < length / 3) {
            height = 3 * height + 1
        }
        while (height > 0) {
            for (i in 1 until arr.size) {
                for (j in i downTo height step height) {
                    if (compare(arr[j], arr[j - height]) < 0) {
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