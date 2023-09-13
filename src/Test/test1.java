package Test;

import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        //创建一个含有16个元素的一维数组，要求打乱顺序后存入一个二维数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        //定义随机变量
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();

        //创建一个二维数组
        int[][] arr = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            arr[i/4][i%4] = tempArr[i];
        }

        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
