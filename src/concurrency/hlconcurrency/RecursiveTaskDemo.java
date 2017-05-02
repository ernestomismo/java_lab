package concurrency.hlconcurrency;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskDemo {

		private static final int SIZE = 10000000;

		/**
		 * @param args
		 */
		public static void main(String[] args) {

			final int[] numbers = new int[SIZE];
			int maxNum = 0;

			// Start sequential calculation
			long st = System.currentTimeMillis();

			for (int i = 0; i < SIZE; i++) {
				numbers[i] = (int) (Math.random() * 10000);
				if (numbers[i] > maxNum) {
					maxNum = numbers[i];
				}
			}

			System.out.println("Calculated maximum number (sequential execution): "
					+ maxNum + " -- Total time: "
					+ (System.currentTimeMillis() - st));

			// Start parallel calculation
			long pt = System.currentTimeMillis();

			ForkJoinPool pool = new ForkJoinPool(4);
			MaxNumberCalculator fbn = new MaxNumberCalculator(numbers);
			System.out.println("Calculated maximum number (parallel execution): "
					+ pool.invoke(fbn) + " -- Total time: "
					+ (System.currentTimeMillis() - pt));
		}

}