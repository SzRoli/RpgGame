package modell;

public class Player {

    private String name;
    private String classe;
    private String species;
    private String gender;
    private int dmg;
    private int def;
    private int hp;
    private int doge;

    public Player(){
        this.name = "asdasdasdad";
        this.classe = "";
        this.species = "";
        this.gender = "";
    }

    public void setParameters(String name,String species, String classe, String gender, int hp, int dmg, int def, int doge){

        this.name = name;
        this.species = species;
        this.classe = classe;
        this.gender = gender;
        this.hp = hp;
        this.dmg = dmg;
        this.def = def;
        this.doge = doge;
    }

    public String getName() {
        return name;
    }

    public String getClasse() {
        return classe;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDoge() {
        return doge;
    }

    public void setDoge(int doge) {
        this.doge = doge;
    }
}
