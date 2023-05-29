package level_ajax_query.entity;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.6.22 2:16 PM
 */
public class City {
    private Integer id;
    private String name;
    private Integer provinceId;

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

    public Integer getProvinceId() {
        return provinceId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
}
