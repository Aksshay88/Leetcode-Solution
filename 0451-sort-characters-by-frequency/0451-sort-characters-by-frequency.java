class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> queue = new PriorityQueue<>(
            (o1, o2) -> map.get(o2).compareTo(map.get(o1))
        );
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            queue.offer(kv.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}