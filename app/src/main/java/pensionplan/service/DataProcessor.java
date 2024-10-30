package pensionplan.service;

import pensionplan.dto.EmployeesPensionPlanDto;
import pensionplan.model.Employee;
import pensionplan.model.PensionPlan;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {
    public List<Employee> loadAllEmployee() {
        List<Employee> employees = loadSeedData();
        return employees.stream().sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Comparator.comparing(Employee::getEmploymentDate).reversed()))
                .collect(Collectors.toList());
    }

    public List<Employee> loadMonthlyUpcomingEnrolles() {
        LocalDate now = LocalDate.now();

        YearMonth nextMonth = YearMonth.from(now).plusMonths(1);
        LocalDate firstDayOfNextMonth = nextMonth.atDay(1);
        LocalDate lastDayOfNextMonth = nextMonth.atEndOfMonth();

        List<Employee> employees = loadSeedData();

        return employees.stream()
                .filter(emp ->
                        !emp.isPensionPlanEnrolled() &&
                                emp.getEmploymentDate().plusYears(5).isAfter(firstDayOfNextMonth.minusDays(1)) &&
                                emp.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth.plusDays(1)))
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Comparator.comparing(Employee::getEmploymentDate).reversed()))
                .collect(Collectors.toList());
    }

    private List<Employee> loadSeedData() {
        List<EmployeesPensionPlanDto> employeesPensionPlanDtos = new ArrayList<EmployeesPensionPlanDto>() {
            {
                add(new EmployeesPensionPlanDto(1, "EX1089", "Daniel", "Agar", 105945.50, LocalDate.of(2018,01,17),LocalDate.of(2023,01,17),100.0));
                add(new EmployeesPensionPlanDto(2, null, "Benard", "Shaw", 197750.00, LocalDate.of(2019,04,03), null,null));
                add(new EmployeesPensionPlanDto(3, "SM2307", "Carly", "Agar", 842000.75, LocalDate.of(2014,05,16),LocalDate.of(2019,11,04),1555.50));
                add(new EmployeesPensionPlanDto(4, null, "Wesley", "Schneider", 74500.00, LocalDate.of(2019,11,02), null,null));
            }
        };

        List<Employee> employees = employeesPensionPlanDtos.stream()
                .map(o -> new Employee(o.getEmployeeId(), o.getFirstName(), o.getLastName(), o.getEmploymentDate(), o.getYearlySalary(), o.getPlanReferenceNumber() != null ? new PensionPlan(o.getPlanReferenceNumber(), o.getEnrollDate(), o.getMonthlyContribution()) : null))
                .collect(Collectors.toList());

        return employees;
    }
}
