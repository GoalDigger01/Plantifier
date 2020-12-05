package edu.ucucite.ph.plantifier;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Description extends AppCompatActivity {
    TextView imageurl, Type;
        private Spinner spinner;
    FirebaseStorage storage;
    DatabaseReference databasePlants,databaseTrees,databaseFlowers,databaseTopPicks;
    StorageReference storageReference;
    EditText Name,Family,Habitat,FloweringTime,Description;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String imageURL= getIntent().getStringExtra("ImageUrl");

//        Spinner
        Type=findViewById(R.id.type);
        spinner = findViewById(R.id.spinner);
        List<String> Categories = new ArrayList<>();
        Categories.add(0,"Choose Type");
        Categories.add("Plant");
        Categories.add("Tree");
        Categories.add("Flower");

        final ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (adapterView.getItemAtPosition(position).equals("Choose Type")){


                }else {
                    Type.setText(adapterView.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






//        DATABASE
        storageReference = FirebaseStorage.getInstance().getReference();
        storage = FirebaseStorage.getInstance();
        databasePlants = FirebaseDatabase.getInstance().getReference("Plants");
        databaseTrees = FirebaseDatabase.getInstance().getReference("Trees");
        databaseFlowers = FirebaseDatabase.getInstance().getReference("Flowers");
        databaseTopPicks = FirebaseDatabase.getInstance().getReference("Top Picks");
        storageReference = FirebaseStorage.getInstance().getReference();

//        Edit Text
        Name = findViewById(R.id.editName);
        FloweringTime = findViewById(R.id.editFloweringTime);
        Family = findViewById(R.id.editFamily);
        Habitat = findViewById(R.id.editHabitat);
        Description = findViewById(R.id.editDescription);
        imageurl=findViewById(R.id.imageURL);





        imageurl.setText(imageURL);

    }

    public void savebtn(View view) {

        String uImageUrl = imageurl.getText().toString();
        String uName = Name.getText().toString();
        String uFamily = Family.getText().toString();
        String uHabitat = Habitat.getText().toString();
        String uFloweringTime = FloweringTime.getText().toString();
        String uDescription = Description.getText().toString();

        if (uName.isEmpty() || uFamily.isEmpty() || uDescription.isEmpty() || uFloweringTime.isEmpty() || uHabitat.isEmpty() || uImageUrl.isEmpty()){

            Toast.makeText(this, "Fill Out First!", Toast.LENGTH_SHORT).show();

    }
         else if(Type.getText().equals("Plant")){
            uploadplants();
            uploadTopPicks();

        } else if (Type.getText().equals("Tree")){
            uploadtree();
            uploadTopPicks();

        }else {
                uploadflower();
                uploadTopPicks();

            }

        }



    private void uploadTopPicks() {
        String uType = Type.getText().toString();
        String id = databasePlants.push().getKey();
        String uImageUrl = imageurl.getText().toString();
        String uName = Name.getText().toString();
        String uFamily = Family.getText().toString();
        String uHabitat = Habitat.getText().toString();
        String uFloweringTime = FloweringTime.getText().toString();
        String uDescription = Description.getText().toString();

        TopPicksDB topPicksDB = new TopPicksDB (id, uType, uName, uFamily,  uHabitat, uFloweringTime, uDescription, uImageUrl);

        databaseTopPicks.child(id).setValue(topPicksDB);


        startActivity(new Intent(this, Adminhome.class));

    }

    private void uploadflower() {
        String uType = Type.getText().toString();
        String id = databasePlants.push().getKey();
        String uImageUrl = imageurl.getText().toString();
        String uName = Name.getText().toString();
        String uFamily = Family.getText().toString();
        String uHabitat = Habitat.getText().toString();
        String uFloweringTime = FloweringTime.getText().toString();
        String uDescription = Description.getText().toString();

        FlowersDB flowersDB = new FlowersDB (id, uType, uName, uFamily,  uHabitat, uFloweringTime, uDescription, uImageUrl);

        databaseFlowers.child(id).setValue(flowersDB);

        Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Adminhome.class));

    }

    private void uploadtree() {
        String uType = Type.getText().toString();
        String id = databasePlants.push().getKey();
        String uImageUrl = imageurl.getText().toString();
        String uName = Name.getText().toString();
        String uFamily = Family.getText().toString();
        String uHabitat = Habitat.getText().toString();
        String uFloweringTime = FloweringTime.getText().toString();
        String uDescription = Description.getText().toString();

        TreesDB treesDB = new TreesDB (id, uType, uName, uFamily,  uHabitat, uFloweringTime, uDescription, uImageUrl);

        databaseTrees.child(id).setValue(treesDB);

        Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Adminhome.class));
    }

    private void uploadplants() {
        String uType = Type.getText().toString();
        String id = databasePlants.push().getKey();
        String uImageUrl = imageurl.getText().toString();
        String uName = Name.getText().toString();
        String uFamily = Family.getText().toString();
        String uHabitat = Habitat.getText().toString();
        String uFloweringTime = FloweringTime.getText().toString();
        String uDescription = Description.getText().toString();

        PlantDB plantdb = new PlantDB (id, uType, uName, uFamily,  uHabitat, uFloweringTime, uDescription, uImageUrl);

        databasePlants.child(id).setValue(plantdb);

        Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Adminhome.class));

    }




}