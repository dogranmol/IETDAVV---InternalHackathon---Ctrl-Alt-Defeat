package com.example.mydisasterbuddy;

public class EmergencyContact
{
    String num1;
    String num2;
    String num3;

    public EmergencyContact(String num1, String num2, String num3)
    {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }
}
