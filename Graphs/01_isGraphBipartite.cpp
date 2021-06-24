//--------------- DFS SOLUTION--------------------
// the approach is to make a adjacency list out of the given matrix
// then traverse the list and color the graph
// if color==0 then node is not coloured, 1 and 2 are two different colors used for colouring..

#include <bits/stdc++.h>
using namespace std;

list<int> *l;
bool bipartiteCheck(int start, int parent, vector<int> &colors, int color)
{
    colors[start] = color;
    for (auto nbr : l[start])
    {
        if (colors[nbr] == 0)
        {
            bool ans = bipartiteCheck(nbr, start, colors, 3 - color);
            if (!ans)
                return false;
        }
        if (nbr != parent and colors[nbr] == color)
            return false;
    }
    return true;
}
bool isBipartite(vector<vector<int>> &graph)
{
    int n = graph.size();
    l = new list<int>[n];
    int i = 0;
    for (auto it : graph)
    {
        for (auto x : it)
        {
            l[i].push_back(x);
        }

        i++;
    }
    vector<int> colors(n, 0);
    bool ans = true;
    for (int i = 0; i < n; i++)
        if (colors[i] == 0)
            ans = (ans and bipartiteCheck(i, -1, colors, 1));

    return ans;
}