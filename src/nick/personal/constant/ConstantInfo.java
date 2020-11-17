package nick.personal.constant;

import java.io.InputStream;

public abstract class ConstantInfo {
    byte tag;

    public ConstantInfo(byte tag) {
        this.tag = tag;
    }

    public abstract void readFrom(InputStream is);

    @Override
    public String toString() {
        return "ConstantInfo{" +
                "tag=" + tag +
                '}';
    }


    public abstract String typeName();

    public String realValue(ConstantInfo[] constantInfoArr) {
        return "";
    }
}
