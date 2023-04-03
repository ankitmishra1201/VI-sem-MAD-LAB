package com.example.l7q1;



public class Customer
{
    private String name;
    private String num;

    public Customer(String name, String num)
    {
        this.name = name;
        this.num = num;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }
}