class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // Split each log into identifier and content
            int idx1 = log1.indexOf(' ');
            int idx2 = log2.indexOf(' ');

            String id1 = log1.substring(0, idx1);
            String content1 = log1.substring(idx1 + 1);

            String id2 = log2.substring(0, idx2);
            String content2 = log2.substring(idx2 + 1);

            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));

            // If both are letter logs
            if (!isDigit1 && !isDigit2) {
                int cmp = content1.compareTo(content2);
                if (cmp != 0) return cmp;
                return id1.compareTo(id2);
            }

            // If one is letter-log and the other digit-log
            if (!isDigit1 && isDigit2) return -1;
            if (isDigit1 && !isDigit2) return 1;

            // Both are digit logs, maintain original order
            return 0;
        });

        return logs;
    }
}
