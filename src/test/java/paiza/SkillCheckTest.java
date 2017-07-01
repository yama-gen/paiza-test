package paiza;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author yama-gen
 */
public class SkillCheckTest {

    @Test
    public void testMain(@Mocked final BufferedReader br) throws Exception {

        // 標準入力
        new NonStrictExpectations() {{
            br.readLine();
            result = "1";
            result = "a,b";
        }};

        // 標準出力の差し替え
        final OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 実行
        SkillCheck.main();

        // キューに詰めて1行ずつアサート
        final Queue<String> queue = new ArrayDeque<>(Arrays.asList(out.toString().split(System.lineSeparator())));
        assertThat(queue.poll(), is("hello = a , world = b"));
        assertThat(queue.poll(), is(nullValue()));
    }
}