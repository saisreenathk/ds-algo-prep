package com.preparation.practice.corejavainterview;

public class ThreadSafeAndBillPaughSingleton {

    private static ThreadSafeAndBillPaughSingleton INSTANCE;

    private ThreadSafeAndBillPaughSingleton(){
    }

    public static ThreadSafeAndBillPaughSingleton getThreadSafeInstance(){
        if(INSTANCE == null){
            synchronized (ThreadSafeAndBillPaughSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new ThreadSafeAndBillPaughSingleton();
                }
            }
        }
        return INSTANCE;
    }

    //variation 2: best used in industry: easier, threadsafe because static inner class wont get loaded first.

    private static class SingletonHolder{
        private static final ThreadSafeAndBillPaughSingleton INSTANCE2 = new ThreadSafeAndBillPaughSingleton();
    }

    public static ThreadSafeAndBillPaughSingleton getBillPaughSingletonInstance(){
        return SingletonHolder.INSTANCE2;
    }
}
