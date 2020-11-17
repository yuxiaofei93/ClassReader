package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantDoubleInfo extends ConstantInfo {
    double value = 0;

    public ConstantDoubleInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        value = Double.longBitsToDouble(StreamUtil.read8(is));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public String typeName() {
        return "Double";
    }

}
