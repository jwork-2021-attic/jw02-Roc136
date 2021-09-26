package S191220112;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int test_size = 16;

        Gourds.initGourds(test_size);

        Line line = new Line(test_size * test_size);
        
        for (int i = 0; i < test_size*test_size; i++)
        {
            line.put(Gourds.getRandom(), i);
        }

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new BubbleSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
