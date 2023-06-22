public class converString {
    public static void main(String[] args) throws Exception {
        String itemId = "M 921abc";
        String itemId1 = "";
//        int[] plates = {1, 3, 2};
        //{2, 4, 3, 1, 6}
//        Long item_id;
//        item_id = getSku(null, itemId1);
//        String itemIdRes = getSku(null, itemId1);
        String itemIdRes = getSku(0L, itemId);
        System.out.println("The itemId is : " + itemIdRes);

    }

    public static String getSku(Long defaultVal, String itemId) throws Exception {
//        Long item_id = getLongValue(itemId, defaultVal);
        if(itemId == null || itemId.isEmpty()) {
            throw new Exception(
                    "Invalid ItemId=" + itemId,
                    null
            );
        }
       itemId = itemId.replaceAll("[^a-zA-Z0-9]", "");
       return itemId;
    }


    private static Long getLongValue(String value, Long defaultVal) {
        if(value.isEmpty()) {
            return defaultVal;
        }
        try {
            return Long.valueOf(value);
        } catch(NumberFormatException nfe) {
            return defaultVal;
        }
    }
}
