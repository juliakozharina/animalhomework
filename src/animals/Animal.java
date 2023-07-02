package animals;

public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getWeight(){
        return weight;
        }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void say(){
        System.out.println ("Я говорю");
    }
    public void go(){
        System.out.println ("Я иду");
    }
    public void drink(){
        System.out.println ("Я пью");
    }
    public void eat(){
        System.out.println ("Я ем");
    }

    @Override
    public String toString(){
        return String.format("Добрый день! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет %s!",
                getName(),getAge(),getYearCase(),getWeight(),getColor());
    }

    private String getYearCase(){
        return switch (getAge()) {
            case 1 -> "год";
            case 2, 3, 4 -> "года";
            default -> "лет";
        };
    }
}

