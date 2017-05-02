package concurrency.hlconcurrency;

import java.util.concurrent.ForkJoinPool;

public class MyRecursiveTaskMain {

	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool(4);
		MyRecursiveTask mrt = new MyRecursiveTask(100);
		
		System.out.println("final result: "+ pool.invoke(mrt));

	}

}
