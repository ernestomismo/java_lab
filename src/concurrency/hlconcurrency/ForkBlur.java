package concurrency.hlconcurrency;

import java.util.concurrent.RecursiveAction;

public class ForkBlur extends RecursiveAction{
	
	private int[] mSource;
    private int mStart;
    private int mLength;
    private int[] mDestination;
    
    // Processing window size; should be odd.
    private int mBlurWidth = 15;
    
    public ForkBlur(int[] src, int start, int length, int[] dst) {
        mSource = src;
        mStart = start;
        mLength = length;
        mDestination = dst;
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
	}

}
