class Solution {

    public String isPossible(int n, int[] freq, String cur, char mid, String target) {
        int[] count = freq.clone();

        for (int i = 25; i >= 0; i--) {
            while (count[i] > 0) {
                cur += (char) ('a' + i);
                count[i]--;
            }
        }

        StringBuilder result = new StringBuilder(cur);

        if (mid != '#') {
            result.append(mid);
        }

        result.append(new StringBuilder(cur).reverse());

        String candidate = result.toString();

        return candidate.compareTo(target) > 0 ? candidate : "";
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        if (n == 1) {
            return s.compareTo(target) > 0 ? s : "";
        }

        char mid = '#';
        int oddCount = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                mid = (char) ('a' + i);
                freq[i]--;
                oddCount++;
            }

            freq[i] /= 2;

            if (oddCount > 1) {
                return "";
            }
        }

        int half = n / 2;
        String prefix = "";
        String answer = "";

        for (int i = 0; i < half; i++) {
            boolean found = false;

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) {
                    continue;
                }

                freq[j]--;
                String next = prefix + (char) ('a' + j);

                String candidate = isPossible(
                    half,
                    freq,
                    next,
                    mid,
                    target
                );

                if (!candidate.isEmpty()) {
                    prefix = next;
                    answer = answer.isEmpty()
                            ? candidate
                            : (answer.compareTo(candidate) < 0 ? answer : candidate);

                    found = true;
                    break;
                }

                freq[j]++;
            }

            if (!found) {
                return "";
            }
        }

        return answer;
    }
}