package nick.personal;

import nick.personal.constant.ConstantInfo;
import nick.personal.constant.ConstantInfoFactory;

import java.io.InputStream;

public class ClassInfo {
    String magicNumber;
    short minorVersion;
    short majorVersion;
    short constantPoolCount;
    ConstantInfo[] constantMap = null;
    short accessFlags;
    short thisClassIndex;
    short parentClassIndex;

    public ClassInfo() {
    }

    public void readFrom(InputStream is) {
        magicNumber = StreamUtil.toHex(StreamUtil.read4(is));
        minorVersion = StreamUtil.read2(is);
        majorVersion = StreamUtil.read2(is);
        constantPoolCount = StreamUtil.read2(is);
        constantMap = new ConstantInfo[constantPoolCount];
        for (short i = 1; i < constantPoolCount; ++i) {
            constantMap[i] = ConstantInfoFactory.readFrom(is);
        }
        accessFlags = StreamUtil.read2(is);
        thisClassIndex = StreamUtil.read2(is);
        parentClassIndex = StreamUtil.read2(is);
    }

    public void print() {
        System.out.println("magic number: " + magicNumber);
        System.out.println("minor_version: " + minorVersion);
        System.out.println("major_version: " + majorVersion);
        System.out.println("constant pool count: " + constantPoolCount);
        for (int i = 1; i < constantMap.length; ++i) {
            System.out.println(String.format("#%-2d = %-20s\t\t %-50s\t\t// %s", i, constantMap[i].typeName(), constantMap[i].toString(), constantMap[i].realValue(constantMap)));
        }

        System.out.println("access flags: " + parseAccessFlags(accessFlags));
        System.out.println("class full name: " + constantMap[thisClassIndex].realValue(constantMap));
        System.out.println("parent class: " + constantMap[parentClassIndex].realValue(constantMap));
    }

    private String parseAccessFlags(short accessFlags) {
        StringBuilder sb = new StringBuilder();
        if ((accessFlags & 0x0001) != 0) sb.append("ACC_PUBLIC, ");
        if ((accessFlags & 0x0010) != 0) sb.append("ACC_FINAL, ");
        if ((accessFlags & 0x0020) != 0) sb.append("ACC_SUPER, ");
        if ((accessFlags & 0x0200) != 0) sb.append("ACC_INTERFACE, ");
        if ((accessFlags & 0x0400) != 0) sb.append("ACC_ABSTRACT, ");
        if ((accessFlags & 0x1000) != 0) sb.append("ACC_SYNTHETIC, ");
        if ((accessFlags & 0x2000) != 0) sb.append("ACC_ANNOTATION, ");
        if ((accessFlags & 0x4000) != 0) sb.append("ACC_ENUM, ");
        return sb.toString();
    }

}
