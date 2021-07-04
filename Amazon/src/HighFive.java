import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//Leetcode: 1086
class Record {
    public int id, score;

    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }


    public static Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        HashMap<Integer, PriorityQueue<Record>> map = new HashMap<>();
        int k = 5;
        // 将r.id对应的放入priority_queue, minHeap排序
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                PriorityQueue<Record> pq = new PriorityQueue<Record>(k, new Comparator<Record>() {
                    public int compare(Record a, Record b) {
                        return a.score - b.score;
                    }
                });
                map.put(r.id, pq);
            }
            if (map.get(r.id).size() > k) {
                map.get(r.id).poll();
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            result.put(id, average);
        }
        return result;
    }

    public static void main(String[] args) {
        Record r1 = new Record(1, 4);
        Record r2 = new Record(1, 3);
        Record r3 = new Record(1, 6);
        Record r4 = new Record(1, 8);
        Record r5 = new Record(1, 7);
        Record r6 = new Record(1, 9);

        Record r7 = new Record(2, 14);
        Record r8 = new Record(2, 12);
        Record r9 = new Record(2, 3);
        Record r10 = new Record(2, 6);
        Record r11 = new Record(2, 17);
        Record r12 = new Record(2, 9);

        Record r13 = new Record(3, 17);
        Record r14 = new Record(3, 12);
        Record r15 = new Record(3, 18);
        Record r16 = new Record(3, 16);
        Record r17 = new Record(3, 22);
        Record r18 = new Record(3, 10);

        Record[] input = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        Map<Integer, Double> res =  highFive(input);
        for( Map.Entry<Integer, Double>entry : res.entrySet()) {
            System.out.println("avg of " + entry.getKey() + " = " + entry.getValue());
        }
    }
}
