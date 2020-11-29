package edu.ucucite.ph.plantifier;

public class PlantDB {

    String Type;
    String Name;
    String Family;
    String Habitat;
    String FloweringTime;
    String Description;
    String Imageurl;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String habitat) {
        Habitat = habitat;
    }

    public String getFloweringTime() {
        return FloweringTime;
    }

    public void setFloweringTime(String floweringTime) {
        FloweringTime = floweringTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }



    public PlantDB(String id, String type, String name, String family, String habitat, String floweringTime, String description, String imageurl) {
        Type = type;
        Name = name;
        Family = family;
        Habitat = habitat;
        FloweringTime = floweringTime;
        Description = description;
        Imageurl = imageurl;
    }









}
