package DesignPattern.SingletonDesignPatern;

public class Main {

    public static void main(String[] args) {
      /**

       EagerSingleton eagerSingleton = EagerSingleton.getInstance();
       EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
       System.out.println(eagerSingleton.hashCode());
       System.out.println(eagerSingleton1.hashCode());

       **/

      /**

       // Since runnable interface is a functional interface, we can use lambda expression to create the runnable task
       // When t1 and t2 thread is created and task is passed in constructor t1 and t2 bind the reference of
       // the task to be executed and once we start() it jvm request to OS for cpu time once cpu time is granted then they execute it.

       // create the runnable task
        Runnable task = () -> {
            LazySingleton lazySingleton = LazySingleton.getInstance();
            System.out.println("Inside Runnable task:: " + "Thread name-> " + Thread.currentThread().getName() +
                    " hashcode-> " + lazySingleton.hashCode() + "current timestamp-> " + System.currentTimeMillis());
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();

       **/

      /**
        Runnable task = () -> {
            SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
            System.out.println("Inside Runnable task:: " + "Thread name-> " + Thread.currentThread().getName() +
                    " hashcode-> " + synchronizedSingleton.hashCode() + "current timestamp-> " + System.currentTimeMillis());
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();

       **/

      BillPughSingleton instance = BillPughSingleton.getInstance();
      BillPughSingleton instance1 = BillPughSingleton.getInstance();
      System.out.println("Instance1 hash-> " + instance.hashCode() + "Instance2" +
              " hash-> " + instance1.hashCode());

    }
}
