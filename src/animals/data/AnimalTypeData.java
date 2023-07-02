package animals.data;

public enum AnimalTypeData {
    DOG("собака"),
    CAT("кошка"),
    DUCK("утка");

    private String name;
    AnimalTypeData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
