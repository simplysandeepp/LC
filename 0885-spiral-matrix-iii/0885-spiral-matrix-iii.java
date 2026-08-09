class Solution {
    String[] options = new String[]{"East", "South", "West", "North"};
    
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int steps = 0; 
        int i=0;
        ArrayList<int[]> al = new ArrayList<>();
        al.add(new int[]{rStart, cStart});
        
        while (al.size() < rows * cols) {
            int direction = i % 4;
            
            if (direction == 0) { 
                steps++; 
                for (int walks = 0; walks < steps; walks++) {
                    cStart++;
                    if (isValid(rStart, cStart, rows, cols)) {
                        al.add(new int[]{rStart, cStart});
                    }
                }
            } else if (direction == 1) { 
                for (int walks = 0; walks < steps; walks++) {
                    rStart++;
                    if (isValid(rStart, cStart, rows, cols)) {
                        al.add(new int[]{rStart, cStart});
                    }
                }
            } else if (direction == 2) { 
                steps++; 
                for (int walks = 0; walks < steps; walks++) {
                    cStart--;
                    if (isValid(rStart, cStart, rows, cols)) {
                        al.add(new int[]{rStart, cStart});
                    }
                }
            } else { 
                for (int walks = 0; walks < steps; walks++) {
                    rStart--;
                    if (isValid(rStart, cStart, rows, cols)) {
                        al.add(new int[]{rStart, cStart});
                    }
                }
                
            }
            
            i++; 
        }
        
        return al.toArray(new int[al.size()][]);
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}