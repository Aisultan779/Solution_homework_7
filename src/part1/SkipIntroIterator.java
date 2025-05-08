package part1;

public class SkipIntroIterator implements EpisodeIterator {
    private final EpisodeIterator inner;
    private final int skipSec;

    public SkipIntroIterator(EpisodeIterator inner, int skipSec) {
        this.inner = inner;
        this.skipSec = skipSec;
    }

    @Override
    public boolean hasNext() {
        return inner.hasNext();
    }

    @Override
    public Episode next() {
        Episode e = inner.next();
        return new EpisodeView(e, skipSec);
    }
}