class Solution {
    public int hIndex(int[] citations) {
		  int n = citations.length;
		  int s=0;
		  int e = n-1;
		  int a=0;
		  while(s<=e) {	
			  int m = (s+e)/2;
			  if(citations[m]>=n-m) {
				  e=m-1;
				  a=n-m;
			  }else {
				  s=m+1;
			  }
		  }
		  
		  return a;
	   
	   
    }
}