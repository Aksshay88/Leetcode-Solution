class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> news =new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                news.add("FizzBuzz");
            }else if(i%3==0){
                news.add("Fizz");
            }else if(i%5==0){
                news.add("Buzz");
            }else{
                news.add(String.valueOf(i));
            }
        }
        return news;
    }
}