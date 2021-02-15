class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        //edge case
        if(p.length()==0 || p == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> hmap = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }

        int start = 0;
        int end = 0;
        int match = 0;

        while(end < s.length()){
            char ch_end = s.charAt(end);
            char ch_start = s.charAt(start);

            if(hmap.containsKey(ch_end)){
                hmap.put(ch_end,hmap.getOrDefault(ch_end,0)-1);

                if(hmap.get(ch_end) == 0)
                    match += 1;

            }

            if(end-start+1 > p.length()){
                if(hmap.containsKey(s.charAt(start))){
                    hmap.put(ch_start,hmap.getOrDefault(ch_start,0)+1);


                    if(hmap.get(ch_start) == 1)
                        match -= 1;
                }


                start += 1;
            }
            if(match == hmap.size()){
                list.add(start);
            }
            end += 1;
        }
        return list;
    }
}