class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        int ind = 0;
        while(ind < n){
            int i = groupSize;
            List<Integer> list = new ArrayList<>();
            Iterator<Integer> iterator = map.keySet().iterator();
            while(iterator.hasNext() && i > 0){
                int key = iterator.next();
                int value = map.get(key);
                list.add(key);
                map.put(key, value - 1);
                if(map.get(key) == 0){
                    iterator.remove();
                }
                int size = list.size();
                if(size > 1){
                    if(list.get(size - 1) - list.get(size - 2) != 1){
                        return false;
                    }
                }
                i--;
                ind++;
            }
            if(list.size() != groupSize){
                return false;
            }
        }
        return true;
    }
}