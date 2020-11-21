package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantInterfaceMethodRefInfo extends ConstantInfo {
    int classInfoIndex;
    int nameAndTypeIndex;

    public ConstantInterfaceMethodRefInfo(int tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        classInfoIndex = StreamUtil.read2(is);
        nameAndTypeIndex = StreamUtil.read2(is);
    }

    @Override
    public String toString() {
        return String.format("#%d.#%d", classInfoIndex, nameAndTypeIndex);
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return String.format("%s.%s", constantInfoArr[classInfoIndex].realValue(constantInfoArr), constantInfoArr[nameAndTypeIndex].realValue(constantInfoArr));
    }

    @Override
    public String typeName() {
        return "InterfaceMethodref";
    }
}
