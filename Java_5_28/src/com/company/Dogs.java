package com.company;

/**
 * 狗类
 * 包含名字，年龄，狗主人的电话，种类
 *
 */
public class Dogs {

    // 狗名字
    private String communityDogName;

    // 狗年龄
    private int communityDogAge;

    // 狗种类
    private String communityDogsPecies;

    // 狗主人的电话
    private String ownerDogsPhone;


    public String getCommunityDogName() {
        return communityDogName;
    }

    public void setCommunityDogName(String communityDogName) {
        this.communityDogName = communityDogName;
    }

    public int getCommunityDogAge() {
        return communityDogAge;
    }

    public void setCommunityDogAge(int communityDogAge) {
        this.communityDogAge = communityDogAge;
    }

    public String getCommunityDogsPecies() {
        return communityDogsPecies;
    }

    public void setCommunityDogsPecies(String communityDogsPecies) {
        this.communityDogsPecies = communityDogsPecies;
    }

    public String getOwnerDogsPhone() {
        return ownerDogsPhone;
    }

    public void setOwnerDogsPhone(String ownerDogsPhone) {
        this.ownerDogsPhone = ownerDogsPhone;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "communityDogName='" + communityDogName + '\'' +
                ", communityDogAge=" + communityDogAge +
                ", communityDogsPecies='" + communityDogsPecies + '\'' +
                ", ownerDogsPhone='" + ownerDogsPhone + '\'' +
                '}';
    }

    public Dogs() {

    }

    public Dogs(String communityDogName, int communityDogAge, String communityDogsPecies, String ownerDogsPhone) {
        this.communityDogName = communityDogName;
        this.communityDogAge = communityDogAge;
        this.communityDogsPecies = communityDogsPecies;
        this.ownerDogsPhone = ownerDogsPhone;
    }
}
