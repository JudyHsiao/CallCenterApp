# Note

In this program, [ConcurrentLinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html) is used to keep track free employees thus eliminating the needs of syncronized methods or mutexes. ConcurrentLinkedList is based-on a wait-free algorithm, it guarantees that every active process will make progress within a bounded
number of time steps.






