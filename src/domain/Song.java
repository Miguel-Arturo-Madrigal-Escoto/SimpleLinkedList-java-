package domain;

public class Song {

    private String name;
    private String author;
    private String interprether;
    private int ranking;

    public Song() {

    }

    public Song(String name, String author, String interprether, int ranking) {
        this.name = name;
        this.author = author;
        this.interprether = interprether;
        this.ranking = ranking;
    }
    
    public Song(Song song){
        this.name = song.name;
        this.author = song.author;
        this.interprether = song.interprether;
        this.ranking = song.ranking;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInterprether() {
        return interprether;
    }

    public void setInterprether(String interprether) {
        this.interprether = interprether;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    public static boolean compare(Song a, Song b){
        return (a.getName() == null ? b.getName() == null : a.getName().equals(b.getName()));
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.name + " Autor: " + this.author
                + " Interprete: " + this.interprether + " Ranking: " + this.ranking;
    }

}
