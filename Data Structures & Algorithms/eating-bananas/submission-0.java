class Solution {
    boolean isPossible(int[] piles, int h, int mid) {
        int calH = 0;
        for (int pile:piles) {
            calH += Math.ceil(pile*1.0/mid);
        }
        return calH <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = Arrays.stream(piles).max().getAsInt();
        int ans = e;

        while (s <= e) {
            int mid = (s+e)/2;
            boolean isP = isPossible(piles, h, mid);
            if (isP) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }
}
