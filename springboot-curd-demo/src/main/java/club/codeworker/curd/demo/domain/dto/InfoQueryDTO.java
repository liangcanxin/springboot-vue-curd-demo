package club.codeworker.curd.demo.domain.dto;

import club.codeworker.curd.demo.commons.Constant;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 搜索入参
 *
 * @author code-worker
 * @since 2022/02/21 12:29
 */
public class InfoQueryDTO implements Serializable {
    /**
     * key值
     */
    private String key;
    /**
     * value值
     */
    private String value;
    /**
     * 页码
     */
    private Long pageNum = Constant.DEFAULT_PAGE_NUM;

    @Override
    public String toString() {
        return "InfoQueryDTO{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", pageNum=" + pageNum +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }
}
