package image.unnc.com.imagesimilarityapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import image.unnc.com.imagesimilarityapp.model.image;

import static android.R.attr.bitmap;
import static android.R.attr.path;



public class MainActivity extends Activity {

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button btnSelect;
    private ImageView ivImage;
    private String userChoosenTask;

    private Button btnConfirm;
    Hashtable<String, Integer> sample = new Hashtable<String, Integer> ();

    public Bitmap pic;
    static int tarID;

    private static final String TAG = "Mainactivity";
    static {
        if(!OpenCVLoader.initDebug()){
            Log.d(TAG, "opencv not loaded ");
        }else{
            Log.d(TAG, "opencv loaded ");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sample.put("file:///storage/emulated/0/DCIM/Camera/IMG_20170506_214854.jpg", 2);
        sample.put("file:///storage/emulated/0/DCIM/Camera/IMG_20170506_214920.jpg", 13);
        sample.put("file:///storage/emulated/0/DCIM/Camera/IMG_20170506_215003.jpg", 18);
        sample.put("file:///storage/emulated/0/DCIM/Camera/IMG_20170506_214834.jpg", 29);
        sample.put("file:///storage/emulated/0/DCIM/Camera/IMG_20170506_214807.jpg", 39);

//        SQLiteDatabase imageDB = LitePal.getDatabase();
        SQLiteDatabase db = Connector.getDatabase();

        addImage();
        addImage1();
        addImage2();
        addImage3();
        addImage4();
        addImage5();
        addImage6();
        addImage7();
        addImage8();
        addImage9();
        addImage10();
        addImage11();
        addImage12();
        addImage13();
        addImage14();
        addImage15();
        addImage16();
        addImage17();
        addImage18();
        addImage19();
        addImage20();
        addImage21();
        addImage22();
        addImage23();
        addImage24();
        addImage25();
        addImage26();
        addImage27();
        addImage28();
        addImage29();
        addImage30();
        addImage31();
        addImage32();
        addImage33();
        addImage34();
        addImage35();
        addImage36();
        addImage37();
        addImage38();
        addImage39();
        addImage40();
        addImage41();
        addImage42();
        addImage43();
        addImage44();
        addImage45();
        addImage46();
        addImage47();
        addImage48();
        addImage49();
        addImage50();
        Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.image001);
        similarityAlgorithm SA = new similarityAlgorithm();
//        Mat mat1 = SA.bitToGray(img1);
//        Mat mat2 = SA.bitToGray(img2);
//        Mat edge1 = SA.detectEdge(img1);
//        Mat edge2 = SA.detectEdge(img2);
        double simi = SA.detectEdge(img1, img2);
        double simi2 = SA.distance(img1,img2);

//        double simi = SA.distance(edge1, edge2);
        // double simi = SA.calSimilarity(SA.distance(edge1, edge2));
//        Log.d("The similarity is ", "(opencv++)"+String.valueOf(simi));
//        Log.d("The similarity is ", "(distance++++++++++++)"+String.valueOf(simi2));


//        TestAdapter mDbHelper = new TestAdapter(this);
//        mDbHelper.createDatabase();
//        mDbHelper.open();

//        Cursor testdata = mDbHelper.getTestData();

//        SQLiteDatabase db = Connector.getDatabase();

//        dbHelper.closeDatabase();
        setContentView(R.layout.activity_main);
        btnSelect = (Button) findViewById(R.id.btnSelectPhoto);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        // ivImage.setImageBitmap(edge1);
        btnConfirm = (Button) findViewById(R.id.btnconfrim);
        btnSelect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Image_grid.class);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                pic = resizeBitmap(pic, 700);
                pic.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] bitmapByte = baos.toByteArray();
                intent.putExtra("bitmap", bitmapByte);


                startActivity(intent);
            }
        });


    }


    /**
     * 添加一张图片
     */
    private void addImage() {
        image db = new image ();
        db.setId(0);
        db.setName("测试");
        db.setAuthor("test");
        db.setInstro("这是一张测试图片");
        db.setRemark("测试");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/image001.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));//设置上传时间为当前时间
        db.save();
    }
    private void addImage1() {
        image db = new image ();
        db.setId(1);
        db.setName("Watermelon cup");
        db.setAuthor("Inventor: Brian Pellham");
        db.setInstro("Patent No.: US D783,362 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a watermelon cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup1.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage2() {
        image db = new image ();
        db.setId(2);
        db.setName("Drinking cup");
        db.setAuthor("Inventors: Reid Schlegel, John Traub, Wastney");
        db.setInstro("Patent No.: US D783,358 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a drinking cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup2.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage3() {
        image db = new image ();
        db.setId(3);
        db.setName("Serving cup");
        db.setAuthor("Inventors: Jeffrey R.Jetton, Tyler L.Williams, Stan A.Levltsky");
        db.setInstro("Patent No.: US D783,357 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a serving cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup3.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage4() {
        image db = new image ();
        db.setId(4);
        db.setName("Bottle");
        db.setAuthor("Inventors: Michael G.Marantis; Richard A.Ponton; Joshua W.Hubbard; Jonathan P.Richards");//设置版权名字
        db.setInstro("Patent No.: US D783,407 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a bottle, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup4.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage5() {
        image db = new image ();
        db.setId(5);
        db.setName("TNT cup");
        db.setAuthor("Inventor: Brian Pellham");
        db.setInstro("Patent No.: US D783,361 S,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a TNT cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup5.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage6() {
        image db = new image ();
        db.setId(6);
        db.setName("Infuser tea cup with straw");
        db.setAuthor("Inventor: Huajun Yao");
        db.setInstro("Patent No.: US D784,082 S,  Date of patent:  ** Apr.18,2017");
        db.setRemark("Claim: The omamental design for an infuser tea cup with straw, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup6.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage7() {
        image db = new image ();
        db.setId(7);
        db.setName("Push up cereal cup");
        db.setAuthor("Inventor: Noah Vilinsky");
        db.setInstro("Patent No.: US 9,624,024 B2,  Date of patent:  ** Apr.18,2017");
        db.setRemark("Claim: The omamental design for a push up cereal cup, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup7.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage8() {
        image db = new image ();
        db.setId(8);
        db.setName("Bottle");
        db.setAuthor("Inventor: Tadayori Nakayama");
        db.setInstro("Patent No.: US 9,617,028 B2,  Date of patent:  ** Apr.11,2017");
        db.setRemark("Claim: The omamental design for a bottle, substantially as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup8.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage9() {
        image db = new image ();
        db.setId(9);
        db.setName("Snack cup");
        db.setAuthor("Inventor: Sara L. Delgado Carmona");
        db.setInstro("Patent No.: US D782,883 S,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a snack cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup9.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage10() {
        image db = new image ();
        db.setId(10);
        db.setName("Communion cup");
        db.setAuthor("Inventor: Ronald M. Rebmann");
        db.setInstro("Patent No.: US D782,876 S,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a communion cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup10.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage11() {
        image db = new image ();
        db.setId(11);
        db.setName("Multi-chamber container");
        db.setAuthor("Inventors: Matthew Lee Kolb; John C. Crawford");
        db.setInstro("Patent No.: US 9,611,077 B2,  Date of patent:  ** Apr.4,2017");
        db.setRemark("Claim: The omamental design for a multi-chamber container, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup11.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage12() {
        image db = new image ();
        db.setId(12);
        db.setName("Cup for a juice extractor");
        db.setAuthor("Inventors: Jong Boo Kim; In Young Kim");
        db.setInstro("Patent No.: US D782,247 S,  Date of patent:  ** Mar.28,2017");
        db.setRemark("Claim: The omamental design for a cup for a juice extractor, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup12.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage13() {
        image db = new image ();
        db.setId(13);
        db.setName("Two-layered cup");
        db.setAuthor("Inventor: Hui Pang");
        db.setInstro("Patent No.: US D781,108 S,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a two-layered cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup13.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
       db.save();
    }
    private void addImage14() {
        image db = new image ();
        db.setId(14);
        db.setName("Shaker cup");
        db.setAuthor("Inventor: Anthony Cerasani");
        db.setInstro("Patent No.: US D781,104 S,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a shaker cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup14.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage15() {
        image db = new image ();
        db.setId(15);
        db.setName("Oxford style sample cup");
        db.setAuthor("Inventor: Donato Pompa");
        db.setInstro("Patent No.: US 9,594,034 B1,  Date of patent:  ** Mar.14,2017");
        db.setRemark("Claim: The omamental design for a Oxford style sample cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup15.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage16() {
        image db = new image ();
        db.setId(16);
        db.setName("Mug cup");
        db.setAuthor("Inventor: Mun Hyang Heo");
        db.setInstro("Patent No.: US D779,880 S,  Date of patent:  ** Feb.28,2017");
        db.setRemark("Claim: The omamental design for a mug cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup16.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage17() {
        image db = new image ();
        db.setId(17);
        db.setName("Cap and bottle");
        db.setAuthor("Inventors: John Crawford; Scott Beckerman");
        db.setInstro("Patent No.: US D9,579,262 B2,  Date of patent:  ** Feb.28,2017");
        db.setRemark("Claim: The omamental design for a cap and bottle, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup17.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage18() {
        image db = new image ();
        db.setId(18);
        db.setName("Container");
        db.setAuthor("Inventors: Bradley J. Crosby; Carter Ash; Brent Frazler; David Hull");
        db.setInstro("Patent No.: US D779,276 S,  Date of patent:  ** Feb.21,2017");
        db.setRemark("Claim: The omamental design for a container, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup18.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage19() {
        image db = new image ();
        db.setId(19);
        db.setName("Cup for soup");
        db.setAuthor("Inventor: Ewald Struggl");
        db.setInstro("Patent No.: US D777,521 S,  Date of patent:  ** Jan.31,2017");
        db.setRemark("Claim: The omamental design for a cup for soup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup19.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
       db.save();
    }
    private void addImage20() {
        image db = new image ();
        db.setId(20);
        db.setName("Cup");
        db.setAuthor("Inventors: Dorian Levy; William Prindle");
        db.setInstro("Patent No.: US D777,519 S,  Date of patent:  ** Jan.31,2017");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup20.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage21() {
        image db = new image ();
        db.setId(21);
        db.setName("Cup with lid");
        db.setAuthor("Inventors: Jeff Hunt; Alfred Lechner");
        db.setInstro("Patent No.: US D775,957 S,  Date of patent:  ** Jan.10,2017");
        db.setRemark("Claim: The omamental design for a cup with lid, as shown");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup21.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage22() {
        image db = new image ();
        db.setId(22);
        db.setName("Cup");
        db.setAuthor("Inventor: Che-Min Chu");
        db.setInstro("Patent No.: US D775,896 S,  Date of patent:  ** Jan.10,2017");
        db.setRemark("Claim: The omamental design for a cup, as shown");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup22.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage23() {
        image db = new image ();
        db.setId(23);
        db.setName("Shoe-shape cup");
        db.setAuthor("Inventor: Robert M.Faber");
        db.setInstro("Patent No.: US D775,494 S,  Date of patent:  ** Jan.3,2017");
        db.setRemark("Claim: The omamental design for a shoe-shape cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup23.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage24() {
        image db = new image ();
        db.setId(24);
        db.setName("Cup");
        db.setAuthor("Inventor: M.Olivier");
        db.setInstro("Patent No.: US D774,829 S,  Date of patent:  ** Dec.27,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup24.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage25() {
        image db = new image ();
        db.setId(25);
        db.setName("Dispensing cup");
        db.setAuthor("Inventor: Michael David Sanders");
        db.setInstro("Patent No.: US D772,705 S,  Date of patent:  ** Nov.29,2016");
        db.setRemark("Claim: The omamental design for a dispensing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup25.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage26() {
        image db = new image ();
        db.setId(26);
        db.setName("Cup");
        db.setAuthor("Inventor: John D.O'Connor");
        db.setInstro("Patent No.: US D772,013 S,  Date of patent:  ** Nov.22,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup26.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage27() {
        image db = new image ();
        db.setId(27);
        db.setName("Slotted cup");
        db.setAuthor("Inventors: Jeffy Zwerner; Danielle Reid; Eric Pfeiffer; John Barretto");
        db.setInstro("Patent No.: US D769,971 S,  Date of patent:  ** Oct.25,2016");
        db.setRemark("Claim: The omamental design for a slotted cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup27.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage28() {
        image db = new image ();
        db.setId(28);
        db.setName("Insulating cup sleeve");
        db.setAuthor("Inventor: Robert L.Farichild, Jr.");
        db.setInstro("Patent No.: US D769,717 S,  Date of patent:  ** Oct.25,2016");
        db.setRemark("Claim: The omamental design for an insulating cup sleeve, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup28.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage29() {
        image db = new image ();
        db.setId(29);
        db.setName("Hexagonal cup");
        db.setAuthor("Inventors: William Heimsoth; Aaron Attebery ");
        db.setInstro("Patent No.: US D769,071 S,  Date of patent:  ** Oct.18,2016");
        db.setRemark("Claim: The omamental design for a hexagonal cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup29.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage30() {
        image db = new image ();
        db.setId(30);
        db.setName("Snack storage lid for a beverage cup");
        db.setAuthor("Inventor: Bonnie Sussman Strominger");
        db.setInstro("Patent No.: US 9,463,913 B2,  Date of patent:  ** Oct.11,2016");
        db.setRemark("Claim: The omamental design for a snack storage lid for a beverage cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup30.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage31() {
        image db = new image ();
        db.setId(31);
        db.setName("Mixing/Drinking cup");
        db.setAuthor("Inventors: Augusto A.Picozza; Evan Gant; Joongoo Lee");
        db.setInstro("Patent No.: US D767,938 S,  Date of patent:  ** Oct.4,2016");
        db.setRemark("Claim: The omamental design for a mixing/drinking cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup31.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage32() {
        image db = new image ();
        db.setId(32);
        db.setName("Cup");
        db.setAuthor("Inventor: Spiros Margaris");
        db.setImageUrl("/assets/cup32.jpg");
        db.setInstro("Patent No.: US D766,077 S,  Date of patent:  ** Sep.13,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup32.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage33() {
        image db = new image ();
        db.setId(33);
        db.setName("Stackable cup with plate cut-out");
        db.setAuthor("Inventor: Michael Altman");
        db.setInstro("Patent No.: US D9,439,525 B1,  Date of patent:  ** Sep.13,2016");
        db.setRemark("Claim: The omamental design for a stackable cup with plate cut-out, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup33.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage34() {
        image db = new image ();
        db.setId(34);
        db.setName("Stackable cup with plate cut-out");
        db.setAuthor("Inventor: Timothy Dryden Gorbold");
        db.setInstro("Patent No.: US D765,471 S,  Date of patent:  ** Sep.6,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup34.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage35() {
        image db = new image ();
        db.setId(35);
        db.setName("Trainer cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D764,235 S,  Date of patent:  ** Aug.23,2016");
        db.setRemark("Claim: The omamental design for a trainer cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup35.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage36() {
        image db = new image ();
        db.setId(36);
        db.setName("Trainer straw cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D762,419 S,  Date of patent:  ** Aug.2,2016");
        db.setRemark("Claim: The omamental design for a trainer straw cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup36.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage37() {
        image db = new image ();
        db.setId(37);
        db.setName("Spice cup");
        db.setAuthor("Inventors: Aaron Frank Fitchko; Erica Hammack; Robert G. Larkin; William H.Dickson; Jillian Christime Hartke; Michael J.Palmisano; Steven Douglas Richardson");
        db.setInstro("Patent No.: US D761,059 S,  Date of patent:  ** Jul.12,2016");
        db.setRemark("Claim: The omamental design for a spice cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup37.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage38() {
        image db = new image ();
        db.setId(38);
        db.setName("Cup");
        db.setAuthor("Inventors: Norman R.Wainwright; Eric Stimpson; Bruce J.Tomson; Thomas Preidel");
        db.setInstro("Patent No.: US D759,837 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup38.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage39() {
        image db = new image ();
        db.setId(39);
        db.setName("Cup");
        db.setAuthor("Inventors: Norman R.Wainwright; Eric Stimpson; Bruce J.Tomson; Thomas Preidel");
        db.setInstro("Patent No.: US D759,836 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup39.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage40() {
        image db = new image ();
        db.setId(40);
        db.setName("Dosing cup");
        db.setAuthor("Inventors: Luiz Fernando Arenas; Diogo Matos Rodrigues");
        db.setInstro("Patent No.: US D759,515 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a dosing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup40.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage41() {
        image db = new image ();
        db.setId(41);
        db.setName("Shoe-shape cup");
        db.setAuthor("Inventors: Luiz Fernando Arenas; Diogo Matos Rodrigues");
        db.setInstro("Patent No.: US D759,515 S,  Date of patent:  ** Jun.21,2016");
        db.setRemark("Claim: The omamental design for a dosing cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup41.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage42() {
        image db = new image ();
        db.setId(42);
        db.setName("Straw transition cup");
        db.setAuthor("Inventors: Richard Parker; Peter Angus; Matthew O'Brien; James Roe; Jason Roebuck");
        db.setInstro("Patent No.: US D755,572 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a straw transition cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup42.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage43() {
        image db = new image ();
        db.setId(43);
        db.setName("Paint spray gun cup");
        db.setAuthor("Inventor: Peter Dettlaff");
        db.setInstro("Patent No.: US D758,533 S,  Date of patent:  ** Jun.7,2016");
        db.setRemark("Claim: The omamental design for a paint spray gun cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup43.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage44() {
        image db = new image ();
        db.setId(44);
        db.setName("Measuring cup");
        db.setAuthor("Inventor: Shigeru Yamazaki");
        db.setInstro("Patent No.: US D758,215 S,  Date of patent:  ** Jun.7,2016");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup44.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage45() {
        image db = new image ();
        db.setId(45);
        db.setName("Can cup");
        db.setAuthor("Inventor: Robert Kushner");
        db.setInstro("Patent No.: US D756,712 S,  Date of patent:  ** May.24,2016");
        db.setRemark("Claim: The omamental design for a can cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup45.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage46() {
        image db = new image ();
        db.setId(46);
        db.setName("Serving cup");
        db.setAuthor("Inventors: Jason Covey; Ian Graves; Thomas Gurski");
        db.setInstro("Patent No.: US D756,771 S,  Date of patent:  ** May.24,2016");
        db.setRemark("Claim: The omamental design for a serving cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup46.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage47() {
        image db = new image ();
        db.setId(47);
        db.setName("Measuring cup");
        db.setAuthor("Inventor: Joseph Kent");
        db.setInstro("Patent No.: US D756,246 S,  Date of patent:  ** May.17,2016");
        db.setRemark("Claim: The omamental design for a measuring cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup47.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage48() {
        image db = new image ();
        db.setId(48);
        db.setName("Cup");
        db.setAuthor("Inventor: Eulbum Lee");
        db.setInstro("Patent No.: US D755,568 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup48.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage49() {
        image db = new image ();
        db.setId(49);
        db.setName("Cup");
        db.setAuthor("Inventor: Shun-Wen Cheng");
        db.setInstro("Patent No.: US D755,571 S,  Date of patent:  ** May.10,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup49.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();
    }
    private void addImage50() {
        image db = new image();
        db.setId(50);
        db.setName("Cup");
        db.setAuthor("Inventors: Vincent Valderrama; Dmitryly Faktorovich");
        db.setImageUrl("/assets/cup50.jpg");
        db.setInstro("Patent No.: US D755,016 S,  Date of patent:  ** May.3,2016");
        db.setRemark("Claim: The omamental design for a cup, as shown and described");
        db.setImage("http://ooxq3v592.bkt.clouddn.com/cup50.jpg");
        db.setType("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        db.setUploadTime(sdf.format(new Date()));
        db.save();

    }








    public Bitmap Bytes2Bimap(byte[] b) {
        if (b.length != 0) {
            return BitmapFactory.decodeByteArray(b, 0, b.length);

        } else {
            return null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(MainActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);



//		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//		//将图片保存至SDcard，相机返回后直接在SDcard读取图片，这样可以解决获取的图片太小的问题。
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory())));
//		startActivityForResult(intent, REQUEST_CAMERA);

    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == Activity.RESULT_OK) {
//            if (requestCode == SELECT_FILE)
//                onSelectFromGalleryResult(data);
//            else if (requestCode == REQUEST_CAMERA){
//                onCaptureImageResult(data);
//
//
//            }
//        }
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE){
                onSelectFromGalleryResult(data);


                Uri selectedImageUri = data.getData();
                String str = selectedImageUri.toString();
                tarID = sample.get(str);
                Log.d("WWWWWWWWWWWW", "path : " + str);
            }



            else if (requestCode == REQUEST_CAMERA){
                onCaptureImageResult(data);


            }
        }
    }
    public String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }



    private void onCaptureImageResult(Intent data) {





        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        pic = thumbnail;



        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        ivImage.setImageBitmap(resizeBitmap(thumbnail,800));

        try {
            MediaStore.Images.Media.insertImage(getContentResolver(),
                    destination.getAbsolutePath(), System.currentTimeMillis() + ".jpg", null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {


        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        pic = bm;

        ivImage.setImageBitmap(resizeBitmap(bm, 800));
    }


    public static Bitmap resizeBitmap(Bitmap bitmap, int newWidth) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float temp = ((float) height) / ((float) width);
        int newHeight = (int) ((newWidth) * temp);
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // matrix.postRotate(45);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
//        bitmap.recycle();
        return resizedBitmap;
    }



}
