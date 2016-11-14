/*****************************************
/* Name:Alba Maloff
/* Course: CIS 4020 01N
/* Semester: Fall 2016
/* Assignment: Program 8 - Recursion
/* Date started: October 27,2016 
/* Date finished:October 29, 2016
/*
/* Description: This program contains different recursive solutions to different problems.
 */
/****************************************/
import java.util.InputMismatchException; //import statements
import java.util.Scanner;

//Class: recursionDemo Class
//Description: This class consists of the main method that is used for calling the five input methods 
//that demonstrate recursion.
public class recursionDemo {

	/*******************************************
	/* Function: Main Method
	/* Description: It calls the five methods below which are the:
	 *    1. inputPowers  
	 *    2. inputGCD
	 *    3. inputPalindrome
	 *    4. inputMystery
	 *    5. inputPermutation
	/******************************************/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in); //Create a Scanner Object for the Keyboard Input
		
		//inputPowers(keyboard);
		inputGCD(keyboard);
		//inputPalindrome(keyboard);
		//inputMystery(keyboard);
		//inputPermutation(keyboard);
		
		keyboard.close(); //Close Scanner class
	}

	/*******************************************
	/* Function: inputPowers Method
	/* Description: It asks input from the user and uses boolean and a do while loop to determine if the input is
	 *Valid. It also has several try catch statements for exception handling.
	 */
	/******************************************/
	public static void inputPowers(Scanner keyboard) 
	{
		
		System.out.println("Enter the Base Value: ");//Asks user for a Base Value 
		int x = 0;//initializes x
		
		boolean isTrue = false;//declares and intializes the boolean variable as false
		
		//do while loop that iterates at least one time 
		do{
			try{ //try statement that validates the data 
				
			if (keyboard.hasNextInt()) //asks the user (for a int type value input)
			{
				x = keyboard.nextInt(); //stores the values inputted by the user
				isTrue = true; //verifies if it meets the criteria
			}
			else //otherwise
			{
				System.out.print("Invalid Value: Enter an Integer Base Value"); //prompts the value is invalid
                isTrue = false; //acknowledges it does not meet criteria
                keyboard.next(); //asks user for a new input value
			}
			}
            catch (InputMismatchException e){ //in the case of a mismatch error it catches it and asks the user to 
            	System.out.print("Enter an Integer Base Value"); //input the correct value 
            	keyboard.next(); //Consumes the invalid token
			}
		}
		while (!(isTrue)); //while the data isn't valid
		
        
		System.out.println("Enter a non-negative Power Value: "); //User must enter a value for the power
		int y = 0; //initializes y
		isTrue = false; //intializes the boolean variable as false so we can uses again
		
		//do while loop that iterates at least one time
		do{
			try{  //try statement that validates the data
				y = keyboard.nextInt();	//stores the values inputted by the user for y
				if (y>=0) //if statement that makes sure there are no calculations done with negative numbers
				{
					isTrue = true; //boolean that validates the data
				}

				else //otherwise
				{
					
					System.out.print("Invalid Value: Enter an Integer Base Value"); //prompts the value is invalid
	            
				}
			}catch (InputMismatchException e){ //in the case of a mismatch error it catches it and asks the user to 
            	System.out.print("Enter an Integer Power Value"); //input the correct value
            	keyboard.next();//consumes the invalid token
			}
			
		}while (!(isTrue)); //while the data isn't valid
		
		
		try{ //try statement that validates the data
		System.out.println(x +  "^" + y + "= " + powers(x,y));
		}
		catch (StackOverflowError e){ //in the case of a StackOverflow Error it catches it and asks the user to 
			System.out.println("Stack Overflow! Enter New Values  \n"); //enter new values
			inputPowers(keyboard); //calls again and restarts the inputPowers Method
		}

	}
	
	/*******************************************
	/* Function: powers Method
	/* Description: Uses recursion to solve the exponent problem with base and powers parameters
	 */
	/******************************************/
	public static int powers(int base,int power) 
	{

		int z; //variable to store the result

		if (power==0)  //special case method
		{
			z = 1;
		}
		else if (power==1) //base case
		{
			z = base;
		}
		else //otherwise
		{
			z = base * powers(base, power-1); //recursive call
		}
		return z;
					
	}
	
	/*******************************************
	/* Function: inputGCD Method
	/* Description: It asks 2 integer inputs from the user and prints the values plus calls the recursive method 
	 *gcd for the greatest common divisor. 
	 */
	/******************************************/
	public static void inputGCD(Scanner keyboard)
	{
		
		System.out.println("Enter the First Value: "); //prompts user to enter first value
		int m = 0;//initializes x
		
		boolean isTrue = false;//declares and intializes the boolean variable as false
		//do while loop that iterates at least one time
		
		do{
			try{  //try statement that validates the data
				m = keyboard.nextInt();	//stores the values inputted by the user for y
				if (m>=0) //if statement that makes sure there are no calculations done with negative numbers
				{
					isTrue = true; //boolean that validates the data
				}

				else //otherwise
				{
					
					System.out.print("Invalid Value: Enter an Integer Value"); //prompts the value is invalid
	            
				}
			}catch (InputMismatchException e){ //in the case of a mismatch error it catches it and asks the user to 
            	System.out.print("Enter an Integer Value"); //input the correct value
            	keyboard.next(); //consumes invalid value
			}
			
		}while (!(isTrue)); //while the data isn't valid
		
        System.out.println("Enter the Second Value: "); //prompts user to enter second value
		int n = 0;//initializes x
		
		isTrue = false;//declares and intializes the boolean variable as false
		//do while loop that iterates at least one time
		
		do{
			try{  //try statement that validates the data
				n = keyboard.nextInt();	//stores the values inputted by the user for y
				if (n>=0) //if statement that makes sure there are no calculations done with negative numbers
				{
					isTrue = true; //boolean that validates the data
				}

				else //otherwise
				{
					
					System.out.print("Invalid Value: Enter an Integer Value"); //prompts the value is invalid
	            
				}
			}catch (InputMismatchException e){ //in the case of a mismatch error it catches it and asks the user to 
            	System.out.print("Enter an Integer Value"); //input the correct value
            	keyboard.next(); //consumes invalid values
			}
			
		}while (!(isTrue)); //while the data isn't valid
		
		System.out.println("gcd(" + m + ", " + n +") = " + gcd(m,n)); //prints the output using the gcd method
		
	}
	
	/*******************************************
	/* Function: gcd Method
	/* Description: Uses recursion to solve the greatest common divisor problem int parameters
	 */
	/******************************************/
	public static int gcd(int m, int n)
	{
		int x = 0; 
		
		if (m % n == 0) //base case
			x = n;
		else //otherwise
			x = gcd(n, (m % n)); //recursive call
		return x;
			
	}
	
	/*******************************************
	/* Function: inputPalindrome Method
	/* Description: It asks 2 integer inputs from the user and prints the values plus calls the recursive method 
	 *gcd for the greatest common divisor. 
	 */
	/******************************************/
	public static void inputPalindrome(Scanner keyboard)
	{
		boolean result; //declares the boolean variable
		System.out.println("Enter a Palindrome: "); //Prompts the user to enter a Palindrome
		
		String string = keyboard.nextLine(); //creates a string based on user input
		String NewString = string.replaceAll(" ","").toLowerCase(); //Takes the spaces out of the string
		
		//declares a character array
		char [] array = (NewString.toCharArray());
	
		
		result = palindrome(array,0,array.length-1);//calls the palindrome method and stores the value in result variable
		
		//if else statement, if the result is true the string input prints as "is a palindrome" 
		if (result == true)
			System.out.println("\"" + string + "\"" + " is a palindrome.");
		else 
			System.out.println("\"" + string + "\"" + " is not a palindrome.");
	}
	
	/*******************************************
	/* Function: palindrome Method
	/* Description: Uses recursion to solve the is it a palindrome method using a character array and 2 int arrays
	 */
	/******************************************/
	public static boolean palindrome(char [] array,int x, int y)
	{
		boolean result; //declares boolean variable result
		
		if(y - x == 0 || y - x == 1) //base case
		{
			result = true;
		}
		else if(array[x] == array[y])
			result = palindrome(array, x+1, y-1); //recursive call
		else 
			result = false; //otherwise
		
		return result; //return result statement
	}
	
	/*******************************************
	/* Function: inputMystery Method
	/* Description: It asks 2 integer inputs from the user and prints the values plus calls the recursive method 
	 *mystery. 
	 */
	/******************************************/
	public static void inputMystery(Scanner keyboard)
	{

		System.out.println("Enter the First Value: ");//prompts user to enter first value
		int m = keyboard.nextInt(); //stores value into variable m
		System.out.println("Enter the Second Value: ");//prompts user to enter second value
		int n = keyboard.nextInt(); //stores value into variable n
		
		System.out.println("mystery(" + m + ", " + n +") = " + mystery(m,n)); //prints the output using the mystery method
		
	}
	/*******************************************
	/* Function: mystery Method
	/* Description: Uses recursion to solve the mystery method using 2 int variables. 
	 *Assumption: I believe this mystery method works a way of multiplication between the 2 variables. 
	 *It is not approached like a regular multiplication but the result are like if it was a regular multiplication.
	 */
	/******************************************/
	public static int mystery(int m, int n)
	{
		int result = 0;
		
		if (n==0) //base case
			m=n;
		else if (n % 2 == 0) //recursion call 1
			result = mystery(m + m,n/2); 
		else //otherwise
			result = mystery(m + m,n/2) + m; //recursion call 2
		
		return result;
			
	}
	
	/*******************************************
	/* Function: inputPermutation Method
	/* Description: It asks character inputs from the user and calls the recursive method permutation
	 *mystery. 
	 */
	/******************************************/
	public static void inputPermutation(Scanner keyboard)
	{
		System.out.println("Enter Characters: "); 
		
		String string = keyboard.nextLine();
		String NewString = string.replaceAll(" ","").toLowerCase();	
		permutation("",NewString);
	}
	
	/*******************************************
	/* Function: permutation Method
	/* Description: Uses recursion to find the total permutations.
	 */
	/******************************************/
	public static void permutation(String fixCharString, String charLeft)
	{
		if(charLeft.equals("")) //base case
		{
			System.out.println(fixCharString); 
		}
		else //otherwise
		{
			for(int i = 0;i<charLeft.length();i++) //for loop that iterates through every element of the string 
			{
				permutation(fixCharString + charLeft.charAt(i), charLeft.substring(0, i) + 
						   charLeft.substring(i + 1, charLeft.length()));
				/**********************
				/* The Recursive Call
				 *-------------------------------------------------------------------- 
				 * This recursive call uses 2 parameters: 
				 *
				 *    1.fixCharString (FIXED CHARACTER STRING) + current element
				 *    2.everything left in charLeft up to current element and after it 
				 */
				/***********************/
			}
		}
			
	}

}
