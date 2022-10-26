package com.epam.maksym_yena.java.lecture3.task1.arrayTask;

public class ApplicationArray {

    public static void main(String[] args) {
        ApplicationArray applicationArray = new ApplicationArray();
        int[] nums = applicationArray.fillArray();
        applicationArray.printArray(nums);
        System.out.println("Array[1]");
        applicationArray.triplingValue(nums);
        System.out.println("Array[2] (after changing)");
    }

    /* 4.В массиве целых чисел утроить каждый положительный элемент,
    который стоит перед отрицательным. */
    public void triplingValue(int [] nums){
        for(int i = 0 ;i < nums.length-1; i++) {
            if(nums[i] > 0 && nums[i+1]<0){
                nums[i] = 3 * nums[i];
            }
        }
        printArray(nums);
    }

    /* Initialization of array */
    public int[] fillArray(){
        int[] nums;
        nums = new int[20];
        for(int i = 0; i< nums.length; i++) {
            nums[i] = (int)((Math.random() * 21) - 11);
        }
        return nums;
    }

    /* Display array */
    public void printArray(int[] nums) {
        for(int x : nums)
        {
            System.out.print(x + " ");
        }
    }
}
