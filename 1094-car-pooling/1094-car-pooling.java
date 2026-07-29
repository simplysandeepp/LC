class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int car = 0;
        int[] arr = new int[1001];
        for (int i = 0; i < trips.length; i ++) { 
            arr[trips[i][1]] += trips[i][0];
            arr[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i <= 1000; i ++) { 
            car += arr[i];
            if (car > capacity) return false; 
        }
        return true;
    }
}