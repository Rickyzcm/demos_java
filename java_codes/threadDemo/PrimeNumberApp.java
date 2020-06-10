package threadDemo;

import java.util.Scanner;

public class PrimeNumberApp {
    public static void main(String[] args) {
        PrimeNumberApp primeNumberApp = new PrimeNumberApp();
        primeNumberApp.excute();
    }

    public void excute(){
        Scanner scan = new Scanner(System.in);

        Long number = scan.nextLong();
        while (number!= 0){
            PrimeNumberTester primeNumberTester = new PrimeNumberTester();
            primeNumberTester.countPrimeNumber(number);
            System.out.println("请输入");
            number = scan.nextLong();
            System.out.println("输入了："+number);
        }
    }

    public class PrimeNumberTester{
        /**
         *测试输入的整数是否是质数
         * @param number
         * @return
         */
        public boolean isPrimeNumber(Long number){
            Long sqrNumber = (new Double(Math.sqrt(number))).longValue();
            for(Long i=2l;i<=sqrNumber;i++){
                if(number % i ==0){
                    return false;
                }
            }

            return true;
        }

        /**
         * 测试小于等于指定整数中质数的个数
         * @param number
         * @return
         */
        public void countPrimeNumber(Long number){
            Long count = 0l;
            for (Long i =2l;i<=number;i++){
                if(this.isPrimeNumber(i)){
                    count++;
                }
            }
            System.out.println("小于："+number+"的质数个数："+count);
        }
    }
}
