package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantIntegerInfo extends ConstantInfo {
    int value;

    public ConstantIntegerInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        value = StreamUtil.read4(is);
    }

    @Override
    public String typeName() {
        return "Integer";
    }
}
