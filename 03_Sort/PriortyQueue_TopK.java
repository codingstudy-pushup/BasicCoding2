public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        
        Map<Integer, Integer> map = new HashMap<>();
       
    
        for(int i : nums) {
            if(map.containsKey(i)) {
                int exist = map.get(i);
                map.put(i, exist+1);
            } else {
                map.put(i, 1);
            }
        }
        
        // hepify
        for(Integer key: map.keySet()) {
            pq.add(map.get(key));
        }
        
        
        int[] a = new int[k];
        int i=0;
        
   
        while(!pq.isEmpty() && k-- > 0) {
            int top = (int) pq.poll();
            
           for(Map.Entry<Integer, Integer> e : map.entrySet()) {
               if (e.getValue() == top) {
                    int key = e.getKey();
                    a[i++] = key;
                    // remove the node, otherwise it may read the same keu with collided frequencies
                    map.remove(key);
                   break;
                }
           } 
        }
        
        return a;
        
    }

//2
public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        

        for(int i=0;i<nums.length;i++)
        {
            if(!hashmap.containsKey(nums[i]))
                hashmap.put(nums[i],1);
            else
                hashmap.put(nums[i],hashmap.get(nums[i])+1);
        }
     
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> hashmap.get(b) - hashmap.get(a));
        
        for(int pointer : hashmap.keySet())
        {
            queue.add(pointer);
        }
        
        int[] result = new int[k];
  
        for(int i=0;i<result.length;i++)
            result[i] = queue.poll();
        
        return result;
    }
}
