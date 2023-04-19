import javax.swing.JOptionPane;

public class DaysinMonth {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        String[] monthAbbreviations = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec." };
        String[] month3lett = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int year = 0;
        int monthout = 0;
        boolean validInput = false;
        int daysInMonth = 0;

        while (!validInput) {
            String monthInput = JOptionPane.showInputDialog(null, "Enter month (full name or abbreviation):");
            String month = monthInput.trim().toLowerCase();
            String yearInput = JOptionPane.showInputDialog(null, "Enter year:");
            
            for (int i = 0; i < months.length; i++) {
                if (month.equals(months[i].toLowerCase()) || month.equals(monthAbbreviations[i].toLowerCase()) || month.equals(month3lett[i].toLowerCase()) || month.equals(String.valueOf(i + 1))) {
                    daysInMonth = days[i];
                    monthout = i;
                    validInput = true;
                    break;
                } else {
                    validInput = false;
                }
                
            }
            try {
                year = Integer.parseInt(yearInput);
                validInput = validInput && year > 0;
            } catch (NumberFormatException e) {
                validInput = false;
            }

            if (!validInput) {
                System.out.println("Invalid input. Please try again.");
            }

        
        }
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Display number of days in the month
        if (monthout == 1 && isLeapYear) {
            JOptionPane.showMessageDialog(null,"February " + year + " has 29 days.");
        } else {
            JOptionPane.showMessageDialog(null, months[monthout] + " " + year + " has " + daysInMonth + " days.");
        }    
    }
}