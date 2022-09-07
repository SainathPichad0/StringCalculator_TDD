
public class Calculator {
	
	//addded the add method in cal class 
	//
	 public int add(String num) {
	        if (num.length() < 2) {
	            if (num.isEmpty()) {
	                return 0;
	            } else {
	                return convertToInt(num);
	            }
	        } else {
	            String delimiter = ",";
	            if (num.matches("//(.*)\n(.*)")) {
	                delimiter = Character.toString(num.charAt(2));
	                num = num.substring(4);
	            }

	            String[] numList = splitNumbers(num, delimiter + "|\n");
	            return sum(numList);
	        }
	    }

	    private String[] splitNumbers(String numbers, String divider) {
	        return numbers.split(divider);
	    }

	    private int convertToInt(String num) {
	        return Integer.parseInt(num);
	    }

	    private int sum(String[] numbers) {
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
	            throw new IllegalArgumentException("Negatives Number is  not allowed: " + negativeString);
	        }

	        return total;
	    }
}
