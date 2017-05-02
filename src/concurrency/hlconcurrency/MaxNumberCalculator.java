package concurrency.hlconcurrency;

import java.util.concurrent.RecursiveTask;

public class MaxNumberCalculator extends RecursiveTask{
	
	public static final int THRESHOLD = 5000;

	private int[] numbers;
	private int start;
	private int end;

	public MaxNumberCalculator(int[] numbers) {
		this(numbers, 0, numbers.length);
	}

	public MaxNumberCalculator(int[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer compute() {
		int length = end - start;
		int max = 0;
		if (length < THRESHOLD) {
			for (int x = start; x < end; x++) {
					max = numbers[x];
				}
	
			return max;
		} else {
			int split = length / 2;
			MaxNumberCalculator left = new MaxNumberCalculator(numbers, start,
				start + split);
			left.fork();
			MaxNumberCalculator right = new MaxNumberCalculator(numbers, start
				+ split, end);
			return Math.max(right.compute(), (int)left.join());
		}
	}

}