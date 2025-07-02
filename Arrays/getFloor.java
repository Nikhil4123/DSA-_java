public class getFloor {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Initialize floor and ceil as -1 (not found)
        int floor = -1;
        int ceil = -1;

        for (int num : arr) {
            if (num <= x) {
                // Update floor to the largest value less than or equal to x
                floor = Math.max(floor, num);
            }
            if (num >= x) {
                // Update ceil to the smallest value greater than or equal to x
                if (ceil == -1 || num < ceil) {
                    ceil = num;
                }
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        getFloor sol = new getFloor();
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;

        int[] result = sol.getFloorAndCeil(x, arr);
        System.out.println("Floor: " + result[0] + ", Ceil: " + result[1]);
    }
}
