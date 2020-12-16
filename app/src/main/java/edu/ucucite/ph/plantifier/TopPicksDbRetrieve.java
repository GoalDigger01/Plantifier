package edu.ucucite.ph.plantifier;

public class TopPicksDbRetrieve {
    String type;
    String name;
    String family;
    String floweringtime;
    String habitat;
    String description;
    String imageurl;

    public TopPicksDbRetrieve() {
    }

    public TopPicksDbRetrieve(String type, String name, String family, String floweringtime, String habitat, String description, String imageurl) {
        this.type = type;
        this.name = name;
        this.family = family;
        this.floweringtime = floweringtime;
        this.habitat = habitat;
        this.description = description;
        this.imageurl = imageurl;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getfloweringtime() {
        return floweringtime;
    }

    public void setFloweringtime(String floweringtime) {
        this.floweringtime = floweringtime;
    }

    public String gethabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getimageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setFloweringTime(String floweringTime) {
        this.floweringtime = floweringTime;
    }
}
