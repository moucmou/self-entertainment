package cn.example.amazingt.dao;

import cn.example.amazingt.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author AmazingZ
 * @date 2018/9/15 17:37
 */
@Repository
public interface IDeviceRepository extends JpaRepository<Device, Long>,JpaSpecificationExecutor<Device> {

    @Modifying
    @Transactional
    @Query("delete from Device d where d.indexCode = :indexCode")
    int deleteByIndexCode(@Param("indexCode") String indexCode);
    @Modifying
    @Transactional
    @Query("update Device d SET d.deviceName=:deviceName,d.ip=:ip,d.timeNote=:timeNote where d.indexCode=:indexCode")
    int updateByIndexCode(@Param("deviceName") String deviceName,@Param("ip") String ip,@Param("timeNote")String timeNote,@Param("indexCode") String indexCode);

    @Modifying
    @Transactional
    @Query("update Device d SET d.online=0,d.timeNote=:timeNote where d.indexCode=:indexCode")
    int updateStatuByIndexCode(@Param("timeNote")String timeNote,@Param("indexCode") String indexCode);

    Device findDeviceByIndexCode(String indexCode);
}
