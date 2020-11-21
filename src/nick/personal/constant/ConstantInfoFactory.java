package nick.personal.constant;

import nick.personal.StreamUtil;

import java.io.InputStream;

public class ConstantInfoFactory {
    public static ConstantInfo readFrom(InputStream is) {
        int tag = StreamUtil.read1(is);
        ConstantInfo info = null;

        switch (tag) {
            case 1:
                info = new ConstantUtf8Info(tag);
                break;
            case 3:
                info = new ConstantIntegerInfo(tag);
                break;
            case 4:
                info = new ConstantFloatInfo(tag);
                break;
            case 5:
                info = new ConstantLongInfo(tag);
                break;
            case 6:
                info = new ConstantDoubleInfo(tag);
                break;
            case 7:
                info = new ConstantClassInfo(tag);
                break;
            case 8:
                info = new ConstantStringInfo(tag);
                break;
            case 9:
                info = new ConstantFieldRefInfo(tag);
                break;
            case 10:
                info = new ConstantMethodRefInfo(tag);
                break;
            case 11:
                info = new ConstantInterfaceMethodRefInfo(tag);
                break;
            case 12:
                info = new ConstantNameAndTypeInfo(tag);
                break;
            case 15:
                info = new ConstantMethodHandleInfo(tag);
                break;
            case 16:
                info = new ConstantMethodTypeInfo(tag);
                break;
            case 18:
                info = new ConstantInvokeDynamicInfo(tag);
                break;
        }

        if (info != null) {
            info.readFrom(is);
        }

        return info;
    }
}
