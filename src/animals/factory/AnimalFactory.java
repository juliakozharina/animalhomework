package animals.factory;

import animals.Animal;
import animals.bird.Duck;
import animals.data.AnimalTypeData;
import animals.pets.Cat;
import animals.pets.Dog;


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
                return new Cat();
            }
            case DOG:{
                return new Dog();
            }
            default:{
                return new Duck();
            }
            }
        }
    }

