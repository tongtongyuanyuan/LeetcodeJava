

class TrieNode {
    Integer val;
    TrieNode[] links;

    public TrieNode() {
        val = null;
        links = new TrieNode[27];
    }
}
class FileSystem {
    TrieNode root;

    public FileSystem() {
        root = new TrieNode();
        root.val = -1;
        root.links[26] = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        TrieNode curr = root;
        boolean res = true;
        Integer preVal = null;

        for(int i = 0; i < path.length(); i++) {
            int idx = path.charAt(i) != '/' ? path.charAt(i) - 'a' : 26;

            if(curr.links[idx] == null) {
                curr.links[idx] = new TrieNode();
            }

            preVal = curr.val; //'/'开始的话 curr.val=-1；初始值
            //是/而且，说明是这样'/'
            if(idx == 26 && preVal == null) {
                return false;
            }
            curr = curr.links[idx];
        }

      
        //reach the last character, if exist, return false, not exist in the current dictionary, creating a new node
        if(curr.val != null) {
            return false;
        } else {
            curr.val = value;
            curr.links[26] = new TrieNode();
        }
        return res;
    }

    public int get(String path) {
        TrieNode curr = root;
        for(int i = 0; i < path.length(); i++) {
            int idx = path.charAt(i) != '/' ? path.charAt(i) - 'a' : 26;
            if(curr.links[idx] == null)
                return -1;

            curr = curr.links[idx];
        }

        return curr.val != null ? curr.val : -1;
    }
}


class Solution {
    public static void main(String args[]) {

        FileSystem filesystem = new FileSystem();
        System.out.println(filesystem.createPath("/",1));
        System.out.println(filesystem.createPath("/leet/code",2));
        System.out.println(filesystem.get("/leet/code"));
        System.out.println(filesystem.createPath("/c/d",1));
        System.out.println(filesystem.get("/"));
    }
}

