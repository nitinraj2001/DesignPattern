package DesignPattern.SingletonDesignPatern;

/**
 * This method reduces synchronization overhead. It checks for a null instance outside
 * the synchronized block first. If it is null, it takes a lock and checks again.
 */
public class DoublyCheckedSynchronization {

    // This volatile keyword is used to avoid compilation instructions reordering by the compiler.
    // It ensures that the instance variable is read from main memory and not from thread's local cache.
    private static volatile DoublyCheckedSynchronization instance;

    private DoublyCheckedSynchronization() {

    }

    /**
     * This method is used to return the object of lazy singleton when requested for the first time,
     *
     * @return it returns the instance of DoublyCheckedSynchronization
     */

    public static DoublyCheckedSynchronization getInstance() {
        // it will first check whether instance is null or not,
        // if it is not null then it will return the instance without taking the lock
        if (instance == null) {
            // Now it will take a lock and check again whether instance is null or not
            synchronized (DoublyCheckedSynchronization.class) {
                if (instance == null) {
                    instance = new DoublyCheckedSynchronization();
                }
            }
        }
        return instance;
    }

    // The volatile keyword in Java guarantees thread safety for a variable by providing
    // visibility and preventing instruction reordering. It forces all reads and writes
    // to go directly to main memory instead of local CPU caches, ensuring every thread
    // instantly sees the most updated value. Crucially, it injects a memory barrier
    // that stops the compiler and CPU from optimizing assembly instructions out of order.
    // In a Double-Checked Locking Singleton, this barrier ensures that an object's constructor
    // finishes executing completely before its memory reference is published. Without volatile,
    // a competing thread could read a non-null but half-initialized, broken object, causing
    // random runtime crashes.

    //When you write synchronized (DoubleCheckedLockingSingleton.class), you are locking on the unique Class object that represents your class in the JVM memory.
   // Here is exactly how it works and why it is used:
          //  • The Metaclass Object: For every class loaded into the JVM, Java automatically creates a single, global instance of java.lang.Class. Writing MyClass.class is how you reference that specific metadata object.
          //  • Global Static Lock: Because your getInstance() method is static, there is no instance (this) of the Singleton available to lock on yet. Locking on the .class object acts as a global lock that applies to all threads across the entire application, regardless of which instance they are trying to access.
          //  • Mutual Exclusion: When Thread-1 enters the block, it acquires the monitor lock of that specific Class object. If Thread-2 tries to call getInstance() at the exact same time, it sees that the Class object is locked, halts execution, and waits patiently until Thread-1 exits the block.
}
