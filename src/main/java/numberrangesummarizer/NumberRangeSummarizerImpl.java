package numberrangesummarizer;

import java.util.*;

/**
 * Implementation that parses a comma-separated string of integers, collects them
 * into a sorted set (removing duplicates) and summarizes consecutive ranges
 * as 'start-end'. Single numbers remain as-is. Returns a comma-space separated
 * string of the ranges.
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] parts = input.split(",");
        SortedSet<Integer> set = new TreeSet<>();
        for (String p : parts) {
            String t = p.trim();
            if (t.isEmpty()) continue;
            try {
                int v = Integer.parseInt(t);
                set.add(v);
            } catch (NumberFormatException e) {
                // ignore tokens that are not integers
            }
        }
        return Collections.unmodifiableList(new ArrayList<>(set));
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) return "";

        List<Integer> nums = new ArrayList<>(input);
        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();
        int start = nums.get(0);
        int prev = start;

        for (int i = 1; i < nums.size(); i++) {
            int cur = nums.get(i);
            if (cur == prev + 1) {
                prev = cur;
                continue;
            }
            appendRange(sb, start, prev);
            sb.append(", ");
            start = cur;
            prev = cur;
        }
        appendRange(sb, start, prev);
        return sb.toString();
    }
    private void appendRange(StringBuilder sb, int start, int end) {
        if (start == end) sb.append(start);
        else sb.append(start).append("-").append(end);
    }
}
