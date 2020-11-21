package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.IOException;
import java.io.InputStream;

public class ConstantUtf8Info extends ConstantInfo {
    int length;
    byte[] bytes;

    public ConstantUtf8Info(int tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        length = StreamUtil.read2(is);
        bytes = new byte[length];
        try {
            int ret = is.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return new String(bytes);
    }


    @Override
    public String typeName() {
        return "Utf8";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return toString();
    }
}
