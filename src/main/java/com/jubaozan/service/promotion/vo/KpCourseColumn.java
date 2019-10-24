package com.jubaozan.service.promotion.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 专栏表
 * </p>
 *
 * @author yuanjie
 * @since 2019-03-02
 */
@Accessors(chain = true)
@ApiModel(value = "KpCourseColumn对象", description = "专栏表")
public class KpCourseColumn extends Model<KpCourseColumn> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "1000")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "专栏名称")
    private String name;

    @ApiModelProperty(value = "专栏简介")
    private String summary;

    @ApiModelProperty(value = "讲师")
    private Integer lecturerId;

    @ApiModelProperty(value = "专栏封面")
    private String coverImageUrl;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "0免费，1付费", example = "1")
    private Integer free;

    @ApiModelProperty(value = "商品id", example = "1000")
    private Long goodsId;

    @ApiModelProperty(value = "商家ID", example = "1000")
    private Long sjid;

    @ApiModelProperty(value = "课程总数", example = "1000")
    private Integer courseTotal;

    @ApiModelProperty(value = "辅助购买量", example = "1000")
    private Integer buynumAssist;

    @ApiModelProperty(value = "辅助浏览量", example = "1000")
    private Integer browsenumAssist;

    @ApiModelProperty(value = "创建人")
    private String createdby;

    @ApiModelProperty(value = "修改人")
    private String updatedby;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updatedTime;

    // 辅助字段
    @ApiModelProperty(value = " 状态1:上架 0：下架", example = "1")
    @TableField(exist = false)
    private Integer hasPublish;

    @ApiModelProperty(value = "划线价格", example = "100.00")
    @TableField(exist = false)
    private Double originPrice;

    @ApiModelProperty(value = "商品价格", example = "88.00")
    @TableField(exist = false)
    private Double price;

    @ApiModelProperty(value = "专栏-课程列表")
    @TableField(exist = false)
    private List<KpCourse> listCourse;
    
    @ApiModelProperty(value = " 状态1:课程 2：专栏", example = "1")
    @TableField(exist = false)
    private Integer kpType;

    public KpCourseColumn() {
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSummary() {
        return this.summary;
    }

    public Integer getLecturerId() {
        return this.lecturerId;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public Integer getFree() {
        return this.free;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public Long getSjid() {
        return this.sjid;
    }

    public Integer getCourseTotal() {
        return this.courseTotal;
    }

    public Integer getBuynumAssist() {
        return this.buynumAssist;
    }

    public Integer getBrowsenumAssist() {
        return this.browsenumAssist;
    }

    public String getCreatedby() {
        return this.createdby;
    }

    public String getUpdatedby() {
        return this.updatedby;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return this.updatedTime;
    }

    public Integer getHasPublish() {
        return this.hasPublish;
    }

    public Double getOriginPrice() {
        return this.originPrice;
    }

    public Double getPrice() {
        return this.price;
    }

    public List<KpCourse> getListCourse() {
        return this.listCourse;
    }

    public Integer getKpType() {
        return this.kpType;
    }

    public KpCourseColumn setId(Long id) {
        this.id = id;
        return this;
    }

    public KpCourseColumn setName(String name) {
        this.name = name;
        return this;
    }

    public KpCourseColumn setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public KpCourseColumn setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
        return this;
    }

    public KpCourseColumn setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
        return this;
    }

    public KpCourseColumn setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public KpCourseColumn setFree(Integer free) {
        this.free = free;
        return this;
    }

    public KpCourseColumn setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public KpCourseColumn setSjid(Long sjid) {
        this.sjid = sjid;
        return this;
    }

    public KpCourseColumn setCourseTotal(Integer courseTotal) {
        this.courseTotal = courseTotal;
        return this;
    }

    public KpCourseColumn setBuynumAssist(Integer buynumAssist) {
        this.buynumAssist = buynumAssist;
        return this;
    }

    public KpCourseColumn setBrowsenumAssist(Integer browsenumAssist) {
        this.browsenumAssist = browsenumAssist;
        return this;
    }

    public KpCourseColumn setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    public KpCourseColumn setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
        return this;
    }

    public KpCourseColumn setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public KpCourseColumn setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public KpCourseColumn setHasPublish(Integer hasPublish) {
        this.hasPublish = hasPublish;
        return this;
    }

    public KpCourseColumn setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
        return this;
    }

    public KpCourseColumn setPrice(Double price) {
        this.price = price;
        return this;
    }

    public KpCourseColumn setListCourse(List<KpCourse> listCourse) {
        this.listCourse = listCourse;
        return this;
    }

    public KpCourseColumn setKpType(Integer kpType) {
        this.kpType = kpType;
        return this;
    }

    public String toString() {
        return "KpCourseColumn(id=" + this.getId() + ", name=" + this.getName() + ", summary=" + this.getSummary() + ", lecturerId=" + this.getLecturerId() + ", coverImageUrl=" + this.getCoverImageUrl() + ", introduction=" + this.getIntroduction() + ", free=" + this.getFree() + ", goodsId=" + this.getGoodsId() + ", sjid=" + this.getSjid() + ", courseTotal=" + this.getCourseTotal() + ", buynumAssist=" + this.getBuynumAssist() + ", browsenumAssist=" + this.getBrowsenumAssist() + ", createdby=" + this.getCreatedby() + ", updatedby=" + this.getUpdatedby() + ", createdTime=" + this.getCreatedTime() + ", updatedTime=" + this.getUpdatedTime() + ", hasPublish=" + this.getHasPublish() + ", originPrice=" + this.getOriginPrice() + ", price=" + this.getPrice() + ", listCourse=" + this.getListCourse() + ", kpType=" + this.getKpType() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof KpCourseColumn)) return false;
        final KpCourseColumn other = (KpCourseColumn) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$summary = this.getSummary();
        final Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) return false;
        final Object this$lecturerId = this.getLecturerId();
        final Object other$lecturerId = other.getLecturerId();
        if (this$lecturerId == null ? other$lecturerId != null : !this$lecturerId.equals(other$lecturerId))
            return false;
        final Object this$coverImageUrl = this.getCoverImageUrl();
        final Object other$coverImageUrl = other.getCoverImageUrl();
        if (this$coverImageUrl == null ? other$coverImageUrl != null : !this$coverImageUrl.equals(other$coverImageUrl))
            return false;
        final Object this$introduction = this.getIntroduction();
        final Object other$introduction = other.getIntroduction();
        if (this$introduction == null ? other$introduction != null : !this$introduction.equals(other$introduction))
            return false;
        final Object this$free = this.getFree();
        final Object other$free = other.getFree();
        if (this$free == null ? other$free != null : !this$free.equals(other$free)) return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$sjid = this.getSjid();
        final Object other$sjid = other.getSjid();
        if (this$sjid == null ? other$sjid != null : !this$sjid.equals(other$sjid)) return false;
        final Object this$courseTotal = this.getCourseTotal();
        final Object other$courseTotal = other.getCourseTotal();
        if (this$courseTotal == null ? other$courseTotal != null : !this$courseTotal.equals(other$courseTotal))
            return false;
        final Object this$buynumAssist = this.getBuynumAssist();
        final Object other$buynumAssist = other.getBuynumAssist();
        if (this$buynumAssist == null ? other$buynumAssist != null : !this$buynumAssist.equals(other$buynumAssist))
            return false;
        final Object this$browsenumAssist = this.getBrowsenumAssist();
        final Object other$browsenumAssist = other.getBrowsenumAssist();
        if (this$browsenumAssist == null ? other$browsenumAssist != null : !this$browsenumAssist.equals(other$browsenumAssist))
            return false;
        final Object this$createdby = this.getCreatedby();
        final Object other$createdby = other.getCreatedby();
        if (this$createdby == null ? other$createdby != null : !this$createdby.equals(other$createdby)) return false;
        final Object this$updatedby = this.getUpdatedby();
        final Object other$updatedby = other.getUpdatedby();
        if (this$updatedby == null ? other$updatedby != null : !this$updatedby.equals(other$updatedby)) return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        final Object this$updatedTime = this.getUpdatedTime();
        final Object other$updatedTime = other.getUpdatedTime();
        if (this$updatedTime == null ? other$updatedTime != null : !this$updatedTime.equals(other$updatedTime))
            return false;
        final Object this$hasPublish = this.getHasPublish();
        final Object other$hasPublish = other.getHasPublish();
        if (this$hasPublish == null ? other$hasPublish != null : !this$hasPublish.equals(other$hasPublish))
            return false;
        final Object this$originPrice = this.getOriginPrice();
        final Object other$originPrice = other.getOriginPrice();
        if (this$originPrice == null ? other$originPrice != null : !this$originPrice.equals(other$originPrice))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$listCourse = this.getListCourse();
        final Object other$listCourse = other.getListCourse();
        if (this$listCourse == null ? other$listCourse != null : !this$listCourse.equals(other$listCourse))
            return false;
        final Object this$kpType = this.getKpType();
        final Object other$kpType = other.getKpType();
        if (this$kpType == null ? other$kpType != null : !this$kpType.equals(other$kpType)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof KpCourseColumn;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $summary = this.getSummary();
        result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
        final Object $lecturerId = this.getLecturerId();
        result = result * PRIME + ($lecturerId == null ? 43 : $lecturerId.hashCode());
        final Object $coverImageUrl = this.getCoverImageUrl();
        result = result * PRIME + ($coverImageUrl == null ? 43 : $coverImageUrl.hashCode());
        final Object $introduction = this.getIntroduction();
        result = result * PRIME + ($introduction == null ? 43 : $introduction.hashCode());
        final Object $free = this.getFree();
        result = result * PRIME + ($free == null ? 43 : $free.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $sjid = this.getSjid();
        result = result * PRIME + ($sjid == null ? 43 : $sjid.hashCode());
        final Object $courseTotal = this.getCourseTotal();
        result = result * PRIME + ($courseTotal == null ? 43 : $courseTotal.hashCode());
        final Object $buynumAssist = this.getBuynumAssist();
        result = result * PRIME + ($buynumAssist == null ? 43 : $buynumAssist.hashCode());
        final Object $browsenumAssist = this.getBrowsenumAssist();
        result = result * PRIME + ($browsenumAssist == null ? 43 : $browsenumAssist.hashCode());
        final Object $createdby = this.getCreatedby();
        result = result * PRIME + ($createdby == null ? 43 : $createdby.hashCode());
        final Object $updatedby = this.getUpdatedby();
        result = result * PRIME + ($updatedby == null ? 43 : $updatedby.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        final Object $updatedTime = this.getUpdatedTime();
        result = result * PRIME + ($updatedTime == null ? 43 : $updatedTime.hashCode());
        final Object $hasPublish = this.getHasPublish();
        result = result * PRIME + ($hasPublish == null ? 43 : $hasPublish.hashCode());
        final Object $originPrice = this.getOriginPrice();
        result = result * PRIME + ($originPrice == null ? 43 : $originPrice.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $listCourse = this.getListCourse();
        result = result * PRIME + ($listCourse == null ? 43 : $listCourse.hashCode());
        final Object $kpType = this.getKpType();
        result = result * PRIME + ($kpType == null ? 43 : $kpType.hashCode());
        return result;
    }
}
