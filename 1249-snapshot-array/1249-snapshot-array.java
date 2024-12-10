class SnapshotArray {
    ArrayList<int[]>[] arr;
    int snapId;
    public SnapshotArray(int length) {
        arr = new ArrayList[length];
            for(int i = 0; i < length; i++){
                arr[i] = new ArrayList<int[]>();
            }
            snapId = 0;
    }
    public void set(int index, int val) {
        arr[index].add(new int[]{snapId,val});
    }
    
    public int snap() {
        snapId++;
        return snapId-1;
    }
   public int get(int index, int snap_id) {
    List<int[]> alls = arr[index];
    if (alls.size() == 0) {
        return 0;
    }
    int start = 0;
    int end = alls.size() - 1;
    int val = 0;  

    while (start <= end) {
        int mid = start + (end - start) / 2;
        int[] a = alls.get(mid);
        int one = a[0];

        if (one <= snap_id) {
            val = a[1];  
            start = mid + 1;  
        } else {
            end = mid - 1; 
        }
    }
    return val;
}

}
