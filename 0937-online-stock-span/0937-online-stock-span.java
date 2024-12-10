class StockSpanner {
	int count = -1;
	Stack<Integer> st = new Stack<>();
	ArrayList<Integer>al = new ArrayList<>();
    public StockSpanner() {
    }
    public int next(int price) {
    	while(!st.isEmpty() && al.get(st.peek())<=price)
    	{
    		st.pop();
    	}
    	count++;
    	int ans = count+1;
    	if(!st.isEmpty())
    	{
    		ans = count - st.peek();
    	}
        al.add(price);
        st.add(count);
    	return ans;
        
    }
}
