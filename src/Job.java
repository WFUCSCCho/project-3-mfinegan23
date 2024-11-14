/***********************************************************************
 ∗ @file: Job.java
 ∗ @description: This program implements the Job class with Comparable interface. Gets data from jobs_in_data.csv, which is from Kaggle
 ∗ @author: Max Finegan
 ∗ @date: September 24 , 2024
 ***********************************************************************/

import java.util.Objects;

public class Job implements Comparable<Job> {

    //work_year, job_title, job_category, salary_currency, salary, salary_in_usd, employee_residence, experience_level, employment_type, work_setting, company_location, company_size
    Integer workYear;
    String jobTitle;
    String jobCategory;
    String salaryCurrency;
    Integer salary;
    Integer salaryInUSD;
    String employeeResidence;
    String experienceLevel;
    String employmentType;
    String workSetting;
    String companyLocation;
    String companySize;


    //default constructor
    public Job() {
        this.workYear = 0;
        this.jobTitle = "";
        this.jobCategory = "";
        this.salaryCurrency = "";
        this.salary = 0;
        this.salaryInUSD = 0;
        this.employeeResidence = "";
        this.experienceLevel = "";
        this.employmentType = "";
        this.workSetting = "";
        this.companyLocation = "";
        this.companySize = "";
    }

    // constructor for Job data
    public Job(Integer workYear, String jobTitle, String jobCategory, String salaryCurrency, Integer salary, Integer salaryInUSD, String employeeResidence, String experienceLevel, String employmentType, String workSetting, String companyLocation, String companySize){
        this.workYear = workYear;
        this.jobTitle = jobTitle;
        this.jobCategory = jobCategory;
        this.salaryCurrency = salaryCurrency;
        this.salary = salary;
        this.salaryInUSD = salaryInUSD;
        this.employeeResidence = employeeResidence;
        this.experienceLevel = experienceLevel;
        this.employmentType = employmentType;
        this.workSetting = workSetting;
        this.companyLocation = companyLocation;
        this.companySize = companySize;
    }

    // copy constructor
    public Job(Job j) {
        workYear = j.workYear;
        jobTitle = j.jobTitle;
        jobCategory = j.jobCategory;
        salaryCurrency = j.salaryCurrency;
        salary = j.salary;
        salaryInUSD = j.salaryInUSD;
        employeeResidence = j.employeeResidence;
        experienceLevel = j.experienceLevel;
        employmentType = j.employmentType;
        workSetting = j.workSetting;
        companyLocation = j.companyLocation;
        companySize = j.companySize;
    }

    // String interface for Job data
    @Override
    public String toString() {
        return "Work Year: " + workYear + ", Job Title: " + jobTitle + ", Job Category: " + jobCategory + ", Salary Currency: " + salaryCurrency +
                    ", Salary: " + salary + ", Salary in USD: " + salaryInUSD + ", Employee Residence: " + employeeResidence +
                    ", Experience Level: " + experienceLevel + ", Employment Type: " + employmentType + ", Work Setting: " + workSetting +
                    ", Company Location: " + companyLocation + ", Company Size: " + companySize;


    }

    // Compares based off of salaryInUSD
    @Override
    public int compareTo(Job job) {

//        if (this.jobTitle != job.jobTitle){
//            return Integer.compare(this.workYear, job.workYear);
//        }

        return this.salaryInUSD.compareTo(job.salaryInUSD);
    }




//    public boolean equals(Job obj) {
//        if (this == obj) {
//            return true; // Check if it's the same object
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false; // Check if job is a Job
//        }
//        Job job = (Job) obj; // Cast the object to Job // Needed?
//
//        return this.salaryInUSD == job.salaryInUSD; // Compare salary
//    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Check if it's the same object
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Check if obj is a Job
        }
        Job job = (Job) obj; // Cast the object to Job
        return Objects.equals(workYear, job.workYear) &&
                Objects.equals(jobTitle, job.jobTitle) &&
                Objects.equals(jobCategory, job.jobCategory) &&
                Objects.equals(salaryCurrency, job.salaryCurrency) &&
                Objects.equals(salary, job.salary) &&
                Objects.equals(salaryInUSD, job.salaryInUSD) &&
                Objects.equals(employeeResidence, job.employeeResidence) &&
                Objects.equals(experienceLevel, job.experienceLevel) &&
                Objects.equals(employmentType, job.employmentType) &&
                Objects.equals(workSetting, job.workSetting) &&
                Objects.equals(companyLocation, job.companyLocation) &&
                Objects.equals(companySize, job.companySize);
    }



    // Getters and Setters for Work Year
    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer workYear) {
        this.workYear = workYear;
    }

    // Getters and Setters for Job Title
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // Getters and Setters for Job Category
    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    // Getters and Setters for Salary Currency
    public String getSalaryCurrency() {
        return salaryCurrency;
    }

    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    // Getters and Setters for Salary
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    // Getters and Setters for Salary in USD
    public Integer getSalaryInUSD() {
        return salaryInUSD;
    }

    public void setSalaryInUSD(Integer salaryInUSD) {
        this.salaryInUSD = salaryInUSD;
    }

    // Getters and Setters for Employee Residence
    public String getEmployeeResidence() {
        return employeeResidence;
    }

    public void setEmployeeResidence(String employeeResidence) {
        this.employeeResidence = employeeResidence;
    }

    // Getters and Setters for Experience Level
    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    // Getters and Setters for Employment Type
    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    // Getters and Setters for Work Setting
    public String getWorkSetting() {
        return workSetting;
    }

    public void setWorkSetting(String workSetting) {
        this.workSetting = workSetting;
    }

    // Getters and Setters for Company Location
    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    // Getters and Setters for Company Size
    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }



}
