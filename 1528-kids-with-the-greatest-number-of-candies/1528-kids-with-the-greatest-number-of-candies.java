class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Arrays.stream(candies).max().getAsInt();;
        List<Boolean> list=new ArrayList<Boolean>(candies.length);

        for(int j=0;j<candies.length;j++){
            if(candies[j]+extraCandies >= max){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }

        return list;


        
    }
}