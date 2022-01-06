class Solution {
    public String minNumber(int[] nums) {
        if (nums.length == 0){
            return new String();
        }
        String[] strs = new String[nums.length];
        int index = 0;
        for (int i : nums) {
            strs[index++] = String.valueOf(i);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l < r) {
            int p = sort(strs, l, r);
            quickSort(strs, l, p - 1);
            quickSort(strs, p + 1, r);
        }
    }

    private int sort(String[] strs, int l, int r) {
        String v = strs[l];
        int i = l, j = r + 1;
        while (true) {
            while (++i < r && (strs[i] + v).compareTo(v + strs[i]) < 0) {
            }
            while (--j > l && (strs[j] + v).compareTo(v + strs[j]) > 0) {
            }
            if (i >= j) {
                break;
            }
            String tem = strs[j];
            strs[j] = strs[i];
            strs[i] = tem;
        }
        strs[l] = strs[j];
        strs[j] = v;
        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,1};
        String s1 = s.minNumber(nums);
        System.out.println("s1 = " + s1);
    }
}