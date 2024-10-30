package pensionplan.dto;

import java.time.LocalDate;

public class EmployeesPensionPlanDto {
    private long employeeId;

    private String planReferenceNumber;

    private String firstName;

    private String lastName;

    private double yearlySalary;

    private LocalDate employmentDate;

    private LocalDate enrollDate;

    private Double monthlyContribution;

    public EmployeesPensionPlanDto(long employeeId, String planReferenceNumber, String firstName, String lastName, double yearlySalary, LocalDate employmentDate, LocalDate enrollDate, Double monthlyContribution) {
        this.employeeId = employeeId;
        this.planReferenceNumber = planReferenceNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearlySalary = yearlySalary;
        this.employmentDate = employmentDate;
        this.enrollDate = enrollDate;
        this.monthlyContribution = monthlyContribution;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public Double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(Double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
