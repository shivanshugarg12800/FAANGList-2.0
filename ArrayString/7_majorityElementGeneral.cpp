#include <bits/stdc++.h>
using namespace std;

int countOccurence(int arr[], int n, int k)
{
    // Your code here
    map<int, int> mp;
    for (int i = 0; i < n; i++)
        mp[arr[i]]++;

    int count = 0;
    for (auto it : mp)
        if (it.second > n / k)
            count++;

    return count;
}