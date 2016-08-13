package collections.equals_hashcode;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Дан класс, представляющий собой некоторую бизнес-сущность (entity), объект предметной области (domain object).
 * Необходимо для него корректно определить методы equals(..), hashCode() и toString().
 * Предполагается, что методы equals(..), hashCode() и toString() для EntityA и EntityB уже корректно определены.
 */
public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;

    public EntityC(EntityA entity, List<EntityB> list, Map<Set<EntityA>, List<EntityB[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public EntityA getEntity() {
        return entity;
    }

    public List<EntityB> getList() {
        return list;
    }

    public Map<Set<EntityA>, List<EntityB[]>> getMap() {
        return map;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + entity.hashCode();
        result = 31 * result + list.hashCode();
        // TODO
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // todo: writes equals()
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return new String("");
    }
}
