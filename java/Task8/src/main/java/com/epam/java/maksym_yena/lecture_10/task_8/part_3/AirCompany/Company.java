package com.epam.java.maksym_yena.lecture_10.task_8.part_3.AirCompany;


import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.Plane;

public class Company {

    Plane[] planes;
    private String name;
    private int countOfPlanes;

    public Company(String name, int countOfPlanes) {
        this.countOfPlanes = countOfPlanes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfPlanes() {
        return countOfPlanes;
    }

    public void setCountOfPlanes(int countOfPlanes) {
        this.countOfPlanes = countOfPlanes;
    }

    private String renameCompany(String oldName, String newName) {
        this.name = newName;
        return this.name;
    }

    public long getSumCarriage(Plane[] planes) {
        long result = 0;
        for(int i = 0;i < planes.length; i++) {
            result+=planes[i].getCarriage();
        }
        return result;
    }

    public long getSumCapacity(Plane[] planes) {
        long result = 0;
        for(int i = 0; i < planes.length; i++) {
            result+=planes[i].getMaxCapacity();
        }
        return result;
    }

    public void about(Company company) {
        System.out.print("Name of company : " + company.getName() + "\nAnd it has got = " +
                company.countOfPlanes);
    }

}
