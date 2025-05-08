package part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BingeIterator implements EpisodeIterator {
    private final List<Iterator<Episode>> seasonIters;
    private int current;

    public BingeIterator(Series series) {
        this.seasonIters = new ArrayList<>();
        for (Season s : series.getSeasons()) {
            seasonIters.add(new SeasonIterator(s));
        }
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        while (current < seasonIters.size()) {
            if (seasonIters.get(current).hasNext()) return true;
            current++;
        }
        return false;
    }

    @Override
    public Episode next() {
        return seasonIters.get(current).next();
    }
}