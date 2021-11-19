package uni.fmi.bachelors.speedracer;

import android.graphics.Bitmap;

import java.util.Random;

public class RoadDot {
    int x;
    int y;
    int maxX;
    int maxY;
    int speed;

    Random random;

    public RoadDot(int screenSizeX, int screenSizeY, int speed){
        maxX = screenSizeX;
        maxY = screenSizeY;
        this.speed = speed;
        random = new Random();

        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
    }

    public void update(){
        y += speed;

        if(y > maxY){
            y = random.nextInt(10) * -1;
            x = random.nextInt(maxX);
        }
    }
}
