package DesignPattern.SingletonDesignPatern;

/**
 * Eager Singleton is thread safe, but it is waste of memory as object is created
 * at class load time and if instance is not used in the application then memory is wasted.
 */

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("Creating the instance using EagerSingleton");
    }

    /**
     * This method is used to fetch the instance throughout the application
     */
    public static EagerSingleton getInstance(){
        return instance;
    }

}
