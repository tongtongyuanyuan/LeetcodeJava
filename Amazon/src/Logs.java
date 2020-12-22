import java.util.*;


public class Logs {

    public static List<String> processLogs(List<String> logs, int threshold){

        Map<String, Integer> userToFreq = new HashMap<>();
        for(String log : logs){
            String[] array = log.split(" ");
            String usr1 = array[0];
            String usr2 = array[1];
            userToFreq.put(usr1, userToFreq.getOrDefault(usr1, 0) + 1);
            if(!usr2.equals(usr1)){
                userToFreq.put(usr2, userToFreq.getOrDefault(usr2, 0) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : userToFreq.entrySet()){
            if(entry.getValue() >= threshold){
                res.add(entry.getKey());
            }
        }

        List<Integer> intRes = new ArrayList<>();
        for(String str : res){
            intRes.add(Integer.valueOf(str));
        }
        Collections.sort(intRes);


        List<String> StringResult = new ArrayList<>();
        for(int val : intRes){
            StringResult.add(val + "");
        }
        return StringResult;
    }

    public static void main(String[] args) {
            List<String> logs = new ArrayList<>();
//            logs.add("88 99 200");
//            logs.add("88 99 300");
//            logs.add("99 32 100");
//            logs.add("12 12 15");
//            logs.add("1 2 50");
//            logs.add("1 7 70");
//            logs.add("2 2 17");
//            logs.add("1 3 20");
              logs.add("88 99 200");
              logs.add("88 99 300");
              logs.add("99 32 100");
              logs.add("12 12 15");
            List<String> res = processLogs(logs, 2);
            for(String i : res) {
                System.out.println(i);
            }
    }
}
