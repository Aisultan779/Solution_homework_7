package part1;

public class EpisodeView extends Episode {
    private final int startOffsetSec;

    public EpisodeView(Episode episode, int startOffsetSec) {
        super(episode.getTitle(), episode.getRuntimeSec());
        this.startOffsetSec = startOffsetSec;
    }

    public void play() {
        System.out.printf("Playing '%s' from %d sec...%n", getTitle(), startOffsetSec);
    }
}