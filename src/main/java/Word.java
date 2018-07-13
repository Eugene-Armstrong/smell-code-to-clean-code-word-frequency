/**
 * Created by jxzhong on 2018/5/22.
 */
public class Word {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getWordCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String value;
    private int count;

    public Word(String value,int count) {
        this.value = value;
        this.count = count;
    }

}
