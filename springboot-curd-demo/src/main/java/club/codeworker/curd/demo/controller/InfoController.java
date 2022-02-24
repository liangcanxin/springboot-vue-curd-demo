package club.codeworker.curd.demo.controller;

import club.codeworker.curd.demo.commons.BaseResponse;
import club.codeworker.curd.demo.domain.dto.InfoQueryDTO;
import club.codeworker.curd.demo.domain.dto.InfoSaveDTO;
import club.codeworker.curd.demo.domain.dto.InfoUpdateDTO;
import club.codeworker.curd.demo.domain.entity.Info;
import club.codeworker.curd.demo.service.InfoService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * (Info)表控制层
 *
 * @author code-worker
 * @since 2022-02-21 11:23:43
 */
@RestController
@CrossOrigin
public class InfoController {
    /**
     * 服务对象
     */
    @Resource
    private InfoService infoService;

    @GetMapping("/info")
    public BaseResponse getInfos(InfoQueryDTO infoQueryDTO) {
        return infoService.getInfosByDTO(infoQueryDTO);
    }

    @GetMapping("/info/{id}")
    public BaseResponse getInfoById(@PathVariable @NotNull(message = "id不能为空") Integer id) {
        return BaseResponse.success(infoService.getById(id));
    }

    @PostMapping("/info")
    public BaseResponse saveInfo(@Validated @RequestBody InfoSaveDTO infoSaveDTO) {
        // bean复制
        BeanCopier copier = BeanCopier.create(InfoSaveDTO.class, Info.class, false);
        Info info = new Info();
        copier.copy(infoSaveDTO, info, null);
        return infoService.save(info) ? BaseResponse.success() : BaseResponse.failure("新增失败!");
    }

    @PutMapping("/info")
    public BaseResponse updateInfo(@Validated @RequestBody InfoUpdateDTO infoUpdateDTO) {
        // bean复制
        BeanCopier copier = BeanCopier.create(InfoUpdateDTO.class, Info.class, false);
        Info info = new Info();
        copier.copy(infoUpdateDTO, info, null);
        return infoService.updateById(info) ? BaseResponse.success() : BaseResponse.failure("更新失败!");
    }

    @DeleteMapping("/info/{id}")
    public BaseResponse deleteInfo(@PathVariable @NotNull(message = "id不能为空") Integer id) {
        return infoService.removeById(id) ? BaseResponse.success() : BaseResponse.failure("更新失败!");
    }

}

