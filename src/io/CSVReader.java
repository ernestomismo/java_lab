package io;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {

	private static final String COLUMN_SEPARATOR = ",";
	private BufferedReader br = null;
    private String line = "";
    private int numeroColumnas;
    private int numeroLineas;
	
	public CSVReader(String filepath, String separator) {
		
		try{
			
			if ((separator == null) || (separator.equals(""))){
				separator = COLUMN_SEPARATOR;
			}
			
			br = new BufferedReader(new FileReader(filepath));
			
			int contador = 0; 
			
			while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] columnas = line.split(separator);
                
                setNumeroColumnas(columnas.length);
                
                contador++;
              
            }
			
			setNumeroLineas(contador);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	public void setNumeroColumnas(int numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}

	public int getNumeroLineas() {
		return numeroLineas;
	}

	public void setNumeroLineas(int numeroLineas) {
		this.numeroLineas = numeroLineas;
	}
	
}
