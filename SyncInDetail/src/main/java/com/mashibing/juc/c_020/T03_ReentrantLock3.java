/**
 * reentrantlock用于替代synchronized 
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁
 */
package com.mashibing.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T03_ReentrantLock3 {
	Lock lock = new ReentrantLock();

	void m1() {
		try {
			lock.lock();
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);

				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
	 * 可以根据tryLock的返回值来判断是否锁定
	 * 也可以指定tryLock的时间
	 */
	void m2() {
		/*
		boolean locked = lock.tryLock();
		System.out.println("m2 ..." + locked);
		if(locked) lock.unlock();
		*/
		
		boolean locked = false;
		
		try {
			locked = lock.tryLock(5, TimeUnit.SECONDS);
			System.out.println("m2 ..." + locked);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(locked) lock.unlock();
		}
		
	}

	public static void main(String[] args) {
		T03_ReentrantLock3 rl = new T03_ReentrantLock3();
		new Thread(rl::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(rl::m2).start();
	}
}
