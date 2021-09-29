package S191220112;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int test_size = 8;

        Sprites.initSprites(test_size);

        // Set set = new Line(test_size * test_size);
        Set set = new Matrix(test_size);
        
        for (int i = 0; i < test_size*test_size; i++)
        {
            set.put(Sprites.getRandom(), i);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        // Sorter sorter = new BubbleSorter();
        Sorter sorter = new QuickSorter();
        // Sorter sorter = new SelectSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(set);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result_mqs_8.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
