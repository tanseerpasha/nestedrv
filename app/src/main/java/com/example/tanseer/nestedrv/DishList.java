package com.example.tanseer.nestedrv;

/**
 * Created by Supreme on 8/18/2017.
 */

public class DishList {

    private int dishImage;
    private String dishName;
    private int dishType;
    private int dishRatingIcon;
    private String dishRatingNumber;
    private String dishDeliveryTime;
    private String dishPrice;


    public DishList(int dishImage, String dishName, int dishType, int dishRatingIcon, String dishRatingNumber,
                    String dishDeliveryTime, String dishPrice){
        this.dishImage = dishImage;
        this.dishName = dishName;
        this.dishType = dishType;
        this.dishRatingIcon = dishRatingIcon;
        this.dishRatingNumber = dishRatingNumber;
        this.dishDeliveryTime = dishDeliveryTime;
        this.dishPrice = dishPrice;
    }

    public int getDishImage() {
        return dishImage;
    }

    public String getDishName() {
        return dishName;
    }

    public int getDishType() {
        return dishType;
    }

    public int getDishRatingIcon() {
        return dishRatingIcon;
    }

    public String getDishRatingNumber() {
        return dishRatingNumber;
    }

    public String getDishDeliveryTime() {
        return dishDeliveryTime;
    }

    public String getDishPrice() {
        return dishPrice;
    }
}
