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

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author yuanjie
 * @since 2019-03-02
 */
@Accessors(chain = true)
@ApiModel(value = "KpCourse对象", description = "课程信息表")
public class KpCourse extends Model<KpCourse> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", example = "1000")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课程名称")
    private String name;

    @ApiModelProperty(value = "简介")
    private String summary;

    @ApiModelProperty(value = "讲师ID", example = "1000")
    private Integer lecturerId;

    @ApiModelProperty(value = "课程介绍")
    private String introduction;

    @ApiModelProperty(value = "是否支持单独售卖 0 是，1否", example = "1")
    private Integer saleSingle;

    @ApiModelProperty(value = "0收费 1 免费", example = "1")
    private Integer free;

    @ApiModelProperty(value = "封面图片路径")
    private String coverImageUrl;

    @ApiModelProperty(value = "试听时长(秒）", example = "1000")
    private Integer tryAudioTime;

    @ApiModelProperty(value = "试看时长(秒）", example = "1000")
    private Integer tryVideoTime;

    @ApiModelProperty(value = "音频素材ID", example = "1000")
    private Long audioResourceId;

    @ApiModelProperty(value = "视频素材ID", example = "1000")
    private Long videoResourceId;

    @ApiModelProperty(value = "图文资源ID", example = "1000")
    private Long graphicContentId;

    @ApiModelProperty(value = "辅助购买量", example = "1000")
    private Integer buynumAssist;

    @ApiModelProperty(value = "辅助浏览量", example = "1000")
    private Integer browsenumAssist;

    @ApiModelProperty(value = "商品ID", example = "1000")
    private Long goodsId;

    @ApiModelProperty(value = "商家ID", example = "1000")
    private Long sjid;

    @ApiModelProperty(value = "创建人")
    private String createdby;

    @ApiModelProperty(value = "修改人")
    private String updatedby;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updatedTime;

    // 辅助字段

    @ApiModelProperty(value = "状态1:上架 0：下架", example = "1")
    @TableField(exist = false)
    private Integer hasPublish;

    @ApiModelProperty(value = "划线价格", example = "100.00")
    @TableField(exist = false)
    private Double originPrice;

    @ApiModelProperty(value = "商品价格", example = "88.00")
    @TableField(exist = false)
    private Double price;

    @ApiModelProperty(value = "图文内容")
    @TableField(exist = false)
    private String graphic;

    @ApiModelProperty(value = "音频名称")
    @TableField(exist = false)
    private String audioName;

    @ApiModelProperty(value = "音频URL")
    @TableField(exist = false)
    private String audioUrl;

    @ApiModelProperty(value = "视频名称")
    @TableField(exist = false)
    private String videoName;

    @ApiModelProperty(value = "视频URL")
    @TableField(exist = false)
    private String videoUrl;

    @ApiModelProperty(value = "排序(数字越小越靠前)")
    @TableField(exist = false)
    private Integer sort;

    @ApiModelProperty(value = "试看开关 0关 1开")
    @TableField(exist = false)
    private Integer trailerSwitch;
    
    @ApiModelProperty(value = " 状态1:课程 2：专栏", example = "1")
    @TableField(exist = false)
    private Integer kpType;

    public KpCourse() {
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

    public String getIntroduction() {
        return this.introduction;
    }

    public Integer getSaleSingle() {
        return this.saleSingle;
    }

    public Integer getFree() {
        return this.free;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public Integer getTryAudioTime() {
        return this.tryAudioTime;
    }

    public Integer getTryVideoTime() {
        return this.tryVideoTime;
    }

    public Long getAudioResourceId() {
        return this.audioResourceId;
    }

    public Long getVideoResourceId() {
        return this.videoResourceId;
    }

    public Long getGraphicContentId() {
        return this.graphicContentId;
    }

    public Integer getBuynumAssist() {
        return this.buynumAssist;
    }

    public Integer getBrowsenumAssist() {
        return this.browsenumAssist;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public Long getSjid() {
        return this.sjid;
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

    public String getGraphic() {
        return this.graphic;
    }

    public String getAudioName() {
        return this.audioName;
    }

    public String getAudioUrl() {
        return this.audioUrl;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public Integer getSort() {
        return this.sort;
    }

    public Integer getTrailerSwitch() {
        return this.trailerSwitch;
    }

    public Integer getKpType() {
        return this.kpType;
    }

    public KpCourse setId(Long id) {
        this.id = id;
        return this;
    }

    public KpCourse setName(String name) {
        this.name = name;
        return this;
    }

    public KpCourse setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public KpCourse setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
        return this;
    }

    public KpCourse setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public KpCourse setSaleSingle(Integer saleSingle) {
        this.saleSingle = saleSingle;
        return this;
    }

    public KpCourse setFree(Integer free) {
        this.free = free;
        return this;
    }

    public KpCourse setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
        return this;
    }

    public KpCourse setTryAudioTime(Integer tryAudioTime) {
        this.tryAudioTime = tryAudioTime;
        return this;
    }

    public KpCourse setTryVideoTime(Integer tryVideoTime) {
        this.tryVideoTime = tryVideoTime;
        return this;
    }

    public KpCourse setAudioResourceId(Long audioResourceId) {
        this.audioResourceId = audioResourceId;
        return this;
    }

    public KpCourse setVideoResourceId(Long videoResourceId) {
        this.videoResourceId = videoResourceId;
        return this;
    }

    public KpCourse setGraphicContentId(Long graphicContentId) {
        this.graphicContentId = graphicContentId;
        return this;
    }

    public KpCourse setBuynumAssist(Integer buynumAssist) {
        this.buynumAssist = buynumAssist;
        return this;
    }

    public KpCourse setBrowsenumAssist(Integer browsenumAssist) {
        this.browsenumAssist = browsenumAssist;
        return this;
    }

    public KpCourse setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public KpCourse setSjid(Long sjid) {
        this.sjid = sjid;
        return this;
    }

    public KpCourse setCreatedby(String createdby) {
        this.createdby = createdby;
        return this;
    }

    public KpCourse setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
        return this;
    }

    public KpCourse setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public KpCourse setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public KpCourse setHasPublish(Integer hasPublish) {
        this.hasPublish = hasPublish;
        return this;
    }

    public KpCourse setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
        return this;
    }

    public KpCourse setPrice(Double price) {
        this.price = price;
        return this;
    }

    public KpCourse setGraphic(String graphic) {
        this.graphic = graphic;
        return this;
    }

    public KpCourse setAudioName(String audioName) {
        this.audioName = audioName;
        return this;
    }

    public KpCourse setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public KpCourse setVideoName(String videoName) {
        this.videoName = videoName;
        return this;
    }

    public KpCourse setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public KpCourse setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public KpCourse setTrailerSwitch(Integer trailerSwitch) {
        this.trailerSwitch = trailerSwitch;
        return this;
    }

    public KpCourse setKpType(Integer kpType) {
        this.kpType = kpType;
        return this;
    }

    public String toString() {
        return "KpCourse(id=" + this.getId() + ", name=" + this.getName() + ", summary=" + this.getSummary() + ", lecturerId=" + this.getLecturerId() + ", introduction=" + this.getIntroduction() + ", saleSingle=" + this.getSaleSingle() + ", free=" + this.getFree() + ", coverImageUrl=" + this.getCoverImageUrl() + ", tryAudioTime=" + this.getTryAudioTime() + ", tryVideoTime=" + this.getTryVideoTime() + ", audioResourceId=" + this.getAudioResourceId() + ", videoResourceId=" + this.getVideoResourceId() + ", graphicContentId=" + this.getGraphicContentId() + ", buynumAssist=" + this.getBuynumAssist() + ", browsenumAssist=" + this.getBrowsenumAssist() + ", goodsId=" + this.getGoodsId() + ", sjid=" + this.getSjid() + ", createdby=" + this.getCreatedby() + ", updatedby=" + this.getUpdatedby() + ", createdTime=" + this.getCreatedTime() + ", updatedTime=" + this.getUpdatedTime() + ", hasPublish=" + this.getHasPublish() + ", originPrice=" + this.getOriginPrice() + ", price=" + this.getPrice() + ", graphic=" + this.getGraphic() + ", audioName=" + this.getAudioName() + ", audioUrl=" + this.getAudioUrl() + ", videoName=" + this.getVideoName() + ", videoUrl=" + this.getVideoUrl() + ", sort=" + this.getSort() + ", trailerSwitch=" + this.getTrailerSwitch() + ", kpType=" + this.getKpType() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof KpCourse)) return false;
        final KpCourse other = (KpCourse) o;
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
        final Object this$introduction = this.getIntroduction();
        final Object other$introduction = other.getIntroduction();
        if (this$introduction == null ? other$introduction != null : !this$introduction.equals(other$introduction))
            return false;
        final Object this$saleSingle = this.getSaleSingle();
        final Object other$saleSingle = other.getSaleSingle();
        if (this$saleSingle == null ? other$saleSingle != null : !this$saleSingle.equals(other$saleSingle))
            return false;
        final Object this$free = this.getFree();
        final Object other$free = other.getFree();
        if (this$free == null ? other$free != null : !this$free.equals(other$free)) return false;
        final Object this$coverImageUrl = this.getCoverImageUrl();
        final Object other$coverImageUrl = other.getCoverImageUrl();
        if (this$coverImageUrl == null ? other$coverImageUrl != null : !this$coverImageUrl.equals(other$coverImageUrl))
            return false;
        final Object this$tryAudioTime = this.getTryAudioTime();
        final Object other$tryAudioTime = other.getTryAudioTime();
        if (this$tryAudioTime == null ? other$tryAudioTime != null : !this$tryAudioTime.equals(other$tryAudioTime))
            return false;
        final Object this$tryVideoTime = this.getTryVideoTime();
        final Object other$tryVideoTime = other.getTryVideoTime();
        if (this$tryVideoTime == null ? other$tryVideoTime != null : !this$tryVideoTime.equals(other$tryVideoTime))
            return false;
        final Object this$audioResourceId = this.getAudioResourceId();
        final Object other$audioResourceId = other.getAudioResourceId();
        if (this$audioResourceId == null ? other$audioResourceId != null : !this$audioResourceId.equals(other$audioResourceId))
            return false;
        final Object this$videoResourceId = this.getVideoResourceId();
        final Object other$videoResourceId = other.getVideoResourceId();
        if (this$videoResourceId == null ? other$videoResourceId != null : !this$videoResourceId.equals(other$videoResourceId))
            return false;
        final Object this$graphicContentId = this.getGraphicContentId();
        final Object other$graphicContentId = other.getGraphicContentId();
        if (this$graphicContentId == null ? other$graphicContentId != null : !this$graphicContentId.equals(other$graphicContentId))
            return false;
        final Object this$buynumAssist = this.getBuynumAssist();
        final Object other$buynumAssist = other.getBuynumAssist();
        if (this$buynumAssist == null ? other$buynumAssist != null : !this$buynumAssist.equals(other$buynumAssist))
            return false;
        final Object this$browsenumAssist = this.getBrowsenumAssist();
        final Object other$browsenumAssist = other.getBrowsenumAssist();
        if (this$browsenumAssist == null ? other$browsenumAssist != null : !this$browsenumAssist.equals(other$browsenumAssist))
            return false;
        final Object this$goodsId = this.getGoodsId();
        final Object other$goodsId = other.getGoodsId();
        if (this$goodsId == null ? other$goodsId != null : !this$goodsId.equals(other$goodsId)) return false;
        final Object this$sjid = this.getSjid();
        final Object other$sjid = other.getSjid();
        if (this$sjid == null ? other$sjid != null : !this$sjid.equals(other$sjid)) return false;
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
        final Object this$graphic = this.getGraphic();
        final Object other$graphic = other.getGraphic();
        if (this$graphic == null ? other$graphic != null : !this$graphic.equals(other$graphic)) return false;
        final Object this$audioName = this.getAudioName();
        final Object other$audioName = other.getAudioName();
        if (this$audioName == null ? other$audioName != null : !this$audioName.equals(other$audioName)) return false;
        final Object this$audioUrl = this.getAudioUrl();
        final Object other$audioUrl = other.getAudioUrl();
        if (this$audioUrl == null ? other$audioUrl != null : !this$audioUrl.equals(other$audioUrl)) return false;
        final Object this$videoName = this.getVideoName();
        final Object other$videoName = other.getVideoName();
        if (this$videoName == null ? other$videoName != null : !this$videoName.equals(other$videoName)) return false;
        final Object this$videoUrl = this.getVideoUrl();
        final Object other$videoUrl = other.getVideoUrl();
        if (this$videoUrl == null ? other$videoUrl != null : !this$videoUrl.equals(other$videoUrl)) return false;
        final Object this$sort = this.getSort();
        final Object other$sort = other.getSort();
        if (this$sort == null ? other$sort != null : !this$sort.equals(other$sort)) return false;
        final Object this$trailerSwitch = this.getTrailerSwitch();
        final Object other$trailerSwitch = other.getTrailerSwitch();
        if (this$trailerSwitch == null ? other$trailerSwitch != null : !this$trailerSwitch.equals(other$trailerSwitch))
            return false;
        final Object this$kpType = this.getKpType();
        final Object other$kpType = other.getKpType();
        if (this$kpType == null ? other$kpType != null : !this$kpType.equals(other$kpType)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof KpCourse;
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
        final Object $introduction = this.getIntroduction();
        result = result * PRIME + ($introduction == null ? 43 : $introduction.hashCode());
        final Object $saleSingle = this.getSaleSingle();
        result = result * PRIME + ($saleSingle == null ? 43 : $saleSingle.hashCode());
        final Object $free = this.getFree();
        result = result * PRIME + ($free == null ? 43 : $free.hashCode());
        final Object $coverImageUrl = this.getCoverImageUrl();
        result = result * PRIME + ($coverImageUrl == null ? 43 : $coverImageUrl.hashCode());
        final Object $tryAudioTime = this.getTryAudioTime();
        result = result * PRIME + ($tryAudioTime == null ? 43 : $tryAudioTime.hashCode());
        final Object $tryVideoTime = this.getTryVideoTime();
        result = result * PRIME + ($tryVideoTime == null ? 43 : $tryVideoTime.hashCode());
        final Object $audioResourceId = this.getAudioResourceId();
        result = result * PRIME + ($audioResourceId == null ? 43 : $audioResourceId.hashCode());
        final Object $videoResourceId = this.getVideoResourceId();
        result = result * PRIME + ($videoResourceId == null ? 43 : $videoResourceId.hashCode());
        final Object $graphicContentId = this.getGraphicContentId();
        result = result * PRIME + ($graphicContentId == null ? 43 : $graphicContentId.hashCode());
        final Object $buynumAssist = this.getBuynumAssist();
        result = result * PRIME + ($buynumAssist == null ? 43 : $buynumAssist.hashCode());
        final Object $browsenumAssist = this.getBrowsenumAssist();
        result = result * PRIME + ($browsenumAssist == null ? 43 : $browsenumAssist.hashCode());
        final Object $goodsId = this.getGoodsId();
        result = result * PRIME + ($goodsId == null ? 43 : $goodsId.hashCode());
        final Object $sjid = this.getSjid();
        result = result * PRIME + ($sjid == null ? 43 : $sjid.hashCode());
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
        final Object $graphic = this.getGraphic();
        result = result * PRIME + ($graphic == null ? 43 : $graphic.hashCode());
        final Object $audioName = this.getAudioName();
        result = result * PRIME + ($audioName == null ? 43 : $audioName.hashCode());
        final Object $audioUrl = this.getAudioUrl();
        result = result * PRIME + ($audioUrl == null ? 43 : $audioUrl.hashCode());
        final Object $videoName = this.getVideoName();
        result = result * PRIME + ($videoName == null ? 43 : $videoName.hashCode());
        final Object $videoUrl = this.getVideoUrl();
        result = result * PRIME + ($videoUrl == null ? 43 : $videoUrl.hashCode());
        final Object $sort = this.getSort();
        result = result * PRIME + ($sort == null ? 43 : $sort.hashCode());
        final Object $trailerSwitch = this.getTrailerSwitch();
        result = result * PRIME + ($trailerSwitch == null ? 43 : $trailerSwitch.hashCode());
        final Object $kpType = this.getKpType();
        result = result * PRIME + ($kpType == null ? 43 : $kpType.hashCode());
        return result;
    }
}
