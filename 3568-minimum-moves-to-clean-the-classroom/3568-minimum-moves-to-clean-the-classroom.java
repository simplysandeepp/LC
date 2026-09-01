class Solution {

    static class State {
        int row;
        int col;
        int energy;
        int moves;
        int mask;

        State(int row, int col, int energy, int moves, int mask) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.moves = moves;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {
                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (cell == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;

        Queue<State> queue = new LinkedList<>();

        queue.offer(
            new State(
                startRow,
                startCol,
                energy,
                0,
                0
            )
        );

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[startRow][startCol][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.mask == targetMask) {
                return current.moves;
            }

            if (current.energy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = current.row + dr[d];
                int nc = current.col + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X') {
                    continue;
                }

                int newEnergy = current.energy - 1;
                int newMask = current.mask;

                if (cell == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                queue.offer(
                    new State(
                        nr,
                        nc,
                        newEnergy,
                        current.moves + 1,
                        newMask
                    )
                );
            }
        }

        return -1;
    }
}