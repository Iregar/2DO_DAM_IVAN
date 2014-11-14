package ut01.act06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fibonacci {
	
	public static String readFileFibonacci(String file){
		FileInputStream fileIn = null;
		StringBuilder sb = new StringBuilder();
		int number;
		try {
			fileIn = new FileInputStream(file);
			while((number=fileIn.read())!=-1){
				sb.append(number);
				sb.append(" ");
			}
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		}
		finally{
			if(fileIn!=null)
				try {
					fileIn.close();
				} catch (IOException e) {
					
				}
		}
		return sb.toString();
	}
	
	public static void writeFileFibonacci(String file, int n){
		int fibo1=1,fibo2=1;
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(file);
			fileOut.write(fibo1);
			for (int i = 2; i <= n; i++) {
				fileOut.write(fibo2);
				
				fibo2 = fibo1 + fibo2;
				fibo1 = fibo2 - fibo1;
			}
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		finally{
			if(fileOut!=null)
				try {
					fileOut.close();
				} catch (IOException e) {
					
				}
		}
		
	}
	public static String getFibonacci(int n) {
		int fibo1=1,fibo2=1;
		StringBuilder sb = new StringBuilder();
		sb.append(fibo1);
		sb.append(" ");
		for (int i = 2; i <= n; i++) {
			sb.append(fibo2);
			sb.append(" ");
			fibo2 = fibo1 + fibo2;
			fibo1 = fibo2 - fibo1;
		}
		return sb.toString();
	}
}