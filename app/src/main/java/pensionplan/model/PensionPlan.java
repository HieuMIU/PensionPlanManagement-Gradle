package pensionplan.model;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;

    private LocalDate enrollDate;

    private Double monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollDate = enrollDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
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
