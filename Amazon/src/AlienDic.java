import java.util.*;

class AlienDic {
    public String alienOrder(String[] words) {

        //create data structure and find all unique letters
        //Map 记录字母有没有见过
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        //find all edges, build adjacent list & Map
        for(int i = 0; i < words.length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            //checking word2 is not a  prefix word of word2
            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            //word1.length() <= word2.length()
            //find the first non match and update the counts for indegree
            for(int j = 0; i < Math.min(word1.length(), word2.length());j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        //BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : counts.keySet()) {
            //开始入度为0的字母可以先放进去
            if(counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while(!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            //traverse adjacent of c
            for(Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if(counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if(sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}

//DFS : https://leetcode.com/problems/alien-dictionary/solution/