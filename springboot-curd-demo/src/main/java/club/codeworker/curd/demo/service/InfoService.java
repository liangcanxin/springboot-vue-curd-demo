package club.codeworker.curd.demo.service;

import club.codeworker.curd.demo.commons.BaseResponse;
import club.codeworker.curd.demo.domain.dto.InfoQueryDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import club.codeworker.curd.demo.domain.entity.Info;

/**
 * (Info)表服务接口
 *
 * @author code-worker
 * @since 2022-02-21 11:23:43
 */
public interface InfoService extends IService<Info> {
    /**
     * 根据关键词获取信息列表
     * @author code-worker
     * @since 2022/2/21 11:30
     * @param infoQueryDTO 关键词
	 * @return club.codeworker.curd.demo.commons.BaseResponse<>
     */
    BaseResponse getInfosByDTO(InfoQueryDTO infoQueryDTO);

}

