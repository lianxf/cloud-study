package cn.lianxf.cloud.jpa.repository;

import cn.lianxf.cloud.jpa.controller.vo.MaterialReleaseVO;
import cn.lianxf.cloud.jpa.entity.SoftProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className SoftProductRepository
 * @description 发布信息Repository
 * @date 2021/7/31 下午2:25
 * @author little
 * @version 1.0.0
 */
@Repository
public interface SoftProductRepository extends JpaRepository<SoftProduct, String>, JpaSpecificationExecutor<SoftProduct> {

    /**
     * <p> Description: 根据流程实例ID删除</p>
     * @author little
     * @date 下午2:30 2021/7/31
     * @param flowInstId 流程实例ID
     * @return 删除条数
     */
    int deleteByFlowInstId(String flowInstId);

    /**
     * <p> Description: 根据流程实例和taskId查询</p>
     * @author little
     * @date 下午12:31 2021/8/8
     * @param flowInstId 流程实例ID
     * @param taskId 环节定义ID
     * @return java.util.List<cn.lianxf.cloud.jpa.cn.lianxf.cloud.entity.SoftProduct>
     */
    List<SoftProduct> findByFlowInstIdAndTaskId(String flowInstId, String taskId);

    @Query(value = "select new cn.lianxf.cloud.jpa.controller.vo.MaterialReleaseVO(t.flowInstId, t.materialCode, " +
            "m.status) from SoftProduct t left join MaterialRelease m on t.materialCode = m.materialCode " +
            "where t.deleted = false and t.flowInstId = :flowInstId")
    List<MaterialReleaseVO> materialList(String flowInstId);
}
