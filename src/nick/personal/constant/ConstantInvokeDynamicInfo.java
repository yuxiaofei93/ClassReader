package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantInvokeDynamicInfo extends ConstantInfo {
    /**
     * 值必须是对当前Class文件中引导方法表的boot_strap_method[]数组的有效索引
     */
    short bootstrapMethodAttrIndex;

    /**
     * 值必须是对当前常量池的有效索引，常量池在该索引处的项必须是{@link ConstantNameAndTypeInfo}结构，表示方法名和方法描述符
     */
    short nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(byte tag) {
        super(tag);
    }

    @Override
    public void readFrom(InputStream is) {
        bootstrapMethodAttrIndex = StreamUtil.read2(is);
        nameAndTypeIndex = StreamUtil.read2(is);
    }

    @Override
    public String typeName() {
        return "InvokeDynamic";
    }
}
