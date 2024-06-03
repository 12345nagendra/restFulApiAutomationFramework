package main.java;

import main.java.utils.excelUtility.ExcelUtility;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        int [] arr = {1,2,2,4};
//        int [] arr2 = getTheProduct(arr);
//        System.out.println(Arrays.toString(arr2));
        ExcelUtility.readExcel();
    }

    private static int[] getTheProduct(int[] arr) {
        int length = arr.length;
        int[] newArr = new int [length];
        for(int i=0; i<length; i++){
            int product = 1;
            for(int j=0; j<length; j++){
                if(i!=j){
                    product = product*arr[j];
                }
            }
            newArr[i] = product;
        }
        return newArr;
    }
}