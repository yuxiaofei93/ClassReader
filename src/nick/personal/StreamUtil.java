package nick.personal;

import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
    public static byte read1(InputStream is) {
        return (byte) read(is, 1);
    }

    public static short read2(InputStream is) {
        return (short) read(is, 2);
    }

    public static int read4(InputStream is) {
        return (int) read(is, 4);
    }

    public static long read8(InputStream is) {
        return read(is, 8);
    }

    private static long read(InputStream is, int size) {
        byte[] buf = new byte[size];
        try {
            int ret = is.read(buf);
            if (ret < size) return -1L;
            long ans = 0;
            for (byte b : buf) {
                ans <<= 8;
                ans |= (b & 0xff);
            }
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1L;
    }

    public static String toHex(int number) {
        return Integer.toHexString(number);
    }
}
