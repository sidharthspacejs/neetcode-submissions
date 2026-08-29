class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> [] bucket = new List[nums.length + 1];
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int n : nums) {
            frequencyMap.put(n,frequencyMap.getOrDefault(n,0) + 1);
        }

        for(int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i=bucket.length-1; i>=0 && counter<k; i--) {
            if(bucket[i] != null) {
                for(int value : bucket[i]) {
                    res[counter++] = value;
                }
            }
        }

        return res;
    }
}
