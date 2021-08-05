package com.happy.springcloud.servier;


import java.util.Random;
import java.util.concurrent.Callable;

public class PaymentService {

    public String paymentInfoOK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK，id:" + id + "\t 哈哈";
    }

    public String paymentInfoTimeOut(Integer id) {
        int time = 3;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut，id:" + id + "\t";
    }

}
