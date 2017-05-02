package math.statistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeSeriesTest {

	@Test
	public void movingAverageTest() {
		double serie[] = {120, 150, 240, 540, 210, 380, 120, 870, 250, 1100, 500, 950};
		
		double result[] = TimeSeries.movingAverage(serie, 6);
		
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}

}
