package DesignPattern.SingletonDesignPatern;

/**
 * Widely considered the cleanest way to implement lazy loading in Java. It relies on the
 * JVM's class-loading mechanics. The inner helper class SingletonHelper is not loaded
 * into memory until getInstance() is explicitly called, achieving lazy loading without
 * explicit synchronization overhead.
 */
public class BillPughSingleton {

    private BillPughSingleton() {}

    // it is static and final because it is a constant reference to the singleton instance,
    // and it is private to prevent external access. The JVM guarantees that this static inner
    // class will not be loaded until it is referenced, which happens when getInstance()
    // is called for the first time. This ensures that the singleton instance is created in
    // a thread-safe manner without requiring synchronized blocks or methods.
    private static class SingletonHelper{

        private static final BillPughSingleton instance =
                new BillPughSingleton();
    }

    /**
     * This method is used to return the object of lazy singleton when requested for the first time,
     * @return it returns the instance of BillPughSingleton
     */
    public static BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }
}
