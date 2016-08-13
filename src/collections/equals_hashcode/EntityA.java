package collections.equals_hashcode;

/**
 * Дан класс, представляющий собой некоторую бизнес-сущность (entity), объект предметной области (domain object).
 * Необходимо для него корректно определить методы equals(..), hashCode() и toString().
 */
public class EntityA {
    private int age;
    private int height;
    private String name;

    public EntityA(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + ((name != null) ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        EntityA that = (EntityA) obj;
        if (this.age != that.age) return false;
        if (this.height != that.height) return false;
        return (this.name == null) ? that.name == null : this.name.equals(that.name);
    }

    @Override
    public String toString() {
        return "EntityA {age = " + age + ", height = "
                + height + ", name = '" + name + "'}";
    }
}
