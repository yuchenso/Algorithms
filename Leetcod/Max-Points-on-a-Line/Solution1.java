/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	public int maxPoints(Point[] points) {  
	    if(points== null) return 0;  
	    if(points.length <= 2) return points.length;  
	    int max = 0;  
	    int duplicate = 1;//this field setting is amazing  
	    Map<Double,Integer> map = new HashMap<Double,Integer>();  
	    for(int i = 0; i < points.length; i++){  
	        map.clear();  
	        duplicate = 1;  
	        Point p = points[i];  
	        for(int j = 0 ; j < points.length; j++){  
	            if(i == j) continue;  
	            Point tem = points[j];  
	            double slope = 0.0;  
	            if(tem.x == p.x && tem.y == p.y){  
	                duplicate ++;  
	                continue;  
	            }else if(tem.x == p.x){  
	                slope = Integer.MAX_VALUE;  
	            }else{  
	                slope = tem.y == p.y ? 0 : 1.0 * (tem.y - p.y) / (tem.x - p.x);  
	            }  
	            map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1 );  
	        }  
	        if(map.keySet().size() == 0){  
	            max = duplicate;  
	        }  
	        for(double key : map.keySet()){  
	            max = Math.max(max, duplicate + map.get(key));  
	        }  
	          
	    }  
	    return max;  
	}
}
