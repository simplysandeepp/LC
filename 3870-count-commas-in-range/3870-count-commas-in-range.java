class Solution {
    public int countCommas(int n) {
        long total=0;
        long s;
        int k=1;
        while(true) {
            s = (long) Math.pow(10,3*k);
            if(s>n) break;
            long l = Math.min(n,(long) Math.pow(10,3*(k+1)) -1);
            long count = l-s+1;
            total += count*k;
            k++;
        }
        return (int)total;
    }
}