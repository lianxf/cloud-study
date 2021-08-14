package cn.lianxf.cloud.jpa.repository;

import cn.lianxf.cloud.jpa.entity.BaseEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @className BaseRespository
 * @description BaseRespository
 * @date 2021/8/8 上午11:57
 * @author little
 * @version 1.0.0
 */
@NoRepositoryBean
public interface BaseRespository<T extends BaseEntity, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false")
    List<T> findAll();


    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted = false")
    T findOne(ID id);

    @Override
    @Transactional(readOnly = true)
    @Query("select count(e) from #{#entityName} e where e.deleted = false")
    long count();

    @Transactional(readOnly = true)
    default boolean exists(ID id) {
        return findOne(id) != null;
    }

    @Query("update #{#entityName} e set e.deleted = true where e.id = ?1")
    @Transactional
    @Modifying
    void logicDelete(ID id);

    @Transactional
    default void logicDelete(T entity) {
        logicDelete((ID) entity.getId());
    }

    @Transactional
    default void logicDelete(Iterable<? extends T> entities) {
        entities.forEach(entity -> logicDelete((ID) entity.getId()));
    }

    @Query("update #{#entityName} e set e.deleted = true ")
    @Transactional
    @Modifying
    void logicDeleteAll();
}
