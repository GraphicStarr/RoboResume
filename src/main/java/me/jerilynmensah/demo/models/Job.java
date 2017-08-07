package me.jerilynmensah.demo.models;

import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;

@Entity
public class Job {

    @NotNull
    @Min(1)
    @Id
    private String name;

    @NotNull
    @Size(min = 5, max = 30)
    private String email;
    private String organization;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String startDate;
    
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String endDate;
    
    long daysEmployed;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getOrganization()
    {
        return organization;
    }

    public void setOrganization(String organization)
    {
        this.organization = organization;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public long getDaysEmployed()
    {
        return daysEmployed;
    }

    public void setDaysEmployed(long daysEmployed)
    {
        this.daysEmployed = daysEmployed;
    }
}

