/*
You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.

The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).

Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.
*/
class UnionFind{
    int[] parents;
    public UnionFind(int n){
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    public int find(int x){
        if(parents[x] != x) parents[x] = find(parents[x]);
        return parents[x];
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        parents[px] = py;
    }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        HashMap<Integer, HashMap<Integer, Integer>> commonElements = new HashMap();
        int n = source.length, res = 0;
        UnionFind uf = new UnionFind(n);
        for(int[] swap: allowedSwaps){
            int px = uf.find(swap[0]);
            int py = uf.find(swap[1]);
            uf.union(px, py);

        }
        for(int i = 0; i < n; i++){
            int idx = uf.find(i);
            if(!commonElements.containsKey(idx)){
                commonElements.put(idx, new HashMap());
            }
            HashMap<Integer, Integer> map = commonElements.get(idx);
            map.put(source[i], map.getOrDefault(source[i], 0) + 1);
        }
        for(int i = 0; i < n; i++){
            int pt = uf.find(i);
            HashMap<Integer, Integer> map = commonElements.get(pt);
            int count = map.getOrDefault(target[i], 0);
            if(count == 0){
                res += 1;
            }else{
                map.put(target[i], map.get(target[i]) - 1);
            }
        }
        return res;
    }
}