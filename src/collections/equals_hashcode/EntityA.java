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
        int prime = 37;
        int result = 1;
        result = prime * result + age;
        result = prime * result + height;
        result = prime * result + ((name != null) ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        EntityA that = (EntityA) obj;
        if (this.hashCode() == that.hashCode()) return true;

        return ((this.age == that.age) && (this.height == that.height) && (this.name.equals(that.name)));
    }

    @Override
    public String toString() {
        return new String("EntityA [age = " + age + ", height = " + height + ", name = '" + name + "'");
    }
}
