package gen;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by yaxi on 2017/5/26.
 */

@Entity
public class User {
    @Id
    private long id;
    @Property(nameInDb = "USERNAME")
    private String name;
    @Property(nameInDb = "USERAGE")
    private int age; //下面省去了 setter/getter
    @Property(nameInDb = "DESC")
    private String desc;
    @Generated(hash = 1723736742)
    public User(long id, String name, int age, String desc) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.desc = desc;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}