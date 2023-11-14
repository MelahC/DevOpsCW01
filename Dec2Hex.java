import java.util.Scanner;

class Dec2Hex
{

    public static int Arg1;

    public static void main(String args[])
    {
      // Check for user input
       if (args.length < 1 ) {
       // Print error message and exit the programme if no input argument is provided 
       System.out.println("Please provide valid input");
       //Exit the program with error code (meaning encountered problem could not complete inteded operation)
        System.exit(1);
     }
      try {
        Arg1 = Integer.parseInt(args[0]);
     } catch (NumberFormatException e) {
      // Handle non intergear input
       System.out.println("Error: Input not valid. Please enter a  valid decimal number.");
      //exit code 0 to indicate unable to perform conversion due to invalid user input
       System.exit(0);
     }
        char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem, num;
        num = Arg1;
        String hexadecimal="";
        System.out.println("Converting the Decimal Value " + num + " to Hex...");
       
        //Converting decimal number to hexadecimal using while loop
        while(num != 0)
        {
            rem=num%16;
            hexadecimal= ch[rem] + hexadecimal;
            num= num/16;
        }
       
        System.out.println("Hexadecimal representation is: " + hexadecimal);

    }
}
