package com.example.baseapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {
    public float bitMapX;
    public float bitMapY;

    public RabbitView(Context context) {
        super(context);
        bitMapX = 290;
        bitMapY = 130;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.rabbit03);
        canvas.drawBitmap(bitmap, bitMapX, bitMapY, paint);
        if (!bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
