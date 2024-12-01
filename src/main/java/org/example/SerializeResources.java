package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeResources {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Country romania = new Country("Romania",
                List.of(new Resources("daci liberi"), new Resources("tuneluri energetice"), new Resources("petrol & gaze")));
        Country bulgaria = new Country("Bulgaria",
                List.of(new Resources("castraveti"), new Resources("scoici"), new Resources("izvoare termale")));
        Country franta = new Country("Franta",
                List.of(new Resources("struguri"), new Resources("carbune"), new Resources("fotbalisti")));
        Country uruguay = new Country("Uruguay",
                List.of(new Resources("aur"), new Resources("teren agrigol"), new Resources("pietre pretioase")));

        List<Country> mapamond = new ArrayList<>();
        mapamond.add(romania);
        mapamond.add(bulgaria);
        mapamond.add(franta);
        mapamond.add(uruguay);

        File tariResurse = new File("./src/main/resources/ceGasimLaOamneiiAia.txt");
        if(tariResurse.length() == 0) {
            System.out.println("fisierul e gol, sa-l scriem " + tariResurse.getName() + "\n");
            FileOutputStream fos = new FileOutputStream(tariResurse);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("********ne apucam sa scriem************");
            mapamond.forEach(m -> m.resourcesList(m.name, m.resources));
            oos.writeObject(mapamond);
            System.out.println("********am terminat de scris************");
            oos.close();
            fos.close();
        }else if(tariResurse.exists() && tariResurse.length() > 0){
            System.out.println("exista deja un fisier cu acest nume: " + tariResurse.getName());
            System.out.println("******** uite datele din el: ");
            FileInputStream  fis = new FileInputStream (tariResurse);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Country> mapamondScrisDeja = (List<Country>) ois.readObject();
            mapamondScrisDeja.forEach(System.out::println);
            ois.close();
            fis.close();
        }

    }
}