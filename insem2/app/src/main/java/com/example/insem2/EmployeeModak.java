package com.example.insem2;

public class EmployeeModak {
    private String id;
    private String name;
    private String salary;
    private String comission;

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getComission() {
        return comission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }

    public EmployeeModak(String name, String salary,String comission,String string){
        this.name=name;
        this.salary=salary;
        this.comission=comission;
    }

}
