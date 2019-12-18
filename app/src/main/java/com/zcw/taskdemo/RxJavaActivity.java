package com.zcw.taskdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_SYSTEM_PIC = 10;

    private ImageView imageView;

    private int[] resIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        init();
    }

    private void init() {
        imageView = findViewById(R.id.img_rx_java_test);
        findViewById(R.id.btn_select_photo).setOnClickListener(this);

        resIds = new int[]{
                R.mipmap.pic1,
                R.mipmap.pic2,
                R.mipmap.pic3,
                R.mipmap.pic4,
                R.mipmap.pic5,
                R.mipmap.pic6,
        };

        showImage();
    }

    private void showImage() {
        Observable.create(new ObservableOnSubscribe<Drawable>() {
                    @Override
                    public void subscribe(ObservableEmitter<Drawable> emitter) throws Exception {
                        for (int i = 0; i < resIds.length; i++) {
                            Drawable drawable = getResources().getDrawable(resIds[i]);
                            emitter.onNext(drawable);

                            SystemClock.sleep(3000);
                        }
                        emitter.onComplete();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaActivity.this, "加载图片错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void showImage(String path) {
        Disposable subscribe = Observable.just(path)
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Exception {
                        return getBitmapFromPath(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        if(bitmap == null) {
                            Toast.makeText(RxJavaActivity.this, "加载图片失败", Toast.LENGTH_SHORT).show();
                            return ;
                        }

                        imageView.setImageBitmap(bitmap);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(RxJavaActivity.this, "加载图片失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private Bitmap getBitmapFromPath(String path) {
        if(path == null) {
            return null;
        }

        try {
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            return bitmap;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select_photo:
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, REQUEST_SYSTEM_PIC);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case REQUEST_SYSTEM_PIC:
                if (resultCode == Activity.RESULT_OK) {
                    String photoPath = handleImageOnKitKat(data);
                    showImage(photoPath);
                }
                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @TargetApi(19)
    private String handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();

        if (DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的Uri,则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];//解析出数字格式的id
//                String selection = MediaStore.Images.Media._ID + "=" + id;
                String selection = MediaStore.Images.Media._ID + "=?";
                String[] selectionArgs = {id};
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection, selectionArgs);
                Log.i(imagePath, "相册选择1");
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse(
                        "content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null, null);
                Log.i(imagePath, "相册选择2");
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的Uri，则使用普通方法处理
            imagePath = getImagePath(uri, null, null);
            Log.i(imagePath, "相册选择3");
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
            Log.i(imagePath, "相册选择4");
        }

        return imagePath;
    }

    private String getImagePath(Uri uri, String selection, String[] selectionArgs) {
        String path = "";
        //通过uri和selection来获取真实的图片路径
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(uri, null, selection, selectionArgs, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return path;
        }
        finally {
            if(cursor != null) {
                cursor.close();
            }
        }

        Log.i(path, "相册选择");
        return path;
    }
}
