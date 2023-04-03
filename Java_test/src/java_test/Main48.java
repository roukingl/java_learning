package java_test;

public class Main48 {

    public int[] clockwisePrint(int[][] mat, int n, int m) {
        int[] arr = new int[n * m];
        int nLength = 1;
        int mLength = 0;
        int index = 0; // arr数组的下标
        while ((n - nLength) != 0 && (m - mLength) != 0) {
            for (int i = mLength; i < m; i++) {
                arr[index++] = mat[nLength - 1][i];
            }
            for (int i = nLength; i < n; i++) {
                arr[index++] = mat[i][m - 1 - mLength];
            }
            mLength++;
            nLength++;
            if ((n - nLength) != 0 && (m - mLength != 0)) {
                for (int i = m - 1 - mLength; i >= nLength - 2; i++) {
                    arr[index++] = mat[n - nLength + 1][i];
                }
                for (int i = n - nLength; i >= mLength; i++) {
                    arr[index++] = mat[i][mLength - 1];
                }
                mLength++;
                nLength++;
            } else {
                break;
            }
        }
        return arr;
    }

    public int findMaxGap(int[] arr, int n) {
        int reject = 0;
        for (int k = 0; k <= n - 2; k++) {
            int leftMax = arr[k];
            int rightMax = arr[k + 1];
            for (int i = 0; i <= k; i++) {
                if (arr[i] > leftMax) {
                    leftMax = arr[i];
                }
            }
            for (int j = k + 1; j < n; j++) {
                if (arr[j] > rightMax) {
                    rightMax = arr[j];
                }
            }
            if (Math.abs(leftMax - rightMax) > reject) {
                reject = Math.abs(leftMax - rightMax);
            }
        }
        return reject;
    }
}
