package club.codeworker.curd.demo.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Info)表实体类
 *
 * @author code-worker
 * @since 2022-02-21 11:23:43
 */
@TableName("tb_info")
public class Info implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */      
    private String name;
    /**
     * 性别，0为男，1为女
     */      
    private Integer sex;
    /**
     * 婚姻情况，0为未婚，1为已婚
     */      
    private Integer marry;
    /**
     * 联系方式
     */      
    private String phone;
    /**
     * 邮箱
     */      
    private String email;
    /**
     * 联系地址
     */      
    private String address;
    /**
     * 创建时间
     */      
    private Date createTime;
    /**
     * 更新时间
     */      
    private Date updateTime;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", marry=" + marry +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

