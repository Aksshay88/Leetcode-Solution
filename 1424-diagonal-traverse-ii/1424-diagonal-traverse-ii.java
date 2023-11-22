class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    int count = 0;
    List<Stack<Integer>> list = new ArrayList();
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> o= nums.get(i);
      for (int j = 0; j < o.size(); j++) {
        int id = i + j;
        if (list.size() < id + 1) {
          list.add(new Stack());
        }
        list.get(id).push(o.get(j));
        ++count;
      }
    }
    int[] res = new int[count];
    int p = 0;
    for (Stack<Integer> stack : list) {
      while(!stack.isEmpty()) {
        res[p++] = stack.pop();
      }
    }
    return res;
  }
}