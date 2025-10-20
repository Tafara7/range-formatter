package numberrangesummarizer;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberRangeSummarizerImplTest {

    private final NumberRangeSummarizerImpl impl = new NumberRangeSummarizerImpl();

    @Test
    public void testSampleInput() {
        Collection<Integer> collected = impl.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summarized = impl.summarizeCollection(collected);
        assertThat(summarized, is("1, 3, 6-8, 12-15, 21-24, 31"));
    }

    @Test
    public void testDuplicatesAndUnsorted() {
        Collection<Integer> collected = impl.collect("5,3,5,4,3,2");
        String summarized = impl.summarizeCollection(collected);
        assertThat(summarized, is("2-5"));
    }

    @Test
    public void testEmptyAndWhitespace() {
        Collection<Integer> collected = impl.collect("   ");
        assertThat(impl.summarizeCollection(collected), is(""));
    }

    @Test
    public void testInvalidTokensIgnored() {
        Collection<Integer> collected = impl.collect("1, a, 2, 3b, 4");
        assertThat(impl.summarizeCollection(collected), is("1, 2-4"));
    }

    @Test
    public void testSingleNumber() {
        Collection<Integer> collected = impl.collect("42");
        assertThat(impl.summarizeCollection(collected), is("42"));
    }

}
