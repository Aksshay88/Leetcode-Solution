class Solution {
    public class Triple{
        int value;
        int i;
        int idx;
        public Triple(int value,int i,int idx){
            this.value=value;
            this.i=i;
            this.idx=idx;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for(int i=0; i<Math.min(k,nums1.length); i++){
         pq.add(new Triple(nums1[i]+nums2[0],i,0));
        }
        List<List<Integer>> list=new ArrayList<>();
        while(k!=list.size()){
            List<Integer> list1=new ArrayList<>();
            int i=pq.peek().i;
            int idx=pq.peek().idx;
            int value=pq.peek().value;
            pq.remove();
           
            list1.add(nums1[i]);
            list1.add(nums2[idx]);
            list.add(list1);
            if(idx!=nums2.length-1){
                idx++;
                pq.add(new Triple(nums1[i]+nums2[idx],i,idx));
            }
        }
        return list;
    }
}