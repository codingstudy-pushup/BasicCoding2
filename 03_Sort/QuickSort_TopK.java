public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0 || k==0)
            return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }

        int[] uk = new int[map.size()];
        int j=0;
        for(int i : map.keySet()){
            uk[j++]=i;
        }
        int pivot = uk.length-k;

        quickSelect(0, uk.length-1, pivot, uk, map);
        int[] result = new int[k];
        for(int i=0; i<k;i++){
            result[i]=uk[pivot++];
        }

        return result;
    }

    public void quickSelect(int left, int right, int pivot, int[] nums, Map<Integer, Integer> map){
        int l=left;
        int r=right;
        int mid = map.get(nums[left+(right-left)/2]);
        while(l<=r){

            while(map.get(nums[l])<mid) l++;
            while(map.get(nums[r])>mid) r--;
            if(l<=r){
                int temp = nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r--;
            }
        }

        if(left<r && pivot<=r)
            quickSelect(left, r, pivot, nums, map);
        else if(right>l && pivot>=l)
            quickSelect(l, right, pivot, nums, map);
    }
