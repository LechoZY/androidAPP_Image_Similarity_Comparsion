package image.unnc.com.imagesimilarityapp.model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by zengye on 4/12/17.
 */

public class Image extends DataSupport implements Serializable {
    private byte[] image;
    private int number;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }



}


