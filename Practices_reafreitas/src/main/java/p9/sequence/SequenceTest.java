package p9.sequence;

import java.util.Arrays;

public class SequenceTest {

	public static void main(String[] args) {
		
		Sequence seq = new Sequence();
		
		seq.displaySequence();
		
		System.out.println(Arrays.toString(seq.getFibonacciWhile()));
		System.out.println(Arrays.toString(seq.getFibonacciFor()));
	}

}

class Sequence {
	int firstNumber = 0;
	int secondNumber = 1;
	int nextNumber;
	public final int SEQUENCE_LIMIT = 100;
	
	public void displaySequence() {
		reset();
		System.out.print(firstNumber + " " + secondNumber);
		nextNumber = firstNumber + secondNumber;
		while(nextNumber <= SEQUENCE_LIMIT) {
			System.out.print(" " + nextNumber);
			firstNumber = secondNumber;
			secondNumber = nextNumber;
			nextNumber = firstNumber + secondNumber;
		}
		System.out.println();
	}
	
	public int[] getFibonacciWhile() {
		reset();
		int[] seq = new int[12];
		int index = 0;
		
		seq[index++] = firstNumber;
		seq[index++] = secondNumber;
		nextNumber = firstNumber + secondNumber;
		while(nextNumber <= SEQUENCE_LIMIT) {
			seq[index++] = nextNumber;
			firstNumber = secondNumber;
			secondNumber = nextNumber;
			nextNumber = firstNumber + secondNumber;
		}
		return seq;
	}
	
	public int[] getFibonacciFor() {
		reset();
		int[] seq = new int[12];
		int index = 0;
		
		seq[index++] = firstNumber;
		seq[index++] = secondNumber;
		nextNumber = firstNumber + secondNumber;
		for(; nextNumber < SEQUENCE_LIMIT;) {
			seq[index++] = nextNumber;
			firstNumber = secondNumber;
			secondNumber = nextNumber;
			nextNumber = firstNumber + secondNumber;
		}
		return seq;
	}
	
	public void reset() {
		firstNumber = 0;
		secondNumber = 1;
		nextNumber = 0;
	}
}