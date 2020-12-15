public abstract class Animal implements IAnimal{
    String name;
    double valuer;
    double values;
    double valuej;

    Animal(String name, double valuer, double values,double valuej){
        this.name = name;
        this.valuer = valuer;
        this.values = values;
        this.valuej = valuej;
    }

    public boolean run(double disr){
        return (this.valuer>=disr);
    }

    public boolean swim(double diss){
        return (this.values>=diss);
    }
    public boolean jump(double disj){
        return (this.valuej>=disj);
    }
}
