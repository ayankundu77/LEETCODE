class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 1. reverse whole array
        reverse(arr, 0, n - 1);

        int l = 0, r = 0, i = 0;

        while (i < n) {
            // skip spaces
            while (i < n && arr[i] == ' ') i++;

            if (i >= n) break;

            // copy word
            if (r != 0) arr[r++] = ' ';

            l = r;
            while (i < n && arr[i] != ' ') {
                arr[r++] = arr[i++];
            }

            // reverse current word
            reverse(arr, l, r - 1);
        }

        return new String(arr, 0, r);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }
}

