import java.util.*;

public class SongCache {
    private Map<String, Integer> m;

    SongCache() {
//        m = new HashMap<>(Map.of(
//                "晴天", 7,
//                "一路向北", 4,
//                "七里香" ,10,
//                "花海", 6,
//                "夜曲",2
//        ));
        m = new HashMap<>();
        m.put("晴天", 7);
        m.put("一路向北", 4);
        m.put("七里香" ,10);
        m.put( "花海", 6);
        m.put( "夜曲",2);
    }
    //1.Record number of plays for a song
    public void recordSongPlays(final String songId, final int numPlays) {
        //Fetch the number of plays of a song

//        String[] arr = songID.split("");
//        //String[] arr = songID.split("[^a-z]+");
//        for(String str : arr) {
//            if(!m.containsKey(str)){
//                m.put(str, 1);
//            }else{
//                m.put(str, m.get(str) + 1);
//            }
//        }
//        // using for-each loop for iteration over Map.entrySet()
//        for(Map.Entry<String, Integer> entry : m.entrySet()) {
//            System.out.print("SongID: " + entry.getKey() + "," + "numsPlays: " + entry.getValue());
//        }
        m.put(songId, m.getOrDefault(songId, 0) + numPlays);
    }

    /*2.fetch the number of plays for a song
    * return the number of plays or -1 if the song ID is unkown*/
    public int getPlaysForSong(final String songId) {
          return m.getOrDefault(songId, -1);
    }


    //3.Return the top N songs playes, in descending order of number of plays-->Top K frequent words
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
    public static void main(String[] args) {
          SongCache songCache = new SongCache();
          songCache.recordSongPlays("晴天",4);
          System.out.println(songCache.getPlaysForSong("晴天"));
          System.out.println(songCache.getTopNSongsPlayed(3));
    }
}
