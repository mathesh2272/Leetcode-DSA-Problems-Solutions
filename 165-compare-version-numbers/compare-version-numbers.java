class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len1 = ver1.length;
        int len2 = ver2.length;
        int n = Math.max(len1, len2);
        long v1 = 0;
        long v2 = 0;
        for(int i = 0 ; i < n ; i++){
            v1 = i < len1 ? Long.parseLong(ver1[i]) : 0;
            v2 = i < len2 ? Long.parseLong(ver2[i]) : 0;
            if(v1 == v2){
                continue;
            }
            return v1 < v2 ? -1 : 1;
        }
        return 0;
    }
}