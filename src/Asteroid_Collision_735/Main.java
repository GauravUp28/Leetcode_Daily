package Asteroid_Collision_735;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] asteroids1 = new int[] {5,10,-5};
        int[] asteroids2 = new int[] {10,2,-5};

        System.out.println("Remaining Asteroids1: "  + Arrays.toString(solution.asteroidCollision(asteroids1)));
        System.out.println("Remaining Asteroids2: "  + Arrays.toString(solution.asteroidCollision(asteroids2)));
    }
}
