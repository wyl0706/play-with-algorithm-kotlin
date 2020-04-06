package play.with.algorithm.chapter2

class SelectionSort<T> : Sort<T> {
    /**
     * 选择排序
     * kotlin虽然支持运算符重载，但是不支持泛型类型使用小于操作符，所以只能传入一个函数参数
     */
    override fun sort(arr: Array<T>, compare: (c1: T, c2: T) -> Int) {
        for (i in arr.indices) {
            var min = i
            for (j in i + 1 until arr.size) {
                if (compare(arr[j], arr[min]) < 0) {
                    min = j
                }
            }
            if (i != min) {
                swap(arr, i, min)
            }
        }
    }
}