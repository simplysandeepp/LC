class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n < m) {
            return new int[0];
        }

        List<Integer>[] pos = new ArrayList[26];
        for (int k = 0; k < 26; k++) {
            pos[k] = new ArrayList<>();
        }
        for (int k = 0; k < n; k++) {
            pos[word1.charAt(k) - 'a'].add(k);
        }

        int[] last = new int[m];
        int curr = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (curr >= 0 && word1.charAt(curr) != word2.charAt(j)) {
                curr--;
            }
            last[j] = curr;
            if (curr >= 0) {
                curr--;
            }
        }

        int[] last1 = new int[m];
        last1[m - 1] = n - 1;

        for (int j = m - 2; j >= 0; j--) {
            int optionA = last[j + 1] - 1; 

            int limit = last1[j + 1] - 1;
            int optionB = getLastOccur(pos, word2.charAt(j), limit);

            last1[j] = Math.max(optionA, optionB);
        }

        int[] ans = new int[m];
        int i = 0;
        boolean usedMismatch = false;

        for (int j = 0; j < m; j++) {
            boolean found = false;

            while (i < n) {
                boolean isMatch = (word1.charAt(i) == word2.charAt(j));

                if (usedMismatch) {
                    if (isMatch && (j == m - 1 || i + 1 <= last[j + 1])) {
                        found = true;
                        break;
                    }
                } else {
                    if (isMatch) {
                        if (j == m - 1 || i + 1 <= last1[j + 1]) {
                            found = true;
                            break;
                        }
                    } else {
                        if (j == m - 1 || i + 1 <= last[j + 1]) {
                            found = true;
                            usedMismatch = true;
                            break;
                        }
                    }
                }
                i++;
            }

            if (!found) {
                return new int[0];
            }

            ans[j] = i;
            i++; 
        }

        return ans;
    }
    private int getLastOccur(List<Integer>[] pos, char c, int limit) {
        if (limit < 0) return -1;
        List<Integer> list = pos[c - 'a'];
        int l = 0, r = list.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= limit) {
                ans = list.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}