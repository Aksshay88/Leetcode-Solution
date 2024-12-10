class Solution {
    boolean isFinish=true;
    Map<Integer,ArrayList<Integer>> map= new HashMap();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visiting=new HashSet<>();
        ArrayList<Integer> visited=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<Integer>());
        }
        //require course mapping with prerequisites courses
        for(int[] courses:prerequisites){
            int required=courses[0];
            int prerequisite=courses[1];
            ArrayList<Integer> list=map.get(required);
            list.add(prerequisite);
            //update map value
            map.put(required,list);
        }

        //start to complete all courses
        for(int course=0;course<numCourses;course++){
            isFinish = isFinish && isCompleted(course,visiting,visited);
        }

        
        
        if(isFinish){
          int[] finishCourse=new int[visited.size()];  
          int i=0;
          for(int course:visited){
            finishCourse[i]=course;
            i++;
            }
          return finishCourse;
        }  
        return new int[0];
    }

    public boolean isCompleted(int course,Set<Integer> visiting,ArrayList<Integer> visited){
        boolean check=true;
        if(visiting.contains(course)){
            return false;
        }
        if(visited.contains(course)){
            return true;
        }
        visiting.add(course);
        ArrayList<Integer> prerequiCourses=map.get(course);
        for(int _course:prerequiCourses){
            boolean completed= isCompleted(_course,visiting,visited);
            check=(completed && check);
        }
        visiting.remove(course);
        visited.add(course);

        return check;
    }
}