
package payrollsystem;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {

    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new FullTimeEmployee("E001", "أحمد علي", 3000.0, LocalDate.of(2020, 5, 10), 500.0));
        employees.add(new FullTimeEmployee("E002", "سارة ", 4500.0, LocalDate.of(2018, 2, 15), 800.0));
        employees.add(new ContractorEmployee("E003", " خالد", LocalDate.of(2023, 1, 20), 50, 160));
        employees.add(new ContractorEmployee("E004", "فاطمة عمر", LocalDate.of(2021, 8, 5), 60, 150));

        System.out.println(" قائمة الموظفين الأصلية ");
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " | Net Salary: " + emp.calculateNetSalary());
        }
        Collections.sort(employees);
        System.out.println("\n قائمة الموظفين بعد الفرز حسب صافي الراتب (تنازليا)");
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " | Net Salary: " + emp.calculateNetSalary());
        }
        employees.sort(Comparator.comparing(Employee::getJoinDate));
        System.out.println("\n قائمة الموظفين بعد الفرز حسب تاريخ الانضمام (الأقدمية)");
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " | Join Date: " + emp.getJoinDate());
        }
        double totalTaxes = 0;
        double totalBonuses = 0;
        double sampleScore = 4.5; 

        for (Employee emp : employees) {
            totalTaxes += emp.calculateTax();
            totalBonuses += emp.calculateBonus(sampleScore);
        }

        System.out.println("\n الحسابات المالية الإجمالية للنظام ");
        System.out.println("إجمالي الضرائب المحصلة: " + totalTaxes);
        System.out.println("إجمالي المكافآت الموزعة: " + totalBonuses);
    }
}