package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantNameAndTypeInfo extends ConstantInfo {
    /**
     * 指向该字段或方法名称常量项的索引
     */
    int nameIndex;

    /**
     * 指向该字段或方法描述符常量项的所以
     */
    int typeIndex;

    public ConstantNameAndTypeInfo(int tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        nameIndex = StreamUtil.read2(is);
        typeIndex = StreamUtil.read2(is);
    }

    @Override
    public String toString() {
        return String.format("#%d.#%d", nameIndex, typeIndex);
    }

    @Override
    public String typeName() {
        return "NameAndType";
    }

    @Override
    public String realValue(ConstantInfo[] constantInfoArr) {
        return String.format("%s:%s", constantInfoArr[nameIndex].realValue(constantInfoArr), constantInfoArr[typeIndex].realValue(constantInfoArr));
    }
}
