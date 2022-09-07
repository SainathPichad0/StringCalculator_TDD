
public class Calculator {
//	
//	////addded the add method in cal class 
	
	
	 public int add(String numbers) {
		 
	
		 boolean flag = numbers.matches(".*[a-zA-Z]+.*");
		 if (numbers.length() < 2) {
	            if (numbers.isEmpty()) {
	                return 0;
	            } else {
	                return convertToInt(numbers);
	            }
	        } 
		
		 else if(flag) {
			 return alphab(numbers);
			 
		 }
	       
	
	        else {
	            String delimiter = ",";
	            if(numbers.startsWith("0//")||numbers.startsWith("1//")) {
	            	return odd_even_index_addition(numbers);
	            }
	            else if (numbers.matches("//(.*)\n(.*)")) {
	                delimiter = Character.toString(numbers.charAt(2));
	                numbers = numbers.substring(4);
	            }

	            String[] numList = splitNumbers(numbers, delimiter + "|\n");
	            return Addition(numList);
	        }
	    }

	    private String[] splitNumbers(String numbers, String divider) {
	        return numbers.split(divider);
	    }

	    //method used to convert string to Integer primitive object passing or wrapper class utilities are used here 
	    private int convertToInt(String num) {
	        return Integer.parseInt(num);
	    }
	    
	 

	    private int Addition(String[] numbers) {
	        int total = 0;
	        StringBuilder negativeString = new StringBuilder();

	        for (String number : numbers) {
	            if (convertToInt(number) < 0) {
	                if (negativeString.toString().equals(""))
	                    negativeString = new StringBuilder(number);
	                else
	                    negativeString.append(",").append(number);
	            }
	            if (convertToInt(number) < 1000)
	                total += convertToInt(number);
	        }

	        if (!negativeString.toString().equals("")) {
	            throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
	        }

	        return total;
	    }
	    
	    
	    ///
	    
//	    Allow alphabets to be included with numbers.
//	    The numeric value for the alphabet would be equal to its position.
//	    Such as a = 1, b = 2, c = 3 … y = 25, z = 26.
//	    For example:
//	    Input: "1,2,adewew  ,c"
//	    Output: 7 (1 + 2 + 1 + 3)
//	    Note: Use lowercase alphabets only
	    private int alphab(String xyz) {
	        xyz.toLowerCase();
	        int sum=0;
	        for(int i=0;i<xyz.length();i++){
	            if(xyz.charAt(i)<='z'&&xyz.charAt(i)>='a'){
	                sum=sum+(xyz.charAt(i)-'a')+1;
	            }
	         else if(xyz.charAt(i)<='9'&&xyz.charAt(i)>='0'){
	                sum=sum+(xyz.charAt(i)-'0');
	            }
	        }
	        return sum;
	    }
	    
	    
//	    
//	    9. (Optionalcd sd ) Support odd/even addition: If the beginning of the string starts with 0// then add numbers 
////	    at odd indices and if it starts with 1// then add numbers at even indices.
////	 
	    
	   private int odd_even_index_addition(String str) {
		   
		   //String str="0//**1**2*89";
	        int flag=-1;
	        int xyz=00;
	        if(str.startsWith("0//")||str.startsWith("//") )
	        {
	            flag=0;
	        }else if(str.startsWith("1//"))
	        {
	            flag=1;
	        }
	        int sum=0;
	        for(int i=3;i<str.length();i++)
	        {
	            if(str.charAt(i)<='9' && str.charAt(i)>='0')
	            {
	                if(flag==0)
	                {
	                    if(i%2==1  )
	                    {
	                        sum=sum+(str.charAt(i)-'0');
	                    }
	                }else if(flag==1)
	                {
	                     if(i%2==0 )
	                    {
	                        sum=sum+(str.charAt(i)-'0');
	                    }
	                }
	            }
	        }
	        return sum;
	   }
}
