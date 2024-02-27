package com.example.tectdepot.spaceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanetsInfoActivity extends AppCompatActivity {

    TextView txtPlanetName, txtPlanetDescription, txtReadMoreLess;
    ImageView planetImage;
    boolean isDescriptionShort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets_info);

        txtPlanetName = findViewById(R.id.txtPlanetName);
        txtPlanetDescription = findViewById(R.id.txtPlanetDescription);
        txtReadMoreLess = findViewById(R.id.txtReadMoreLess);

        planetImage = findViewById(R.id.planetImage);

        isDescriptionShort = true;

        Intent intent = getIntent();
        String pos = intent.getStringExtra("position");
        int position = Integer.parseInt(pos);


        int[][] imageArrays = {
                {R.drawable.mercury_gallery_1, R.drawable.mercury_gallery_2, R.drawable.mercury_gallery_3, R.drawable.mercury_gallery_4, R.drawable.mercury_gallery_5},
                {R.drawable.venus_gallery_1, R.drawable.venus_gallery_2, R.drawable.venus_gallery_3},
                {R.drawable.mercury_img, R.drawable.mercury_image_2, R.drawable.earth_img},

        };
        int[] currentImageArray = imageArrays[position];


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ImageAdapter imageAdapter = new ImageAdapter(currentImageArray);
        recyclerView.setAdapter(imageAdapter);

        RecyclerView recyclerViewTopics = findViewById(R.id.recyclerViewTopics);
        recyclerViewTopics.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<String> planetsTopics = new ArrayList<>();
        List<String> planetsExpandedTopicsText = new ArrayList<>();
        planetsTopics.add("Spas");
        planetsTopics.add("Kati");
        planetsExpandedTopicsText.add("da");
        planetsExpandedTopicsText.add("DA");
        PlanetsTopicsAdapter planetsTopicsAdapter= new PlanetsTopicsAdapter(planetsTopics, planetsExpandedTopicsText);
        recyclerViewTopics.setAdapter(planetsTopicsAdapter);


        List<String> planetsNameList = Arrays.asList(
                "Mercury",
                "Venus",
                "Earth",
                "Mars",
                "Jupiter",
                "Saturn",
                "Uranus",
                "Neptune"
        );

        List<String> planetsDescriptions = Arrays.asList(
                "Mercury, the smallest planet in our solar system, is a desolate and airless world with a rugged, cratered surface reminiscent of Earth's moon. Extreme temperature variations are its hallmark, swinging from scorching hot during the day to frigid cold at night due to its lack of atmosphere to regulate temperatures.",
                "Venus, often referred to as Earth's 'sister planet,' shares a similar size but possesses a vastly different environment. Its thick atmosphere, primarily composed of carbon dioxide, traps heat, resulting in a runaway greenhouse effect. As a result, Venus is the hottest planet in our solar system, with surface temperatures capable of melting lead. Shrouded in dense clouds of sulfuric acid, the planet's surface is a harsh and inhospitable place.",
                "Earth is the third planet from the Sun and the only place known in the universe where life has originated and found habitability. Earth is a water world, the only one in the Solar System to sustain liquid surface water. Its ocean covers 70.8% of its crust and contains allmost all of its water. Most other water is retained in Earth's large polar sheets of ice, covering ocean and land, dwarfing Earth's groundwater, lakes, rivers and atmospheric water. ",
                "Mars, the 'Red Planet,' has captivated human imagination for centuries. Its rusty-colored landscape is marked by towering volcanoes, such as Olympus Mons, the largest volcano in the solar system, and Valles Marineris, a vast canyon system stretching across its surface. Evidence of ancient riverbeds and polar ice caps suggests that Mars once had liquid water, making it a prime target for the search for extraterrestrial life and future human exploration.",
                "Jupiter, the largest planet in our solar system, is a gas giant of immense proportions. Its mesmerizing bands of clouds, predominantly composed of hydrogen and helium, swirl around its atmosphere, giving it a distinctive appearance. Jupiter is famous for its Great Red Spot, a gigantic storm that has persisted for centuries and is larger than Earth. It also hosts a diverse array of moons, including Io, which is the most volcanically active body in the solar system.",
                "Saturn, with its striking and iconic ring system, is a majestic gas giant that commands attention. The rings, made up of countless particles of ice and rock, encircle the planet in a breathtaking display. Saturn's rings are a dynamic and intricate system, with gaps, divisions, and even moonlets within them. The planet also boasts a collection of fascinating moons, including Titan, the only moon in the solar system with a thick atmosphere and liquid lakes on its surface.",
                "Uranus, an ice giant situated far from the Sun, presents a unique and enigmatic presence in our solar system. Its pale blue coloration comes from the methane gas in its atmosphere, which absorbs red light and reflects blue. Uranus possesses a distinctive feature - it spins on its side, with its axis tilted nearly 90 degrees relative to its orbit. This extreme tilt leads to long and unusual seasons, lasting for decades, and gives Uranus a truly fascinating character.",
                "Neptune is the eighth planet from the Sun and the farthest known planet in the Solar System. It is the fourth-largest planet in the Solar System by diameter, the third-most-massive planet, and the densest giant planet. It is 17 times the mass of Earth, and slightly more massive than its near-twin Uranus. Neptune is denser and physically smaller than Uranus because its greater mass causes more gravitational compression of its atmosphere."
        );

        List<String> planetsPhysicalChars = Arrays.asList(
                "0.330 × 10^24 kg-2,439.7 km-5,427 kg/m³-3.7 m/s²",
                "4.87 × 10^24 kg-6,051.8 km-5,243 kg/m³-8.87 m/s²",
                "4.87 × 10^24 kg-6,371 km-5,515 kg/m³-9.81 m/s²",
                "0.642 × 10^24 kg-3,389.5 km- 3,933 kg/m³-3.71 m/s²",
                "1898 × 10^24 kg-69,911 km-1,326 kg/m³-24.79 m/s²",
                "568 × 10^24 kg-58,232 km-687 kg/m³-10.44 m/s²",
                "86.8 × 10^24 kg-24,622 km-1,270 kg/m³-8.69 m/s²",
                "102 × 10^24 kg-24,622 km-1,638 kg/m³-11.15 m/s²"
        );



        List<String> convertedWords = new ArrayList<>();

        List<Integer> planetsImages = Arrays.asList(R.drawable.mercury_img, R.drawable.venus_img, R.drawable.earth_img, R.drawable.mars_img, R.drawable.jupiter_img, R.drawable.saturn_img, R.drawable.uranus_img, R.drawable.neptune_img);

        txtPlanetName.setText(planetsNameList.get(position));
        planetImage.setImageResource(planetsImages.get(position));
        String description = planetsDescriptions.get(position);
        String descriptionShort = "";
        for(int i = 0; i < 50; i++){
            descriptionShort += description.charAt(i);
        }
        txtPlanetDescription.setText(descriptionShort);

        String finalDescriptionShort = descriptionShort;
        txtReadMoreLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDescriptionShort){
                    txtPlanetDescription.setText(description);
                    isDescriptionShort = false;
                    txtReadMoreLess.setText("Read Less");
                }
                else{
                    txtPlanetDescription.setText(finalDescriptionShort);
                    isDescriptionShort = true;
                    txtReadMoreLess.setText("Read More");
                }
            }
        });

        String currentPlanetChars = planetsPhysicalChars.get(position);
        String temp = "";
        List<String> arrCurrentPlanetChars = new ArrayList<>();

        for(int i = 0; i < currentPlanetChars.length(); i++){
            if(currentPlanetChars.charAt(i) != '-'){
                temp += currentPlanetChars.charAt(i);
            }
            else{
                arrCurrentPlanetChars.add(temp);
                temp = "";
            }
        }
            arrCurrentPlanetChars.add(temp);
        Toast.makeText(this, "" + arrCurrentPlanetChars.get(arrCurrentPlanetChars.size() - 1), Toast.LENGTH_LONG).show();
    }

    private void showImageDialog(int imageRes) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.image_gallery_dialog);

        ImageView imageView = dialog.findViewById(R.id.dialogImageView);
        imageView.setImageResource(imageRes);

        dialog.show();
    }


}