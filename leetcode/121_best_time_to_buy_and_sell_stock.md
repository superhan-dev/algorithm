# Idea


# Code my answer

```Java
class Solution {
    public int maxProfit(int[] prices) {
        HashSet<Integer> profitSet = new HashSet<>();

        if(prices.length < 2){
            return 0;
        }
        
        Integer min = Integer.MAX_VALUE;
        Integer max = 0;
        for(int i=0;i<prices.length;i++){
           if(min == Integer.MAX_VALUE){
               min = Math.min(min,prices[i]);
           } 
           
           if(min > prices[i]){
               min = prices[i];
               max = 0;
           }

           if(min != Integer.MAX_VALUE){
               max = Math.max(max,prices[i]);
           }
           profitSet.add(max-min);
        }

        ArrayList<Integer> list = new ArrayList<>(profitSet);
        Collections.sort(list);
        
        return list.get(list.size()-1);
    }
}

```

# Best answer

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        
        return maxProfit != Integer.MIN_VALUE ? maxProfit : 0;
    }
}

```