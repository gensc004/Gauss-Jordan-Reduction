import java.util.Scanner;
import java.util.Stack;
public class GaussJordanReduction {
	/*
	this takes in a input using scanner the first two numbers you put in are the size of the matrix and the
	rest are the numbers in the matrix reading from left to right.
	*/
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		System.out.println("Input the size of the matrix followed by the numbers in it:");
		int x = ob.nextInt();
		int y = ob.nextInt();
		double[][] inputArray = new double[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				inputArray[i][j] = ob.nextInt(); 
			}
		}
		reduce(inputArray);
	}
	
	/*
	this function ruduces the matrix using the three steps that you can use using the Gauss-Jordan method.
	we store the matrix in a two by two double matrix. we use doubles because we multiply the rows by 1/a, a
	being the number that is in the leading co-efficient spot which could make a decimal.
	*/
	
	public static void reduce(double[][] array) {
		double multiple = 0;
		double[][] arr = array; 
		printBigArray(arr);
		for (int j = 0; j < arr[0].length; j++) {
			if (arr[j][j] != 0) { 
			multiple = 1 / arr[j][j];
			for (int i = 0; i < arr[j].length; i++) {
				arr[j][i] *= multiple;	
			}
			System.out.println();
			System.out.println("Multiply row " + (j + 1) + " by the constant " + multiple);
			System.out.println();
			printBigArray(arr);
			System.out.println();
			
			for (int x = 0; x < arr.length; x++) {
				if (x != j) {
					if (arr[x][j] != 0) {
						double clearer = arr[x][j];
						for (int i = 0; i < arr[x].length; i++) {
							arr[x][i] -= (arr[j][i] * clearer);
						}
						arr[x][j] = 0;
						
						System.out.println("Multiply row " + (j + 1) + " by " + clearer + " and subtract row " + (x + 1) + " by it");
						System.out.println();
						printBigArray(arr);
						System.out.println();
					}
				}
			}
		} else {
		   	switchRows(arr, j);
		}
		}
		System.out.println("The finished product:");
		System.out.println();
		printBigArray(arr);
	}
	
	/*
	these functions are to print out the array in a matrix fromat
	*/
	
	private static void printBigArray(double[][] array){
		System.out.print("[");
		for(int row = 0;row < array.length; row++){
			printLittleArray(array[row]);
			if (row < array.length - 1){
				System.out.println("]");
			}
			else{
				System.out.print("]");
			}
		}
		System.out.println("]");
	}
	
	private static void printLittleArray(double[] array){
		System.out.print("[");
		for(int column = 0;column < array.length; column++){
			if ( array[column]==0){
				system.out.print("0.0")
			}else{
				System.out.print(array[column]);
			}
			if (column != array.length - 1){
				System.out.print(",");
			}
		}
	}
	
	/*
	this function switches two rows of the array
	*/
	
	private static void switchRows(double[][] arr, int row) {
		Stack<Double> rowToSwitch = new Stack<Double>();
		boolean exit = true; 
		int newRow = 0;
		for (int i = row; i < arr.length && exit; i++) {
			if (arr[i][row] !=0) {
				exit = false;
				newRow = i;
			}
		}
		
		if (exit == false) {
		for (int i = 0; i < arr[row].length; i++) {
			rowToSwitch.push(arr[row][i]);
		}
		for (int i = 0; i < arr[row].length; i++) {
			arr[row][i] = arr[newRow][i];		
		}
		for (int i = arr[newRow].length - 1; i >= 0; i--) {
			arr[newRow][i] = rowToSwitch.pop();
		}
		System.out.println("Swap row " + rowToSwitch + " with row " + newRow);
		}
	}
}
