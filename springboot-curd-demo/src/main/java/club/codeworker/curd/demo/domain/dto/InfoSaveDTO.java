package club.codeworker.curd.demo.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增入参
 *
 * @author code-worker
 * @since 2022/02/21 17:02
 */
public class InfoSaveDTO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    private Integer sex;
    /**
     * 婚姻情况
     */
    @NotNull(message = "婚姻情况不能为空")
    private Integer marry;
    /**
     * 联系方式
     */
    @NotBlank(message = "联系方式不能为空")
    private String phone;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 联系地址
     */
    @NotBlank(message = "联系地址不能为空")
    private String address;

    @Override
    public String toString() {
        return "InfoSaveDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", marry=" + marry +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getMarry() {
        return marry;
    }

    public void setMarry(Integer marry) {
        this.marry = marry;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
