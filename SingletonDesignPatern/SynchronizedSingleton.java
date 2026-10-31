package DesignPattern.SingletonDesignPatern;

/**
 * Adding synchronized to the method forces thread safety. While safe, it introduces
 * significant performance bottlenecks because every subsequent call must wait for the
 * lock, even after the instance is initialized
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){

    }

    /**
     * This method is used to return the object of lazy singleton when requested for the first time,
     * it will create the object and return it,
     * @return it returns the instance of SynchronizedSingleton
     */
    public synchronized static SynchronizedSingleton getInstance(){
        if(instance == null){
            // this is intentionally to simulate the race condition example,
            // so that two threads can enter the if condition simultaneously
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                System.out.println("Exception occurred while creating instance:: " + e.getMessage());
            }
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
