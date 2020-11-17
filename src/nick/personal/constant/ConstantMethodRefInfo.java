package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantMethodRefInfo extends ConstantInfo {
    short typeIndex;
    short nameIndex;

    public ConstantMethodRefInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        this.typeIndex = StreamUtil.read2(is);
        this.nameIndex = StreamUtil.read2(is);
    }

    @Override
    public String toString() {
        return String.format("#%d.#%d", typeIndex, nameIndex);
    }

    @Override
    public String typeName() {
        return "MethodRef";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return String.format("%s#%s", constantInfoArr[typeIndex].realValue(constantInfoArr), constantInfoArr[nameIndex].realValue(constantInfoArr));
    }
}
