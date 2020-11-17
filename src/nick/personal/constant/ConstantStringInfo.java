package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantStringInfo extends ConstantInfo {
    public short index;

    public ConstantStringInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        this.index = StreamUtil.read2(is);
    }

    @Override
    public String toString() {
        return String.format("#%d", index);
    }

    @Override
    public String typeName() {
        return "String";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return constantInfoArr[index].realValue(constantInfoArr);
    }
}
