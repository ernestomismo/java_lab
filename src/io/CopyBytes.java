package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;

public class CopyBytes {

	public static void main(String[] args) throws IOException {

		FileInputStream fInputStream = null;
        FileOutputStream fOutStream = null;

        try {
        	
        	out.println("Reading files");
        	
        	fInputStream = new FileInputStream("resources/xanadu.txt");
        	fOutStream = new FileOutputStream("resources/outagain.txt");
            int c;
            
            while ((c = fInputStream.read()) != -1) {
            	fOutStream.write(c);
            }
            
            out.println("finishing");
            
        } finally {
            if (fInputStream != null) {
            	fInputStream.close();
            }
            if (fOutStream != null) {
            	fOutStream.close();
            }
        }

	}

}
