import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/11/21
 */
public class LockConditionTest {
    @Test
    public void test() throws IOException {
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        new Thread(producer, "producer-").start();
        new Thread(consumer, "consumer-").start();
        System.in.read();
    }

    class Buffer {
        private final Lock lock;
        private final Condition full;
        private final Condition empty;
        private LinkedList<Integer> storage;

        Buffer(int size) {
            //使用锁lock，并且创建两个condition，相当于两个阻塞队列
            lock = new ReentrantLock();
            full = lock.newCondition();
            empty = lock.newCondition();
            storage = new LinkedList<>();
        }

        public void put(Integer num) {
            lock.lock();
            try {
//                while (storage.size() == maxSize) {//如果队列满了
//                    System.out.print(Thread.currentThread().getName() + ": wait \n");
//                    full.await();//阻塞生产线程
//                }
                storage.add(num);
                System.out.print(Thread.currentThread().getName() + ": put:" + num + "\n");
                empty.signalAll();//唤醒消费线程
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                full.await();//阻塞生产线程
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void take() {
            lock.lock();
            try {
//                while (storage.size() == 0) {//如果队列满了
//                    System.out.print(Thread.currentThread().getName() + ": wait \n");
//                    empty.await();//阻塞消费线程
//                }
                Integer num = storage.poll();
                System.out.print(Thread.currentThread().getName() + ": take:" + num + "\n");
                full.signalAll();//唤醒生产线程
                System.out.print(Thread.currentThread().getName() + ": wait \n");
                empty.await();//阻塞消费线程
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Producer implements Runnable {
        private Buffer buffer;

        Producer(Buffer b) {
            buffer = b;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
            }
        }
    }

    class Consumer implements Runnable {
        private Buffer buffer;

        Consumer(Buffer b) {
            buffer = b;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                buffer.take();
            }
        }
    }
}
