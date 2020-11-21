package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantFloatInfo extends ConstantInfo {
    float value;

    public ConstantFloatInfo(int tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        value = Float.intBitsToFloat(StreamUtil.read4(is));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public String typeName() {
        return "Float";
    }
}
