package com.epam.java.maksym_yena.lecture_10.task_8.part_3.Sorted;


import com.epam.java.maksym_yena.lecture_10.task_8.part_3.Planes.Plane;

public class sortedBy {

    public  void sortByDistance(Plane[] planes) {

        for (int i = planes.length - 1; i >= 1; i--) {

            for(int j = 0; j < i; j++) {

                if(planes[j].getGetFlghtRange() > planes[j + 1].getGetFlghtRange()) {

                    double range = planes[i].getGetFlghtRange();

                    planes[i].setGetFlghtRange(planes[j].getGetFlghtRange());

                    planes[j].setGetFlghtRange(range);
                }
            }
        }

        for(Plane obj : planes) {
            System.out.println("Name : " + obj.getName() + " " + "flghtRange: " + obj.getGetFlghtRange());
        }
    }

    public void findPlane(Plane[] planes, double searchWeight, int searchMaxSpeed,
                               double searchFuelConsumption, int searchFuelTank,
                               int searchCarriage, int searchMaxCapacity, int searchWeightOfCargo) {

        for (int i = 0; i < planes.length; i++) {

            if ((searchWeight == planes[i].getWeight()) && (searchMaxSpeed == planes[i].getMaxSpeed())

            && (searchFuelConsumption == planes[i].getFuelConsumption()) && (searchFuelTank == planes[i].getFuelTank())

            && (searchCarriage == planes[i].getCarriage()) && (searchMaxCapacity == planes[i].getMaxCapacity()))

            {
                System.out.println("Founded airplane : " + planes[i].getName());
                break;
            }
            else {
                System.out.println("Not founded!");
            }
        }
    }




}
