class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> student = new LinkedList<>();
        for(int ele : students){
            student.add(ele);
        }
        LinkedList<Integer> sandwich = new LinkedList<>();
        for(int ele : sandwiches){
            sandwich.add(ele);
        }
        while(!student.isEmpty()){
            if(student.peek() == sandwich.peek()){
                sandwich.pop();
                student.poll();
            }
            else{
                if(!student.contains(sandwich.peek())){
                    break;
                }
                student.addLast(student.poll());
            }
        }
        return student.size();
    }
}