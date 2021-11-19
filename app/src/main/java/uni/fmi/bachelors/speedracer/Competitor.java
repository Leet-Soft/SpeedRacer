package uni.fmi.bachelors.speedracer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import java.util.Random;

public class Competitor {
    Context context;
    Bitmap bitmap;

    int x;
    int y;
    int maxX;
    int maxY;
    int speed;

    int screenSizeX;
    int screenSizeY;

    Random random;

    int[] skins = {R.drawable.competitor1, R.drawable.competitor2, R.drawable.competitor3,
                    R.drawable.competitor4, R.drawable.competitor5, R.drawable.competitor6,
                    R.drawable.competitor7};

    Rect collisionDetection;

    public Competitor(Context context , int screenSizeX, int screenSizeY, int speed){
        this.context = context;
        random = new Random();
        this.speed = speed - random.nextInt( speed / 2 ) + 1;
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;

        resetCompetitor();
    }

    public void resetCompetitor(){
        bitmap = BitmapFactory.decodeResource(context.getResources(), skins[random.nextInt(skins.length)]);

        maxX = screenSizeX - bitmap.getWidth();
        maxY = screenSizeY - bitmap.getHeight();

        y = (random.nextInt(100) + bitmap.getHeight()) * -1;
        x = random.nextInt(maxX);

        collisionDetection = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }

    public void update(int playerSpeed){

        y += playerSpeed - speed;

        if(y > maxY){
            resetCompetitor();
            this.speed = playerSpeed - random.nextInt(playerSpeed / 2) + 1;
        }

        collisionDetection.top = y;
        collisionDetection.bottom = y + bitmap.getHeight();
    }
}
