package com.mashibing.util;

import java.util.concurrent.TimeUnit;

public class SleepHelper {
    public static void sleepSeconds(int secodes) {
        try {
            TimeUnit.SECONDS.sleep(secodes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
