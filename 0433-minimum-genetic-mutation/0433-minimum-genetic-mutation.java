class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {

        // i change character by character and i can see if
        // i can go from the newString to other string which is closer to the endGene

        Set<String> hashSet = new HashSet<>();
        for (String item : bank)
            hashSet.add(item);

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(startGene);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String currGene = queue.remove();
                if (visited.contains(currGene)){
                    size--;
                    continue;
                }

                visited.add(currGene);

                if (currGene.equals(endGene))
                    return level;

                StringBuilder stringBuilder = new StringBuilder(currGene);

                for(String gene : hashSet){
                    if(visited.contains(gene))
                        continue;
                    
                 for (int i = 0; i < 8; i++) {
                    if (stringBuilder.charAt(i) != gene.charAt(i)) {
                        char oldChar = stringBuilder.charAt(i);
                        stringBuilder.setCharAt(i, gene.charAt(i));
                        if (hashSet.contains(stringBuilder.toString())) {
                            queue.add(stringBuilder.toString());
                        }
                        stringBuilder.setCharAt(i, oldChar);
                    }

                }
            }
                size--;
            }
            level++;

        }
        return -1;
    }
}