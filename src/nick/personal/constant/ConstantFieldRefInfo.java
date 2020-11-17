package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantFieldRefInfo extends ConstantInfo {
    short typeIndex;
    short nameIndex;

    public ConstantFieldRefInfo(byte tag) {
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
        return "FieldRef";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return String.format("%s:%s", constantInfoArr[nameIndex].realValue(constantInfoArr), constantInfoArr[typeIndex].realValue(constantInfoArr));
    }
}
