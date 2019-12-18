package zcw.com.basic.copy;

/**
 * Created by 朱城委 on 2019/9/23.<br><br>
 */
public class StudentDeep implements Cloneable {
    private String name;

    public StudentDeep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected StudentDeep clone() throws CloneNotSupportedException {
        return (StudentDeep) super.clone();
    }
}
