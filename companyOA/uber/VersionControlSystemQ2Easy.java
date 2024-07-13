package uber;

import java.util.*;

public class VersionControlSystemQ2Easy {

    public String maxSizeBranch(String[] logs) {
        Map<String, HashSet<String>> vcs = new HashMap<>();
        String branch = "";
        int max = 0;
        String maxSizeBranch = "";
        for (String str : logs) {
            String[] operationValue = str.split(" ");
            String operation = operationValue[0];
            String value = operationValue[1];
            if (operation.equals("switch")) {
                branch = value;
                if (!vcs.containsKey(value)) vcs.put(value, new HashSet<>());
            } else {
                Set<String> files = vcs.get(branch);
                files.add(value);
                if (max < vcs.get(branch).size()) {
                    max = vcs.get(branch).size();
                    maxSizeBranch = branch;
                }
            }
        }
        return maxSizeBranch;
    }

    public static void main(String[] args) {
        VersionControlSystemQ2Easy v = new VersionControlSystemQ2Easy();
        String logs[] = {"switch branch1", "push file1", "push file2", "push file1",
                "switch branch2", "switch issue2", "push file1", "push file2", "push file3"};
        System.out.println(v.maxSizeBranch(logs));
    }
}
