package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 70;
    private static final int HEIGHT = 70;

    private static class startPoint{
        int x;
        int y;

        startPoint(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void addHexagon(int length, int x, int y, TETile[][] tiles){
        for (int i = 0; i < length; i++){
            drawLine(length+2*i, x - i, y+i, tiles);
        }
        for (int i = 0; i < length; i++){
            drawLine(length+2*(length-1) - 2*i, x - (length-1) + i, y+length + i, tiles);
        }
    }

    private static void drawLine(int length, int x, int y, TETile[][] tiles){
        for (int i = 0; i < length; i++){
            tiles[x+i][y] = Tileset.WALL;
        }
    }

    private static List<startPoint> getDrawingPoint(int length, int x, int y){
        int longestLength = length*2;
        int margin = length - 1;
        List<startPoint> sp = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            sp.add(new startPoint(x, y + i * longestLength));
        }
        y += length;
        for (int i = 0; i < 4; i++){
            sp.add(new startPoint(x-margin-length, y + i * longestLength));
        }
        for (int i = 0; i < 4; i++){
            sp.add(new startPoint(x+margin+length, y + i * longestLength));
        }
        y += length;
        for (int i = 0; i < 3; i++){
            sp.add(new startPoint(x-2*margin-2*length, y + i * longestLength));
        }
        for (int i = 0; i < 3; i++){
            sp.add(new startPoint(x+2*margin+2*length, y + i * longestLength));
        }

        return sp;

    }

    public static void drawTesselationHexagons(int length, int x, int y,  TETile[][] tiles){
        List<startPoint> startPoints = getDrawingPoint(length, x, y);
        for (startPoint sp : startPoints){
            addHexagon(length, sp.x, sp.y, tiles);
        }
    }
    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        drawTesselationHexagons(4, 25, 0, world);
        ter.renderFrame(world);

    }
}
