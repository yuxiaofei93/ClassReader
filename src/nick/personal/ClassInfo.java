package nick.personal;

import nick.personal.constant.*;

import java.io.InputStream;

public class ClassInfo {
    String magicNumber;
    int minorVersion;
    int majorVersion;
    int constantPoolCount;
    ConstantInfo[] constantMap = null;
    int accessFlags;
    int thisClassIndex;
    int parentClassIndex;
    int interfaceCnt;
    int[] interfaceArr;
    int fieldCnt;

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

            // Long / Double 占两个位置
            if (constantMap[i] instanceof ConstantDoubleInfo || constantMap[i] instanceof ConstantLongInfo) {
                ++i;
                constantMap[i] = constantMap[i - 1];
            }
        }
        accessFlags = StreamUtil.read2(is);
        thisClassIndex = StreamUtil.read2(is);
        parentClassIndex = StreamUtil.read2(is);
        interfaceCnt = StreamUtil.read2(is);
        interfaceArr = new int[interfaceCnt];
        for (int i = 0; i < interfaceCnt; ++i) {
            interfaceArr[i] = StreamUtil.read2(is);
        }
        fieldCnt = StreamUtil.read2(is);
    }

    public void print() {
        System.out.println("magic number: " + magicNumber);
        System.out.println("minor_version: " + minorVersion);
        System.out.println("major_version: " + majorVersion);
        System.out.println("constant pool count: " + constantPoolCount);
        for (int i = 1; i < constantMap.length; ++i) {
            if (constantMap[i] instanceof ConstantUtf8Info) {
                printf("#%-2d = %-20s\t\t %-50s\n", i, constantMap[i].typeName(), constantMap[i].toString());
            } else {
                System.out.println(String.format("#%-2d = %-20s\t\t %-50s\t\t// %s", i, constantMap[i].typeName(), constantMap[i].toString(), constantMap[i].realValue(constantMap)));
            }
        }

        System.out.println("access flags: " + ClassUtil.accessFlagToString(accessFlags));
        System.out.println("class full name: " + constantMap[thisClassIndex].toString() + ", " + constantMap[thisClassIndex].realValue(constantMap));
        System.out.println("parent class: " + constantMap[parentClassIndex].realValue(constantMap));
        System.out.println("interface count: " + interfaceCnt);
        printf("interfaces: \n");
        for (int i = 0; i < interfaceCnt; ++i) {
            printf("#%d: %s\n", i, constantMap[interfaceArr[i]].realValue(constantMap));
        }
        printf("field count: %d\n", fieldCnt);
    }

    private void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
