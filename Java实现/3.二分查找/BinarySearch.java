import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = binary_search(arr, 4);
        System.out.println(i);

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        int[] res = findMatrix(matrix, 7);
        System.out.println(Arrays.toString(res));
    }

    public static int binary_search(int[] arr, int target) {
        int low = 0, height = arr.length - 1, mid;
        while (low <= height) {
            mid = (low + height) / 2; //取mid
            if (arr[mid] == target) { //mid为目标元素直接返回
                return mid;
            } else if (arr[mid] > target) { //目标元素小于mid,查找mid前半部分
                height = mid - 1;
            } else { //查找mid后半部分
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int[] findMatrix(int[][] arr, int target) {
        if (arr.length == 0 || arr[0].length == 0) {
            return new int[0];
        }
        int row = arr.length;
        int col = arr[0].length;
        int low = 0, mid = 0;
        int height = row * col - 1;//将二维数组拉成一维数组
        while (low <= height) {
            mid = (low + height) / 2;
            int _row = mid / col; //mid索引所在的行
            int _col = mid % col; //mid索引所在的列
            if (arr[_row][_col] == target) { //mid为目标元素直接返回
                return new int[]{_row, _col};
            } else if (arr[_row][_col] > target) { //目标元素小于mid,查找mid前半部分
                height = mid - 1;
            } else { //查找mid后半部分
                low = mid + 1;
            }
        }
        return new int[0];

    }


}