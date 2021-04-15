import java.util.*;

public class SongCache {
    final private String input = "la, ba, ma, db, cm1, er1, er1, la, la, ma";
    private Map<String, Integer> m;
    //Record number of plays for a song
    public void recordSongPlays(final String songID, final int numPlays) {
        //Fetch the number of plays of a song
        m = new HashMap<String, Integer>();
        String[] arr = songID.split("");
        //String[] arr = songID.split("[^a-z]+");
        for(String str : arr) {
            if(!m.containsKey(str)){
                m.put(str, 1);
            }else{
                m.put(str, m.get(str) + 1);
            }
        }
        // using for-each loop for iteration over Map.entrySet()
        for(Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.print("SongID: " + entry.getKey() + "," + "numsPlays: " + entry.getValue());
        }
    }

    /*fetch the number of plays for a song
    * return the number of plays or -1 if the song ID is unkown*/
    public int getPlaysForSong(final String songId) {
        int n = 0;

        return -1;
    }


    //Return the top N songs playes, in descending order of number of plays-->Top K frequent words
    public List<String> getTopNSongsPlayed(int n) {


        List<String> res = new ArrayList<String>();

        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> m.get(w1).equals(m.get(w2)) ?
                                         w2.compareTo(w1) : m.get(w1) - m.get(w2));

        for(String st : m.keySet()) {
            heap.offer(st);
            if(heap.size() > n) {
                heap.poll();
            }
        }
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
    public void main(String[] args) {
          List<String> ans = new ArrayList<String>();
          SongCache songCache = new SongCache();
          ans = songCache.getTopNSongsPlayed(3);
          System.out.print(ans);
    }
}
