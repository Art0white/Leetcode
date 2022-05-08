import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

/**
 * @author Lovsog
 * 2022/4/18
 * LeetCode 1226.哲学家进餐
 **/

// philosopher                          哲学家的编号。
// pickLeftFork 和 pickRightFork        表示拿起左边或右边的叉子。
// eat                                  表示吃面。
// putLeftFork 和 putRightFork          表示放下左边或右边的叉子。

class DiningPhilosophers_1226 {

    private final ReentrantLock[] ForkList = {new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock()};//0,1,2,3,4
    private Semaphore phi = new Semaphore(4);
    public DiningPhilosophers_1226() {

    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher+4)%5;
        int rightFork = philosopher;
        phi.acquire();
        ForkList[leftFork].lock();
        ForkList[rightFork].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        ForkList[leftFork].unlock();
        ForkList[rightFork].unlock();
        phi.release();
    }
}


public class NO_1226 {
    public static void main(String[] args) {
        DiningPhilosophers_1226 d1 = new DiningPhilosophers_1226();
    }
}
