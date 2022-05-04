package ru.kpfu.itis.models;

public class Match {

   private Long id_match;
   private String first_team;
   private String second_team;
   private String time;
   private String reference;

    public Match(Long id_match, String first_team, String second_team, String time, String reference) {
        this.id_match = id_match;
        this.first_team = first_team;
        this.second_team = second_team;
        this.time = time;
        this.reference = reference;
    }

    public Long getId_match() {
        return id_match;
    }

    public void setId_match(Long id_match) {
        this.id_match = id_match;
    }

    public String getFirst_team() {
        return first_team;
    }

    public void setFirst_team(String first_team) {
        this.first_team = first_team;
    }

    public String getSecond_team() {
        return second_team;
    }

    public void setSecond_team(String second_team) {
        this.second_team = second_team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Матч: " +
                first_team + '\'' +
                "- " + second_team + '\'' +
                " в " + time + "." + '\'' +
                " Данный матч можно посмотреть по данной ссылке: " + reference + '\'' ;
    }
}
