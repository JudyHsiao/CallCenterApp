# Note

In this program, [ConcurrentLinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html) is used to keep track free employees thus eliminating the needs of syncronized methods or mutexes. ConcurrentLinkedList is based-on an wait-free algorithm, so the performance penality of its putting and polling methods are quite small.





