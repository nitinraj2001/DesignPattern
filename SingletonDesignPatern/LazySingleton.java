package DesignPattern.SingletonDesignPatern;

/**
 * The instance is created only when it is first requested.
 * However, it is not thread-safe; if two threads enter the
 * if condition simultaneously, two separate instances will be created.
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){

    }

    /**
     * This method is used to return the object of lazy singleton when requested for the first time,
     * it will create the object and return it,
     * @return instance of LazySingleton
     */
    public static LazySingleton getInstance(){
        // check if the reference is null, if yes then create the instance
        if(instance == null ){
            // this is intentionally to simulate the race condition example,
            // so that two threads can enter the if condition simultaneously
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                System.out.println("Exception occurred while creating instance:: " + e.getMessage());
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}
