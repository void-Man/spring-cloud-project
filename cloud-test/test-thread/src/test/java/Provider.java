import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/11/21
 */
public class Provider {
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private LinkedList<Integer> list = new LinkedList<>();

    public void add(Integer num) throws InterruptedException {
        lock.lock();
        if (list.size() > 1000000) {
            notEmpty.await();
        }
        list.offer(num);
        lock.unlock();
    }

}
