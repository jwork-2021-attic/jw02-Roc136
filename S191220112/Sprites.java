package S191220112;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import S191220112.Set.Position;

public class Sprites {

    private static Sprites theSpriteManger;
    private static Sprite[] sprites;
    private static List<Integer> randomList;
    private static int index;

    // number 写 8 或 16
    public static void initSprites(int number) throws IOException {
        if (theSpriteManger == null) {
            theSpriteManger = new Sprites();
        }

        File file=new File("c256.png");
        BufferedImage bufImage=ImageIO.read(file);

        sprites = new Sprite[number*number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++){
                int rank, r, g, b;
                rank = i * number + j + 1;
                // DONE : cal rgb
                int rgb = bufImage.getRGB((int)(j * 35.75 + 13.375), (int)(i * 26.75 + 13.375));
                
                r = (rgb >> 16) & 0xFF;
                g = (rgb >> 8) & 0xFF;
                b = rgb & 0xFF;

                sprites[rank - 1] = theSpriteManger.new Sprite(r, g, b, rank);
            }
        }
        index = 0;
        randomList = IntStream.rangeClosed(0, number * number - 1).boxed().collect(Collectors.toList());
        Collections.shuffle(randomList);
    }
    
    public static Sprite getSpriteByRank(int rank) {
    
        if (rank <= sprites.length) {
            return sprites[rank - 1];
        }
        return null;

    }

    public static Sprite getRandom() {
        index = (index + 1) % sprites.length;
        return sprites[randomList.get(index)];
    }
    
    public class Sprite implements Linable {

        private final int r;
        private final int g;
        private final int b;
        private final int rank;
    
        private Position position;
    
        Sprite(int r, int g, int b, int rank) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.rank = rank;
        }
    
        public int rank() {
            return this.rank;
        }
    
        @Override
        public String toString() {
            String text = "   ";
            boolean showNum = false;
            if (showNum) {
                text = String.format("  %03d  ", this.rank());
            }
            return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m" + text + "\033[0m";
        }
    
        @Override
        public void setPosition(Position position) {
            this.position = position;
        }
    
        @Override
        public Position getPosition() {
            return this.position;
        }
    
        public void swapPosition(Sprite another) {
            Position p = another.position;
            this.position.setLinable(another);
            p.setLinable(this);
        }
    
        @Override
        public int getValue() {
            return this.rank();
        }
    
    }
}