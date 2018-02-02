package school.db.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 数据Entity类
 */
public abstract class IncrementDataEntity extends BaseEntity {

    /**
     * Integer 类型实体编号（唯一标识）
     */
    @JsonIgnore
    protected Long id;

    public IncrementDataEntity() {
    }

    public IncrementDataEntity(Long id) {
        this.id = id;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
        setUpdateDate(new Date());
        setCreateDate(getUpdateDate());
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        setUpdateDate(new Date());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNewRecord() {
        return id == null;
    }

}
