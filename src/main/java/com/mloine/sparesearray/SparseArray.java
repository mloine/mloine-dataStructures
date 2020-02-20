package com.mloine.sparesearray;
/**
 * @Author mloine
 * @Description 稀疏数组 和 二维数组之间的转换
 * @Date 3:04 下午 2020/2/20
 */
public class SparseArray {

    public static void main(String[] args) {
        //1.创建原始的二维数组
        // 0-无棋子 1-黑子 2-白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        //输出原始而为数组
        System.out.println("原始二维数组~~~~~");
        for(int[] row: chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //二维数组 转 稀疏数组  --------------------------------------------------------
        int sum = 0;
        // 行数
        int rows = chessArr1.length;
        // 列数
        int lows = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                lows = chessArr1[i].length;
                if(chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }
//        System.out.println(sum);

        //创建对应的稀疏数组
        int[][] sparseArray = new int[1+sum][3];
        // 赋值
        sparseArray[0][0] = rows;
        sparseArray[0][1] = lows;
        sparseArray[0][2] = sum;

        // 计数器 继续辅助
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j] ;
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("得到的稀疏数组~~~~~~");
        for(int[] row: sparseArray){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //稀疏数组 恢复成二维数组 --------------------------------------------------------------------
        // 更具行数 和 列数  定义恢复的二维数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //恢复后的二维数组
        System.out.println("恢复后的二维数组~~~~~~");
        for(int[] row: chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
