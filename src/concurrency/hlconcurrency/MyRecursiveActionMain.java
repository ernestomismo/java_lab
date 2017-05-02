package concurrency.hlconcurrency;

import java.util.concurrent.ForkJoinPool;

public class MyRecursiveActionMain {

	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool(4);
		MyRecursiveAction mra = new MyRecursiveAction(232);
		
		pool.invoke(mra);
		
	}

}
