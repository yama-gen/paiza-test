package paiza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author yama-gen
 */
public class Main {

    public static void main(String... args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] strings = br.readLine().split(" ");
        final int totalPage = Integer.parseInt(strings[0]);
        final int readPage = Integer.parseInt(strings[1]);

        System.out.println(totalPage - readPage);
    }
}
