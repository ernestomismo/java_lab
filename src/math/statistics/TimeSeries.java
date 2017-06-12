package math.statistics;

// prueba
public class TimeSeries {

	public static double[] movingAverage(double[] timeSeries, int interval){
		
		int vectorLength = timeSeries.length;
		
		double result[] = new double[vectorLength - interval + 1];
		double temp = 0;
		
		for (int i = 0; i < vectorLength - interval +1; i++){
			
			for(int j = i; j < interval + i; j++ ){
				temp = temp + timeSeries[j];
				System.out.println("valor " + j + " : " + timeSeries[j]);
				System.out.println("suma: " + temp);
			}
			
			result[i] = temp/interval;
			System.out.println("result: " + result[i]);
			
			temp = 0;
			
		}
		
		return result;
	}
}
