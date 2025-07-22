public class PayrollCalculator {
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {

        double payAmount = 0;
        if (hoursWorked < 0 || hourlyRate < 0) {
            return -1;
        }
        switch (employeeType) {
            case "FULL_TIME":
                if (hoursWorked > 40) {

                    double overtimeHours = hoursWorked - 40;
                    double overTimePay = (hourlyRate * 1.5) * overtimeHours;
                    payAmount = (40 * hourlyRate) + overTimePay;
                } else {
                    payAmount = hourlyRate * hoursWorked;
                }
                break;
            case "PART_TIME":
                if (hoursWorked > 25) {
                    payAmount = hourlyRate * 25;
                } else {
                    payAmount = hourlyRate * hoursWorked;
                }
                break;
            case "CONTRACTOR":
                payAmount = hoursWorked * hourlyRate;
                break;
            case "INTERN":
                if (hoursWorked > 20) {
                    payAmount = (hourlyRate * 20) * 0.80;
                } else {
                    payAmount = (hourlyRate * hoursWorked) * 0.80;
                }
                break;
            default:
                return -1;

        }
        return payAmount;
    }


    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double taxPrec = 0;
        if (grossPay < 500) {
            taxPrec = 10;
        } else{
            if(grossPay < 1001){
                taxPrec = 15;
            }else if(grossPay <2001){
                taxPrec = 20;
            }else{
                taxPrec = 25;
            }
        }
        double taxAmount = grossPay * (taxPrec/100);
        return taxPrec;
    }


    public static void processPayroll(String[] employeeTypes,double[] hours,double[] rates, String[] names){

        int minLength = Integer.MAX_VALUE;
        if(employeeTypes !=null) minLength = Math.min(minLength,hours.length);
        if (hours != null) minLength = Math.min(minLength, hours.length);
        if (rates != null) minLength = Math.min(minLength, rates.length);
        if (names != null) minLength = Math.min(minLength, names.length);

        if(minLength == 0 || minLength == Integer.MAX_VALUE){
            System.out.println("No employee data to process");
            return;
        }

        double highestPay = -1.0;
        String highestPaidEmployee = "-";
        String lowestPaidEmployee = "-";
        double lowestPay = Double.MAX_VALUE;
        double totalPay = 0.0;
        int overtimeEmployees = 0;
        int validEmployeesProcessed = 0;

        System.out.println("\n--- Payroll Processing Results ---");
        System.out.println("+-----------------+------------------+------------------+------------------+");
        System.out.printf("| %-15s | %-16s | %-16s | %-16s |\n", "Employee Name", "Employee Type", "Hours Worked", "Gross Pay");
        System.out.println("+-----------------+------------------+------------------+------------------+");
        for(int i = 0;i<minLength;i++){
            String employeeType = (employeeTypes != null && i < employeeTypes.length) ? employeeTypes[i] : "N/A";
            double employeeHours = (hours != null && i < hours.length) ? hours[i] : 0.0;
            double employeeRate = (rates != null && i < rates.length) ? rates[i] : 0.0;
            String employeeName = (names != null && i < names.length) ? names[i] : "Unknown Employee " + (i + 1);

            // check if data is missing
            if(employeeRate <=0){
                System.out.println("Invalid Rate  for employee{"+employeeName+"}");
                continue;
            }

            double currentPay =calculateWeeklyPay(employeeType,employeeHours,employeeRate);
            if (currentPay <= 0 && employeeRate <= 0) { // If rate was invalid, skip adding to stats
                System.out.printf("| %-15s | %-16s | %-16.2f | %-16s |\n", employeeName, employeeType, employeeHours, "Invalid Input");
                continue; // Skip this employee for statistics if the input was clearly bad
            }
            System.out.printf("| %-15s | %-16s | %-16.2f | %-16.2f |\n", employeeName, employeeType, employeeHours, currentPay);



            totalPay += currentPay;
            validEmployeesProcessed++;


            if(employeeHours > 40){
                overtimeEmployees++;
            }

            if(currentPay > highestPay){
                highestPay = currentPay;
                highestPaidEmployee = employeeName;
            }

            if(currentPay > 0 && currentPay < lowestPay){
                lowestPay = currentPay;
                lowestPaidEmployee = employeeName;
            }else if(validEmployeesProcessed == 1 && currentPay >0){
                lowestPay = currentPay;
                lowestPaidEmployee = employeeName;
            }

            System.out.println("+-----------------+------------------+------------------+------------------+");


        }
        // statistics
        if (validEmployeesProcessed > 0) {
            double averagePay = totalPay / validEmployeesProcessed;
            System.out.println("\n--- Payroll Statistics ---");
            System.out.printf("Total Employees Processed: %d\n", validEmployeesProcessed);
            System.out.printf("Highest Paid Employee: %s (Pay: %.2f)\n", highestPaidEmployee, highestPay);
            System.out.printf("Lowest Paid Employee: %s (Pay: %.2f)\n", lowestPaidEmployee, lowestPay);
            System.out.printf("Average Pay: %.2f\n", averagePay);
            System.out.printf("Employees Who Worked Overtime: %d\n", overtimeEmployees);
        } else {
            System.out.println("\nNo valid employees were processed to calculate statistics.");
        }

    }

    public static  void main(String[] args){
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        processPayroll(types,hours,rates,names);

    }

}
