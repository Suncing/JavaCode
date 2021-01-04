package Java01_初级.线程.线程同步;
/**
 * 银行账户类
 */
class Account {
    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public float getBalance() {
        return amount;
    }

    //存钱
    public void deposit(float money) {
        amount += money;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //取钱
    public void withdraw(float money) {
        amount -= money;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 账户操作类
 */
class AccountOperator implements Runnable {
    private Account account;
    public AccountOperator(Account account) {
        this.account = account;
    }

    public void run() {
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println(Thread.currentThread().getName() + ":" + account.getBalance());
        }
    }
}

public class OnCodeBlock3 {
    public static void main(String[] args) {
        Account account = new Account("周杰伦", 10000.0f);
        AccountOperator accountOperator = new AccountOperator(account);

        /**在AccountOperator类中的run方法里，我们用synchronized给account对象加了锁
         * 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞
         * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。*/
        Thread threads[] = new Thread[5];
        for (int i = 0; i < 5; i ++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }
    }
}
