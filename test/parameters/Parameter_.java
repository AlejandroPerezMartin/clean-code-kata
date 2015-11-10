package parameters;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Parameter_ {

    @Test
    public void testName() throws Exception {
        Parameter parameter = new Parameter();
        parameter.add(5).to("player 1");
        parameter.add(8).to("player 2");
        parameter.add(2).to("player 1");
        assertThat(parameter.get("player 1"), is(7));
        assertThat(parameter.get("player 2"), is(8));
    }

    @Test
    public void when_inserting_1mb_rolls_should_register_in_less_than_1_second() throws Exception {

        Parameter parameter = new Parameter();
        long start = System.nanoTime();

        for (int i = 0; i < 1e6; i++) {
            parameter.add(1).to("player 1");
        }

        long finish = System.nanoTime();

        System.out.println((finish - start) / 1e6);
    }
}
