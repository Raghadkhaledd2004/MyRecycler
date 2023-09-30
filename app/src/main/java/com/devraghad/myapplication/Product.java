package com.devraghad.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    String name;
    float price;
    float prevprice;
    int image;

    public Product(String name, float price, float prevprice, int image) {
        this.name = name;
        this.price = price;
        this.prevprice = prevprice;
        this.image = image;
    }



    public Product( ) {
     }

    protected Product(Parcel in) {
         price = in.readFloat();
        prevprice = in.readFloat();
        image = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getPrevprice() {
        return prevprice;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPrevprice(float prevprice) {
        this.prevprice = prevprice;
    }

    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
         dest.writeFloat(price);
        dest.writeFloat(prevprice);
        dest.writeInt(image);
    }
}
