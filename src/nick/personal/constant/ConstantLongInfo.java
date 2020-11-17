package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantLongInfo extends ConstantInfo {
    long value;

    public ConstantLongInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        value = StreamUtil.read8(is);
    }

    @Override
    public String typeName() {
        return "Long";
    }
}
