
package payrollsystem;

import java.time.LocalDate;

public class ContractorEmployee extends Employee {
   
    private int hourlyRate;
    private int hoursWorked;

    public ContractorEmployee(String id, String name, LocalDate joinDate, int hourlyRate, int hoursWorked) {
        super(id, name, 0.0, joinDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateNetSalary() {
        return hourlyRate * hoursWorked;
    }
    @Override
    public double calculateBonus(double score) {
        if (score > 4.0) {
            return 500.0;
        }
        return 0.0;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}