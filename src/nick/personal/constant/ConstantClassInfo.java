package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantClassInfo extends ConstantInfo {
    int nameIndex;

    public ConstantClassInfo(int tag) {
        super(tag);

    }

    @Override
    public void readFrom(InputStream is) {
        this.nameIndex = StreamUtil.read2(is);
    }

    @Override
    public String toString() {
        return String.format("#%d", nameIndex);
    }

    @Override
    public String typeName() {
        return "Class";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return constantInfoArr[nameIndex].realValue(constantInfoArr);
    }
}
