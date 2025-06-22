import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 526. Beautiful Arrangement
 * Link: https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {
    /**
     * for loop based recursive solution - which basically forms n! total permutations of n numbers and along the way checks
     * if either value and index or index and value are divisible.
     *
     * TC: O(K) k -> worst case O(n!) but it will be less than that as not all permutations pass the given divisibility condition
     * Auxiliary SC: O(n)
     * Recursive stack SC: O(n)
     */
    int result;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        helper(1, n, visited);
        return result;
    }

    private void helper(int pivot, int n, boolean[] visited) {
        //base
        if (pivot == n + 1) {
            result++;
            return;
        }

        //logic
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (pivot % i == 0 || i % pivot == 0) {
                    //action
                    visited[i] = true;
                    //recurse
                    helper (pivot + 1, n, visited);
                    //backtrack
                    visited[i] = false;
                }
            }
        }
    }
}
