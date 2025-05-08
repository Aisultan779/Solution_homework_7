package part1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Series series = new Series();

        Season s1 = new Season();
        s1.addEpisode(new Episode("Episode 1", 1200));
        s1.addEpisode(new Episode("Episode 2", 1300));
        series.addSeason(s1);

        Season s2 = new Season();
        s2.addEpisode(new Episode("Episode 1", 1100));
        s2.addEpisode(new Episode("Episode 2", 1250));
        series.addSeason(s2);

        System.out.println("Normal order season 1:");
        EpisodeIterator it = new SeasonIterator(s1);
        while (it.hasNext()) System.out.println(it.next().getTitle());

        System.out.println("\nReverse order season 1:");
        it = new ReverseSeasonIterator(s1);
        while (it.hasNext()) System.out.println(it.next().getTitle());

        System.out.println("\nShuffle order season 1:");
        it = new ShuffleSeasonIterator(s1);
        while (it.hasNext()) System.out.println(it.next().getTitle());

        System.out.println("\nBinge watch series:");
        it = new BingeIterator(series);
        while (it.hasNext()) System.out.println(it.next().getTitle());

        System.out.println("\nSkip Intro (10 sec) binge watch:");
        it = new SkipIntroIterator(new BingeIterator(series), 10);
        while (it.hasNext()) {
            Episode ep = it.next();
            if (ep instanceof EpisodeView) {
                ((EpisodeView) ep).play();
            } else {
                System.out.println(ep.getTitle());
            }
        }

        System.out.println("\nUnseen filter (skip watched {Episode 1}):");
        Set<String> history = new HashSet<>();
        history.add("Episode 1");
        it = new UnseenEpisodeIterator(new BingeIterator(series), history);
        while (it.hasNext()) System.out.println(it.next().getTitle());
    }
}