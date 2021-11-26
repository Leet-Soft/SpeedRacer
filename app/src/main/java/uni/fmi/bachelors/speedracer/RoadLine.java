package uni.fmi.bachelors.speedracer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class RoadLine {
    int x;
    int y;

    int maxY;

    Bitmap bitmap;

    public RoadLine(Context context, int screenSizeY){
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.road_line);
        y = bitmap.getHeight() * -1;

        maxY = screenSizeY;
    }

    public void update(int playerSpeed){
        y +=  playerSpeed;

        if(y > maxY){
            y = bitmap.getHeight() * -1;
        }
    }

}
