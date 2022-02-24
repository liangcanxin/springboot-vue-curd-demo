package club.codeworker.curd.demo.service.impl;

import club.codeworker.curd.demo.commons.BaseResponse;
import club.codeworker.curd.demo.commons.Constant;
import club.codeworker.curd.demo.domain.dto.InfoQueryDTO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import club.codeworker.curd.demo.dao.InfoDao;
import club.codeworker.curd.demo.domain.entity.Info;
import club.codeworker.curd.demo.service.InfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * (Info)表服务实现类
 *
 * @author code-worker
 * @since 2022-02-21 11:23:43
 */
@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, Info> implements InfoService {

    /**
     * 根据关键词获取信息列表
     *
     * @param infoQueryDTO 关键词
     * @return club.codeworker.curd.demo.commons.BaseResponse<>
     * @author code-worker
     * @since 2022/2/21 11:30
     */
    @Override
    public BaseResponse getInfosByDTO(InfoQueryDTO infoQueryDTO) {
        // 设置分页
        Page<Info> page = new Page<>(infoQueryDTO.getPageNum(), Constant.DEFAULT_PAGE_SIZE);
        // 设置筛选关键词
        QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(infoQueryDTO.getValue()) && StringUtils.hasText(infoQueryDTO.getKey())) {
            queryWrapper.like(infoQueryDTO.getKey(), infoQueryDTO.getValue());
            return BaseResponse.success(page(page, queryWrapper));
        }
        return BaseResponse.success(page(page));
    }
}

