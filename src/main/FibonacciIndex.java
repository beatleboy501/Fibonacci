package main;

public class FibonacciIndex {
	
	public static void main(String[] args){
		try{
		int numIndices = Integer.valueOf(args[0]);
		FibonacciIndex fi = new FibonacciIndex();
		Integer[] results = fi.returnIndices(numIndices);
		for(int result : results){
			System.out.println(result);
		}
		}
		catch(NumberFormatException e){
			System.out.println("NaN: " + e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException ee){
			System.out.println("Not enough args: " + ee.getMessage());
		}
	}

	public Integer[] returnIndices(int index) {
		Integer[] indices = new Integer[index];
		int previous = 0;
		int current = 0;
		
		for(int i = 0; i < index; i++) {
			
			if(i == 0){
				current = 1;
				indices[i] = current;
			}
			else if(i == 1){
				previous = 1;
				current = 1;
				indices[i] = current;
			}
			else{ 
				int curr = current;
				current += previous;
				indices[i] = current;
				previous = curr;
			}
		}
		return indices;
	}
}
