/*
 * 等价类划分原则
 * 活细胞周围有0到1个活细胞：细胞应该死亡。
 * 活细胞周围有2个活细胞：细胞应该保持不变。
 * 活细胞周围有3个活细胞：细胞应该存活。
 * 活细胞周围有4到8个活细胞：细胞应该死亡。
 * 死细胞周围有3个活细胞：细胞应该变成活细胞。
 * 死细胞周围有0到2个活细胞或4到8个活细胞：细胞应该保持死亡状态。
 * 测试用例
 * 边界条件测试：
 *
 * 测试一个1x1的板，中间是活细胞，周围没有其他细胞。
 * 测试一个1x1的板，中间是死细胞，周围没有其他细胞。
 * 测试一个2x2的板，中间是活细胞，周围是死细胞。
 * 测试一个2x2的板，中间是死细胞，周围是活细胞。
 * 一般情况测试：
 * 测试一个更大的板，包含各种活细胞和死细胞组合。
 * 测试一个板，其中包含边界上的活细胞和死细胞。
 * 性能测试：
 * 测试一个非常大的板，以检查方法是否能够在合理的时间内完成计算。
 * 异常情况测试：
 * 测试一个空的板（即没有细胞）。
 * 测试一个所有细胞都是活细胞或死细胞的板。
 */
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L2022211802_19_Test {

    @Test
    public void testEmptyBoard() {
        // 测试一个空的棋盘x
        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } }, board);
    }

    @Test
    public void testOneCellBoard() {
        // 测试一个1x1的棋盘，中间是活细胞
        int[][] board = { { 1 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0 } }, board);
    }

    @Test
    public void testAllLiveCellsBoard() {
        // 测试一个所有细胞都是活细胞的棋盘
        int[][] board = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }, board);
    }


    @Test
    public void testAllDeadCellsBoard() {
        // 测试一个所有细胞都是死细胞的棋盘
        int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, board);
    }

    @Test
    public void testSingleLiveCellWithNoNeighbors() {
        // 测试一个1x1的棋盘，中间是活细胞，周围没有其他细胞
        int[][] board = { { 1 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0 } }, board);
    }

    @Test
    public void testSingleDeadCellWithNoNeighbors() {
        // 测试一个1x1的棋盘，中间是死细胞，周围没有其他细胞
        int[][] board = { { 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0 } }, board);
    }

    @Test
    public void testLiveCellWithTwoLiveNeighbors() {
        // 测试一个活细胞周围有两个活邻居的情况
        int[][] board = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 } }, board);
    }

    @Test
    public void testLiveCellWithThreeLiveNeighbors() {
        // 测试一个活细胞周围有三个活邻居的情况
        int[][] board = { { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));

        assertArrayEquals(new int[][] { { 0, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 } }, board);
    }

    @Test
    public void testLiveCellWithFourLiveNeighbors() {
        // 测试一个活细胞周围有四个活邻居的情况
        int[][] board = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }, board);
    }

    @Test
    public void testDeadCellWithThreeLiveNeighbors() {
        // 测试一个死细胞周围有三个活邻居的情况
        int[][] board = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
        Solution sol = new Solution();
        sol.gameOfLife(board);
        assertArrayEquals(new int[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } }, board);
    }

}
