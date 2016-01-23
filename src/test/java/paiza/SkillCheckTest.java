package paiza;

import mockit.Deencapsulation;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author yama-gen
 */
public class SkillCheckTest {

    @Test
    public void testMain(@Mocked final BufferedReader br, @Mocked final PrintStream ps) throws Exception {

        // 標準入力
        new NonStrictExpectations() {{
            br.readLine();
            result = "1";
            result = "a,b";
        }};

        // 実行
        SkillCheck.main();

        // 標準出力
        new Verifications() {{
            ps.println("hello = a , world = b");
        }};
    }
}