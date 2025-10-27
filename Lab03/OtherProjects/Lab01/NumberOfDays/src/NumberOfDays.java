package Lab03.OtherProjects.Lab01.NumberOfDays.src;





import java.util.Scanner;
public class NumberOfDays {
	    public static boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	    }

	    public static int getMonthNumber(String input) {
	        input = input.trim().toLowerCase();

	        // Check if input is a number
	        if (input.matches("\\d+")) {
	            int num = Integer.parseInt(input);
	            if (num >= 1 && num <= 12) {
	                return num;
	            }
	        }

	        // CHeck if input is the month's name
	        String[] fullNames = {"january","february","march","april","may","june",
	                              "july","august","september","october","november","december"};
	        String[] shortNames = {"jan","feb","mar","apr","may","jun",
	                               "jul","aug","sep","oct","nov","dec"};

	        for (int i = 0; i < 12; i++) {
	            if (input.equals(fullNames[i]) || input.equals(shortNames[i]) || input.equals(shortNames[i] + ".")) {
	                return i + 1;
	            }
	        }

	        return 0; // invalid
	    }

	    public static int getDays(int month, int year) {
	        switch (month) {
	            case 2: return isLeapYear(year) ? 29 : 28;
	            case 4: case 6: case 9: case 11: return 30;
	            default: return 31;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int month, year;

	        while (true) {
	            System.out.print("Enter a month (number, name, or abbreviation): ");
	            String monthInput = sc.nextLine();
	            month = getMonthNumber(monthInput);

	            if (month == 0) {
	                System.out.println("Invalid month. Try again.");
	                continue;
	            }

	            System.out.print("Enter a year (non-negative integer): ");
	            String yearInput = sc.nextLine();

	            if (!yearInput.matches("\\d+")) {
	                System.out.println("Invalid year. Try again.");
	                continue;
	            }

	            year = Integer.parseInt(yearInput);

	            int days = getDays(month, year);
	            System.out.println("The month has " + days + " days.");
	            break; // stop after correct input
	        }

	        sc.close();
	    }
}
