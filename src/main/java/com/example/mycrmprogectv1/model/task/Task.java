package com.example.mycrmprogectv1.model.task;

import com.example.mycrmprogectv1.model.company.Company;
import com.example.mycrmprogectv1.model.employee.Employee;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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



}
