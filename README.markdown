

    <activity android:name="com.dxy.ImageViewer"></activity>

    Intent intent = new Intent(mContext, ImageViewer.class);
    intent.putExtra("imageUrl", "http://www.baidu.com/img/baidu_sylogo1.gif");
    startActivity(intent);
