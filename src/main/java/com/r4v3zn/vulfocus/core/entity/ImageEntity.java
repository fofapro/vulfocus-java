package com.r4v3zn.vulfocus.core.entity;

/**
 * Title: ImageEntity
 * Desc: ImageEntity
 * Date:2021/11/25 20:37
 * Email:woo0nise@gmail.com
 * Company:www.r4v3zn.com
 *
 * @author R4v3zn
 * @version 1.0.0
 */
public class ImageEntity {

    /**
     * image name
     */
    private String imageName;

    /**
     * image vul name
     */
    private String imageVulName;

    /**
     * image desc
     */
    private String imageDesc;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageVulName() {
        return imageVulName;
    }

    public void setImageVulName(String imageVulName) {
        this.imageVulName = imageVulName;
    }

    public String getImageDesc() {
        return imageDesc;
    }

    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "imageName='" + imageName + '\'' +
                ", imageVulName='" + imageVulName + '\'' +
                ", imageDesc='" + imageDesc + '\'' +
                '}';
    }
}
