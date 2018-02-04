package hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClosestPairOfPoints {
		
	public static void main(String[] args) {
		
		if(args.length > 1) {
			System.out.println("please input single file name at one time!\n");
			return;		
		}
		if(args.length < 1) {
			System.out.println("please input the name of point pairs file follow "
					+ "the excution command!\n");
			return;		
		}
		
		File directory = new File(".");
		 
		File[] fileArray = directory.listFiles();
		File points = null;
		
		for(int i = 0; i < fileArray.length; i++) {
			if(fileArray[i].isFile()) {
				if(args.toString() == fileArray[i].getName())
					points = fileArray[i];
			}				
		}
		
		
		if(points == null) {
			System.out.println("Please check file name and "
					+ "input a correct file name");
			return;
		}			
		
		String fileName = points.toString();
		String regex = "[^0-9]"; 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fileName);
		String pointsNumber = matcher.replaceAll("").trim();
		int n = Integer.parseInt(pointsNumber);
		
		Point[] ps = new Point[n]; 
		
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(points)));
				
				ArrayList<String> list = new ArrayList<String>();
				String line = null;
				try {
					while((line = br.readLine() )!= null ) {
						list.add(line);
					}
					System.out.println(list);
				} catch (IOException e) {
					System.out.println("reading file error!");
				}
				
				
			} catch (FileNotFoundException e) {
				System.out.println("File reading error! Please make sure "
						+ "points files and program are in the same directory ");
			}
		
		
		
	
		
//		quickSort(x, 0, pairsNumber);
//		quickSort(y,0,pairsNumber);
	}
	
	
	
	/************************************
	 * Quick Sort method finished here, 
	 * Partition is an auxiliary method for Quick Sort
	 * @param array
	 * @param start
	 * @param end
	 ************************************/
	public static void quickSort(int[] array, int start, int end) {
		
		if(start >= end){
    		System.out.println("Please check start and end arguments!");
        return;
    }
		
		int q = partition(array, start, end);
		quickSort(array, start, q-1);
		quickSort(array, q+1, end);
	}
	
	public static int partition(int[] array, int start, int end){
	    
	    if(start >= end){
	    		System.out.println("Please check start and end arguments!");
	        return -1;
	    }
	    
	    int x = array[end];
		int i = start - 1;
		int j = start;
	    for(; j <= array.length-1; j++) {
	    		if(array[j] <= x) {
	    			i = i + 1;
	    			int t = array[i];
	    			array[i] = array[j];
	    			array[j] = t;
	    		}
	    }
	    
	    array[end] = array[i+1];
	    	array[i+1] = x;
	    
	    return (i+1);
	}	
}
