package S191220112;

public class Geezer {

    private static Geezer theGeezer;

    public static Geezer getTheGeezer() {
        if (theGeezer == null) {
            theGeezer = new Geezer();
        }
        return theGeezer;
    }

    private Geezer() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        if (sortSteps != null) {
            for (String step : sortSteps) {
                this.execute(step);
                System.out.println(line.toString());
                log += line.toString();
                log += "\n[frame]\n";
            }
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        if (plan == "") {
            return null;
        }
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        Gourds.getGourdByRank(Integer.parseInt(couple[0]))
                .swapPosition(Gourds.getGourdByRank(Integer.parseInt(couple[1])));
    }

}
