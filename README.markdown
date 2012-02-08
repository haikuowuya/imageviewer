Android Simple ImageView
------------------------

基于 WebView 的简单图片查看组件，支持双击、双指滑动放大缩小等手势

![ScreenShot](http://pic.yupoo.com/feelinglucky/BJfpUYau/medium.jpg)

使用方法
========

1. 在 IDE 中以 `Android Library Project` 形式載入此項目
2. 修改 `AndroidManifest.xml` 文件，增加 `activity` 声明

<pre>
    &lt;activity android:name="com.dxy.ImageViewer"&gt;&lt;/activity&gt;
</pre>

3. 然后就可以在需要的地方中调用

<pre>
    Intent intent = new Intent(mContext, ImageViewer.class);    
    intent.putExtra("imageUrl", "http://example.com/image.jpg");
    startActivity(intent);
</pre>
   
