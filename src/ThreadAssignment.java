public class ThreadAssignment {

    static class Counter {
        void count() {
            for (int i = 350; i>=1; i--){
                System.out.println(i);
            }
            System.out.println("FINISH!");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            synchronized (counter){
                counter.count();
            };
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DONE!");
    }
}
