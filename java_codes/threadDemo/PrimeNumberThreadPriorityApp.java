package threadDemo;

public class PrimeNumberThreadPriorityApp {
    public static void main(String[] args) {

    }

    public void execute(){
        for(int i=Thread.MIN_PRIORITY;i<=Thread.MAX_PRIORITY;i++){
            long number = 123456789;
        }
    }

    public class PrimeNumberTester extends Thread{
        private Long number;
        public PrimeNumberTester(Long number){
            this.number = number;
        }

        /**
         * 测试输入的整数是否是质数
         */
        public boolean isPrimeNumber(Long number){
            Long sqrNumber =
        }
    }
}
