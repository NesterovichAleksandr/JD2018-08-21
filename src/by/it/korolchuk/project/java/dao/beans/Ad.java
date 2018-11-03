package by.it.korolchuk.project.java.dao.beans;

public class Ad {

    private long id;
    private String description;
    private String kindOfAnimal;
    private String greed;
    private String sex;
    private int age;
    private int height;
    private String qualities;
    private long usersId;

    public Ad() {
    }

    public Ad(long id, String description, String kindOfAnimal, String greed,
              String sex, int age, int height, String qualities, long usersId) {
        this.id = id;
        this.description = description;
        this.kindOfAnimal = kindOfAnimal;
        this.greed = greed;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.qualities = qualities;
        this.usersId = usersId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public String getGreed() {
        return greed;
    }

    public void setGreed(String greed) {
        this.greed = greed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getQualities() {
        return qualities;
    }

    public void setQualities(String qualities) {
        this.qualities = qualities;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", kindOfAnimal='" + kindOfAnimal + '\'' +
                ", greed='" + greed + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age +
                ", height='" + height +
                ", qualities='" + qualities + '\'' +
                ", usersId='" + usersId +
                "}\n";
    }
}
