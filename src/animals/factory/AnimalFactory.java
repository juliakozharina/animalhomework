package animals.factory;

import animals.Animal;
import animals.bird.Duck;
import animals.data.AnimalTypeData;
import animals.pets.cat;
import animals.pets.dog;


public class AnimalFactory {
    public Animal create (String animalType){

        boolean isAnimalExist = false;
        for (AnimalTypeData animalTypeData: AnimalTypeData.values()){
            if (animalTypeData.name().equals(animalType)){
                isAnimalExist = true;
                break;
            }
        }
        if (!isAnimalExist){
            System.out.println(String.format("Животное %s не поддерживается", animalType));
            return null;
        }

        AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalType);

        switch (animalTypeData) {
            case CAT:{
                return new cat();
            }
            case DOG:{
                return new dog();
            }
            default:{
                return new Duck();
            }
            }
        }
    }

