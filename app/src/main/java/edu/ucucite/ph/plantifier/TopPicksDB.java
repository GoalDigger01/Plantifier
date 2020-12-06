package edu.ucucite.ph.plantifier;


public class TopPicksDB  {

    String Type;
    String Name;
    String Family;
    String Habitat;
    String FloweringTime;
    String Description;
    String Imageurl;

    public TopPicksDB() {

    }

    public String getType() {
        return Type;
    }
    public String getName() {
        return Name;
    }
    public String getFamily() {
        return Family;
    }
    public String getHabitat() {
        return Habitat;
    }
    public String getDescription() {
        return Description;
    }
    public String getImageurl() {
        return Imageurl;
    }
    public String getFloweringTime() {
        return FloweringTime;
    }


    public void setType(String type) {
        Type = type;
    }



    public void setName(String name) {
        Name = name;
    }



    public void setFamily(String family) {
        Family = family;
    }



    public void setHabitat(String habitat) {
        Habitat = habitat;
    }



    public void setFloweringTime(String floweringTime) {
        FloweringTime = floweringTime;
    }




    public void setDescription(String description) {
        Description = description;
    }


    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }


    public TopPicksDB(String id, String type, String name, String family, String habitat, String floweringTime, String description, String imageurl) {
        Type = type;
        Name = name;
        Family = family;
        Habitat = habitat;
        FloweringTime = floweringTime;
        Description = description;
        Imageurl = imageurl;
    }


}