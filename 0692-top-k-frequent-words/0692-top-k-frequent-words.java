class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words)
            map.put(str, map.getOrDefault(str, 0) + 1);

        List<String> list = map.keySet().stream().sorted((a, b) -> {
            int freq =  map.get(b).compareTo(map.get(a));
            if(freq != 0) return freq;
            return a.compareTo(b);
        }).limit(k)
        .collect(Collectors.toList());
        return list;
    }
}