package com.example.kanjuice;

import android.os.Parcel;
import android.os.Parcelable;

public class JuiceItem implements Parcelable {
    public String juiceName;
    public boolean isMultiSelected;
    public int selectedQuantity;
    public boolean animate;
    public int imageResId;
    public int localLangResId;

    public JuiceItem(String juiceName, int localLangResId, int imageId) {
        this.juiceName = juiceName;
        this.localLangResId = localLangResId;
        this.isMultiSelected = false;
        this.selectedQuantity = 1;
        this.imageResId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(juiceName);
        dest.writeInt(selectedQuantity);
    }

    public static final Creator<JuiceItem> CREATOR
            = new Creator<JuiceItem>() {
        public JuiceItem createFromParcel(Parcel in) {
            return new JuiceItem(in);
        }

        public JuiceItem[] newArray(int size) {
            return new JuiceItem[size];
        }
    };

    private JuiceItem(Parcel in) {
        juiceName = in.readString();
        selectedQuantity = in.readInt();
    }
}
