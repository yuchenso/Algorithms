public class Solution1 {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length == 0){
    		return;
    	}
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	Boolean rowZero = false;
    	for(int j = 0; j < n; j++){
    		if(matrix[0][j] == 0){
    			rowZero = true;
    			break;
    		}
    	}
    	
    	Boolean colZero = false;
    	for(int i = 0; i < m; i++){
    		if(matrix[i][0] == 0){
    			colZero = true;
    			break;
    		}
    	}
    	
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                	matrix[i][0] = 0;
                	matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
        	if(matrix[i][0] == 0){
        		for(int j = 1; j < n; j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        for(int j = 1; j < n; j++){
        	if(matrix[0][j] == 0){
        		for(int i = 1; i < m; i++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if(colZero){
        	for(int i = 0; i < m; i++){
        		matrix[i][0] = 0;
        	}
        }
        
        if(rowZero){
        	for(int j = 0; j < n; j++){
        		matrix[0][j] = 0;
        	}
        } 
    }
}
