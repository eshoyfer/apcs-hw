import java.io.*;
import java.util.*;

public class RPN {
	MyStack stack;

	public RPN() {
		stack = new MyStack();
		run();
	}

	private boolean isNumber(String s) {
		try {
			double d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true; 
	}

	private boolean isOperator(String s) {
		String[] operators = {
			"+", "-", "*", "/"
		};
		for (String operator : operators) {
			if (s.equals(operator)) {
				return true;
			}
		}
		return false;
	}

	public void run() {
		System.out.println("Starting.");
		Scanner sc = new Scanner(System.in);
		String thisLine = sc.nextLine();
		while (!(thisLine.contains("quit"))) {	

			if (isNumber(thisLine)) {
				stack.push(thisLine);
			} else if (isOperator(thisLine)) {
				try {
					double itemTwo = Double.parseDouble(stack.pop());
					double itemOne = Double.parseDouble(stack.pop());
					double result;
					switch (thisLine) {
						case "+":	result = itemOne + itemTwo; break;
						case "-":	result = itemOne - itemTwo; break;
						case "*":	result = itemOne * itemTwo; break;
						case "/":	result = itemOne / itemTwo; break;
						default:	result = 0;					break;
					}
					String stringedResult = result + ""; 
					stack.push(stringedResult);
				} catch (NullPointerException e) {
					System.out.println("Error: Not enough arguments in stack.");
				}
			} else if (thisLine.equals("clear")) {
				stack = new MyStack();
			} else {
				System.out.println("Command not recognized.");
			}
			System.out.println(stack);
			thisLine = sc.nextLine();
		}
		System.out.println("Terminated.");
	}
}