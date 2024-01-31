# Idea


# Code

```Java
import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> vertexMap = new HashMap<>();

        for(int[] edge:edges){
            int start = edge[0];
            Integer startCount = vertexMap.get(start);
            if(startCount == null){
                vertexMap.put(start,1);
            } else {
                vertexMap.replace(start,startCount+1);
            }
            
            int end = edge[1];
            Integer endCount = vertexMap.get(end);
            if(endCount == null){
                vertexMap.put(end,1);
            } else {
                vertexMap.replace(end,endCount+1);
            }
        }
    
        int maxCount = 0;
        int centerNode = 0;

        for(Integer key : vertexMap.keySet()){
            int currentCount = vertexMap.get(key);

            if(maxCount < currentCount){
                maxCount = currentCount;
                centerNode = key;
            } 
        }

        return centerNode;
    }
}

```