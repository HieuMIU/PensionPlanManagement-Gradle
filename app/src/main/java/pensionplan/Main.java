package pensionplan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import pensionplan.service.DataProcessor;

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();

        // Print-out the list of all the Employees in JSON format
        System.out.println("Employee List:");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            String jsonText = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataProcessor.loadAllEmployee());
            System.out.println(jsonText);
        } catch (JsonProcessingException e) {
            System.out.println("Something wrong!");
        }

        // Print-out the list of all the Monthly Upcoming Enrollees in JSON format
        System.out.println("Monthly Upcoming Enrollees:");

        try {
            String jsonText = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataProcessor.loadMonthlyUpcomingEnrolles());
            System.out.println(jsonText);
        } catch (JsonProcessingException e) {
            System.out.println("Something wrong!");
        }
    }
}