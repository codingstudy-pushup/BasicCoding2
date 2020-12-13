public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        
        Map<Integer, Integer> map = new HashMap<>();
       
        // calculate the frequencies
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
        
        // fetch the top k, max run time is o(k)
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
