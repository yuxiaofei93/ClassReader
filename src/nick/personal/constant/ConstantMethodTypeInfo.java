package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantMethodTypeInfo extends ConstantInfo {

    /**
     * 只必须是对常量池的有效索引，常量池在该索引处的项必须是 {@link ConstantUtf8Info} 结构，表示方法的描述符
     */
    public int descriptorIndex;

    public ConstantMethodTypeInfo(int tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        descriptorIndex = StreamUtil.read2(is);
    }

    @Override
    public String typeName() {
        return "MethodType";
    }
}
