package com.example.tectdepot.spaceapp;

public class Planets {
    String planetName;
    int planetImage;

  Planets(String planetName, int planetImage){
      this.planetName = planetName;
      this.planetImage = planetImage;
  }

    public String getPlanetName() {
        return planetName;
    }

    public int getPlanetImage() {
        return planetImage;
    }
}
