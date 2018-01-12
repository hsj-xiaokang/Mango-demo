package com.example.hsj.picmango;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jelly.mango.ImageSelectListener;
import com.jelly.mango.Mango;
import com.jelly.mango.MultiplexImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final String pic = "http://zyline-photo.qiniudn.com/1392705051156.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MultiplexImage> lm = new ArrayList<>();
        lm.add(new MultiplexImage(pic,pic,MultiplexImage.ImageType.NORMAL));
        lm.add(new MultiplexImage(pic,pic,MultiplexImage.ImageType.NORMAL));
        lm.add(new MultiplexImage(pic,pic,MultiplexImage.ImageType.NORMAL));
        lm.add(new MultiplexImage(pic,pic,MultiplexImage.ImageType.NORMAL));
        lm.add(new MultiplexImage(pic,pic,MultiplexImage.ImageType.NORMAL));


        Mango.setImages(lm); //设置图片源
        Mango.setPosition(0); //设置初始显示位置
        Mango.setImageSelectListener(new ImageSelectListener(){
            @Override
            public void select(int index) {
                Log.i(TAG,"当前图片下标"+index);
                Toast.makeText(MainActivity.this,"当前图片下标"+index,Toast.LENGTH_SHORT).show();
            }
        }); //设置滚动监听


        findViewById(R.id.pic_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Mango.open(MainActivity.this); //开启图片浏览
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
