package advanced.inline

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun main(args: Array<String>): Unit {
    val obj: Lock = ReentrantLock()
    lock(obj) {
        println("Hello")
    }
}

private inline fun lock(l: Lock, body: () -> Unit) {
    l.lock()
    try {
        return body()
    } finally {
        l.unlock()
    }
}