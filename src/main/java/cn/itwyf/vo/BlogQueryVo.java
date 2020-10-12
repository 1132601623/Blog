package cn.itwyf.vo;

/**
 * @program: Blog
 * @author: fei
 * @description:
 * @create: 2020-05-01 13:52
 */

public class BlogQueryVo {
    private String title;
    private Long typeId;
    private boolean recommend;

    public BlogQueryVo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
