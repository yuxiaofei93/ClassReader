package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantInterfaceMethodRefInfo extends ConstantInfo {
    short classInfoIndex;
    short nameAndTypeIndex;

    public ConstantInterfaceMethodRefInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        classInfoIndex = StreamUtil.read2(is);
        nameAndTypeIndex = StreamUtil.read2(is);
    }

    @Override
    public String typeName() {
        return "InterfaceMethodRef";
    }
}
