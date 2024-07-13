record Fri(int position, int health, char dir, int index){}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Fri[] fri = new Fri[n];
        char[] ch = directions.toCharArray();
        for(int i = 0 ; i < n ; i++){
            fri[i] = new Fri(positions[i], healths[i], ch[i], i);
        }
        Arrays.sort(fri, (a, b) -> a.position() - b.position());
        Stack<Fri> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            Fri t = fri[i];
            if(!stack.isEmpty() && stack.peek().dir() == 'R' && t.dir() == 'L'){
                String f1 = t.toString();
                String f2 = "";
                boolean flag = true;
                while(!stack.isEmpty() && stack.peek().dir() == 'R' && t.dir() == 'L'){
                    Fri tmp = stack.pop();
                    if(tmp.health() > t.health()){
                        stack.push(new Fri(tmp.position(), tmp.health() - 1, tmp.dir(), tmp.index()));
                        t = stack.pop();
                    }
                    else if(tmp.health() < t.health()){
                        stack.push(new Fri(t.position(), t.health() - 1, t.dir(), t.index()));
                        t = stack.pop();
                    }
                    else{
                        f2 = t.toString();
                        flag = false;
                        break;
                    }
                }
                if(!f1.equals(f2) && flag){
                    stack.push(t);
                }
            }
            else{
                stack.push(t);
            }
        }
        Collections.sort(stack, (a, b) -> a.index() - b.index());
        List<Integer> ans = new ArrayList<>();
        for(Fri f : stack){
            ans.add(f.health());
        }
        return ans;
    }
}