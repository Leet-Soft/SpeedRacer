package uni.fmi.bachelors.speedracer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class RoadLine {
    int x;
    int y;

    int maxY;
    int speed;

    Bitmap bitmap;

    public RoadLine(Context context, int screenSizeY, int speed){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.road_line);
        y = bitmap.getHeight() * -1;

        maxY = screenSizeY;
        this.speed = speed;
    }

    public void update(){
        y += speed;

        if(y > maxY){
            y = bitmap.getHeight() * -1;
        }
    }

}
