package com.example.mycrmprogectv1.model.tasc;

import com.example.mycrmprogectv1.model.employee.Employee;
import com.example.mycrmprogectv1.model.company.Company;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class Task {
    private Long taskId;

    private String name;
    private String description;
    private LocalDateTime creation;
    private LocalDateTime start;
    private LocalDateTime ending;

    private Action actionId;
    private Status statusId;
    private Company companyId;
    private Employee employeeId;

    public Task() {
        this.creation = LocalDateTime.now();
    }

    public Task(Action action, Status status, Company company) {
        this.actionId = action;
        this.statusId = status;
        this.companyId = company;
    }

    public Task(
            String name,
            String description,
            LocalDateTime creation,
            LocalDateTime start,
            LocalDateTime ending,
            Action actionId,
            Status statusId,
            Company companyId,
            Employee employeeId
    ) {
        this.name = name;
        this.description = description;
        this.creation = LocalDateTime.now();
        this.start = start;
        this.ending = ending;
        this.actionId = actionId;
        this.statusId = statusId;
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public Task(Long taskId, String name,
                String description,
                LocalDateTime creation,
                LocalDateTime start,
                LocalDateTime ending,
                Action actionId,
                Status statusId,
                Employee employeeId) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.creation = LocalDateTime.now();
        this.start = start;
        this.ending = ending;
        this.actionId = actionId;
        this.statusId = statusId;
        this.employeeId = employeeId;
    }
}
