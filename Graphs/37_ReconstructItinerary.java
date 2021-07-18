class Solution {
    public void dfs(HashMap<String,PriorityQueue<String>> graph,String src,List<String> ans){
        if(graph.get(src) == null){
            ans.add(src);
            return;
        }
        PriorityQueue<String> pq = graph.get(src);
        while(pq.size() != 0){
            dfs(graph,pq.remove(),ans);
        }
        ans.add(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> a: tickets){
            String u = a.get(0);
            String v = a.get(1);
            if(!graph.containsKey(u)) graph.put(u,new PriorityQueue<>());
            graph.get(u).add(v);
        }
        
        List<String> ans = new ArrayList<>();
        String src = "JFK";
        dfs(graph,src,ans);
        Collections.reverse(ans);
        return ans;
    }
}