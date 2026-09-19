class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        List<String> filteredList = Arrays.stream(s.split("")).
                                    sorted((a, b) -> {
                                        int freq =  map.get(b.charAt(0)).compareTo(map.get(a.charAt(0)));
                                        return (freq != 0)? freq : a.compareTo(b);
                                    }).collect(Collectors.toList());

        return String.join("", filteredList);
    }
}