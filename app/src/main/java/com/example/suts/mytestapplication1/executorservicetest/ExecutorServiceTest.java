package com.example.suts.mytestapplication1.executorservicetest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by suts on 2017/8/4.
 */

public class ExecutorServiceTest {
    ExecutorService mExecutorService;


    public ExecutorServiceTest() {
        initExecutorService();
    }

    public void initExecutorService(){
        mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        mExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
//        mExecutorService = Executors.newSingleThreadExecutor();
//        mExecutorService = Executors.newCachedThreadPool();
//        mExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public ExecutorService getExecutorService(){
        return this.mExecutorService;
    }

}
