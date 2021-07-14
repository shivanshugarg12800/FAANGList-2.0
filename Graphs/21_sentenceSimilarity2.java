public class Solution {
    /*
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */

    public boolean isSimilarDFS(HashMap<String,ArrayList<String>> graph,String src,String dest, HashSet<String> vis){
        if(src.equals(dest)) return true;
        vis.add(src);
        ArrayList<String> al = graph.get(src);
        for(String s: al){
            if(!vis.contains(s)){
                if(isSimilarDFS(graph,s,dest,vis))  return true;
            }
        }
        return false;
    }
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        int n = words1.length;
        int m = words2.length;
        if(n != m) return false;
        HashMap<String,ArrayList<String>> graph = new HashMap<>();
        for(List<String> p: pairs){
            String u = p.get(0);
            String v = p.get(1);
            if(!graph.containsKey(u)) graph.put(u,new ArrayList<>());
            if(!graph.containsKey(v)) graph.put(v,new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        } 
        
        for(int i=0;i<n;i++){
            HashSet<String> vis = new HashSet<>();
            String src = words1[i];
            String dest = words2[i];
            if(!isSimilarDFS(graph,src,dest,vis)) return false;
            
            // For sentence Similarity I
            // if(src.equals(dest)) continue;
            // ArrayList<String> al = graph.get(src);
            // boolean isPath = false;
            // for(String s: al){
            //     if(s.equals(dest)){
            //         isPath = true;
            //         break;
            //     } 
            // }
            // if(!isPath) return false;
        
        }
        return true;
    }
}