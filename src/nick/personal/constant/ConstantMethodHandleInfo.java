package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantMethodHandleInfo extends ConstantInfo {

    byte referenceKind;
    short referenceIndex;

    public ConstantMethodHandleInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        referenceKind = StreamUtil.read1(is);
        referenceIndex = StreamUtil.read2(is);
    }

    @Override
    public String typeName() {
        return "MethodHandle";
    }
}
